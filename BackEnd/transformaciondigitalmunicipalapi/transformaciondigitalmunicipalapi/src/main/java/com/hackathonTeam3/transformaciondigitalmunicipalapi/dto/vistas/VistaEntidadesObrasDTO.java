package com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas;

public class VistaEntidadesObrasDTO {
    
private Long id; 
private String nombre; 
private String ubicacion;
private Long numero_obras;
private String lista_obras;
private Long total_inversion;
public String getLista_obras() {
    return lista_obras;
}
public void setLista_obras(String lista_obras) {
    this.lista_obras = lista_obras;
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
public Long getNumero_obras() {
    return numero_obras;
}
public void setNumero_obras(Long numero_obras) {
    this.numero_obras = numero_obras;
}
public Long getTotal_inversion() {
    return total_inversion;
}
public void setTotal_inversion(Long total_inversion) {
    this.total_inversion = total_inversion;
}
}
