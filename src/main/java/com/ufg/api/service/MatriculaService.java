package com.ufg.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufg.api.model.Curso;
import com.ufg.api.model.Matricula;
import com.ufg.api.model.Usuario;
import com.ufg.api.repository.MatriculaRepository;

@Service
public class MatriculaService {
	@Autowired
	MatriculaRepository matriculaRepository;
	
	public Matricula salvar(Matricula matricula) {
		return matriculaRepository.save(matricula);
	}
	
	public List<Matricula> buscarPorAlunoECurso(Usuario aluno, Curso curso) {
		return matriculaRepository.findByAlunoAndCurso(aluno, curso);
	}
	
	public List<Matricula> buscarPorAluno(Usuario aluno) {
		return matriculaRepository.findByAluno(aluno);
	}
	
	public List<Matricula> buscarPorCurso(Curso curso) {
		return matriculaRepository.findByCurso(curso);
	}
	
}
