package com.hackathonTeam3.transformaciondigitalmunicipalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.ObraGubernamentalEntity;

@Repository
public interface ObraGubernamentalRepositorio  extends JpaRepository<ObraGubernamentalEntity, Long>{
    
}
