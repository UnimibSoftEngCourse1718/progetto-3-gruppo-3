package com.trinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table (name= "categoria")
	public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idCategoria;
	
	@Column(name="nomeCategoria")
	private String nomeCategoria;

	public Categoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	public Categoria() {
		
	}
	
	public Categoria(int idCategoria, String nomeCategoria) {
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
}