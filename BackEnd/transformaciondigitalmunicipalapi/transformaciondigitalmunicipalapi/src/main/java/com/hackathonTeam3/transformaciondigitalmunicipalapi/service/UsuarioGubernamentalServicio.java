package com.hackathonTeam3.transformaciondigitalmunicipalapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.UsuarioGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.UsuarioGubernamentalEntity;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.exception.RecursoNoEncontradoExcepcion;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.UsuarioGubernamentalRepositorio;

@Service
public class UsuarioGubernamentalServicio {


    @Autowired
    private UsuarioGubernamentalRepositorio usuarioGubernamentalRepositorio;

    public List<UsuarioGubernamentalDTO> obtenerTodosUsuariosGubernamentales() {
       List<UsuarioGubernamentalEntity> usuarioGubernamentalEntities =  usuarioGubernamentalRepositorio.findAll();   
       return usuarioGubernamentalEntities.stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public UsuarioGubernamentalDTO obtenerUsuarioGubernamentalPorId(Long id) {
        UsuarioGubernamentalEntity uEntity = usuarioGubernamentalRepositorio.findById(id).orElseThrow(()->new RecursoNoEncontradoExcepcion("Usuario gubernamental no encontrado"));
    return convertirDTO(uEntity);
    }

    public UsuarioGubernamentalDTO crearUsuarioGubernamentalDTO(UsuarioGubernamentalDTO usuarioGubernamentalDTO) {
 UsuarioGubernamentalEntity uEntity = convertirEntity(usuarioGubernamentalDTO);
 UsuarioGubernamentalEntity uEntityCreado = usuarioGubernamentalRepositorio.save(uEntity);
 return convertirDTO(uEntityCreado);
    }

 
    public void eliminarUsuarioGubernamentalPorId(Long id) {
        UsuarioGubernamentalEntity uEntity = usuarioGubernamentalRepositorio.findById(id).orElseThrow(()->new RecursoNoEncontradoExcepcion("Usuario gubernamental no encontrado"));
        usuarioGubernamentalRepositorio.delete(uEntity);
    }
    



private UsuarioGubernamentalDTO convertirDTO(UsuarioGubernamentalEntity usuarioGubernamentalEntity){
        UsuarioGubernamentalDTO uGDTO = new UsuarioGubernamentalDTO();
        uGDTO.setId(usuarioGubernamentalEntity.getId());
        uGDTO.setNombre(usuarioGubernamentalEntity.getNombre());
        uGDTO.setEdad(usuarioGubernamentalEntity.getEdad());
        uGDTO.setTelefono(usuarioGubernamentalEntity.getTelefono());
        uGDTO.setCorreoElectronico(usuarioGubernamentalEntity.getCorreoElectronico());
        return uGDTO;
    
    }


    private UsuarioGubernamentalEntity convertirEntity(UsuarioGubernamentalDTO usuarioGubernamentalDTO){
        UsuarioGubernamentalEntity uGDTO = new UsuarioGubernamentalEntity();
        uGDTO.setId(usuarioGubernamentalDTO.getId());
        uGDTO.setNombre(usuarioGubernamentalDTO.getNombre());
        uGDTO.setEdad(usuarioGubernamentalDTO.getEdad());
        uGDTO.setTelefono(usuarioGubernamentalDTO.getTelefono());
        uGDTO.setCorreoElectronico(usuarioGubernamentalDTO.getCorreoElectronico());
        return uGDTO;
    }

    public UsuarioGubernamentalDTO actualizarUsuarioGubernamentalPorId(Long id,UsuarioGubernamentalDTO usuarioGubernamentalDTO) {
   
                UsuarioGubernamentalEntity uEntity = usuarioGubernamentalRepositorio.findById(id).orElseThrow(()->new RecursoNoEncontradoExcepcion("Usuario gubernamental no encontrado"));
  
                uEntity.setNombre(usuarioGubernamentalDTO.getNombre());
                uEntity.setEdad(usuarioGubernamentalDTO.getEdad());
                uEntity.setTelefono(usuarioGubernamentalDTO.getTelefono());
                uEntity.setCorreoElectronico(usuarioGubernamentalDTO.getCorreoElectronico());
   

                UsuarioGubernamentalEntity uEntityActualizado = usuarioGubernamentalRepositorio.save(uEntity);
                return  convertirDTO(uEntityActualizado);
            } 


}
