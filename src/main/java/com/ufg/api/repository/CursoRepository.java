package com.ufg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufg.api.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>  {
	
}
