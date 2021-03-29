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
@Table(name = "recomendacionproyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recomendacionproyecto.findAll", query = "SELECT r FROM Recomendacionproyecto r")
    , @NamedQuery(name = "Recomendacionproyecto.findById", query = "SELECT r FROM Recomendacionproyecto r WHERE r.id = :id")
    , @NamedQuery(name = "Recomendacionproyecto.findByIdUsuario", query = "SELECT r FROM Recomendacionproyecto r WHERE r.idUsuario = :idUsuario")
    , @NamedQuery(name = "Recomendacionproyecto.findByRecomiendaMicroservicios", query = "SELECT r FROM Recomendacionproyecto r WHERE r.recomiendaMicroservicios = :recomiendaMicroservicios")
    , @NamedQuery(name = "Recomendacionproyecto.findByComentario", query = "SELECT r FROM Recomendacionproyecto r WHERE r.comentario = :comentario")
    , @NamedQuery(name = "Recomendacionproyecto.findByValorMaximoObtenido", query = "SELECT r FROM Recomendacionproyecto r WHERE r.valorMaximoObtenido = :valorMaximoObtenido")
    , @NamedQuery(name = "Recomendacionproyecto.findByFechaCreacion", query = "SELECT r FROM Recomendacionproyecto r WHERE r.fechaCreacion = :fechaCreacion")})
public class Recomendacionproyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "recomiendaMicroservicios")
    private Float recomiendaMicroservicios;
    @Size(max = 200)
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "valorMaximoObtenido")
    private Float valorMaximoObtenido;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    public Recomendacionproyecto() {
    }

    public Recomendacionproyecto(Integer id) {
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

    public Float getRecomiendaMicroservicios() {
        return recomiendaMicroservicios;
    }

    public void setRecomiendaMicroservicios(Float recomiendaMicroservicios) {
        this.recomiendaMicroservicios = recomiendaMicroservicios;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Float getValorMaximoObtenido() {
        return valorMaximoObtenido;
    }

    public void setValorMaximoObtenido(Float valorMaximoObtenido) {
        this.valorMaximoObtenido = valorMaximoObtenido;
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
        if (!(object instanceof Recomendacionproyecto)) {
            return false;
        }
        Recomendacionproyecto other = (Recomendacionproyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entities.Recomendacionproyecto[ id=" + id + " ]";
    }
    
}
