package com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas;

public class VistaEntidadesServiciosDTO {
    private Long id; 
private String nombre; 
private String ubicacion;
private Long numero_servicios;
private String lista_servicios;
private Long total_inversion;

public String getLista_servicios() {
    return lista_servicios;
}
public void setLista_servicios(String lista_servicios) {
    this.lista_servicios = lista_servicios;
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
public String getUbicacion() {
    return ubicacion;
}
public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
}
public Long getNumero_servicios() {
    return numero_servicios;
}
public void setNumero_servicios(Long numero_servicios) {
    this.numero_servicios = numero_servicios;
}
public Long getTotal_inversion() {
    return total_inversion;
}
public void setTotal_inversion(Long total_inversion) {
    this.total_inversion = total_inversion;
}


}
