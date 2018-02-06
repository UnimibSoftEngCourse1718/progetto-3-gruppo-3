package com.trinity.model;


public class Oggetto {

	private int idOggetto;
	private String nomeOggetto;
	private String descrizione;
	private Categoria categoria;
	
	public Oggetto() {
		idOggetto=0;
		nomeOggetto=null;
		descrizione=null;
		categoria=null;
	}
	
	public Oggetto(int idOggetto, String nomeOggetto, String descrizione, Categoria categoria) {
		this.idOggetto = idOggetto;
		this.nomeOggetto = nomeOggetto;
		this.descrizione = descrizione;
		this.categoria=categoria;
	}
	
	public Oggetto(Oggetto other) {
		this.idOggetto=other.getIdOggetto();
		this.nomeOggetto=other.getNomeOggetto();
		this.descrizione=other.getDescrizione();
		this.categoria=other.getCategoria();
	}
	
	public int getIdOggetto() {
		return idOggetto;
	}
	
	public void setIdOggetto(int idOggetto) {
		this.idOggetto = idOggetto;
	}
	
	public String getNomeOggetto() {
		return nomeOggetto;
	}
	
	public void setNomeOggetto(String nomeOggetto) {
		this.nomeOggetto = nomeOggetto;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}