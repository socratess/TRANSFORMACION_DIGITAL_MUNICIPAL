package com.hackathonTeam3.transformaciondigitalmunicipalapi.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.TramiteGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.TramiteGubernamentalEntity;

@Mapper
public interface TramiteGubernamentalMapper {
    
    TramiteGubernamentalMapper INSTANCE = Mappers.getMapper(TramiteGubernamentalMapper.class);


    @Mapping(source = "entidadGubernamentalEntity.id", target = "entidadGubernamentalEntityId")
    @Mapping(source = "usuarioGubernamentalEntity.id", target = "usuarioGubernamentalEntityId")
    TramiteGubernamentalDTO toDto(TramiteGubernamentalEntity tramiteGubernamentalEntity);
    
    @Mapping(source = "entidadGubernamentalEntityId", target = "entidadGubernamentalEntity.id")
    @Mapping(source = "usuarioGubernamentalEntityId", target = "usuarioGubernamentalEntity.id")
    TramiteGubernamentalEntity toEntity(TramiteGubernamentalDTO tramiteGubernamentalDTO);

}
