package com.ufg.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufg.api.model.Curso;
import com.ufg.api.model.Matricula;
import com.ufg.api.model.Usuario;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer>  {
	
	List<Matricula> findByAlunoAndCurso(Usuario aluno, Curso curso);
	List<Matricula> findByAluno(Usuario aluno);
	List<Matricula> findByCurso(Curso curso);
}
