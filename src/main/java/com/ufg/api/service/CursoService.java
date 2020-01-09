package com.ufg.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ufg.api.dto.CursoAlunoDTO;
import com.ufg.api.model.Curso;
import com.ufg.api.model.Matricula;
import com.ufg.api.model.Usuario;
import com.ufg.api.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	MatriculaService matriculaService;
	
	public List<Curso> listarTodos(){
		return cursoRepository.findAll();
	}
	
	public Curso salvar(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public void deletar(Integer id) {
		cursoRepository.deleteById(id);
	}
	
	public void realizarMatricula(CursoAlunoDTO cursoAlunoDTO) throws Exception{
		
		Optional<Usuario> usuarioOptional = usuarioService.buscarPorId(cursoAlunoDTO.getCodigoAluno());
		Usuario aluno = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Erro - aluno inexistente"));
		
		Optional<Curso> cursoOptional = cursoRepository.findById(cursoAlunoDTO.getCodigoCurso());
		Curso curso = cursoOptional.orElseThrow(() -> new UsernameNotFoundException("Erro - curso inexistente"));
		
		List<Matricula> lista = matriculaService.buscarPorAlunoECurso(aluno, curso);
		if(!lista.isEmpty()) {
			throw new Exception("Erro - Você já possui matricula para este curso.");
		}
		Matricula matricula = new Matricula();
		matricula.setAluno(aluno);
		matricula.setCurso(curso);
		
		matriculaService.salvar(matricula);
	}
}
