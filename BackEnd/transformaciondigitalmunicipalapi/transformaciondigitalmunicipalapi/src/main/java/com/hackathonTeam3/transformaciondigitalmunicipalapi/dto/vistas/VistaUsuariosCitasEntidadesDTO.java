package com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas;

public class VistaUsuariosCitasEntidadesDTO {
    
    private Long id;
    private String nombre;
    private Double edad;
    public Long getNumeroCitas() {
        return numeroCitas;
    }
    public void setNumeroCitas(Long numeroCitas) {
        this.numeroCitas = numeroCitas;
    }
    public String getListaCitas() {
        return listaCitas;
    }
    public void setListaCitas(String listaCitas) {
        this.listaCitas = listaCitas;
    }
    public String getListaEntidades() {
        return listaEntidades;
    }
    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }
    private Long numeroCitas;
    private String listaCitas;
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
