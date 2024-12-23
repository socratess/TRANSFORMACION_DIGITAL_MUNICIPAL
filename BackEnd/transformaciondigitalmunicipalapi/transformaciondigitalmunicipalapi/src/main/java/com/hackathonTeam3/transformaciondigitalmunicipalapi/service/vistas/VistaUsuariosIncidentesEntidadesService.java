package com.hackathonTeam3.transformaciondigitalmunicipalapi.service.vistas;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas.VistaUsuariosIncidentesEntidadesDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class VistaUsuariosIncidentesEntidadesService {
 
     @Autowired
    private EntityManager entityManager;

    public List<VistaUsuariosIncidentesEntidadesDTO> obtenerVistasUsuariosIncidentesEntidades() {
      
   Query query = entityManager.createNativeQuery("SELECT * FROM vista_usuarios_con_incidentes_a_entidades");
       @SuppressWarnings("unchecked")
    List<Object []> resultados = query.getResultList();
       return resultados.stream().map(this::convertirDTO).collect(Collectors.toList());

    }

   private VistaUsuariosIncidentesEntidadesDTO convertirDTO(Object[] objects){
    VistaUsuariosIncidentesEntidadesDTO uigDTO = new VistaUsuariosIncidentesEntidadesDTO();
    uigDTO.setId(((Number) objects[0]).longValue());
    uigDTO.setNombre((String) objects[1]);
    uigDTO.setEdad(((Number) objects[2]).doubleValue());
    uigDTO.setNumeroIncidentes(((Number) objects[3]).longValue());
    uigDTO.setListaIncidentes((String) objects[4]);
    uigDTO.setListaEntidades((String) objects[5]);
        return uigDTO;
    }




}
