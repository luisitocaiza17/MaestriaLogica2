/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.company.logic.PreguntasLogic;
import com.company.logic.ResponseLogic;
import com.company.logic.UsuarioLogic;
import com.company.logic.pojos.Msg;
import com.mycompany.Entities.Preguntas;
import com.mycompany.Entities.Usuario;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
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
@Path("Preguntas")
public class PreguntasController {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PreguntasController
     */
    public PreguntasController() {
    }
    
    /**
     * Metodo que trae todas las preguntas almacenadas
     */
    //invocacion
    /*
    GET http://localhost:8080/JavaServicesMavenHibernateJPA/webresources/Preguntas/BuscarPreguntas HTTP/1.1
    Host: localhost:8080
    Connection: keep-alive
    Cache-Control: max-age=0
    Upgrade-Insecure-Requests: 1
    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36
    Sec-Fetch-Site: none
    Sec-Fetch-Mode: navigate
    Sec-Fetch-User: ?1
    Sec-Fetch-Dest: document
    Accept-Encoding: gzip, deflate, br
    Accept-Language: en-US,en;q=0.9,es;q=0.8
    Token: 123
    CodigoPlataforma: 7
*/    
    
    @Path("BuscarPreguntas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response BuscarPreguntas(@Context HttpHeaders headers) {
        try{
            String CodigoPlataforma = headers.getRequestHeader("CodigoPlataforma").get(0);
            String Token = headers.getRequestHeader("Token").get(0);
            //verifico token
            if(!Token.equals("123"))
                  return Response.status(Response.Status.UNAUTHORIZED).entity("Acceso no Autorizado").build();
            //realizamos la logica de creacion de personas y proyectos
            List<Preguntas> preguntasEncontradas= PreguntasLogic.buscarListadoPregunta();  
             Msg response=ResponseLogic.response_OK(preguntasEncontradas, "Correcto");
            return Response.ok(response, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){            
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el servicio").build();
        }
    } 
}
