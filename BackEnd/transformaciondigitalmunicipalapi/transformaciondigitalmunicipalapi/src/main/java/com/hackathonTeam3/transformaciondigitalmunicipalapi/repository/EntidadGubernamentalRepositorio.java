package com.hackathonTeam3.transformaciondigitalmunicipalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.EntidadGubernamentalEntity;

@Repository
public interface EntidadGubernamentalRepositorio extends JpaRepository<EntidadGubernamentalEntity, Long> {
    
}
