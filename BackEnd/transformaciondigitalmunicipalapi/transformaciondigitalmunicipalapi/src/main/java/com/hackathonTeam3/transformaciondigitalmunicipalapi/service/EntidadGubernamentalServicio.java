package com.hackathonTeam3.transformaciondigitalmunicipalapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.EntidadGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.EntidadGubernamentalEntity;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.exception.RecursoNoEncontradoExcepcion;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.EntidadGubernamentalRepositorio;

@Service
public class EntidadGubernamentalServicio {
    
    @Autowired
    private EntidadGubernamentalRepositorio entidadGubernamentalRepositorio;

    public List<EntidadGubernamentalDTO> obtenerTodasEntidadesGubernamentales() {

      List<EntidadGubernamentalEntity> entidadGubernamentalEntities =  entidadGubernamentalRepositorio.findAll();

      List<EntidadGubernamentalDTO> enGDtos = entidadGubernamentalEntities.stream().map(this::convertirDTO).collect(Collectors.toList());
   
      return enGDtos;
    }

    public EntidadGubernamentalDTO obtenerEntidadGubernamentalPorId(Long id) {
    
    EntidadGubernamentalEntity eGEntity =   entidadGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Entidad gubernamental no encontrada"));

    return convertirDTO(eGEntity);

    }



    private EntidadGubernamentalDTO convertirDTO(EntidadGubernamentalEntity entidadGubernamentalEntity){
        EntidadGubernamentalDTO eGDTO = new EntidadGubernamentalDTO();
        eGDTO.setId(entidadGubernamentalEntity.getId());
        eGDTO.setNombre(entidadGubernamentalEntity.getNombre());
        eGDTO.setUbicacion(entidadGubernamentalEntity.getUbicacion());
        eGDTO.setTelefono(entidadGubernamentalEntity.getTelefono());
        eGDTO.setHorarioLaboral(entidadGubernamentalEntity.getHorarioLaboral());
        eGDTO.setCorreoElectronico(entidadGubernamentalEntity.getCorreoElectronico());
        return eGDTO;
    }

    private EntidadGubernamentalEntity convertirEntity(EntidadGubernamentalDTO entidadGubernamentalDTO){
        EntidadGubernamentalEntity eGDTO = new EntidadGubernamentalEntity();
       // eGDTO.setId(entidadGubernamentalDTO.getId());
        eGDTO.setNombre(entidadGubernamentalDTO.getNombre());
        eGDTO.setUbicacion(entidadGubernamentalDTO.getUbicacion());
        eGDTO.setTelefono(entidadGubernamentalDTO.getTelefono());
        eGDTO.setHorarioLaboral(entidadGubernamentalDTO.getHorarioLaboral());
        eGDTO.setCorreoElectronico(entidadGubernamentalDTO.getCorreoElectronico());
        return eGDTO;
    }

    public EntidadGubernamentalDTO crearEntidadGubernamental(EntidadGubernamentalDTO entidadGubernamentalDTO) {
       EntidadGubernamentalEntity eGtity= convertirEntity(entidadGubernamentalDTO);
       EntidadGubernamentalEntity eGtityCreada = entidadGubernamentalRepositorio.save(eGtity);
       return convertirDTO(eGtityCreada);
    }

    public EntidadGubernamentalDTO actualizarEntidadGubernamentalPorId(Long id, EntidadGubernamentalDTO entidadGubernamentalDTO) {
        EntidadGubernamentalEntity eGEntity =   entidadGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Entidad gubernamental no encontrada"));
        eGEntity.setNombre(entidadGubernamentalDTO.getNombre());
        eGEntity.setUbicacion(entidadGubernamentalDTO.getUbicacion());
        eGEntity.setTelefono(entidadGubernamentalDTO.getTelefono());
        eGEntity.setHorarioLaboral(entidadGubernamentalDTO.getHorarioLaboral());
        eGEntity.setCorreoElectronico(entidadGubernamentalDTO.getCorreoElectronico());

        EntidadGubernamentalEntity eGEntityActualizada = entidadGubernamentalRepositorio.save(eGEntity);

        return convertirDTO(eGEntityActualizada);

    }

    public void eliminarEntidadGubernamentalPorId(Long id) {
        EntidadGubernamentalEntity eGEntity =   entidadGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Entidad gubernamental no encontrada"));
        entidadGubernamentalRepositorio.delete(eGEntity); 
        
    }



    




}
