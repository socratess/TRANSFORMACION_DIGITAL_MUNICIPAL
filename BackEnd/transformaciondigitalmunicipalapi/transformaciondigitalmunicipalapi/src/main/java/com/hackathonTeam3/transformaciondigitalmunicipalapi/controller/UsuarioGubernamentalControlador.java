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

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.UsuarioGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.service.UsuarioGubernamentalServicio;

@RestController
@RequestMapping("/api/usuarios-gubernamentales")
public class UsuarioGubernamentalControlador {
    
 @Autowired
    private UsuarioGubernamentalServicio usuarioGubernamentalServicio;


     @GetMapping
    public List<UsuarioGubernamentalDTO> obtenerTodosUsuariosGubernamentales(){
       return usuarioGubernamentalServicio.obtenerTodosUsuariosGubernamentales();    
    }

@GetMapping("/{id}")
    public ResponseEntity<UsuarioGubernamentalDTO> obtenerUsuarioGubernamentalPorId(@PathVariable Long id){
         UsuarioGubernamentalDTO uGDTO = usuarioGubernamentalServicio.obtenerUsuarioGubernamentalPorId(id);
         return ResponseEntity.ok(uGDTO);
    }

   @PostMapping
    public UsuarioGubernamentalDTO crearUsuarioGubernamentalDTO(@RequestBody UsuarioGubernamentalDTO usuarioGubernamentalDTO){
    return usuarioGubernamentalServicio.crearUsuarioGubernamentalDTO(usuarioGubernamentalDTO); 
    }



    @PutMapping("/{id}")
    public ResponseEntity<UsuarioGubernamentalDTO> actualizarUsuarioGubernamentalPorId(@PathVariable Long id, @RequestBody UsuarioGubernamentalDTO usuarioGubernamentalDTO){
        UsuarioGubernamentalDTO uDTOActualizado = usuarioGubernamentalServicio.actualizarUsuarioGubernamentalPorId(id, usuarioGubernamentalDTO);
            return ResponseEntity.ok(uDTOActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarioGubernamentalPorId(@PathVariable Long id){
            usuarioGubernamentalServicio.eliminarUsuarioGubernamentalPorId(id);
            return ResponseEntity.noContent().build();
    }
}
