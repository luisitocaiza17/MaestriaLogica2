/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import TestConnection.pepito;
import com.company.logic.LoginLogic;
import com.company.logic.PersonaLogic;
import com.company.logic.ResponseLogic;
import com.company.logic.pojos.Login;
import com.company.logic.pojos.Msg;
import com.mycompany.Entities.Persona;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
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
 * @author luisi
 */
@Path("Login")
public class LoginController {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LogicController
     */
    public LoginController() {
    }

    @Path("Estructura")
    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    public Login getJson() {
        //TODO return proper representation object
        Login l = new Login();
        l.setNombre("Luis");
        l.setPassword("Caiza");
        return l;
    }
    
    @Path("ValidateUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public Response TraerPersonaPost(@Context HttpHeaders headers,Login login) {
        //asi podemos tomar los parametros enviados en los headers 
        try{
            String CodigoPlataforma = headers.getRequestHeader("CodigoPlataforma").get(0);
            String Token = headers.getRequestHeader("Token").get(0);
            //verifico token
            if(!Token.equals("123"))
                  return Response.status(Response.Status.UNAUTHORIZED).entity("Acceso no Autorizado").build();
          
            Login loginValidate= LoginLogic.validateUser(login);
            Msg response=ResponseLogic.response_OK(loginValidate, "Correcto");
            return Response.ok(response, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){            
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el servicio").build();
        }
    }
}
