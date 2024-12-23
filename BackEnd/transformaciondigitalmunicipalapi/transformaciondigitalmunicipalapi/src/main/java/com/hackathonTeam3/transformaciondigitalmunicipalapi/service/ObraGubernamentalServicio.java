package com.hackathonTeam3.transformaciondigitalmunicipalapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.ObraGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.ObraGubernamentalEntity;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.exception.RecursoNoEncontradoExcepcion;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.EntidadGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.ObraGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.util.ObraGubernamentalMapper;

@Service
public class ObraGubernamentalServicio {
@Autowired
private EntidadGubernamentalRepositorio entidadGubernamentalRepositorio;

    @Autowired
    private ObraGubernamentalRepositorio obraGubernamentalRepositorio;

    private final ObraGubernamentalMapper mapper = ObraGubernamentalMapper.INSTANCE;

    public List<ObraGubernamentalDTO> obtenerTodasObrasGubernamentales() {
        List<ObraGubernamentalEntity> oGubernamentalEntities = obraGubernamentalRepositorio.findAll();
        return oGubernamentalEntities.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public ObraGubernamentalDTO obtenerObraGubernamentalPorId(Long id) {
        ObraGubernamentalEntity oGEntity =   obraGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Obra gubernamental no encontrada"));
        return mapper.toDto(oGEntity);
  
    }

    public ObraGubernamentalDTO crearObraGubernamentalDTO(ObraGubernamentalDTO obraGubernamentalDTO) {
      if(!entidadGubernamentalRepositorio.existsById(obraGubernamentalDTO.getEntidadGubernamentalEntityId())){
        throw new RecursoNoEncontradoExcepcion("Entidad gubernamental no encontrada y por ello no se puede crear la obra");
      }
      ObraGubernamentalEntity obraGubernamentalEntity = mapper.toEntity(obraGubernamentalDTO);
      ObraGubernamentalEntity obraGubernamentalEntityCreada = obraGubernamentalRepositorio.save(obraGubernamentalEntity);

      return mapper.toDto(obraGubernamentalEntityCreada);
    }

    public ObraGubernamentalDTO actualizarObraGubernamentalPorId(Long id, ObraGubernamentalDTO obraGubernamentalDTO) {
         ObraGubernamentalEntity oGEntity =   obraGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Obra gubernamental no encontrada"));
      oGEntity.setNombre(obraGubernamentalDTO.getNombre());
      oGEntity.setTipo(obraGubernamentalDTO.getTipo());
      oGEntity.setEstado(obraGubernamentalDTO.getEstado());
      oGEntity.setFinanciacion(obraGubernamentalDTO.getFinanciacion());
      //oGEntity.setFechaInicio(obraGubernamentalDTO.getFechaInicio());
      oGEntity.setFechaFinal(obraGubernamentalDTO.getFechaFinal());

      ObraGubernamentalEntity oGEntityActualizada = obraGubernamentalRepositorio.save(oGEntity);

      return mapper.toDto(oGEntityActualizada);
    }

    public void eliminarObraGubernamentalPorId(Long id) {
        ObraGubernamentalEntity oGEntity =   obraGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Obra gubernamental no encontrada"));
      obraGubernamentalRepositorio.delete(oGEntity);
    }

    
}
