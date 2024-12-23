package com.hackathonTeam3.transformaciondigitalmunicipalapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.TramiteGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.TramiteGubernamentalEntity;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.exception.RecursoNoEncontradoExcepcion;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.EntidadGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.TramiteGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.UsuarioGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.util.TramiteGubernamentalMapper;

@Service
public class TramiteGubernamentalServicio {

    @Autowired
    private TramiteGubernamentalRepositorio tramiteGubernamentalRepositorio;
    
    @Autowired
    private EntidadGubernamentalRepositorio entidadGubernamentalRepositorio;

    @Autowired
    private UsuarioGubernamentalRepositorio usuarioGubernamentalRepositorio;

private final TramiteGubernamentalMapper mapper = TramiteGubernamentalMapper.INSTANCE;


    public List<TramiteGubernamentalDTO> obtenerTodosTramitesGubernamentales() {
       return tramiteGubernamentalRepositorio.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public TramiteGubernamentalDTO obtenerTramiteGubernamentalPorId(Long id) {
        return mapper.toDto(tramiteGubernamentalRepositorio.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Tramite gubernamental no encontrado")));       
    }

    public TramiteGubernamentalDTO crearTramiteGubernamentalDTO(TramiteGubernamentalDTO tgDto) {
     if(!entidadGubernamentalRepositorio.existsById(tgDto.getEntidadGubernamentalEntityId())){
        throw new RecursoNoEncontradoExcepcion("Entidad gubernamental no encontrada y por ello no se puede crear el tramite");
     }
     if(!usuarioGubernamentalRepositorio.existsById(tgDto.getUsuarioGubernamentalEntityId())){
        throw new RecursoNoEncontradoExcepcion("Usuario gubernamental no encontrado y por ello no se puede crear el tramite");
     }
    return mapper.toDto(tramiteGubernamentalRepositorio.save(mapper.toEntity(tgDto)));


    }

    public TramiteGubernamentalDTO actualizarTramiteGubernamentalPorId(Long id, TramiteGubernamentalDTO tgDto) {
        TramiteGubernamentalEntity tgEntity = tramiteGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Tramite gubernamental no encontrado"));
        tgEntity.setNombre(tgDto.getNombre());
        tgEntity.setEstado(tgDto.getEstado());
        tgEntity.setTipo(tgDto.getTipo());

        return mapper.toDto(tramiteGubernamentalRepositorio.save(tgEntity));
    }

    public void eliminarTramiteGubernamentalPorId(Long id) {
        tramiteGubernamentalRepositorio.delete(tramiteGubernamentalRepositorio.findById(id).orElseThrow(()-> new RecursoNoEncontradoExcepcion("Tramite gubernamental no encontrado")));
    }
    
}
