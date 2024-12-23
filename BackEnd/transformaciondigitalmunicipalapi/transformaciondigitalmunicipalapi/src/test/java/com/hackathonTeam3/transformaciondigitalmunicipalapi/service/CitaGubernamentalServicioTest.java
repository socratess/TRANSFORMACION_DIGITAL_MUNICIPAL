package com.hackathonTeam3.transformaciondigitalmunicipalapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hackathonTeam3.transformaciondigitalmunicipalapi.dto.CitaGubernamentalDTO;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.entity.CitaGubernamentalEntity;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.CitaGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.EntidadGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.repository.UsuarioGubernamentalRepositorio;
import com.hackathonTeam3.transformaciondigitalmunicipalapi.util.CitaGubernamentalMapper;



@ExtendWith(MockitoExtension.class)
public class CitaGubernamentalServicioTest {
    

@Mock
private CitaGubernamentalRepositorio citaGubernamentalRepositorio;

@Mock
private EntidadGubernamentalRepositorio entidadGubernamentalRepositorio;

@Mock
private UsuarioGubernamentalRepositorio gubernamentalRepositorio;

@Mock
private CitaGubernamentalMapper citaGubernamentalMapper;


@InjectMocks
private CitaGubernamentalServicio citaGubernamentalServicio;


private CitaGubernamentalDTO  citaGubernamentalDTO;
private CitaGubernamentalEntity citaGubernamentalEntity;


@BeforeEach
void setUp(){
    MockitoAnnotations.openMocks(this);

    citaGubernamentalDTO = new CitaGubernamentalDTO();
    citaGubernamentalDTO.setId(1L);
    citaGubernamentalDTO.setNombre("Cita de Prueba 1");
    citaGubernamentalDTO.setTema("Tema de Prueba 1");
    citaGubernamentalDTO.setEstado("Pendiente");
    citaGubernamentalDTO.setFecha("2024-12-25");


    citaGubernamentalEntity = new CitaGubernamentalEntity();
    citaGubernamentalEntity.setId(1L);
    citaGubernamentalEntity.setNombre("Cita de Prueba 1");
    citaGubernamentalEntity.setTema("Tema de Prueba 1");
    citaGubernamentalEntity.setEstado("Pendiente");
    citaGubernamentalEntity.setFecha("2024-12-25");
}


@Test
void testObtenerCitaGubernamentalPorId(){
    
    when(citaGubernamentalRepositorio.findById(anyLong())).thenReturn(Optional.of(citaGubernamentalEntity));
   // when(citaGubernamentalMapper.toDto(any(CitaGubernamentalEntity.class))).thenReturn(citaGubernamentalDTO);

    CitaGubernamentalDTO  result = citaGubernamentalServicio.obtenerCitaGubernamentalPorId(1L);

    assertNotNull(result);
    assertEquals("Cita de Prueba 1", result.getNombre());

}


@Test
void testEliminarCitaGubernamentalPorId(){
    when(citaGubernamentalRepositorio.findById(anyLong())).thenReturn(Optional.of(citaGubernamentalEntity));
    citaGubernamentalServicio.eliminarCitaGubernamentalPorId(1L);
    verify(citaGubernamentalRepositorio, times(1)).delete(any(CitaGubernamentalEntity.class));

}

}
