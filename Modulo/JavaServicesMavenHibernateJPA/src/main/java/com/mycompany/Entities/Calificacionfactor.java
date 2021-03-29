/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc030
 */
@Entity
@Table(name = "calificacionfactor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacionfactor.findAll", query = "SELECT c FROM Calificacionfactor c")
    , @NamedQuery(name = "Calificacionfactor.findById", query = "SELECT c FROM Calificacionfactor c WHERE c.id = :id")
    , @NamedQuery(name = "Calificacionfactor.findByIdUsuario", query = "SELECT c FROM Calificacionfactor c WHERE c.idUsuario = :idUsuario")
    , @NamedQuery(name = "Calificacionfactor.findByIdPreguna", query = "SELECT c FROM Calificacionfactor c WHERE c.idPreguna = :idPreguna")
    , @NamedQuery(name = "Calificacionfactor.findByCalificacion", query = "SELECT c FROM Calificacionfactor c WHERE c.calificacion = :calificacion")
    , @NamedQuery(name = "Calificacionfactor.findByPorcentajeEstadistico", query = "SELECT c FROM Calificacionfactor c WHERE c.porcentajeEstadistico = :porcentajeEstadistico")
    , @NamedQuery(name = "Calificacionfactor.findLastId", query = "SELECT u.id from Calificacionfactor u order by u.id DESC")
    , @NamedQuery(name = "Calificacionfactor.findByFechaCreacion", query = "SELECT c FROM Calificacionfactor c WHERE c.fechaCreacion = :fechaCreacion")})
public class Calificacionfactor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Column(name = "idPreguna")
    private Integer idPreguna;
    @Column(name = "idFactor")
    private Integer idFactor;
    @Column(name = "calificacion")
    private Integer calificacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentajeEstadistico")
    private Float porcentajeEstadistico;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    public Calificacionfactor() {
    }

    public Integer getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(Integer idFactor) {
        this.idFactor = idFactor;
    }

    public Calificacionfactor(Integer id) {
        this.id = id;
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

    public Integer getIdPreguna() {
        return idPreguna;
    }

    public void setIdPreguna(Integer idPreguna) {
        this.idPreguna = idPreguna;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacionfactor)) {
            return false;
        }
        Calificacionfactor other = (Calificacionfactor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entities.Calificacionfactor[ id=" + id + " ]";
    }
    
}
