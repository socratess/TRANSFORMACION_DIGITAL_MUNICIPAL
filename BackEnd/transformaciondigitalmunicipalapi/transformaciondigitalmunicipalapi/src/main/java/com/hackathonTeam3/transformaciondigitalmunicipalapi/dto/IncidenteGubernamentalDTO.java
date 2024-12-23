package com.hackathonTeam3.transformaciondigitalmunicipalapi.dto;

public class IncidenteGubernamentalDTO {
    
    private Long id;
    private String nombre;
    private String tema;
    private String fechaAcontecimientos;
    private String estado;
    private Long entidadGubernamentalEntityId; 
    private Long usuarioGubernamentalEntityId;
    
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
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public String getFechaAcontecimientos() {
        return fechaAcontecimientos;
    }
    public void setFechaAcontecimientos(String fechaAcontecimientos) {
        this.fechaAcontecimientos = fechaAcontecimientos;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getEntidadGubernamentalEntityId() {
        return entidadGubernamentalEntityId;
    }
    public void setEntidadGubernamentalEntityId(Long entidadGubernamentalEntityId) {
        this.entidadGubernamentalEntityId = entidadGubernamentalEntityId;
    }
    public Long getUsuarioGubernamentalEntityId() {
        return usuarioGubernamentalEntityId;
    }
    public void setUsuarioGubernamentalEntityId(Long usuarioGubernamentalEntityId) {
        this.usuarioGubernamentalEntityId = usuarioGubernamentalEntityId;
    }

    
}
