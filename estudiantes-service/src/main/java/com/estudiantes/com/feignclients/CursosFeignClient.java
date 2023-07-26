package com.estudiantes.com.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.estudiantes.com.modelos.Cursos;

@FeignClient(name = "curso-service", url = "http://localhost:8002", path = "/cursos")
public interface CursosFeignClient {

	@PostMapping()
	public Cursos save(@RequestBody Cursos cursos);

	@GetMapping("/curso/{estudiantesId}")
	public List<Cursos> getCursos(@PathVariable("estudiantesId") int estudiantesId);

}
