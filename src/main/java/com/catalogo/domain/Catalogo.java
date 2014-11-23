package com.catalogo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "catalogo")
@Entity
public class Catalogo {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id_catalogo")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_usuario")
  private Usuario dono;

  @Column(name = "nome")
  private String titulo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Usuario getDono() {
    return dono;
  }

  public void setDono(Usuario dono) {
    this.dono = dono;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
}
