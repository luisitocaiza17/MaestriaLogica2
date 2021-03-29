/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.logic;

import com.company.logic.enums.ResponseEnum;
import com.company.logic.pojos.Msg;

/**
 *
 * @author luisi
 */
public class ResponseLogic {
    
    public static Msg response_OK(Object respuesta,String mensaje){
        Msg mensage= new Msg();
        mensage.data=respuesta;
        mensage.message=mensaje;
        mensage.status = "OK";
        return mensage;
    }
}
