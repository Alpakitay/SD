package com.estudiantes.com.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.estudiantes.com.entidades.Estudiantes;
import com.estudiantes.com.feignclients.CursosFeignClient;
import com.estudiantes.com.feignclients.ModalidadFeignClient;
import com.estudiantes.com.modelos.Cursos;
import com.estudiantes.com.modelos.Modalidad;
import com.estudiantes.com.repositorio.EstudiantesRepository;

@Service
public class EstudiantesService {

	@Autowired
	private EstudiantesRepository estudianteRepository;
	@Autowired
	private CursosFeignClient cursoFeignClient;
	@Autowired
	private ModalidadFeignClient modalidadFeignClient;

	public List<Estudiantes> getAll() {
		return estudianteRepository.findAll();
	}

	public Estudiantes getEstuidantesById(int id) {
		return estudianteRepository.findById(id).orElse(null);
	}

	public Estudiantes save(Estudiantes estudiantes) {
		Estudiantes nuevoEstudiante = estudianteRepository.save(estudiantes);
		return nuevoEstudiante;
	}

	public Cursos saveCursos(int estudiantesId, Cursos cursos) {
		cursos.setEstudiantesId(estudiantesId);
		Cursos nuevoCurso = cursoFeignClient.save(cursos);
		return nuevoCurso;
	}

	public Modalidad saveModalidad(int estudiantesId, Modalidad modalidad) {
		modalidad.setEstudiantesId(estudiantesId);
		Modalidad nuevaModalidad = modalidadFeignClient.save(modalidad);
		return nuevaModalidad;
	}

	public Map<String, Object> getEstudianteAndEstudios(int estudiantesId) {
		Map<String, Object> resultado = new HashMap<>();
		Estudiantes usuario = estudianteRepository.findById(estudiantesId).orElse(null);

		if (usuario == null) {
			resultado.put("Mensaje", "El mensaje no existe ):");
			return resultado;
		}
		resultado.put("Cursos", estudiantesId);
		List<Cursos> cursos = cursoFeignClient.getCursos(estudiantesId);
		if (cursos.isEmpty()) {
			resultado.put("Cursos", "El Estudiante en mencion no tiene Cursos");
		} else {
			resultado.put("Cursos", cursos);
		}

		List<Modalidad> modalidad = modalidadFeignClient.getModalidad(estudiantesId);
		if (modalidad.isEmpty()) {
			resultado.put("Modalidad", "El Estudiante en mencion no tiene Modalidad");
		} else {
			resultado.put("Modalidad", modalidad);
		}
		return resultado;
	}
}
