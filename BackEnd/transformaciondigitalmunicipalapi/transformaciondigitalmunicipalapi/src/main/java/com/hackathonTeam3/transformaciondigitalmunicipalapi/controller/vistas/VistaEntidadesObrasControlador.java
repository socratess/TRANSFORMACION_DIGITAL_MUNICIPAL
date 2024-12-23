package com.hackathonTeam3.transformaciondigitalmunicipalapi.controller.vistas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas.VistaEntidadesObrasDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.vistas.VistaEntidadesObrasServicio;

@RestController
@RequestMapping("/api/vista-entidades-obras")
public class VistaEntidadesObrasControlador {
    

    @Autowired
    private VistaEntidadesObrasServicio vistaEntidadesObrasServicio;

    @GetMapping
    public List<VistaEntidadesObrasDTO> obtenerVistasEntidadesObras(){
        return vistaEntidadesObrasServicio.obtenerVistasEntidadesObras();
    }
}
