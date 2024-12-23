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

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.TramiteGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.TramiteGubernamentalServicio;

@RestController
@RequestMapping("/api/tramites-gubernamentales")
public class TramiteGubernamentalControlador {
    

@Autowired
private TramiteGubernamentalServicio tramiteGubernamentalServicio;

@GetMapping
public List<TramiteGubernamentalDTO> obtenerTodosTramitesGubernamentales(){
    return tramiteGubernamentalServicio.obtenerTodosTramitesGubernamentales();
}

@GetMapping("/{id}")
public ResponseEntity<TramiteGubernamentalDTO> obtenerTramiteGubernamentalPorId(@PathVariable Long id){
    return ResponseEntity.ok(tramiteGubernamentalServicio.obtenerTramiteGubernamentalPorId(id));
}

@PostMapping
public TramiteGubernamentalDTO crearTramiteGubernamentalDTO(@RequestBody TramiteGubernamentalDTO tgDto){
    return tramiteGubernamentalServicio.crearTramiteGubernamentalDTO(tgDto);
}

@PutMapping("/{id}")
public ResponseEntity<TramiteGubernamentalDTO> actualizarTramiteGubernamentalPorId(@PathVariable Long id, @RequestBody TramiteGubernamentalDTO tgDto){
    return ResponseEntity.ok(tramiteGubernamentalServicio.actualizarTramiteGubernamentalPorId(id,tgDto));
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarTramiteGubernamentalPorId(@PathVariable Long id){
  tramiteGubernamentalServicio.eliminarTramiteGubernamentalPorId(id);
  return ResponseEntity.noContent().build();
} 

}
