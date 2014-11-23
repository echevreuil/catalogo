package com.catalogo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "album")
@Entity
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id_album")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_artista")
  private Artista artista;

  @Column(name = "nome")
  private String nome;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Artista getArtista() {
    return artista;
  }

  public void setArtista(Artista artista) {
    this.artista = artista;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
