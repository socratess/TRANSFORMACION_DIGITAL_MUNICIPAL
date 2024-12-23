package com.hackathonTeam3.transformaciondigitalmunicipalapi.service.vistas;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas.VistaEntidadesObrasDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class VistaEntidadesObrasServicio {


@Autowired
private EntityManager entityManager;

    public List<VistaEntidadesObrasDTO> obtenerVistasEntidadesObras() {
       Query query = entityManager.createNativeQuery("SELECT * FROM vista_entidades_con_obras");
       @SuppressWarnings("unchecked")
        List<Object []> resultados = query.getResultList();
       return resultados.stream().map(this::convertirDTO).collect(Collectors.toList());
    }

        private VistaEntidadesObrasDTO convertirDTO(Object[] objects){
            VistaEntidadesObrasDTO vEODTO = new VistaEntidadesObrasDTO();
            vEODTO.setId(((Number) objects[0]).longValue());
            vEODTO.setNombre((String) objects[1]);
            vEODTO.setUbicacion((String) objects[2]);
            vEODTO.setNumero_obras(((Number) objects[3]).longValue());
            vEODTO.setLista_obras((String) objects[4]);
            vEODTO.setTotal_inversion(((Number) objects[5]).longValue());
            
      
        return vEODTO;
    }
    
}
