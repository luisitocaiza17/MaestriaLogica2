/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.logic;

import static com.company.logic.FactoresLogic.buscarFactores;
import com.company.logic.pojos.CalificacionFactorPojo;
import com.company.logic.pojos.RespuestaGeneralPojo;
import com.mycompany.Entities.Calificacionfactor;
import com.mycompany.Entities.Calificaciongeneralproyecto;
import com.mycompany.Entities.Calificacionproyecto;
import com.mycompany.Entities.Factores;
import com.mycompany.dao.CalificacionfactorJpaController;
import com.mycompany.dao.CalificaciongeneralproyectoJpaController;
import com.mycompany.dao.CalificacionproyectoJpaController;
import com.mycompany.dao.FactoresJpaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author pc030
 */
public class RegistroDatosLogic {
    
    public static Boolean registrarPreguntaUsuario(CalificacionFactorPojo calificacion){
        //transformamos el pojo en entidade de almacenamiento
        Calificacionfactor calificacionEntity = new Calificacionfactor();
        calificacionEntity.setCalificacion(calificacion.getCalificacion());
        Date date = new Date();
        calificacionEntity.setFechaCreacion(date);
        calificacionEntity.setIdPreguna(calificacion.getIdPregunta());
        calificacionEntity.setIdUsuario(calificacion.getIdUsuario());
        calificacionEntity.setIdFactor(calificacion.getIdFactor());
        //calculamos el porcentaje estadistico de la pregunta con respecto a lo esperado al 100%
        //TODO: desde pantalla voy a recibir el porcentaje estadistico de la pregunta como
        //tambien recibo la calificacion voy a aplicar la formula para hallar el valor de la pregunta
        // calificacion * 100 /porcentajeEstadisticoPregunta
        Double calificacionEstadistica= (calificacion.getCalificacion()*(double)calificacion.getPorcentajeEstadisticoPregunta())/5;
        calificacionEntity.setPorcentajeEstadistico(calificacionEstadistica.floatValue()); 
        //BUSCO EL ID JUSTO ANTES DE LA INSERCION
        CalificacionfactorJpaController controlador = new CalificacionfactorJpaController();
        int lastId=controlador.findLastId()+1;
        calificacionEntity.setId(lastId);
        try {
            controlador.create(calificacionEntity);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static RespuestaGeneralPojo procesarArquitectura(int id) throws Exception{
        //buscamos todas las preguntas de la arquitectura
        CalificacionfactorJpaController controlador = new CalificacionfactorJpaController();
        CalificacionproyectoJpaController controladorProyecto = new CalificacionproyectoJpaController();
        CalificaciongeneralproyectoJpaController controladorGeneralProyecto = new CalificaciongeneralproyectoJpaController();
        List<Calificacionfactor> listadoPreguntas=controlador.BuscarPreguntasPorUsuario(id);
        //formato de respuesta general
        RespuestaGeneralPojo respuesta = new RespuestaGeneralPojo();
        List<CalificacionFactorPojo> factoresPojo = new ArrayList<CalificacionFactorPojo>();
        //buscamos todos los factores
        List<Factores> listadoFactores = FactoresLogic.buscarFactores();
        //Vamos a buscar las preguntas de los factores y sumemos los valores para ver la calificacion por factor
        double sumatoriaFactorTotal = 0;//suma el valor de cada factor
        for(Factores factor:listadoFactores){
            //factor de respuesta
            CalificacionFactorPojo factorPojo = new CalificacionFactorPojo();
            factorPojo.setId(id);
            factorPojo.setNombreFactor(factor.getNombre());
            double sumatoriaFactor = 0;
            //ahora buscamos las preguntas y sumamos
            for(Calificacionfactor pregunta:listadoPreguntas){
                if(factor.getId().intValue() ==  pregunta.getIdFactor().intValue()){
                    sumatoriaFactor += (double)pregunta.getPorcentajeEstadistico();
                }
            } 
            double valorSobrePorcentajeEstadistico= (sumatoriaFactor*factor.getPesoEstadistico())/100;
            //ahora podemos calificar el factor
            Calificacionproyecto calificacionProyecto = new Calificacionproyecto();
            Date date = new Date();
            calificacionProyecto.setFechaCreacion(date);
            calificacionProyecto.setIdCalificacionFactor(factor.getId());
            calificacionProyecto.setPorcentajeFactorSumado((float)sumatoriaFactor);
            calificacionProyecto.setPorcentajeGeneral((float)valorSobrePorcentajeEstadistico);
            int ultimoId=controladorProyecto.findLastId()+1;
            calificacionProyecto.setId(ultimoId);
            calificacionProyecto.setIdUsuario(id);
            factorPojo.setPorcentajeEstadisticoMinimo(factor.getPesoEstadistico()/2);
            //lleno el objeto
            factorPojo.setPorcentajeEstadistico((float)valorSobrePorcentajeEstadistico);
            factorPojo.setPorcentajeEstadisticoPregunta((float)sumatoriaFactor);
            factoresPojo.add(factorPojo);
            controladorProyecto.create(calificacionProyecto);
            //ahora sumamos los valores de los factores para el proyecto
            sumatoriaFactorTotal+=valorSobrePorcentajeEstadistico;
        }
        //llenamos los datos del proyecto
        Calificaciongeneralproyecto ultimaCalificacion = new Calificaciongeneralproyecto();
        Date date = new Date();
        ultimaCalificacion.setPorcentajeRecomendacion(((float)sumatoriaFactorTotal));
        ultimaCalificacion.setFechaCreacion(date);
        ultimaCalificacion.setIdUsuario(id);
        int ultimoId=controladorGeneralProyecto.findLastId()+1;
        ultimaCalificacion.setId(ultimoId);
        controladorGeneralProyecto.create(ultimaCalificacion);
        respuesta.setCalificacionEstadistica((float)sumatoriaFactorTotal);
        respuesta.setIdUsuario(id);
        respuesta.setFactor(factoresPojo);
        return respuesta;
    }
    
    //busca la calificacion de un proyecto
    public static RespuestaGeneralPojo buscarDatosArquitectura(int id){
        //voy a buscar las calificaciones por factor del proyecto
        CalificacionproyectoJpaController controladorProyecto = new CalificacionproyectoJpaController();
        List<Calificacionproyecto> listadoCalificacionFactor=controladorProyecto.buscarCalificacionFactorProyecto(id);
         List<Factores> listadoFactores = FactoresLogic.buscarFactores();
        List<CalificacionFactorPojo> calificacionesRespuesta = new ArrayList<CalificacionFactorPojo>();
        for (Calificacionproyecto calificacion : listadoCalificacionFactor){
            CalificacionFactorPojo calificacionPojo = new CalificacionFactorPojo();
            calificacionPojo.setId(calificacion.getId());
            calificacionPojo.setCalificacion(calificacion.getIdCalificacionFactor());
            calificacionPojo.setPorcentajeEstadistico(calificacion.getPorcentajeGeneral());
            calificacionPojo.setPorcentajeEstadisticoPregunta(calificacion.getPorcentajeFactorSumado());
            
            //busco los datos del factor
            for (Factores factores : listadoFactores){
                if(factores.getId().intValue()==calificacion.getIdCalificacionFactor().intValue()){
                    calificacionPojo.setNombreFactor(factores.getNombre());
                    calificacionPojo.setPorcentajeEstadisticoMinimo(factores.getPesoEstadistico()/2);                    
                }
            }
            calificacionesRespuesta.add(calificacionPojo);
        }
        //ahora busco el valor del proyecto
        CalificaciongeneralproyectoJpaController controladorGeneralProyecto = new CalificaciongeneralproyectoJpaController();
        List<Calificaciongeneralproyecto> proyectos=controladorGeneralProyecto.BuscarPreguntasPorUsuario(id);
        Calificaciongeneralproyecto proyecto=proyectos.get(0);
        //armamos la respuesta
        RespuestaGeneralPojo respuesta = new RespuestaGeneralPojo();
        respuesta.setFactor(calificacionesRespuesta);
        respuesta.setCalificacionEstadistica(proyecto.getPorcentajeRecomendacion());
        return respuesta;
    }
    
}
