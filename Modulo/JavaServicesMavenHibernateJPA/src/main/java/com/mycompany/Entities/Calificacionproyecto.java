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
@Table(name = "calificacionproyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacionproyecto.findAll", query = "SELECT c FROM Calificacionproyecto c")
    , @NamedQuery(name = "Calificacionproyecto.findById", query = "SELECT c FROM Calificacionproyecto c WHERE c.id = :id")
    , @NamedQuery(name = "Calificacionproyecto.findCalificacionProyecto", query = "SELECT c from Calificacionproyecto c WHERE c.idUsuario = :idUsuario")
    , @NamedQuery(name = "Calificacionproyecto.findByIdCalificacionFactor", query = "SELECT c FROM Calificacionproyecto c WHERE c.idCalificacionFactor = :idCalificacionFactor")
    , @NamedQuery(name = "Calificacionproyecto.findByPesoGeneral", query = "SELECT c FROM Calificacionproyecto c WHERE c.pesoGeneral = :pesoGeneral")
    , @NamedQuery(name = "Calificacionproyecto.findByPorcentajeGeneral", query = "SELECT c FROM Calificacionproyecto c WHERE c.porcentajeGeneral = :porcentajeGeneral")
    , @NamedQuery(name = "Calificacionproyecto.findLastId", query = "SELECT u.id from Calificacionproyecto u order by u.id DESC")
    , @NamedQuery(name = "Calificacionproyecto.findByFechaCreacion", query = "SELECT c FROM Calificacionproyecto c WHERE c.fechaCreacion = :fechaCreacion")})
public class Calificacionproyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idCalificacionFactor")
    private Integer idCalificacionFactor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pesoGeneral")
    private Float pesoGeneral;
    @Column(name = "porcentajeGeneral")
    private Float porcentajeGeneral;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Column(name = "porcentajeFactorSumado")
    private Float porcentajeFactorSumado;

    public Float getPorcentajeFactorSumado() {
        return porcentajeFactorSumado;
    }

    public void setPorcentajeFactorSumado(Float porcentajeFactorSumado) {
        this.porcentajeFactorSumado = porcentajeFactorSumado;
    }
    
    
    public Calificacionproyecto() {
    }

    public Calificacionproyecto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCalificacionFactor() {
        return idCalificacionFactor;
    }

    public void setIdCalificacionFactor(Integer idCalificacionFactor) {
        this.idCalificacionFactor = idCalificacionFactor;
    }

    public Float getPesoGeneral() {
        return pesoGeneral;
    }

    public void setPesoGeneral(Float pesoGeneral) {
        this.pesoGeneral = pesoGeneral;
    }

    public Float getPorcentajeGeneral() {
        return porcentajeGeneral;
    }

    public void setPorcentajeGeneral(Float porcentajeGeneral) {
        this.porcentajeGeneral = porcentajeGeneral;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Calificacionproyecto)) {
            return false;
        }
        Calificacionproyecto other = (Calificacionproyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entities.Calificacionproyecto[ id=" + id + " ]";
    }
    
}
