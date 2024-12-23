package com.hackathonTeam3.transformaciondigitalmunicipalapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.IncidenteGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.IncidenteGubernamentalEntity;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.exception.RecursoNoEncontradoExcepcion;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.EntidadGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.IncidenteGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.UsuarioGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.util.IncidenteGubernamentalMapper;

@Service
public class IncidenteGubernamentalServicio {


@Autowired
private IncidenteGubernamentalRepositorio incidenteGubernamentalRepositorio;
@Autowired
private EntidadGubernamentalRepositorio entidadGubernamentalRepositorio;
@Autowired
private UsuarioGubernamentalRepositorio usuarioGubernamentalRepositorio;

private final IncidenteGubernamentalMapper mapper = IncidenteGubernamentalMapper.INSTANCE;

    public List<IncidenteGubernamentalDTO> obtenerTodosIncidentesGubernamentales() {
      return incidenteGubernamentalRepositorio.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public IncidenteGubernamentalDTO obtenerIncidenteGubernamentalPorId(Long id) {
            return mapper.toDto(incidenteGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Incidente gubernamental no encontrado")));
    }

    public IncidenteGubernamentalDTO crearIncidenteGubernamentalDTO(IncidenteGubernamentalDTO igDTO) {
        if(!entidadGubernamentalRepositorio.existsById(igDTO.getEntidadGubernamentalEntityId())){
            throw new RecursoNoEncontradoExcepcion("Entidad gubernamental no encontrada y por ello no se puede crear el incidente");
        }
        if(!usuarioGubernamentalRepositorio.existsById(igDTO.getUsuarioGubernamentalEntityId())){
            throw new RecursoNoEncontradoExcepcion("Usuario gubernamental no encontrado y por ello no se puede crear el incidente");
        }
        return mapper.toDto(incidenteGubernamentalRepositorio.save(mapper.toEntity(igDTO)));
    }

    public IncidenteGubernamentalDTO actualizarIncidenteGubernamentalPorId(Long id, IncidenteGubernamentalDTO igDTO) {
      IncidenteGubernamentalEntity igentiEntity = incidenteGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Incidente gubernamental no encontrado"));
      igentiEntity.setNombre(igDTO.getNombre());
      igentiEntity.setEstado(igDTO.getEstado());
      igentiEntity.setTema(igDTO.getTema());
      //igentiEntity.setFechaAcontecimientos(igDTO.getFechaAcontecimientos());
      
      return mapper.toDto(incidenteGubernamentalRepositorio.save(igentiEntity)); 
    }

    public void eliminarIndicenteGubernamentalPorId(Long id) {
       incidenteGubernamentalRepositorio.delete(incidenteGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Incidente gubernamental no encontrado")));
    }
    
}
