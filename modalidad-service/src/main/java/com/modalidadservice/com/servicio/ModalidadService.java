package com.modalidadservice.com.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modalidadservice.com.entidades.Modalidad;
import com.modalidadservice.com.repositorio.ModalidadRepository;

@Service
public class ModalidadService {

	@Autowired
	private ModalidadRepository modalidadRepository;
	
	public List<Modalidad> getAll(){
		return modalidadRepository.findAll();
	}
	
	public Modalidad getModalidadById(int id){
		return modalidadRepository.findById(id).orElse(null);
	}
	
	public Modalidad save(Modalidad modalidad) {
		Modalidad nuevaModalidad = modalidadRepository.save(modalidad);
		return nuevaModalidad;
	}	
	
	public List<Modalidad> byModalidadId(int estudiantesId){
		return modalidadRepository.findByestudiantesId(estudiantesId);	
	}
}
