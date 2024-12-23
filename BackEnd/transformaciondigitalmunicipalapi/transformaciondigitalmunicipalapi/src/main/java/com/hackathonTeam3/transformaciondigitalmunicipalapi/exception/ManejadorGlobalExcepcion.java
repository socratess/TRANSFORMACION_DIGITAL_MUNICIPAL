package com.hackathonTeam3.transformaciondigitalmunicipalapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ManejadorGlobalExcepcion {

@ExceptionHandler(RecursoNoEncontradoExcepcion.class)
public ResponseEntity<?> manejadorRecursoNoEncontrado(RecursoNoEncontradoExcepcion recursoNoEncontradoExcepcion){
  return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(recursoNoEncontradoExcepcion.getMessage());  
}

@ExceptionHandler(Exception.class)
public ResponseEntity<?> manejadorExcepcionGlobal(Exception exception){
  return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");  
}

    
}
