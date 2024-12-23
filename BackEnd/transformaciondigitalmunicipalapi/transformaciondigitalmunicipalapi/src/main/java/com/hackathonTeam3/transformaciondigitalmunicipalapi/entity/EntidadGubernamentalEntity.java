package com.hackathonTeam3.transformaciondigitalmunicipalapi.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "entidades_gubernamentales")
public class EntidadGubernamentalEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Size(min=5,max=70)
    private String nombre;
    
    @NotNull
    @Column(nullable = false)
    @Size(min=5,max=700)
    private String horarioLaboral;

    @NotNull
    @Column(nullable = false)
    @Size(min=5,max=700)
    private String ubicacion;

    @NotNull
    @Column(nullable = false)
    private Double telefono;

    @NotNull
    @Column(nullable = false)
    private String correoElectronico;

    @OneToMany(mappedBy = "entidadGubernamentalEntity", cascade = CascadeType.ALL)    
    private List<ServicioGubernamentalEntity> servicioGubernamentalEntities;

    @OneToMany(mappedBy = "entidadGubernamentalEntity", cascade = CascadeType.ALL)    
    private List<ObraGubernamentalEntity> obraGubernamentalEntities;

    @OneToMany(mappedBy = "entidadGubernamentalEntity", cascade = CascadeType.ALL)    
    private List<TramiteGubernamentalEntity> tramiteGubernamentalEntities;

    @OneToMany(mappedBy = "entidadGubernamentalEntity", cascade = CascadeType.ALL)    
    private List<CitaGubernamentalEntity> citaGubernamentalEntities;
    
    @OneToMany(mappedBy = "entidadGubernamentalEntity", cascade = CascadeType.ALL)    
    private List<IncidenteGubernamentalEntity> incidenteGubernamentalEntities;

    public List<TramiteGubernamentalEntity> getTramiteGubernamentalEntities() {
        return tramiteGubernamentalEntities;
    }


    public void setTramiteGubernamentalEntities(List<TramiteGubernamentalEntity> tramiteGubernamentalEntities) {
        this.tramiteGubernamentalEntities = tramiteGubernamentalEntities;
    }


    public List<CitaGubernamentalEntity> getCitaGubernamentalEntities() {
        return citaGubernamentalEntities;
    }


    public void setCitaGubernamentalEntities(List<CitaGubernamentalEntity> citaGubernamentalEntities) {
        this.citaGubernamentalEntities = citaGubernamentalEntities;
    }


    public List<IncidenteGubernamentalEntity> getIncidenteGubernamentalEntities() {
        return incidenteGubernamentalEntities;
    }


    public void setIncidenteGubernamentalEntities(List<IncidenteGubernamentalEntity> incidenteGubernamentalEntities) {
        this.incidenteGubernamentalEntities = incidenteGubernamentalEntities;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getHorarioLaboral() {
        return horarioLaboral;
    }


    public void setHorarioLaboral(String horarioLaboral) {
        this.horarioLaboral = horarioLaboral;
    }


    public String getUbicacion() {
        return ubicacion;
    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    public Double getTelefono() {
        return telefono;
    }


    public void setTelefono(Double telefono) {
        this.telefono = telefono;
    }


    public String getCorreoElectronico() {
        return correoElectronico;
    }


    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }


    public List<ServicioGubernamentalEntity> getServicioGubernamentalEntities() {
        return servicioGubernamentalEntities;
    }


    public void setServicioGubernamentalEntities(List<ServicioGubernamentalEntity> servicioGubernamentalEntities) {
        this.servicioGubernamentalEntities = servicioGubernamentalEntities;
    }


    public List<ObraGubernamentalEntity> getObraGubernamentalEntities() {
        return obraGubernamentalEntities;
    }


    public void setObraGubernamentalEntities(List<ObraGubernamentalEntity> obraGubernamentalEntities) {
        this.obraGubernamentalEntities = obraGubernamentalEntities;
    }

}
