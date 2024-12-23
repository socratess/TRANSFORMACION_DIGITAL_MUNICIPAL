package com.hackathonTeam3.transformaciondigitalmunicipalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.UsuarioGubernamentalEntity;

@Repository
public interface UsuarioGubernamentalRepositorio extends JpaRepository<UsuarioGubernamentalEntity, Long> {
    
}
