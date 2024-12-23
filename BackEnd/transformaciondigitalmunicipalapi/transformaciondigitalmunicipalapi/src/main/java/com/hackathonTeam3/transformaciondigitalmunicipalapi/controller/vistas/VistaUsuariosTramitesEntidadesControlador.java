package com.hackathonTeam3.transformaciondigitalmunicipalapi.controller.vistas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas.VistaUsuariosTramitesEntidadesDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.vistas.VistaUsuariosTramitesEntidadesService;

@RestController
@RequestMapping("/api/vista-usuario-tramite-entidades")
public class VistaUsuariosTramitesEntidadesControlador {
    

   
  @Autowired
    private VistaUsuariosTramitesEntidadesService vistaUsuariosTramitesEntidadesService;

    @GetMapping
    public List<VistaUsuariosTramitesEntidadesDTO> obtenerVistasUsuariosTramitesEntidades(){
        return vistaUsuariosTramitesEntidadesService.obtenerVistasUsuariosTramitesEntidades();
    }


}
