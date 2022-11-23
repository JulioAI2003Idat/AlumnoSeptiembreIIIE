package com.idat.AlumnoMicroservicioIIIE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.AlumnoMicroservicioIIIE.dto.AlumnoDTO;
import com.idat.AlumnoMicroservicioIIIE.model.Alumno;
import com.idat.AlumnoMicroservicioIIIE.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	@Override
	public List<AlumnoDTO> listar() {
		List<AlumnoDTO> listadto = new ArrayList<>();
		List<Alumno> lista = repository.findAll();
		AlumnoDTO dto = null;
		for (Alumno alumno : lista) {
			dto = new AlumnoDTO();
			dto.setApe(alumno.getApellido());
			dto.setNom(alumno.getNombre());
			dto.setCod(alumno.getIdAlumno());
			listadto.add(dto);
		}
		return listadto;
	}

	@Override
	public AlumnoDTO obtenerporId(Integer id) {
		AlumnoDTO dto = null;
		Alumno alumno = repository.findById(id).orElse(null);
		dto = new AlumnoDTO();
		dto.setApe(alumno.getApellido());
		dto.setNom(alumno.getNombre());
		dto.setCod(alumno.getIdAlumno());
		
		
		return dto;
	}

	@Override
	public void guardar(AlumnoDTO a) {
		
		Alumno alu = new  Alumno();
		alu.setApellido(a.getApe());
		alu.setNombre(a.getNom());
		alu.setIdAlumno(a.getCod());
		repository.save(alu);
		
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void actualizar(AlumnoDTO alumno) {
		 
        Alumno alu = new Alumno();
        alu.setApellido(alumno.getApe());
        alu.setNombre(alumno.getNom());
        alu.setIdAlumno(alumno.getCod());
        
        repository.saveAndFlush(alu);
		
	}
}
