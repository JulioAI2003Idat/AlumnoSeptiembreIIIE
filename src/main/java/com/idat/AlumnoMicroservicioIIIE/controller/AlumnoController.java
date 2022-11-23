package com.idat.AlumnoMicroservicioIIIE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.AlumnoMicroservicioIIIE.dto.AlumnoDTO;
import com.idat.AlumnoMicroservicioIIIE.model.Alumno;
import com.idat.AlumnoMicroservicioIIIE.service.AlumnoService;

@RestController
@RequestMapping("/api/alumno/v1")
public class AlumnoController {
	
	@Autowired
	private AlumnoService service;


	@GetMapping("/hola")
	public @ResponseBody String hola(){
		return "hola profe xd";
	}
	
	@GetMapping("/listar")
	public @ResponseBody List<AlumnoDTO> listar(){
		return service.listar();
	}
	
	@GetMapping("/listar/{id}")
	public @ResponseBody AlumnoDTO obtenerID(@PathVariable Integer id) {
		return service.obtenerporId(id);
	}
	
	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody AlumnoDTO dto) {
		service.guardar(dto);
	}
	
	@PutMapping
	public @ResponseBody void actualizar(@RequestBody AlumnoDTO dto) {
		service.actualizar(dto);
	}
	
	@DeleteMapping("/eliminar")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
	}

}
