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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc030
 */
@Entity
@Table(name = "calificaciongeneralproyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificaciongeneralproyecto.findAll", query = "SELECT c FROM Calificaciongeneralproyecto c")
    , @NamedQuery(name = "Calificaciongeneralproyecto.findByIdUsuario", query = "SELECT c FROM Calificaciongeneralproyecto c WHERE c.idUsuario = :idUsuario")
    , @NamedQuery(name = "Calificaciongeneralproyecto.findById", query = "SELECT c FROM Calificaciongeneralproyecto c WHERE c.id = :id")
    , @NamedQuery(name = "Calificaciongeneralproyecto.findByPorcentajeRecomendacion", query = "SELECT c FROM Calificaciongeneralproyecto c WHERE c.porcentajeRecomendacion = :porcentajeRecomendacion")
    , @NamedQuery(name = "Calificaciongeneralproyecto.findLastId", query = "SELECT u.id from Calificaciongeneralproyecto u order by u.id DESC")
    , @NamedQuery(name = "Calificaciongeneralproyecto.findByFechaCreacion", query = "SELECT c FROM Calificaciongeneralproyecto c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Calificaciongeneralproyecto.findByMensaje", query = "SELECT c FROM Calificaciongeneralproyecto c WHERE c.mensaje = :mensaje")})
public class Calificaciongeneralproyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentajeRecomendacion")
    private Float porcentajeRecomendacion;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 500)
    @Column(name = "Mensaje")
    private String mensaje;
    @Column(name = "idUsuario")
    private Integer idUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
        
    public Calificaciongeneralproyecto() {
    }

    public Calificaciongeneralproyecto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPorcentajeRecomendacion() {
        return porcentajeRecomendacion;
    }

    public void setPorcentajeRecomendacion(Float porcentajeRecomendacion) {
        this.porcentajeRecomendacion = porcentajeRecomendacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
        if (!(object instanceof Calificaciongeneralproyecto)) {
            return false;
        }
        Calificaciongeneralproyecto other = (Calificaciongeneralproyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entities.Calificaciongeneralproyecto[ id=" + id + " ]";
    }
    
}
