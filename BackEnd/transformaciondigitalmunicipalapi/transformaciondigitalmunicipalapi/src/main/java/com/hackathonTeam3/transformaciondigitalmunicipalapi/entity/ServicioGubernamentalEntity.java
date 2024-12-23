package com.hackathonTeam3.transformaciondigitalmunicipalapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "servicios_gubernamentales")
public class ServicioGubernamentalEntity {
    
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Size(min=5,max=70)
    private String nombre;

    @NotNull
    @Column(nullable = false)
    @Size(min=5,max=70)
    private String tipo;

    @NotNull
    @Column(nullable = false)
    private Double financiacion;

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

    public EntidadGubernamentalEntity getEntidadGubernamentalEntity() {
        return entidadGubernamentalEntity;
    }

    public void setEntidadGubernamentalEntity(EntidadGubernamentalEntity entidadGubernamentalEntity) {
        this.entidadGubernamentalEntity = entidadGubernamentalEntity;
    }

    @NotNull
    @Column(nullable = false)
    @Size(min=5,max=70)
    private String estado;

    @NotNull
    @Column(nullable = false)
    @Size(min=5,max=70)
    private String duracion;

    @ManyToOne
    @JoinColumn(name = "entidades_gubernamentales_id", nullable = false)
    private EntidadGubernamentalEntity entidadGubernamentalEntity;

}
