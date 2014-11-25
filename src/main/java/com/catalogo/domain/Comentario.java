package com.catalogo.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_comentario")
	private Long id;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "data")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="id_comentario_pai")
	private Comentario comentarioPai;
	
	@OneToMany(mappedBy = "comentarioPai")
	private List<Comentario> comentarios;
	
	@Column(name = "id_tipo_comentario")
	private TipoComentario tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Comentario getComentarioPai() {
		return comentarioPai;
	}

	public void setComentarioPai(Comentario comentarioPai) {
		this.comentarioPai = comentarioPai;
	}

	public TipoComentario getTipo() {
		return tipo;
	}

	public void setTipo(TipoComentario tipo) {
		this.tipo = tipo;
	}
	
	

}
