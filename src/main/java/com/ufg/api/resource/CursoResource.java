package com.ufg.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ufg.api.dto.CursoAlunoDTO;
import com.ufg.api.model.Curso;
import com.ufg.api.service.CursoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/cursos")
public class CursoResource {

	@Autowired
	CursoService cursoService;
	/*
	 * @Autowired S3Service s3Service;
	 */
	
	
	@ApiOperation("Busca todos os cursos")
	@GetMapping()
	public  List<Curso> litarTodos() throws Exception {
		return cursoService.listarTodos();
	}
	
	@GetMapping("/publicos")
	public  List<Curso> litarTodosPublico() throws Exception {
		return cursoService.listarTodos();
	}
	
	@ApiOperation("Busca apenas um curso, pelo seu CODIGO")
	@GetMapping("/{codigo}")
	public Curso buscarProId(@PathVariable Integer codigo, HttpServletResponse response) throws Exception {
		return cursoService.consultarPorId(codigo);
	}
	
	@PostMapping
	public ResponseEntity<Curso> criar(@RequestBody Curso curso, HttpServletResponse response) {
		Curso cursoSalvo = cursoService.salvar(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void remover(@PathVariable Integer codigo, HttpServletResponse response) throws Exception {
		cursoService.deletar(codigo);
	}
	
	@PostMapping("/inscreva")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public void inscreva(@RequestBody CursoAlunoDTO cursoAlunoDTO, HttpServletResponse response) throws Exception {
		cursoService.realizarMatricula(cursoAlunoDTO);
	}
	
	
}
