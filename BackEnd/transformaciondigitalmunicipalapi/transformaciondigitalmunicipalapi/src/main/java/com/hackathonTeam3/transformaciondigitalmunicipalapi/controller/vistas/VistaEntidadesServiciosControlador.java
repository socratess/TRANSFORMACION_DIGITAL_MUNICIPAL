package com.hackathonTeam3.transformaciondigitalmunicipalapi.controller.vistas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas.VistaEntidadesServiciosDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.vistas.VistaEntidadesServiciosServicio;

@RestController
@RequestMapping("/api/vista-entidades-servicios")
public class VistaEntidadesServiciosControlador {
    

    @Autowired
    private VistaEntidadesServiciosServicio vistaEntidadesServiciosServicio;

    @GetMapping
    public List<VistaEntidadesServiciosDTO> obtenerVistasEntidadesServicios(){
        return vistaEntidadesServiciosServicio.obtenerVistasEntidadesServicios();
    }


}
