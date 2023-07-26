package com.modalidadservice.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modalidadservice.com.entidades.Modalidad;
import com.modalidadservice.com.servicio.ModalidadService;

@RestController
@RequestMapping("/modalidad")
public class ModalidadController {
	
	@Autowired
	private ModalidadService modalidadService;
	
	@GetMapping
	public ResponseEntity<List<Modalidad>> listarModalidado() {
		List<Modalidad> modalidad = modalidadService.getAll();
		if (modalidad.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(modalidad);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Modalidad> obtenerModalidad(@PathVariable("id") int id) {
		Modalidad modalidad = modalidadService.getModalidadById(id);
		if (modalidad == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(modalidad);
	}

	@PostMapping
	public ResponseEntity<Modalidad> guardarCurso(@RequestBody Modalidad modalidad) {
		Modalidad nuevaModalidad = modalidadService.save(modalidad);
		return ResponseEntity.ok(nuevaModalidad);

	}

	@GetMapping("/modalidad/{estudiantesId}")
	public ResponseEntity<List<Modalidad>> listarModalidadxId(@PathVariable("estudiantesId") int id) {
		List<Modalidad> modalidad = modalidadService.byModalidadId(id);
		if (modalidad.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(modalidad);
	}

}
