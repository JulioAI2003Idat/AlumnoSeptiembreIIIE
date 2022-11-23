package com.idat.AlumnoMicroservicioIIIE.service;

import java.util.List;

import com.idat.AlumnoMicroservicioIIIE.dto.AlumnoDTO;

public interface AlumnoService {
	
	List<AlumnoDTO> listar();
	AlumnoDTO obtenerporId(Integer id);
	void guardar(AlumnoDTO a);
	void eliminar(Integer id);
	void actualizar(AlumnoDTO alumno);

}
