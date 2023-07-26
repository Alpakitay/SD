package com.estudiantes.com.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.estudiantes.com.modelos.Modalidad;

@FeignClient(name = "modalidad-service", url = "http://localhost:8003", path = "/modalidad")
public interface ModalidadFeignClient {

	@PostMapping()
	public Modalidad save(@RequestBody Modalidad modalidad);

	@GetMapping("/modalidad/{estudiantesId}")
	public List<Modalidad> getModalidad(@PathVariable("estudiantesId") int estudiantesId);

}
