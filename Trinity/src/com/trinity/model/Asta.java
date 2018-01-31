package com.trinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Aste")

public abstract class Asta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idasta", nullable=false, unique=true)
	private int idAsta;
	@Column(name = "baseasta", length = 40, nullable = false)
	private int baseAsta;
	@Column(name = "durata", length = 40, nullable = false)
	private int durata;
	@Column(name = "stato", length = 40, nullable = false)
	private String stato;
	@Column(name = "oggettoinasta", length = 40, nullable = false)
	private Oggetto oggettoInAsta;
	
	public Asta(int nuovaIdAsta, int nuovaBaseAsta, int nuovaDurata, String nuovoStato, Oggetto nuovoOggettoInAsta){
		this.idAsta=nuovaIdAsta;
		this.baseAsta=nuovaBaseAsta;
		this.durata=nuovaDurata;
		this.stato=nuovoStato;
		this.oggettoInAsta=nuovoOggettoInAsta;
	}

	public int getIdAsta() {
		return idAsta;
	}

	public void setIdAsta(int idAsta) {
		this.idAsta = idAsta;
	}

	public int getBaseAsta() {
		return baseAsta;
	}

	public void setBaseAsta(int baseAsta) {
		this.baseAsta = baseAsta;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
	public void avviaAsta(){
		
	}
	public void terminaAsta(){
		
	}
}
