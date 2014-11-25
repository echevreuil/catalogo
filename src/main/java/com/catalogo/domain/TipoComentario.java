package com.catalogo.domain;

public enum TipoComentario {

	ALBUM(1), ARTISTA(2), GRUPO(3), MUSICA(4), CATALOGO(5);

	private final int tipoCode;

	TipoComentario(int tipoCode) {
		
		this.tipoCode = tipoCode;
		
	}
	
	public int getValue(){
		
		return this.tipoCode;
		
	}

}
