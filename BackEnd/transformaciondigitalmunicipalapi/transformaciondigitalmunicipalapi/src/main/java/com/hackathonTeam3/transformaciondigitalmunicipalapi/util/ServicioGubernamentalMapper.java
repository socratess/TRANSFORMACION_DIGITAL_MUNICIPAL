package com.hackathonTeam3.transformaciondigitalmunicipalapi.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.ServicioGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.ServicioGubernamentalEntity;

@Mapper
public interface ServicioGubernamentalMapper {

    ServicioGubernamentalMapper INSTANCE = Mappers.getMapper(ServicioGubernamentalMapper.class); 
    

    @Mapping(source = "entidadGubernamentalEntity.id", target = "entidadGubernamentalEntityId")
    ServicioGubernamentalDTO toDto(ServicioGubernamentalEntity servicioGubernamentalEntity);
    
    @Mapping(source = "entidadGubernamentalEntityId", target = "entidadGubernamentalEntity.id")
    ServicioGubernamentalEntity toEntity(ServicioGubernamentalDTO servicioGubernamentalDTO);
}
