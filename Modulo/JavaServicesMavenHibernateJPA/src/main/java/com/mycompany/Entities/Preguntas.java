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
@Table(name = "preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p")
    , @NamedQuery(name = "Preguntas.findById", query = "SELECT p FROM Preguntas p WHERE p.id = :id")
    , @NamedQuery(name = "Preguntas.findByIdFactor", query = "SELECT p FROM Preguntas p WHERE p.idFactor = :idFactor")
    , @NamedQuery(name = "Preguntas.findByNombre", query = "SELECT p FROM Preguntas p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Preguntas.findByPeso", query = "SELECT p FROM Preguntas p WHERE p.peso = :peso")
    , @NamedQuery(name = "Preguntas.findByPesoEstadistico", query = "SELECT p FROM Preguntas p WHERE p.pesoEstadistico = :pesoEstadistico")
    , @NamedQuery(name = "Preguntas.findByPesoMinimo", query = "SELECT p FROM Preguntas p WHERE p.pesoMinimo = :pesoMinimo")
    , @NamedQuery(name = "Preguntas.findByPesoMinimoEstadistico", query = "SELECT p FROM Preguntas p WHERE p.pesoMinimoEstadistico = :pesoMinimoEstadistico")
    , @NamedQuery(name = "Preguntas.findByImportancia", query = "SELECT p FROM Preguntas p WHERE p.importancia = :importancia")
    , @NamedQuery(name = "Preguntas.findByFechaCreacion", query = "SELECT p FROM Preguntas p WHERE p.fechaCreacion = :fechaCreacion")})
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idFactor")
    private Integer idFactor;
    @Size(max = 400)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Float peso;
    @Column(name = "pesoEstadistico")
    private Float pesoEstadistico;
    @Column(name = "pesoMinimo")
    private Float pesoMinimo;
    @Column(name = "pesoMinimoEstadistico")
    private Float pesoMinimoEstadistico;
    @Column(name = "importancia")
    private Integer importancia;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 400)
    @Column(name = "Concepto")
    private String Concepto;
    @Size(max = 100)
    @Column(name = "valor5")
    private String valor5;
    @Size(max = 100)
    @Column(name = "valor4")
    private String valor4;
    @Size(max = 100)
    @Column(name = "valor3")
    private String valor3;
    @Size(max = 100)
    @Column(name = "valor2")
    private String valor2;
    @Size(max = 100)
    @Column(name = "valor1")
    private String valor1;
    
    public Preguntas() {
    }

    public Preguntas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(Integer idFactor) {
        this.idFactor = idFactor;
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

    public Float getPesoMinimo() {
        return pesoMinimo;
    }

    public void setPesoMinimo(Float pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }

    public Float getPesoMinimoEstadistico() {
        return pesoMinimoEstadistico;
    }

    public void setPesoMinimoEstadistico(Float pesoMinimoEstadistico) {
        this.pesoMinimoEstadistico = pesoMinimoEstadistico;
    }

    public Integer getImportancia() {
        return importancia;
    }

    public void setImportancia(Integer importancia) {
        this.importancia = importancia;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String Concepto) {
        this.Concepto = Concepto;
    }

    public String getValor5() {
        return valor5;
    }

    public void setValor5(String valor5) {
        this.valor5 = valor5;
    }

    public String getValor4() {
        return valor4;
    }

    public void setValor4(String valor4) {
        this.valor4 = valor4;
    }

    public String getValor3() {
        return valor3;
    }

    public void setValor3(String valor3) {
        this.valor3 = valor3;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
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
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entities.Preguntas[ id=" + id + " ]";
    }
    
}
