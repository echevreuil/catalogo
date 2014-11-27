package com.catalogo.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Table(name = "usuario")
@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_usuario")
  private Long id;

  @Email
  @NotNull
  @Column(name = "login")
  private String login;

  @NotNull
  @Column(name = "senha")
  private String senha;

  @Column(name = "dt_nascimento")
  private Date dataNascimento;

  @NotNull
  @Column(name = "nome")
  private String nome;
  
  @ManyToMany(mappedBy = "participantes")
  private List<Grupo> grupos;
  
  @OneToMany(mappedBy = "usuario")
  private List<Comentario> comentarios;
  

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}