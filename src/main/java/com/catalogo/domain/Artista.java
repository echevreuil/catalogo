package com.catalogo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "artista")
@Entity
public class Artista {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id_artista")
  private Long id;

  @Column(name = "nome")
  private String nome;

  @OneToMany(mappedBy = "artista")
  private List<Album> albuns;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Album> getAlbuns() {
    return albuns;
  }

  public void setAlbuns(List<Album> albuns) {
    this.albuns = albuns;
  }

}
