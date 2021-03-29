/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author pc030
 */
@Path("generic")
public class exampleService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of exampleService
     */
    public exampleService() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.services.exampleService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("numero") int numero) {
        //TODO return proper representation object
        return ""+numero+numero;
    }

    /**
     * PUT method for updating or creating an instance of exampleService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
