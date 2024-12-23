package com.hackathonTeam3.transformaciondigitalmunicipalapi.controller.vistas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas.VistaUsuariosIncidentesEntidadesDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.vistas.VistaUsuariosIncidentesEntidadesService;

@RestController
@RequestMapping("/api/vista-usuario-incidente-entidades")
public class VistaUsuariosIncidentesEntidadesControlador {
    

   
  @Autowired
    private VistaUsuariosIncidentesEntidadesService vistaUsuariosIncidentesEntidadesService;

    @GetMapping
    public List<VistaUsuariosIncidentesEntidadesDTO> obtenerVistasUsuariosIncidentesEntidades(){
        return vistaUsuariosIncidentesEntidadesService.obtenerVistasUsuariosIncidentesEntidades();
    }

}
