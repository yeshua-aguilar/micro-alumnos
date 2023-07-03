package com.edu.certus.alumnos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.certus.alumnos.dto.AlumnosDto;
import com.edu.certus.alumnos.dto.ResponseDto;
import com.edu.certus.alumnos.entity.AlumnosEntity;
import com.edu.certus.alumnos.repository.AlumnosRepository;
import com.edu.certus.alumnos.service.AlumnosService;
import com.edu.certus.alumnos.util.Constante;
import com.edu.certus.alumnos.util.Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlumnosServiceImpl implements AlumnosService{

	@Autowired
	private AlumnosRepository alumnosRepository;
	
	@Override
	public ResponseDto getAllAlumnos() {
		try {
			List<AlumnosEntity> listAlumnosEntity = alumnosRepository.findAll();
			if(listAlumnosEntity.isEmpty()) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			List<AlumnosDto> list = new ArrayList<AlumnosDto>();
			for (AlumnosEntity alumnosEntity : listAlumnosEntity) {
				list.add(AlumnosDto.builder()
						.id(alumnosEntity.getId())
						.nombres(alumnosEntity.getNombres())
						.apellidos(alumnosEntity.getApellidos())
						.sexo(alumnosEntity.getSexo())
						.estado(alumnosEntity.getEstado())
						.build());
			}
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
		} catch (Exception e) {
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
		
	}

	@Override
	public ResponseDto getAlumnos(Long id) {
		try {
			AlumnosEntity alumnosEntity = alumnosRepository.findById(id).orElse(null);
			if(null == alumnosEntity) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			AlumnosDto alumnosDto = AlumnosDto.builder()
					.id(alumnosEntity.getId())
					.nombres(alumnosEntity.getNombres())
					.apellidos(alumnosEntity.getApellidos())
					.sexo(alumnosEntity.getSexo())
					.estado(alumnosEntity.getEstado())
					.build();
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, alumnosDto);
		} catch (Exception e) {
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto createAlumnos(AlumnosDto alumnos) {
		try {
			AlumnosEntity alumnosEntity = AlumnosEntity.builder()
					.nombres(alumnos.getNombres())
					.apellidos(alumnos.getApellidos())
					.sexo(alumnos.getSexo())
					.estado(true)
					.build();
				alumnosRepository.save(alumnosEntity);
				alumnos.setId(alumnosEntity.getId());
				return Util.getResponse(true, Constante.OPERATION_SUCCESS, alumnos);
		} catch (Exception e) {
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto updateAlumnos(AlumnosDto alumnos) {
		try {
			AlumnosEntity alumnosEntity = alumnosRepository.findById(alumnos.getId()).orElse(null);
			if(null == alumnosEntity) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			alumnosEntity.setNombres(alumnos.getNombres());
			alumnosEntity.setApellidos(alumnos.getApellidos());
			alumnosEntity.setSexo(alumnos.getSexo());
			alumnosRepository.save(alumnosEntity);
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, alumnos);
		} catch (Exception e) {
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto deleteAlumnos(Long id) {
		try {
			AlumnosEntity alumnosEntity = alumnosRepository.findById(id).orElse(null);
			alumnosEntity.setEstado(false);
			alumnosRepository.save(alumnosEntity);
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

}

