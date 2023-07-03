package com.edu.certus.alumnos.service;

import com.edu.certus.alumnos.dto.AlumnosDto;
import com.edu.certus.alumnos.dto.ResponseDto;

public interface AlumnosService {
    public ResponseDto getAllAlumnos();
	public ResponseDto getAlumnos(Long id);
	public ResponseDto createAlumnos(AlumnosDto alumnos);
	public ResponseDto updateAlumnos(AlumnosDto alumnos);
	public ResponseDto deleteAlumnos(Long id);
	/*CRUD*/
}
