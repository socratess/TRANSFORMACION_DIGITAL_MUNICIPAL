package com.hackathonTeam3.transformaciondigitalmunicipalapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.ServicioGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.ServicioGubernamentalEntity;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.exception.RecursoNoEncontradoExcepcion;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.EntidadGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.ServicioGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.util.ServicioGubernamentalMapper;

@Service
public class ServicioGubernamentalServicio {

    @Autowired
private ServicioGubernamentalRepositorio servicioGubernamentalRepositorio;

@Autowired
private EntidadGubernamentalRepositorio entidadGubernamentalRepositorio;

    private final ServicioGubernamentalMapper mapper = ServicioGubernamentalMapper.INSTANCE;

    public List<ServicioGubernamentalDTO> obtenerTodosServiciosGubernamentales() {
     List<ServicioGubernamentalEntity> sGubernamentalEntities = servicioGubernamentalRepositorio.findAll();
        return sGubernamentalEntities.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public ServicioGubernamentalDTO obtenerServicioGubernamentalPorId(Long id) {
        ServicioGubernamentalEntity sGEntity =   servicioGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Servicio gubernamental no encontrada"));
        return mapper.toDto(sGEntity);}

    public ServicioGubernamentalDTO actualizarServicioGubernamentalPorId(Long id,ServicioGubernamentalDTO servicioGubernamentalDTO) {
   
        ServicioGubernamentalEntity sGEntity =   servicioGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Servicio gubernamental no encontrada"));
       sGEntity.setNombre(servicioGubernamentalDTO.getNombre());
       sGEntity.setTipo(servicioGubernamentalDTO.getTipo());
       sGEntity.setEstado(servicioGubernamentalDTO.getEstado());
        sGEntity.setFinanciacion(servicioGubernamentalDTO.getFinanciacion());
        sGEntity.setDuracion(servicioGubernamentalDTO.getDuracion());
        ServicioGubernamentalEntity sGEntityActualizada = servicioGubernamentalRepositorio.save(sGEntity);
  
        return mapper.toDto(sGEntityActualizada);

    }

    public void eliminarServicioGubernamentalPorId(Long id) {
        ServicioGubernamentalEntity sGEntity =   servicioGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Servicio gubernamental no encontrada"));
        servicioGubernamentalRepositorio.delete(sGEntity);
    }

    public ServicioGubernamentalDTO crearServicioGubernamentalDTO(ServicioGubernamentalDTO servicioGubernamentalDTO) {
        if(!entidadGubernamentalRepositorio.existsById(servicioGubernamentalDTO.getEntidadGubernamentalEntityId())){
            throw new RecursoNoEncontradoExcepcion("Servicio gubernamental no encontrada");
          }
          ServicioGubernamentalEntity sGubernamentalEntity = mapper.toEntity(servicioGubernamentalDTO);
          ServicioGubernamentalEntity sGubernamentalEntityCreada = servicioGubernamentalRepositorio.save(sGubernamentalEntity);
    
          return mapper.toDto(sGubernamentalEntityCreada);
    }
    
}
