package com.cursoservice.com.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoservice.com.entidades.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

	List<Curso> findByestudiantesId(int estudiantesId);

	
}