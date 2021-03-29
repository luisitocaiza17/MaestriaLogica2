/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.logic.pojos;

import java.util.List;

/**
 *
 * @author pc030
 */
public class RespuestaGeneralPojo {
    //devolvemos el listado calificado de factores
    List<CalificacionFactorPojo> factor;
    int idUsuario;
    float calificacionEstadistica;  
    String Recomendacion;

    public List<CalificacionFactorPojo> getFactor() {
        return factor;
    }

    public void setFactor(List<CalificacionFactorPojo> factor) {
        this.factor = factor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getCalificacionEstadistica() {
        return calificacionEstadistica;
    }

    public void setCalificacionEstadistica(float calificacionEstadistica) {
        this.calificacionEstadistica = calificacionEstadistica;
    }

    public String getRecomendacion() {
        return Recomendacion;
    }

    public void setRecomendacion(String Recomendacion) {
        this.Recomendacion = Recomendacion;
    }
    
}
