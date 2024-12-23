package com.hackathonTeam3.transformaciondigitalmunicipalapi.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.IncidenteGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.IncidenteGubernamentalEntity;

@Mapper
public interface IncidenteGubernamentalMapper {
    

    IncidenteGubernamentalMapper INSTANCE = Mappers.getMapper(IncidenteGubernamentalMapper.class);


    @Mapping(source = "entidadGubernamentalEntity.id", target = "entidadGubernamentalEntityId")
    @Mapping(source = "usuarioGubernamentalEntity.id", target = "usuarioGubernamentalEntityId")
    IncidenteGubernamentalDTO toDto(IncidenteGubernamentalEntity incidenteGubernamentalEntity);
    
    @Mapping(source = "entidadGubernamentalEntityId", target = "entidadGubernamentalEntity.id")
    @Mapping(source = "usuarioGubernamentalEntityId", target = "usuarioGubernamentalEntity.id")
    IncidenteGubernamentalEntity toEntity(IncidenteGubernamentalDTO incidenteGubernamentalDTO);



}
