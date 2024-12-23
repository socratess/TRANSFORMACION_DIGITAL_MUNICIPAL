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

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.CitaGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.CitaGubernamentalServicio;

@RestController
@RequestMapping("/api/citas-gubernamentales")
public class CitaGubernamentalControlador {

@Autowired
private CitaGubernamentalServicio citaGubernamentalServicio;

    
@GetMapping    
public List<CitaGubernamentalDTO> obtenerTodasCitasGubernamentales(){
    return citaGubernamentalServicio.obtenerTodasCitasGubernamentales();
}

@GetMapping("/{id}")
public ResponseEntity<CitaGubernamentalDTO> obtenerCitaGubernamentalPorId(@PathVariable Long id){
   CitaGubernamentalDTO citaGubernamentalDTO = citaGubernamentalServicio.obtenerCitaGubernamentalPorId(id);
    return ResponseEntity.ok(citaGubernamentalDTO);
}


  @PostMapping
    public CitaGubernamentalDTO crearCitaGubernamentalDTO(@RequestBody CitaGubernamentalDTO citaGubernamentalDTO){
    return citaGubernamentalServicio.crearCitaGubernamentalDTO(citaGubernamentalDTO); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaGubernamentalDTO> actualizarCitaGubernamentalPorId(@PathVariable Long id, @RequestBody CitaGubernamentalDTO citaGubernamentalDTO){
      CitaGubernamentalDTO cDTOActualizado = citaGubernamentalServicio.actualizarCitaGubernamentalPorId(id, citaGubernamentalDTO);
            return ResponseEntity.ok(cDTOActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCitaGubernamentalPorId(@PathVariable Long id){
            citaGubernamentalServicio.eliminarCitaGubernamentalPorId(id);
            return ResponseEntity.noContent().build();
    }

    
}
