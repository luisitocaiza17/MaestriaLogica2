/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import TestConnection.pepito;
import com.company.logic.FactoresLogic;
import com.company.logic.ResponseLogic;
import com.company.logic.UsuarioLogic;
import com.company.logic.pojos.DataPojo;
import com.company.logic.pojos.Msg;
import com.company.logic.pojos.UsuarioPojo;
import com.mycompany.Entities.Calificacionfactoresindglobales;
import com.mycompany.Entities.Persona;
import com.mycompany.Entities.Usuario;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("Usuario")
public class UsuarioController {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.services.UsuarioController
     * @return an instance of java.lang.String
     */
    @Path("BuscarUsuarioPorId")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario BuscarUsuarioPorId(@QueryParam("idUsuario") int idUsuario) {
        //http://localhost:8080/JavaServicesMavenHibernateJPA/webresources/Usuario/BuscarUsuarioPorId?idUsuario=2 
        Usuario usuario= UsuarioLogic.buscarUsuario(idUsuario);
        
        return usuario;
    }  
    
    //servivio para crear el proyecto el usuario y el correo devuelve el objeto creado
    //http://localhost:8080/JavaServicesMavenHibernateJPA/webresources/Usuario/CrearUsuarioProyecto
    /*
    {
        "nombre":"nuevo",
        "correoElectronico":"lcaiza@gmail.com",
        "nombreProyecto":"nuevo"
    }
    */
    
    @Path("CrearUsuarioProyecto")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public Response CrearUsuarioProyecto(@Context HttpHeaders headers,UsuarioPojo usuario) {
        //asi podemos tomar los parametros enviados en los headers 
        try{
            String CodigoPlataforma = headers.getRequestHeader("CodigoPlataforma").get(0);
            String Token = headers.getRequestHeader("Token").get(0);
            //verifico token
            if(!Token.equals("123"))
                  return Response.status(Response.Status.UNAUTHORIZED).entity("Acceso no Autorizado").build();
            //realizamos la logica de creacion de personas y proyectos
            Usuario usuariosEncontrados= UsuarioLogic.CrearUsuarioProyecto(usuario);
            Msg response=ResponseLogic.response_OK(usuariosEncontrados, "Correcto");
            return Response.ok(response, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){            
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el servicio").build();
        }
    }
    
    @Path("GuardarDatos")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public Response GuardarDatos(@Context HttpHeaders headers,DataPojo data) {
        //asi podemos tomar los parametros enviados en los headers 
        try{
            String CodigoPlataforma = headers.getRequestHeader("CodigoPlataforma").get(0);
            String Token = headers.getRequestHeader("Token").get(0);
            //verifico token
            if(!Token.equals("123"))
                  return Response.status(Response.Status.UNAUTHORIZED).entity("Acceso no Autorizado").build();
            //realizamos la logica de creacion de personas y proyectos
            Calificacionfactoresindglobales res= FactoresLogic.guardarData(data);
            Msg response=ResponseLogic.response_OK(res, "Correcto");
            return Response.ok(response, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){            
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el servicio").build();
        }
    }
    
    
}
