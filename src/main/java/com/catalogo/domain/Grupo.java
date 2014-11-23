package com.catalogo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "grupo")
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_grupo")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToMany
	@JoinTable(
		      name="grupo_usuario",
		      joinColumns={@JoinColumn(name="id_usuario", referencedColumnName="id_usuario")},
		      inverseJoinColumns={@JoinColumn(name="id_grupo", referencedColumnName="id_grupo")})
	private List<Usuario> participantes;

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

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}
	
	

}
