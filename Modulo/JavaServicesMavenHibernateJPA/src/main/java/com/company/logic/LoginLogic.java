/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.logic;

import com.company.logic.pojos.Login;
import com.mycompany.Entities.Persona;
import com.mycompany.dao.PersonaJpaController;

/**
 *
 * @author luisi
 */
public class LoginLogic {
    public static Login validateUser(Login user){
        //verifico la existencia en la base de datos    
        PersonaJpaController perDB= new PersonaJpaController();
        Persona per=perDB.findByNameUser(user.getNombre(),user.getPassword());
        if(per!=null){
            user.setPersona(per);
            user.setEsCorrecto(true);
        }           
        return user;
    }
}
