/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.logic.pojos;

import java.util.Date;

/**
 *
 * @author pc030
 */
public class CalificacionFactorPojo {
    private Integer id;
    private Integer idUsuario;
    private Integer idFactor;
    private Integer idPregunta;
    private Integer calificacion;
    private Float porcentajeEstadistico;
    private Date fechaCreacion;
    private Float porcentajeEstadisticoPregunta;
    private String nombreFactor;
    private Float porcentajeEstadisticoMinimo;

    public Float getPorcentajeEstadisticoMinimo() {
        return porcentajeEstadisticoMinimo;
    }

    public void setPorcentajeEstadisticoMinimo(Float porcentajeEstadisticoMinimo) {
        this.porcentajeEstadisticoMinimo = porcentajeEstadisticoMinimo;
    }

    
    
    public Integer getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(Integer idFactor) {
        this.idFactor = idFactor;
    }

    public String getNombreFactor() {
        return nombreFactor;
    }

    public void setNombreFactor(String nombreFactor) {
        this.nombreFactor = nombreFactor;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPreguna) {
        this.idPregunta = idPreguna;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Float getPorcentajeEstadistico() {
        return porcentajeEstadistico;
    }

    public void setPorcentajeEstadistico(Float porcentajeEstadistico) {
        this.porcentajeEstadistico = porcentajeEstadistico;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Float getPorcentajeEstadisticoPregunta() {
        return porcentajeEstadisticoPregunta;
    }

    public void setPorcentajeEstadisticoPregunta(Float porcentajeEstadisticoPregunta) {
        this.porcentajeEstadisticoPregunta = porcentajeEstadisticoPregunta;
    }
    
    
}
