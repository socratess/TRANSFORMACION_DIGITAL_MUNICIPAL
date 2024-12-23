package com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas;

public class VistaUsuariosIncidentesEntidadesDTO {
    
    private Long id;
    private String nombre;
    private Double edad;
    public Long getNumeroIncidentes() {
        return numeroIncidentes;
    }
    public void setNumeroIncidentes(Long numeroIncidentes) {
        this.numeroIncidentes = numeroIncidentes;
    }
    public String getListaIncidentes() {
        return listaIncidentes;
    }
    public void setListaIncidentes(String listaIncidentes) {
        this.listaIncidentes = listaIncidentes;
    }
    public String getListaEntidades() {
        return listaEntidades;
    }
    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }
    private Long numeroIncidentes;
    private String listaIncidentes;
    private String listaEntidades;
    
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
    public Double getEdad() {
        return edad;
    }
    public void setEdad(Double edad) {
        this.edad = edad;
    }
}
