package com.hackathonTeam3.transformaciondigitalmunicipalapi.dto;

public class ObraGubernamentalDTO {
       
    private Long id;
    private String nombre;
    private String tipo;
    private Double financiacion;
    private String estado;
    private String fechaInicio;
    private String fechaFinal;
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
    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFinal() {
        return fechaFinal;
    }
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    public Long getEntidadGubernamentalEntityId() {
        return entidadGubernamentalEntityId;
    }
    public void setEntidadGubernamentalEntityId(Long entidadGubernamentalEntityId) {
        this.entidadGubernamentalEntityId = entidadGubernamentalEntityId;
    }
   
}
