/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.logic;

import com.company.logic.pojos.UsuarioPojo;
import com.mycompany.Entities.Usuario;
import com.mycompany.dao.UsuarioJpaController;
import java.util.List;

/**
 *
 * @author pc030
 */
public class UsuarioLogic {
    
    public static Usuario buscarUsuario (int identificador){
        UsuarioJpaController  baseUsuario = new UsuarioJpaController();
        Usuario usuarioEncontrado= baseUsuario.findUsuario(identificador);
        return usuarioEncontrado;
    }
    
    public static Usuario CrearUsuarioProyecto(UsuarioPojo usuarioPantalla) throws Exception{
        UsuarioJpaController  baseUsuario = new UsuarioJpaController();
        //busco el ultimo id ingresado
        int lastId=baseUsuario.findLastId()+1;
        
        Usuario usu = new Usuario();
        usu.setId(lastId);
        usu.setCorreoElectronico(usuarioPantalla.getCorreoElectronico());
        usu.setNombre(usuarioPantalla.getNombre());
        usu.setNombreProyecto(usuarioPantalla.getNombreProyecto());
        baseUsuario.create(usu);
        //si se creo voy a tomat el id para saber a quien le pertenece
        return usu;
    }
}
