package com.ufg.api.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufg.api.model.Usuario;
import com.ufg.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	UsuarioService usuarioSerice;
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario, HttpServletResponse response) throws Exception {
		Usuario usuarioSalvo = usuarioSerice.salvar(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	
}
