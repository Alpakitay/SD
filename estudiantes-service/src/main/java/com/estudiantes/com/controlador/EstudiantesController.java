package com.estudiantes.com.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudiantes.com.entidades.Estudiantes;
import com.estudiantes.com.modelos.Cursos;
import com.estudiantes.com.modelos.Modalidad;
import com.estudiantes.com.servicio.EstudiantesService;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {

	@Autowired
	private EstudiantesService estudiantesService;

	@GetMapping
	public ResponseEntity<List<Estudiantes>> listarEstudiantes() {
		List<Estudiantes> estudiantes = estudiantesService.getAll();
		if (estudiantes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(estudiantes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estudiantes> obtenerEstudiantes(@PathVariable("id") int id) {
		Estudiantes estudiantes = estudiantesService.getEstuidantesById(id);
		if (estudiantes == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estudiantes);
	}

	@PostMapping
	public ResponseEntity<Estudiantes> guardarEstudiantes(@RequestBody Estudiantes estudiantes) {
		Estudiantes nuevoEstudiante = estudiantesService.save(estudiantes);
		return ResponseEntity.ok(nuevoEstudiante);

	}

	@PostMapping("/cursos/{estudiantesId}")
	public ResponseEntity<Cursos> guardarCursos(@PathVariable("estudiantesId") int estudiantesId,
			@RequestBody Cursos cursos) {
		Cursos nuevoCurso = estudiantesService.saveCursos(estudiantesId, cursos);
		return ResponseEntity.ok(nuevoCurso);
	}

	@PostMapping("/modalidad/{estudiantesId}")
	public ResponseEntity<Modalidad> guardarModalidad(@PathVariable("estudiantesId") int estudiantesId,
			@RequestBody Modalidad modalidad) {
		Modalidad nuevaModalidad = estudiantesService.saveModalidad(estudiantesId, modalidad);
		return ResponseEntity.ok(nuevaModalidad);
	}

	@GetMapping("/todos/{estudiantesId}")
	public ResponseEntity<Map<String, Object>> listarTodosLosCursos(@PathVariable("estudiantesId") int estudiantesId) {
		Map<String, Object> resultado = estudiantesService.getEstudianteAndEstudios(estudiantesId);
		return ResponseEntity.ok(resultado);
	}

}
