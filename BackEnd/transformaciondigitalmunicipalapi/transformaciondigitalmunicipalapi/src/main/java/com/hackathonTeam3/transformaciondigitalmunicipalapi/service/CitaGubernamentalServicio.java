package com.hackathonTeam3.transformaciondigitalmunicipalapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.CitaGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.CitaGubernamentalEntity;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.exception.RecursoNoEncontradoExcepcion;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.CitaGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.EntidadGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.UsuarioGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.util.CitaGubernamentalMapper;

@Service
public class CitaGubernamentalServicio {

@Autowired
private CitaGubernamentalRepositorio citaGubernamentalRepositorio;

@Autowired
private EntidadGubernamentalRepositorio entidadGubernamentalRepositorio;

@Autowired
private UsuarioGubernamentalRepositorio usuarioGubernamentalRepositorio;

private final CitaGubernamentalMapper mapper = CitaGubernamentalMapper.INSTANCE;

    public List<CitaGubernamentalDTO> obtenerTodasCitasGubernamentales() {
    return  citaGubernamentalRepositorio.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public CitaGubernamentalDTO obtenerCitaGubernamentalPorId(Long id) {
     return mapper.toDto(citaGubernamentalRepositorio.findById(id).orElseThrow( () -> new RecursoNoEncontradoExcepcion("Cita gubernamental no encontrada")));
    }

    public CitaGubernamentalDTO actualizarCitaGubernamentalPorId(Long id, CitaGubernamentalDTO citaGubernamentalDTO) {
      CitaGubernamentalEntity citaGubernamentalEntity = citaGubernamentalRepositorio.findById(id).orElseThrow( () -> new RecursoNoEncontradoExcepcion("Cita gubernamental no encontrada"));
       citaGubernamentalEntity.setNombre(citaGubernamentalDTO.getNombre());
       citaGubernamentalEntity.setTema(citaGubernamentalDTO.getTema());
       citaGubernamentalEntity.setEstado(citaGubernamentalDTO.getEstado());
       citaGubernamentalEntity.setFecha(citaGubernamentalDTO.getFecha()); 
   
      return mapper.toDto(citaGubernamentalRepositorio.save(citaGubernamentalEntity));
    }

    public void eliminarCitaGubernamentalPorId(Long id) {
       citaGubernamentalRepositorio.delete(citaGubernamentalRepositorio.findById(id).orElseThrow( () -> new RecursoNoEncontradoExcepcion("Cita gubernamental no encontrada")));
       
    }

    public CitaGubernamentalDTO crearCitaGubernamentalDTO(CitaGubernamentalDTO citaGubernamentalDTO) {
        if(!entidadGubernamentalRepositorio.existsById(citaGubernamentalDTO.getEntidadGubernamentalEntityId())){
            throw new RecursoNoEncontradoExcepcion("Entidad gubernamental no encontrada y por ello no se puede crear la obra");
        }
        if(!usuarioGubernamentalRepositorio.existsById(citaGubernamentalDTO.getUsuarioGubernamentalEntityId())){
            throw new RecursoNoEncontradoExcepcion("Usuario gubernamental no encontrado y por ello no se puede crear la obra");
        }

          return mapper.toDto(citaGubernamentalRepositorio.save(mapper.toEntity(citaGubernamentalDTO)));
    }
    
}
