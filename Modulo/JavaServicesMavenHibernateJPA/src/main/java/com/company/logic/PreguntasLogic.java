/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.logic;

import com.mycompany.Entities.Preguntas;
import com.mycompany.dao.PreguntasJpaController;
import java.util.List;

/**
 *
 * @author pc030
 */
public class PreguntasLogic {
    
    public static List<Preguntas> buscarListadoPregunta(){
        PreguntasJpaController controlador = new PreguntasJpaController();
        List<Preguntas> preguntas= controlador.BuscarPreguntasTodas();
        return preguntas; 
    }
}
