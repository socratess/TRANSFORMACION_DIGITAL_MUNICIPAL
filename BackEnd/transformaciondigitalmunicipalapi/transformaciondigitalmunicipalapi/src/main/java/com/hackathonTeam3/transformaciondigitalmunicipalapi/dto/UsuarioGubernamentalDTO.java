package com.hackathonTeam3.transformaciondigitalmunicipalapi.dto;

public class UsuarioGubernamentalDTO {
    
    private Long id;
    private String nombre;
    private String correoElectronico;
    private Double telefono;
    private Double edad;
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


    
}
