/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestConnection;

import com.mycompany.Entities.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pc030
 */
public class TestConnectionDB {
    public static void main (String[] arg){
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("mavendbConnection");
        EntityManager em= emf.createEntityManager();
        Persona per= em.find(Persona.class, 2);
        System.out.println(per);
        System.out.println(per.getNombres());
        System.out.println("Test Finalizado");
        em.close();
    }
}
