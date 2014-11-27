package com.catalogo.service;

import com.catalogo.domain.Usuario;

public interface UsuarioService {
	
	public Usuario criarUsuario(Usuario usuario);
	
	public void deletarUsuario(Long usuarioId);
	
	public Usuario alterarUsuario(Usuario usuario);
	
}
