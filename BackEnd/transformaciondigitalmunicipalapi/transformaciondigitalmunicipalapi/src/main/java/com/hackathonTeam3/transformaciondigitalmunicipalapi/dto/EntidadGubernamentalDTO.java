package com.hackathonTeam3.transformaciondigitalmunicipalapi.dto;

public class EntidadGubernamentalDTO {


    private Long id;
    private String nombre;
    private String horarioLaboral;
    private String ubicacion;
    private Double telefono;
    private String correoElectronico;
    
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

    
    
}
