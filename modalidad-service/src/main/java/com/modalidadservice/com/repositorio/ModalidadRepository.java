package com.modalidadservice.com.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modalidadservice.com.entidades.Modalidad;


@Repository
public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>{

	List<Modalidad> findByestudiantesId(int estudiantesId);

	
}