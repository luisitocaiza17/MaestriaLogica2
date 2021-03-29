/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.logic;

import com.mycompany.Entities.Persona;
import com.mycompany.dao.PersonaJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pc030
 */
public class PersonaLogic {
    public static Persona ConsultarPersona(int id){
        try{
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("mavendbConnection");
        EntityManager em= emf.createEntityManager();
        Persona per= em.find(Persona.class, 2);
        System.out.println(per);
        System.out.println(per.getNombres());
        System.out.println("Test Finalizado");
        em.close();
        return per;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void crearPersona() throws Exception{
        PersonaJpaController controlador= new PersonaJpaController();
        Persona per= new Persona();
        per.setId(1000);
        per.setNombres("aa");
        per.setApellidos("dsfasfda");
        controlador.create(per);
    }
}
