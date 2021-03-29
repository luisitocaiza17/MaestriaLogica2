/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import TestConnection.pepito;
import com.company.logic.PersonaLogic;
import com.mycompany.Entities.Persona;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
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
@Path("Personas")
public class PersonasController {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonasController
     */
    public PersonasController( ) {
        
    }

    /**
     * Retrieves representation of an instance of com.mycompany.services.PersonasController
     * @return an instance of java.lang.String
     */
    @Path("BuscarPersonas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    public pepito getJson(@QueryParam("numeroPersona") int numeroPersona) {
        //TODO return proper representation object
        //Persona per= PersonaLogic.ConsultarPersona(numeroPersona);
        pepito p = new pepito();
        p.nombre="lui";
        p.apellido="caiza";
        try{
            PersonaLogic.crearPersona();
        }catch(Exception e){
            e.printStackTrace();
        }
        return p;
    }

    @Path("BuscarPersonasPost")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public Response TraerPersonaPost(@Context HttpHeaders headers,pepito pep) {
        //asi podemos tomar los parametros enviados en los headers 
        try{
            String CodigoPlataforma = headers.getRequestHeader("CodigoPlataforma").get(0);
            String Token = headers.getRequestHeader("Token").get(0);
            //verifico token
            if(!Token.equals("123"))
                  return Response.status(Response.Status.UNAUTHORIZED).entity("Acceso no Autorizado").build();
          
            //Persona per= PersonaLogic.ConsultarPersona(persona.id());
            pepito p = new pepito();
            p.nombre="lui";
            p.apellido="caiza";
            
            return Response.ok(p, MediaType.APPLICATION_JSON).build();
        }catch(Exception e){            
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el servicio").build();
        }
    }
    
}
