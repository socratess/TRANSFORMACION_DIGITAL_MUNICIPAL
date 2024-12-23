package com.hackathonTeam3.transformaciondigitalmunicipalapi.dto;

public class ServicioGubernamentalDTO {
     
      
    private Long id;
    private String nombre;
    private String tipo;
    private Double financiacion;
    private String estado;
    private String duracion;
    private Long entidadGubernamentalEntityId;
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
    public Double getFinanciacion() {
        return financiacion;
    }
    public void setFinanciacion(Double financiacion) {
        this.financiacion = financiacion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getDuracion() {
        return duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public Long getEntidadGubernamentalEntityId() {
        return entidadGubernamentalEntityId;
    }
    public void setEntidadGubernamentalEntityId(Long entidadGubernamentalEntityId) {
        this.entidadGubernamentalEntityId = entidadGubernamentalEntityId;
    }

}
