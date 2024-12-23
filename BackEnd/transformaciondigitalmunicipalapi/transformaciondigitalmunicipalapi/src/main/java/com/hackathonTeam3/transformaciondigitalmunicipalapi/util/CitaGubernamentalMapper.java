package com.hackathonTeam3.transformaciondigitalmunicipalapi.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.CitaGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.CitaGubernamentalEntity;

@Mapper
public interface CitaGubernamentalMapper {
    
CitaGubernamentalMapper INSTANCE = Mappers.getMapper(CitaGubernamentalMapper.class);


    @Mapping(source = "entidadGubernamentalEntity.id", target = "entidadGubernamentalEntityId")
    @Mapping(source = "usuarioGubernamentalEntity.id", target = "usuarioGubernamentalEntityId")
    CitaGubernamentalDTO toDto(CitaGubernamentalEntity citaGubernamentalEntity);
    
    @Mapping(source = "entidadGubernamentalEntityId", target = "entidadGubernamentalEntity.id")
    @Mapping(source = "usuarioGubernamentalEntityId", target = "usuarioGubernamentalEntity.id")
    CitaGubernamentalEntity toEntity(CitaGubernamentalDTO citaGubernamentalDTO);
    
    


}
