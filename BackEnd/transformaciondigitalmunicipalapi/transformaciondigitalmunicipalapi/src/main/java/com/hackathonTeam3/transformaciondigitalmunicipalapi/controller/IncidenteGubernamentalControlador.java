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

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.IncidenteGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.IncidenteGubernamentalServicio;

@RestController
@RequestMapping("/api/incidentes-gubernamentales")
public class IncidenteGubernamentalControlador {
    

    @Autowired
    IncidenteGubernamentalServicio incidenteGubernamentalServicio;


    @GetMapping
    public List<IncidenteGubernamentalDTO> obtenerTodosIncidentesGubernamentales(){
        return incidenteGubernamentalServicio.obtenerTodosIncidentesGubernamentales();
    }

    @GetMapping("/{id}")
    public  ResponseEntity<IncidenteGubernamentalDTO> obtenerIncidenteGubernamentalPorId(@PathVariable Long id){
        return ResponseEntity.ok(incidenteGubernamentalServicio.obtenerIncidenteGubernamentalPorId(id));
    }
@PostMapping
public IncidenteGubernamentalDTO crearIncidenteGubernamentalDTO(@RequestBody IncidenteGubernamentalDTO igDTO){
    return incidenteGubernamentalServicio.crearIncidenteGubernamentalDTO(igDTO);
}

@PutMapping("/{id}")
public ResponseEntity<IncidenteGubernamentalDTO> actualizarIncidenteGubernamentalPorId(@PathVariable Long id, @RequestBody IncidenteGubernamentalDTO igDTO){
    return ResponseEntity.ok(incidenteGubernamentalServicio.actualizarIncidenteGubernamentalPorId(id, igDTO));
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarIndicenteGubernamentalPorId(@PathVariable Long id){
    incidenteGubernamentalServicio.eliminarIndicenteGubernamentalPorId(id);
    return ResponseEntity.noContent().build();
}
}
