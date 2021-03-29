/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.logic;

import com.company.logic.pojos.DataPojo;
import com.mycompany.Entities.Calificacionfactoresindglobales;
import com.mycompany.Entities.Factores;
import com.mycompany.dao.CalificacionfactoresindglobalesJpaController;
import com.mycompany.dao.FactoresJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc030
 */
public class FactoresLogic {
    public static List<Factores> buscarFactores(){
        FactoresJpaController controlador = new FactoresJpaController();
        List<Factores> preguntas= controlador.BuscarFactoresTodos();
        return preguntas;
    }
    
     public static Calificacionfactoresindglobales guardarData(DataPojo datas){
        CalificacionfactoresindglobalesJpaController controlador = new CalificacionfactoresindglobalesJpaController();
        //transformo el objeto       
        Calificacionfactoresindglobales data = new Calificacionfactoresindglobales();
        data.setIdProyecto(datas.getIdProyecto());
        data.setCohesionAcoplamiento(datas.getCohesionAcoplamiento());
        data.setCohesionAcoplamientoSi(datas.getCohesionAcoplamientoSi()==true? (short)1:(short)0);
        data.setComputacionNube(datas.getComputacionNube());
        data.setComputacionNubeSi(datas.getComputacionNubeSi()==true? (short)1:(short)0);
        data.setDisponibilidad(datas.getDisponibilidad());
        data.setDisponibilidadSi(datas.getDisponibilidadSi()==true? (short)1:(short)0);
        data.setEscalabilidadDinamica(datas.getEscalabilidadDinamica());
        data.setEscalabilidadDinamicaSI(datas.getEscalabilidadDinamicaSI()==true? (short)1:(short)0);
        data.setFiabilidad(datas.getFiabilidad());
        data.setFiabilidadSi(datas.getFiabilidadSi()==true? (short)1:(short)0);
        data.setFlexibilidad(datas.getFlexibilidad());
        data.setFlexibilidadSi(datas.getFlexibilidadSi()==true? (short)1:(short)0);
        data.setIntegracionContinua(datas.getIntegracionContinua());
        data.setIntegracionContinuaSi(datas.getIntegracionContinuaSi()==true? (short)1:(short)0);
        data.setInterOperabilidad(datas.getInterOperabilidad());
        data.setInterOperabilidadSi(datas.getInterOperabilidadSi()==true? (short)1:(short)0);
        data.setManejabilidad(datas.getManejabilidad());
        data.setManejabilidadSi(datas.getManejabilidadSi()==true? (short)1:(short)0);
        data.setModularidad(datas.getModularidad());
        data.setModularidadSi(datas.getModularidadSi()==true? (short)1:(short)0);
        data.setMantenibilidad(datas.getMantenibilidad());
        data.setMantenibilidadSi(datas.getMantenibilidadSi()==true? (short)1:(short)0);
        data.setPorcentajeRecomendacion(datas.getPorcentajeRecomendacion());
        data.setPorcentajeRecomendacionSi(datas.getPorcentajeRecomendacionSi()==true? (short)1:(short)0);
        data.setPortabilidad(datas.getPortabilidad());
        data.setPortabilidadSi(datas.getPortabilidadSi()==true? (short)1:(short)0);
        data.setRecomendacionFinal(datas.getRecomendacionFinal());
        data.setReusabilidad(datas.getReusabilidad());
        data.setReusabilidadSi(datas.getReusabilidadSi()==true? (short)1:(short)0);
        data.setUtilizacionRecursos(datas.getUtilizacionRecursos());
        data.setUtilizacionRecursosSi(datas.getUtilizacionRecursosSi()==true? (short)1:(short)0);
        try {
            //guardamos en la base de datos.
            controlador.create(data);
            return data;
        } catch (Exception ex) {
            Logger.getLogger(FactoresLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }            
             
    }
}
