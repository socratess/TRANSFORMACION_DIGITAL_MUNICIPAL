package com.hackathonTeam3.transformaciondigitalmunicipalapi.dto;

public class TramiteGubernamentalDTO {
      
    private Long id;
    private String nombre;
    private String tipo;
    private String estado;
    private Long entidadGubernamentalEntityId; 
    private Long usuarioGubernamentalEntityId;
    
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
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    

}
