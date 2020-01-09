package com.ufg.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufg.api.model.Matricula;
import com.ufg.api.model.Usuario;
import com.ufg.api.service.MatriculaService;
import com.ufg.api.service.UsuarioService;

@RestController
@RequestMapping("/matriculas")
public class MatriculaResource {

	@Autowired
	 MatriculaService matriculaService;
	@Autowired
	 UsuarioService usuarioService;
	
	
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
	@GetMapping("/{codigoAluno}")
	public  List<Matricula> litarTodas(@PathVariable Integer codigoAluno) throws Exception {
		
		Optional<Usuario> usuarioOptional = usuarioService.buscarPorId(codigoAluno);
		Usuario aluno = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Erro - aluno inexistente"));
		
		return matriculaService.buscarPorAluno(aluno);
	}
	
	
	
}
