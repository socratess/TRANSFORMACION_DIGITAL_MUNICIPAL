package com.hackathonTeam3.transformaciondigitalmunicipalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.EntidadGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.EntidadGubernamentalServicio;

@RestController
@RequestMapping("/api/entidades-gubernamentales")
public class EntidadGubernamentalControlador {
    
    @Autowired
    private EntidadGubernamentalServicio entidadGubernamentalServicio;

    @GetMapping
    public List<EntidadGubernamentalDTO> obtenerTodasEntidadesGubernamentales(){
            return entidadGubernamentalServicio.obtenerTodasEntidadesGubernamentales();     
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadGubernamentalDTO> obtenerEntidadGubernamentalPorId(@PathVariable Long id){
         EntidadGubernamentalDTO eGDTO = entidadGubernamentalServicio.obtenerEntidadGubernamentalPorId(id);
         return ResponseEntity.ok(eGDTO);
    }

    @PostMapping
    public EntidadGubernamentalDTO crearEntidadGubernamentalDTO(@RequestBody EntidadGubernamentalDTO entidadGubernamentalDTO){
    return entidadGubernamentalServicio.crearEntidadGubernamental(entidadGubernamentalDTO); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadGubernamentalDTO> actualizarEntidadGubernamentalPorId(@PathVariable Long id, @RequestBody EntidadGubernamentalDTO entidadGubernamentalDTO){
            EntidadGubernamentalDTO eDTOActualizada = entidadGubernamentalServicio.actualizarEntidadGubernamentalPorId(id, entidadGubernamentalDTO);
            return ResponseEntity.ok(eDTOActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEntidadGubernamentalPorId(@PathVariable Long id){
            entidadGubernamentalServicio.eliminarEntidadGubernamentalPorId(id);
            return ResponseEntity.noContent().build();
    }
}
