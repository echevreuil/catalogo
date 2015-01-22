package com.catalogo.service;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.catalogo.domain.Usuario;

@Named("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

  @PersistenceUnit(unitName = "catalogo")
  private EntityManagerFactory factory;
  // @PersistenceContext(unitName = "catalogo")
  private EntityManager em;
	
	public UsuarioServiceImpl(){
		
	}

	@Override
	public Usuario criarUsuario(Usuario usuario) {

    synchronized (this) {
      if (this.em == null) {
        this.em = factory.createEntityManager();
      }
    }
    this.em.getTransaction().begin();
    this.em.persist(usuario);
    this.em.flush();
    this.em.getTransaction().commit();

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
