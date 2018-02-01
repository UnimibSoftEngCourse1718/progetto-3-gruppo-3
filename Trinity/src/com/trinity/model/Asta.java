package com.trinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public abstract class Asta {
	
	private int idAsta;
	
	private int baseAsta;
	
	private int durata;
	
	private String stato;
	
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
