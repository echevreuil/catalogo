package com.catalogo.ws;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.catalogo.domain.Usuario;
import com.catalogo.service.UsuarioService;

@Path("usuarios")
@Named("usuarioResource")
public class UsuarioResource {

  private UsuarioService usuarioService;

  @Inject
  public void setUsuarioService(@Named("usuarioService") UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response insere(Usuario usuario) {
	  
	System.out.println("----> "+usuarioService);

    usuario = usuarioService.criarUsuario(usuario);

    return Response.status(201).entity(usuario).build();

  }

}
