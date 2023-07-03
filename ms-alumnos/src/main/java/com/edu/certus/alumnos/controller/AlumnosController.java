package com.edu.certus.alumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.certus.alumnos.dto.AlumnosDto;
import com.edu.certus.alumnos.dto.ResponseDto;
import com.edu.certus.alumnos.service.AlumnosService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/alumnos1/alumnos")
public class AlumnosController {

	@Autowired
	private AlumnosService alumnosService;
	
	@ApiOperation(value = "listar todos alumnos")
	@GetMapping
	public ResponseEntity<ResponseDto> readAllAlumnos(){
		return ResponseEntity.status(HttpStatus.OK).body(alumnosService.getAllAlumnos());
	}
	
	@ApiOperation(value = "obtener alumnos por su id")
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> readAlumnos(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(alumnosService.getAlumnos(id));
	}
	
	@ApiOperation(value = "crear alumnos")
	@PostMapping
	public ResponseEntity<ResponseDto> createAlumnos(@RequestBody AlumnosDto alumnos){
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnosService.createAlumnos(alumnos));
	}
	
	@ApiOperation(value = "Actualizar datos de un alumno existente")
	@PutMapping
	public ResponseEntity<ResponseDto> updateAlumnos(@RequestBody AlumnosDto alumnos){
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnosService.updateAlumnos(alumnos));
	}
	
	@ApiOperation(value = "eliminar alumnos por su id")
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDto> deleteAlumnos(
			@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(alumnosService.deleteAlumnos(id));
	}
}
