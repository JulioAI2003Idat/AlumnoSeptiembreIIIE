package com.idat.AlumnoMicroservicioIIIE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.AlumnoMicroservicioIIIE.model.Alumno;

@Repository
public interface AlumnoRepository  extends JpaRepository<Alumno, Integer>{

}
