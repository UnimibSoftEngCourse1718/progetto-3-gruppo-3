package com.trinity.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "oggetto")
public class Oggetto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOggetto", nullable = false, unique = true)
	public int idOggetto;

	@Column(name = "nomeOggetto", nullable = false)
	private String nomeOggetto;
	
	@Column(name = "descrizione", nullable = false)
	private String descrizione;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name = "categoria")
	public Categoria categoria;

	public Oggetto(){}

	public Oggetto(int idOggetto, String nomeOggetto, String descrizione, Categoria categoria) {
		this.idOggetto=idOggetto;
		this.nomeOggetto=nomeOggetto;
		this.descrizione=descrizione;
		this.categoria=categoria;
	}
	
	public Oggetto(String nomeOggetto, String descrizione, Categoria categoria) {
		setNomeOggetto(nomeOggetto);
		setDescrizione(descrizione);
		setCategoria(categoria);
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

	public int getIdOggetto() {
		return idOggetto;
	}

	public void setIdOggetto(int idOggetto) {
		this.idOggetto = idOggetto;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}