package com.catalogo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.catalogo.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@PersistenceContext(name = "catalogo")
	EntityManager em;
	
	public UsuarioServiceImpl(){
		
	}

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
