package com.hackathonTeam3.transformaciondigitalmunicipalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.TramiteGubernamentalEntity;

@Repository
public interface TramiteGubernamentalRepositorio extends  JpaRepository<TramiteGubernamentalEntity, Long> {
    
}
