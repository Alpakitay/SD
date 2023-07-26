package com.cursoservice.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoservice.com.entidades.Curso;
import com.cursoservice.com.servicio.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping
	public ResponseEntity<List<Curso>> listarCurso() {
		List<Curso> curso = cursoService.getAll();
		if (curso.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(curso);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Curso> obtenerCurso(@PathVariable("id") int id) {
		Curso curso = cursoService.getCursoById(id);
		if (curso == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(curso);
	}

	@PostMapping
	public ResponseEntity<Curso> guardarCurso(@RequestBody Curso curso) {
		Curso nuevoCurso = cursoService.save(curso);
		return ResponseEntity.ok(nuevoCurso);

	}

	@GetMapping("/curso/{id}")
	public ResponseEntity<List<Curso>> listarCursoxId(@PathVariable("id") int id) {
		List<Curso> curso = cursoService.byCursoId(id);
		if (curso.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(curso);
	}
}
