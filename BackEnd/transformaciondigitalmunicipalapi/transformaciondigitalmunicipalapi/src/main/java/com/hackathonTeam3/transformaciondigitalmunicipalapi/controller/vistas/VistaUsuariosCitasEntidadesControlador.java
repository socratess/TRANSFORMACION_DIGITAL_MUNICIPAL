package com.hackathonTeam3.transformaciondigitalmunicipalapi.controller.vistas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas.VistaUsuariosCitasEntidadesDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.vistas.VistaUsuariosCitasEntidadesServicio;

@RestController
@RequestMapping("/api/vista-usuario-cita-entidades")
public class VistaUsuariosCitasEntidadesControlador {
    
  @Autowired
    private VistaUsuariosCitasEntidadesServicio vistaUsuariosCitasEntidadesServicio;

    @GetMapping
    public List<VistaUsuariosCitasEntidadesDTO> obtenerVistasUsuariosCitasEntidades(){
        return vistaUsuariosCitasEntidadesServicio.obtenerVistasUsuariosCitasEntidades();
    }

}
