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
@Table(name = "factores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factores.findAll", query = "SELECT f FROM Factores f")
    , @NamedQuery(name = "Factores.findById", query = "SELECT f FROM Factores f WHERE f.id = :id")
    , @NamedQuery(name = "Factores.findByNombre", query = "SELECT f FROM Factores f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Factores.findByPeso", query = "SELECT f FROM Factores f WHERE f.peso = :peso")
    , @NamedQuery(name = "Factores.findByPesoEstadistico", query = "SELECT f FROM Factores f WHERE f.pesoEstadistico = :pesoEstadistico")
    , @NamedQuery(name = "Factores.findByFechaCreacion", query = "SELECT f FROM Factores f WHERE f.fechaCreacion = :fechaCreacion")})
public class Factores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Float peso;
    @Column(name = "pesoEstadistico")
    private Float pesoEstadistico;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    public Factores() {
    }

    public Factores(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getPesoEstadistico() {
        return pesoEstadistico;
    }

    public void setPesoEstadistico(Float pesoEstadistico) {
        this.pesoEstadistico = pesoEstadistico;
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
        if (!(object instanceof Factores)) {
            return false;
        }
        Factores other = (Factores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entities.Factores[ id=" + id + " ]";
    }
    
}
