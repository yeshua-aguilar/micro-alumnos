package com.edu.certus.alumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.certus.alumnos.entity.AlumnosEntity;

@Repository
public interface AlumnosRepository extends JpaRepository<AlumnosEntity, Integer>{

}