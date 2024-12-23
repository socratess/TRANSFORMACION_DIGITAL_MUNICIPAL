package com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas;

public class VistaUsuariosTramitesEntidadesDTO {
    
    private Long id;
    private String nombre;
    private Double edad;
    private Long numeroTramites;
    private String listaTramites;
    private String listaEntidades;

    
    
    public Long getNumeroTramites() {
        return numeroTramites;
    }
    public void setNumeroTramites(Long numeroTramites) {
        this.numeroTramites = numeroTramites;
    }
    public String getListaTramites() {
        return listaTramites;
    }
    public void setListaTramites(String listaTramites) {
        this.listaTramites = listaTramites;
    }
    public String getListaEntidades() {
        return listaEntidades;
    }
    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
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
    public Double getEdad() {
        return edad;
    }
    public void setEdad(Double edad) {
        this.edad = edad;
    }    
}
