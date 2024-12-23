package com.hackathonTeam3.transformaciondigitalmunicipalapi.service.vistas;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas.VistaUsuariosCitasEntidadesDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class VistaUsuariosCitasEntidadesServicio {

    @Autowired
    private EntityManager entityManager;

    public List<VistaUsuariosCitasEntidadesDTO> obtenerVistasUsuariosCitasEntidades() {
       Query query = entityManager.createNativeQuery("SELECT * FROM vista_usuarios_con_citas_a_entidades");
       @SuppressWarnings("unchecked")
    List<Object []> resultados = query.getResultList();
       return resultados.stream().map(this::convertirDTO).collect(Collectors.toList());
    }
    
   private VistaUsuariosCitasEntidadesDTO convertirDTO(Object[] objects){
    VistaUsuariosCitasEntidadesDTO ucgDTO = new VistaUsuariosCitasEntidadesDTO();
    ucgDTO.setId(((Number) objects[0]).longValue());
    ucgDTO.setNombre((String) objects[1]);
    ucgDTO.setEdad(((Number) objects[2]).doubleValue());
    ucgDTO.setNumeroCitas(((Number) objects[3]).longValue());
    ucgDTO.setListaCitas((String) objects[4]);
    ucgDTO.setListaEntidades((String) objects[5]);
        return ucgDTO;
    }


}
