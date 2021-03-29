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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc030
 */
@Entity
@Table(name = "percepcionusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Percepcionusuario.findAll", query = "SELECT p FROM Percepcionusuario p")
    , @NamedQuery(name = "Percepcionusuario.findById", query = "SELECT p FROM Percepcionusuario p WHERE p.id = :id")
    , @NamedQuery(name = "Percepcionusuario.findByIdUsuario", query = "SELECT p FROM Percepcionusuario p WHERE p.idUsuario = :idUsuario")
    , @NamedQuery(name = "Percepcionusuario.findByLeSirvioLaApp", query = "SELECT p FROM Percepcionusuario p WHERE p.leSirvioLaApp = :leSirvioLaApp")
    , @NamedQuery(name = "Percepcionusuario.findByRecomendariaLaApp", query = "SELECT p FROM Percepcionusuario p WHERE p.recomendariaLaApp = :recomendariaLaApp")
    , @NamedQuery(name = "Percepcionusuario.findByComentarioMejora", query = "SELECT p FROM Percepcionusuario p WHERE p.comentarioMejora = :comentarioMejora")
    , @NamedQuery(name = "Percepcionusuario.findByCalificacion", query = "SELECT p FROM Percepcionusuario p WHERE p.calificacion = :calificacion")})
public class Percepcionusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Column(name = "leSirvioLaApp")
    private Short leSirvioLaApp;
    @Column(name = "recomendariaLaApp")
    private Short recomendariaLaApp;
    @Size(max = 200)
    @Column(name = "comentarioMejora")
    private String comentarioMejora;
    @Column(name = "Calificacion")
    private Integer calificacion;

    public Percepcionusuario() {
    }

    public Percepcionusuario(Integer id) {
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

    public Short getLeSirvioLaApp() {
        return leSirvioLaApp;
    }

    public void setLeSirvioLaApp(Short leSirvioLaApp) {
        this.leSirvioLaApp = leSirvioLaApp;
    }

    public Short getRecomendariaLaApp() {
        return recomendariaLaApp;
    }

    public void setRecomendariaLaApp(Short recomendariaLaApp) {
        this.recomendariaLaApp = recomendariaLaApp;
    }

    public String getComentarioMejora() {
        return comentarioMejora;
    }

    public void setComentarioMejora(String comentarioMejora) {
        this.comentarioMejora = comentarioMejora;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
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
        if (!(object instanceof Percepcionusuario)) {
            return false;
        }
        Percepcionusuario other = (Percepcionusuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entities.Percepcionusuario[ id=" + id + " ]";
    }
    
}
