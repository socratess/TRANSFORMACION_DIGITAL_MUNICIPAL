package com.hackathonTeam3.transformaciondigitalmunicipalapi.service.vistas;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.vistas.VistaUsuariosTramitesEntidadesDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class VistaUsuariosTramitesEntidadesService {
    
 @Autowired
    private EntityManager entityManager;

    public List<VistaUsuariosTramitesEntidadesDTO> obtenerVistasUsuariosTramitesEntidades() {
         Query query = entityManager.createNativeQuery("SELECT * FROM vista_usuario_con_tramites_a_entidades");
       @SuppressWarnings("unchecked")
    List<Object []> resultados = query.getResultList();
       return resultados.stream().map(this::convertirDTO).collect(Collectors.toList());
    }


      private VistaUsuariosTramitesEntidadesDTO convertirDTO(Object[] objects){
        VistaUsuariosTramitesEntidadesDTO utgDTO = new VistaUsuariosTramitesEntidadesDTO();
        utgDTO.setId(((Number) objects[0]).longValue());
        utgDTO.setNombre((String) objects[1]);
        utgDTO.setEdad(((Number) objects[2]).doubleValue());
        utgDTO.setNumeroTramites(((Number) objects[3]).longValue());
        utgDTO.setListaTramites((String) objects[4]);
        utgDTO.setListaEntidades((String) objects[5]);
        return utgDTO;
    }

}
