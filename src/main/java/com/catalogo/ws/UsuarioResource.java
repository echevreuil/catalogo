package com.catalogo.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.catalogo.domain.Usuario;
import com.catalogo.service.UsuarioService;

@Path("usuarios")
@Transactional
public class UsuarioResource {

  @Autowired
  private UsuarioService usuarioService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response insere(Usuario usuario) {
	  
	System.out.println("----> "+usuarioService);

    usuario = usuarioService.criarUsuario(usuario);

    return Response.status(201).entity(usuario).build();

  }

}
