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

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.ObraGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.ObraGubernamentalServicio;

@RestController
@RequestMapping("/api/obras-gubernamentales")
public class ObraGubernamentalControlador {
    


    @Autowired
    ObraGubernamentalServicio obraGubernamentalServicio;

    
@GetMapping    
public List<ObraGubernamentalDTO> obtenerTodasObrasGubernamentales(){
    return obraGubernamentalServicio.obtenerTodasObrasGubernamentales();
}

@GetMapping("/{id}")
public ResponseEntity<ObraGubernamentalDTO> obtenerObraGubernamentalPorId(@PathVariable Long id){
    ObraGubernamentalDTO obraGubernamentalDTO = obraGubernamentalServicio.obtenerObraGubernamentalPorId(id);
    return ResponseEntity.ok(obraGubernamentalDTO);
}


  @PostMapping
    public ObraGubernamentalDTO crearObraGubernamentalDTO(@RequestBody ObraGubernamentalDTO obraGubernamentalDTO){
    return obraGubernamentalServicio.crearObraGubernamentalDTO(obraGubernamentalDTO); 
    }



    @PutMapping("/{id}")
    public ResponseEntity<ObraGubernamentalDTO> actualizarObraGubernamentalPorId(@PathVariable Long id, @RequestBody ObraGubernamentalDTO obraGubernamentalDTO){
        ObraGubernamentalDTO oDTOActualizado = obraGubernamentalServicio.actualizarObraGubernamentalPorId(id, obraGubernamentalDTO);
            return ResponseEntity.ok(oDTOActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarObraGubernamentalPorId(@PathVariable Long id){
            obraGubernamentalServicio.eliminarObraGubernamentalPorId(id);
            return ResponseEntity.noContent().build();
    }




}
