package com.trinity.model;


public class Categoria {

	private int idCategoria;
	private String nomeCategoria;
	
	public Categoria() {
		idCategoria=0;
		nomeCategoria=null;
	}

	public Categoria(int idCategoria, String nomeCategoria) {
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
	}
	
	public Categoria(Categoria other) {
		this.idCategoria=other.getIdCategoria();
		this.nomeCategoria=other.getNomeCategoria();
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	 
	
}