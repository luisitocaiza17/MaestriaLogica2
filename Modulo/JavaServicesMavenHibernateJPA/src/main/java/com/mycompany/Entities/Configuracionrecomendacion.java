/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc030
 */
@Entity
@Table(name = "configuracionrecomendacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracionrecomendacion.findAll", query = "SELECT c FROM Configuracionrecomendacion c")
    , @NamedQuery(name = "Configuracionrecomendacion.findById", query = "SELECT c FROM Configuracionrecomendacion c WHERE c.id = :id")
    , @NamedQuery(name = "Configuracionrecomendacion.findByValorMaximoRecomendado", query = "SELECT c FROM Configuracionrecomendacion c WHERE c.valorMaximoRecomendado = :valorMaximoRecomendado")
    , @NamedQuery(name = "Configuracionrecomendacion.findByValorMinimoRecomendado", query = "SELECT c FROM Configuracionrecomendacion c WHERE c.valorMinimoRecomendado = :valorMinimoRecomendado")
    , @NamedQuery(name = "Configuracionrecomendacion.findByMinimoPorcentajeRecomendado", query = "SELECT c FROM Configuracionrecomendacion c WHERE c.minimoPorcentajeRecomendado = :minimoPorcentajeRecomendado")})
public class Configuracionrecomendacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorMaximoRecomendado")
    private Float valorMaximoRecomendado;
    @Column(name = "valorMinimoRecomendado")
    private Float valorMinimoRecomendado;
    @Column(name = "minimoPorcentajeRecomendado")
    private Float minimoPorcentajeRecomendado;

    public Configuracionrecomendacion() {
    }

    public Configuracionrecomendacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValorMaximoRecomendado() {
        return valorMaximoRecomendado;
    }

    public void setValorMaximoRecomendado(Float valorMaximoRecomendado) {
        this.valorMaximoRecomendado = valorMaximoRecomendado;
    }

    public Float getValorMinimoRecomendado() {
        return valorMinimoRecomendado;
    }

    public void setValorMinimoRecomendado(Float valorMinimoRecomendado) {
        this.valorMinimoRecomendado = valorMinimoRecomendado;
    }

    public Float getMinimoPorcentajeRecomendado() {
        return minimoPorcentajeRecomendado;
    }

    public void setMinimoPorcentajeRecomendado(Float minimoPorcentajeRecomendado) {
        this.minimoPorcentajeRecomendado = minimoPorcentajeRecomendado;
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
        if (!(object instanceof Configuracionrecomendacion)) {
            return false;
        }
        Configuracionrecomendacion other = (Configuracionrecomendacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entities.Configuracionrecomendacion[ id=" + id + " ]";
    }
    
}
