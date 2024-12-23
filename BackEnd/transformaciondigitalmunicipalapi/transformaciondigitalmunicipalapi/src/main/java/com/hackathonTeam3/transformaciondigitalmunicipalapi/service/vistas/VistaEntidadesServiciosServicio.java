package com.hackathonTeam3.transformaciondigitalmunicipalapi.service.vistas;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas.VistaEntidadesServiciosDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class VistaEntidadesServiciosServicio {
    

    @Autowired
    private EntityManager entityManager;

    public List<VistaEntidadesServiciosDTO> obtenerVistasEntidadesServicios() {
        Query query = entityManager.createNativeQuery("SELECT * FROM vista_entidades_con_servicios");
        @SuppressWarnings("unchecked")
        List <Object []> resultados = query.getResultList();
        return resultados.stream().map(this::convertirDTO).collect(Collectors.toList());
    }
    private VistaEntidadesServiciosDTO convertirDTO(Object[] objects){
        VistaEntidadesServiciosDTO vESDTO = new VistaEntidadesServiciosDTO();
        vESDTO.setId(((Number) objects[0]).longValue());
        vESDTO.setNombre((String) objects[1]);
        vESDTO.setUbicacion((String) objects[2]);
        vESDTO.setNumero_servicios(((Number) objects[3]).longValue());
        vESDTO.setLista_servicios((String) objects[4]);
        vESDTO.setTotal_inversion(((Number) objects[5]).longValue());
      
        return vESDTO;
    }
    
}
