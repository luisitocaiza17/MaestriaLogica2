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
@Table(name = "calificacionfactoresindglobales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacionfactoresindglobales.findAll", query = "SELECT c FROM Calificacionfactoresindglobales c")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findById", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.id = :id")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByEscalabilidadDinamica", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.escalabilidadDinamica = :escalabilidadDinamica")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByManejabilidad", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.manejabilidad = :manejabilidad")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByUtilizacionRecursos", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.utilizacionRecursos = :utilizacionRecursos")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByDisponibilidad", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.disponibilidad = :disponibilidad")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByFiabilidad", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.fiabilidad = :fiabilidad")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByIntegracionContinua", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.integracionContinua = :integracionContinua")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByModularidad", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.modularidad = :modularidad")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByMantenibilidad", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.mantenibilidad = :mantenibilidad")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByReusabilidad", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.reusabilidad = :reusabilidad")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByFlexibilidad", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.flexibilidad = :flexibilidad")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByInterOperabilidad", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.interOperabilidad = :interOperabilidad")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByCohesionAcoplamiento", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.cohesionAcoplamiento = :cohesionAcoplamiento")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByPortabilidad", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.portabilidad = :portabilidad")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByComputacionNube", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.computacionNube = :computacionNube")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByPorcentajeRecomendacion", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.porcentajeRecomendacion = :porcentajeRecomendacion")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByRecomendacionFinal", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.recomendacionFinal = :recomendacionFinal")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByEscalabilidadDinamicaSI", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.escalabilidadDinamicaSI = :escalabilidadDinamicaSI")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByManejabilidadSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.manejabilidadSi = :manejabilidadSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByUtilizacionRecursosSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.utilizacionRecursosSi = :utilizacionRecursosSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByDisponibilidadSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.disponibilidadSi = :disponibilidadSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByFiabilidadSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.fiabilidadSi = :fiabilidadSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByIntegracionContinuaSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.integracionContinuaSi = :integracionContinuaSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByMantenibilidadSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.mantenibilidadSi = :mantenibilidadSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByReusabilidadSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.reusabilidadSi = :reusabilidadSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByFlexibilidadSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.flexibilidadSi = :flexibilidadSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByInterOperabilidadSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.interOperabilidadSi = :interOperabilidadSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByCohesionAcoplamientoSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.cohesionAcoplamientoSi = :cohesionAcoplamientoSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByPortabilidadSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.portabilidadSi = :portabilidadSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByComputacionNubeSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.computacionNubeSi = :computacionNubeSi")
    , @NamedQuery(name = "Calificacionfactoresindglobales.findByPorcentajeRecomendacionSi", query = "SELECT c FROM Calificacionfactoresindglobales c WHERE c.porcentajeRecomendacionSi = :porcentajeRecomendacionSi")})
public class Calificacionfactoresindglobales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EscalabilidadDinamica")
    private Float escalabilidadDinamica;
    @Column(name = "Manejabilidad")
    private Float manejabilidad;
    @Column(name = "UtilizacionRecursos")
    private Float utilizacionRecursos;
    @Column(name = "Disponibilidad")
    private Float disponibilidad;
    @Column(name = "Fiabilidad")
    private Float fiabilidad;
    @Column(name = "IntegracionContinua")
    private Float integracionContinua;
    @Column(name = "Modularidad")
    private Float modularidad;
    @Column(name = "Mantenibilidad")
    private Float mantenibilidad;
    @Column(name = "Reusabilidad")
    private Float reusabilidad;
    @Column(name = "Flexibilidad")
    private Float flexibilidad;
    @Column(name = "InterOperabilidad")
    private Float interOperabilidad;
    @Column(name = "CohesionAcoplamiento")
    private Float cohesionAcoplamiento;
    @Column(name = "Portabilidad")
    private Float portabilidad;
    @Column(name = "ComputacionNube")
    private Float computacionNube;
    @Column(name = "PorcentajeRecomendacion")
    private Float porcentajeRecomendacion;
    @Size(max = 200)
    @Column(name = "RecomendacionFinal")
    private String recomendacionFinal;
    @Column(name = "EscalabilidadDinamicaSI")
    private Short escalabilidadDinamicaSI;
    @Column(name = "ManejabilidadSi")
    private Short manejabilidadSi;
    @Column(name = "UtilizacionRecursosSi")
    private Short utilizacionRecursosSi;
    @Column(name = "DisponibilidadSi")
    private Short disponibilidadSi;
    @Column(name = "FiabilidadSi")
    private Short fiabilidadSi;
    @Column(name = "IntegracionContinuaSi")
    private Short integracionContinuaSi;
    @Column(name = "MantenibilidadSi")
    private Short mantenibilidadSi;
    @Column(name = "ReusabilidadSi")
    private Short reusabilidadSi;
    @Column(name = "FlexibilidadSi")
    private Short flexibilidadSi;
    @Column(name = "InterOperabilidadSi")
    private Short interOperabilidadSi;
    @Column(name = "CohesionAcoplamientoSi")
    private Short cohesionAcoplamientoSi;
    @Column(name = "PortabilidadSi")
    private Short portabilidadSi;
    @Column(name = "ComputacionNubeSi")
    private Short computacionNubeSi;
    @Column(name = "PorcentajeRecomendacionSi")
    private Short porcentajeRecomendacionSi;
    @Column(name = "ModularidadSi")
    private Short ModularidadSi;
    @Column(name = "idProyecto")
    private Integer idProyecto;

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }
    

    public Short getModularidadSi() {
        return ModularidadSi;
    }

    public void setModularidadSi(Short ModularidadSi) {
        this.ModularidadSi = ModularidadSi;
    }
    
    
    public Calificacionfactoresindglobales() {
    }

    public Calificacionfactoresindglobales(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getEscalabilidadDinamica() {
        return escalabilidadDinamica;
    }

    public void setEscalabilidadDinamica(Float escalabilidadDinamica) {
        this.escalabilidadDinamica = escalabilidadDinamica;
    }

    public Float getManejabilidad() {
        return manejabilidad;
    }

    public void setManejabilidad(Float manejabilidad) {
        this.manejabilidad = manejabilidad;
    }

    public Float getUtilizacionRecursos() {
        return utilizacionRecursos;
    }

    public void setUtilizacionRecursos(Float utilizacionRecursos) {
        this.utilizacionRecursos = utilizacionRecursos;
    }

    public Float getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Float disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Float getFiabilidad() {
        return fiabilidad;
    }

    public void setFiabilidad(Float fiabilidad) {
        this.fiabilidad = fiabilidad;
    }

    public Float getIntegracionContinua() {
        return integracionContinua;
    }

    public void setIntegracionContinua(Float integracionContinua) {
        this.integracionContinua = integracionContinua;
    }

    public Float getModularidad() {
        return modularidad;
    }

    public void setModularidad(Float modularidad) {
        this.modularidad = modularidad;
    }

    public Float getMantenibilidad() {
        return mantenibilidad;
    }

    public void setMantenibilidad(Float mantenibilidad) {
        this.mantenibilidad = mantenibilidad;
    }

    public Float getReusabilidad() {
        return reusabilidad;
    }

    public void setReusabilidad(Float reusabilidad) {
        this.reusabilidad = reusabilidad;
    }

    public Float getFlexibilidad() {
        return flexibilidad;
    }

    public void setFlexibilidad(Float flexibilidad) {
        this.flexibilidad = flexibilidad;
    }

    public Float getInterOperabilidad() {
        return interOperabilidad;
    }

    public void setInterOperabilidad(Float interOperabilidad) {
        this.interOperabilidad = interOperabilidad;
    }

    public Float getCohesionAcoplamiento() {
        return cohesionAcoplamiento;
    }

    public void setCohesionAcoplamiento(Float cohesionAcoplamiento) {
        this.cohesionAcoplamiento = cohesionAcoplamiento;
    }

    public Float getPortabilidad() {
        return portabilidad;
    }

    public void setPortabilidad(Float portabilidad) {
        this.portabilidad = portabilidad;
    }

    public Float getComputacionNube() {
        return computacionNube;
    }

    public void setComputacionNube(Float computacionNube) {
        this.computacionNube = computacionNube;
    }

    public Float getPorcentajeRecomendacion() {
        return porcentajeRecomendacion;
    }

    public void setPorcentajeRecomendacion(Float porcentajeRecomendacion) {
        this.porcentajeRecomendacion = porcentajeRecomendacion;
    }

    public String getRecomendacionFinal() {
        return recomendacionFinal;
    }

    public void setRecomendacionFinal(String recomendacionFinal) {
        this.recomendacionFinal = recomendacionFinal;
    }

    public Short getEscalabilidadDinamicaSI() {
        return escalabilidadDinamicaSI;
    }

    public void setEscalabilidadDinamicaSI(Short escalabilidadDinamicaSI) {
        this.escalabilidadDinamicaSI = escalabilidadDinamicaSI;
    }

    public Short getManejabilidadSi() {
        return manejabilidadSi;
    }

    public void setManejabilidadSi(Short manejabilidadSi) {
        this.manejabilidadSi = manejabilidadSi;
    }

    public Short getUtilizacionRecursosSi() {
        return utilizacionRecursosSi;
    }

    public void setUtilizacionRecursosSi(Short utilizacionRecursosSi) {
        this.utilizacionRecursosSi = utilizacionRecursosSi;
    }

    public Short getDisponibilidadSi() {
        return disponibilidadSi;
    }

    public void setDisponibilidadSi(Short disponibilidadSi) {
        this.disponibilidadSi = disponibilidadSi;
    }

    public Short getFiabilidadSi() {
        return fiabilidadSi;
    }

    public void setFiabilidadSi(Short fiabilidadSi) {
        this.fiabilidadSi = fiabilidadSi;
    }

    public Short getIntegracionContinuaSi() {
        return integracionContinuaSi;
    }

    public void setIntegracionContinuaSi(Short integracionContinuaSi) {
        this.integracionContinuaSi = integracionContinuaSi;
    }

    public Short getMantenibilidadSi() {
        return mantenibilidadSi;
    }

    public void setMantenibilidadSi(Short mantenibilidadSi) {
        this.mantenibilidadSi = mantenibilidadSi;
    }

    public Short getReusabilidadSi() {
        return reusabilidadSi;
    }

    public void setReusabilidadSi(Short reusabilidadSi) {
        this.reusabilidadSi = reusabilidadSi;
    }

    public Short getFlexibilidadSi() {
        return flexibilidadSi;
    }

    public void setFlexibilidadSi(Short flexibilidadSi) {
        this.flexibilidadSi = flexibilidadSi;
    }

    public Short getInterOperabilidadSi() {
        return interOperabilidadSi;
    }

    public void setInterOperabilidadSi(Short interOperabilidadSi) {
        this.interOperabilidadSi = interOperabilidadSi;
    }

    public Short getCohesionAcoplamientoSi() {
        return cohesionAcoplamientoSi;
    }

    public void setCohesionAcoplamientoSi(Short cohesionAcoplamientoSi) {
        this.cohesionAcoplamientoSi = cohesionAcoplamientoSi;
    }

    public Short getPortabilidadSi() {
        return portabilidadSi;
    }

    public void setPortabilidadSi(Short portabilidadSi) {
        this.portabilidadSi = portabilidadSi;
    }

    public Short getComputacionNubeSi() {
        return computacionNubeSi;
    }

    public void setComputacionNubeSi(Short computacionNubeSi) {
        this.computacionNubeSi = computacionNubeSi;
    }

    public Short getPorcentajeRecomendacionSi() {
        return porcentajeRecomendacionSi;
    }

    public void setPorcentajeRecomendacionSi(Short porcentajeRecomendacionSi) {
        this.porcentajeRecomendacionSi = porcentajeRecomendacionSi;
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
        if (!(object instanceof Calificacionfactoresindglobales)) {
            return false;
        }
        Calificacionfactoresindglobales other = (Calificacionfactoresindglobales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entities.Calificacionfactoresindglobales[ id=" + id + " ]";
    }
    
}
