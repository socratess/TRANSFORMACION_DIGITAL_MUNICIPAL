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

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.ServicioGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.ServicioGubernamentalServicio;

@RestController
@RequestMapping("/api/servicios-gubernamentales")
public class ServicioGubernamentalControlador {


    @Autowired
    private ServicioGubernamentalServicio servicioGubernamentalServicio;


    @GetMapping
    public List<ServicioGubernamentalDTO> obtenerTodosServiciosGubernamentales(){
       return servicioGubernamentalServicio.obtenerTodosServiciosGubernamentales();    
    }

@GetMapping("/{id}")
    public ResponseEntity<ServicioGubernamentalDTO> obtenerServicioGubernamentalPorId(@PathVariable Long id){
        ServicioGubernamentalDTO sGDTO = servicioGubernamentalServicio.obtenerServicioGubernamentalPorId(id);
         return ResponseEntity.ok(sGDTO);
    }

     @PostMapping
    public ServicioGubernamentalDTO crearServicioGubernamentalDTO(@RequestBody ServicioGubernamentalDTO servicioGubernamentalDTO){
    return servicioGubernamentalServicio.crearServicioGubernamentalDTO(servicioGubernamentalDTO); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioGubernamentalDTO> actualizarServicioGubernamentalPorId(@PathVariable Long id, @RequestBody ServicioGubernamentalDTO servicioGubernamentalDTO){
        ServicioGubernamentalDTO sDTOActualizado = servicioGubernamentalServicio.actualizarServicioGubernamentalPorId(id, servicioGubernamentalDTO);
            return ResponseEntity.ok(sDTOActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicioGubernamentalPorId(@PathVariable Long id){
            servicioGubernamentalServicio.eliminarServicioGubernamentalPorId(id);
            return ResponseEntity.noContent().build();
    }

    
}
