package com.hackathonTeam3.transformaciondigitalmunicipalapi.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.ObraGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.ObraGubernamentalEntity;

@Mapper
public interface ObraGubernamentalMapper {
    

    ObraGubernamentalMapper INSTANCE = Mappers.getMapper(ObraGubernamentalMapper.class);


    @Mapping(source = "entidadGubernamentalEntity.id", target = "entidadGubernamentalEntityId")
    ObraGubernamentalDTO toDto(ObraGubernamentalEntity obraGubernamentalEntity);
    
    @Mapping(source = "entidadGubernamentalEntityId", target = "entidadGubernamentalEntity.id")
    ObraGubernamentalEntity toEntity(ObraGubernamentalDTO obraGubernamentalDTO);
    
    
    
}
