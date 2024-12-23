package com.hackathonTeam3.transformaciondigitalmunicipalapi.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios_gubernamentales")
public class UsuarioGubernamentalEntity {
    

    @Id
    @NotNull
    @Column(unique=true,nullable = false)
    private Long id;


    @NotNull
    @Column(nullable = false)
    @Size(min=5,max=70)
    private String nombre;

    @NotNull
    @Column(nullable = false)
    private String correoElectronico;

    @NotNull
    @Column(nullable = false)
    private Double telefono;

    @NotNull
    @Column(nullable = false)
    private Double edad;

    @OneToMany(mappedBy = "usuarioGubernamentalEntity", cascade = CascadeType.ALL)    
    private List<TramiteGubernamentalEntity> tramiteGubernamentalEntities;

    @OneToMany(mappedBy = "usuarioGubernamentalEntity", cascade = CascadeType.ALL)    
    private List<CitaGubernamentalEntity> citaGubernamentalEntities;
    
    @OneToMany(mappedBy = "usuarioGubernamentalEntity", cascade = CascadeType.ALL)    
    private List<IncidenteGubernamentalEntity> incidenteGubernamentalEntities;

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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Double getTelefono() {
        return telefono;
    }

    public void setTelefono(Double telefono) {
        this.telefono = telefono;
    }

    public Double getEdad() {
        return edad;
    }

    public void setEdad(Double edad) {
        this.edad = edad;
    }

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
 
    
    
}
