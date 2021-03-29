/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.company.logic.RegistroDatosLogic;
import com.company.logic.ResponseLogic;
import com.company.logic.UsuarioLogic;
import com.company.logic.pojos.CalificacionFactorPojo;
import com.company.logic.pojos.Msg;
import com.company.logic.pojos.RespuestaGeneralPojo;
import com.company.logic.pojos.UsuarioPojo;
import com.mycompany.Entities.Usuario;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author pc030
 */
@Path("RegistroDatos")
public class RegistroDatosController {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RegistroDatosController
     */
    public RegistroDatosController() {
    }

    /*
    POST http://localhost:8080/JavaServicesMavenHibernateJPA/webresources/RegistroDatos/RegistrarPregunta HTTP/1.1
    Host: localhost:8080
    Connection: keep-alive
    Cache-Control: max-age=0
    Upgrade-Insecure-Requests: 1
    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36
    Accept-Encoding: gzip, deflate, br
    Accept-Language: en-US,en;q=0.9,es;q=0.8
    Content-Length: 113
    Content-Type: application/json
    CodigoPlataforma: 7
    Token: 123

    {
       "id":0,
       "idUsuario":1,
       "idPregunta":1,
       "calificacion":"5",
       "porcentajeEstadistico":11.11
    }
    */
    
    @Path("RegistrarPregunta")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public Response RegistrarPregunta(@Context HttpHeaders headers,CalificacionFactorPojo calificacion) {
        //asi podemos tomar los parametros enviados en los headers 
        try{
            String CodigoPlataforma = headers.getRequestHeader("CodigoPlataforma").get(0);
            String Token = headers.getRequestHeader("Token").get(0);
            //verifico token
            if(!Token.equals("123"))
                  return Response.status(Response.Status.UNAUTHORIZED).entity("Acceso no Autorizado").build();
            //realizamos la logica de creacion de personas y proyectos
            Boolean estadoProceso= RegistroDatosLogic.registrarPreguntaUsuario(calificacion);
            Msg response=ResponseLogic.response_OK(estadoProceso, "Correcto");
            return Response.ok(response, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){            
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el servicio").build();
        }
    }
    
    /**
     * Retrieves representation of an instance of com.mycompany.services.UsuarioController
     * @return an instance of java.lang.String
     */
    @Path("ProcesarArquitectura")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response BuscarUsuarioPorId(@Context HttpHeaders headers,@QueryParam("idProyecto") int idProyecto) {
        try{
            String CodigoPlataforma = headers.getRequestHeader("CodigoPlataforma").get(0);
            String Token = headers.getRequestHeader("Token").get(0);
            //verifico token
            if(!Token.equals("123"))
                  return Response.status(Response.Status.UNAUTHORIZED).entity("Acceso no Autorizado").build();
            //realizamos la logica de creacion de personas y proyectos
            RespuestaGeneralPojo respuesta= RegistroDatosLogic.procesarArquitectura(idProyecto);
            Msg response=ResponseLogic.response_OK(respuesta, "Correcto");
            return Response.ok(response, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){ 
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el servicio").build();
        }
    } 
    
    /**
     * Retrieves representation of an instance of com.mycompany.services.UsuarioController
     * @return an instance of java.lang.String
     */
    @Path("leerCalificacionArquitectura")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response leerCalificacionArquitectura(@Context HttpHeaders headers,@QueryParam("idProyecto") int idProyecto) {
        try{
            String CodigoPlataforma = headers.getRequestHeader("CodigoPlataforma").get(0);
            String Token = headers.getRequestHeader("Token").get(0);
            //verifico token
            if(!Token.equals("123"))
                  return Response.status(Response.Status.UNAUTHORIZED).entity("Acceso no Autorizado").build();
            //realizamos la logica de creacion de personas y proyectos
            RespuestaGeneralPojo respuesta= RegistroDatosLogic.buscarDatosArquitectura(idProyecto);
            Msg response=ResponseLogic.response_OK(respuesta, "Correcto");
            return Response.ok(response, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){ 
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el servicio").build();
        }
    }  
}
