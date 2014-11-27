package com.catalogo.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.catalogo.domain.Usuario;

public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	EntityManager em;

	@Override
	public Usuario criarUsuario(Usuario usuario) {

		em.persist(usuario);
		em.flush();

		return usuario;
	}

	@Override
	public void deletarUsuario(Long usuarioId) {

		Usuario usuario = em.find(Usuario.class, usuarioId);

		if (usuario != null) {
			em.remove(usuario);
			em.flush();
		}
		
	}

	@Override
	public Usuario alterarUsuario(Usuario usuario) {

		em.merge(usuario);
		em.flush();

		return usuario;
	}

}
