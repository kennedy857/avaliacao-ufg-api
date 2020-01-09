package com.ufg.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.ufg.api.model.Usuario;
import com.ufg.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario) {
		gerarSenha(usuario);
		return usuarioRepository.save(usuario);
	}

	
	private void gerarSenha(Usuario usuario) {
		String salt = BCrypt.gensalt(06);
		usuario.setSenha(BCrypt.hashpw(usuario.getSenha(), salt));
	}
	
	public Optional<Usuario> buscarPorId(Integer id) {
		return usuarioRepository.findById(Long.valueOf(id));
	}
}
