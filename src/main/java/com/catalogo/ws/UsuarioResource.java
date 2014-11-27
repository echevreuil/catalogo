package com.catalogo.ws;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.catalogo.domain.Usuario;
import com.catalogo.service.UsuarioService;

@Path("usuarios")
public class UsuarioResource {

  @Inject
  private UsuarioService service;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response insere(Usuario usuario) {

    usuario = service.criarUsuario(usuario);

    return Response.status(201).entity(usuario).build();

  }

}
