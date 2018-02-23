package com.trinity.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name= "offertasuperamentoimmediato")
public class OffertaSuperamentoImmediato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOffertaSI;
	
	@Column(name="valore", nullable = false)
	public int valore;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn (name = "asta", nullable = false)
	public AstaSuperamentoImmediato asta;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn (name = "offerente", nullable = false)
	public UtenteRegistrato offerente;
	
	public OffertaSuperamentoImmediato(int idOffertaSI, int valore, AstaSuperamentoImmediato asta, UtenteRegistrato offerente) {
		this.idOffertaSI = idOffertaSI;
		this.valore = valore;
		this.asta = asta;
		this.offerente = offerente;
	}

	public OffertaSuperamentoImmediato(int valore, AstaSuperamentoImmediato asta, UtenteRegistrato offerente) {
		this.valore = valore;
		this.asta = asta;
		this.offerente = offerente;
	}
	
	public int getIdOffertaSI() {
		return idOffertaSI;
	}

	public void setIdOffertaSI(int idOffertaSI) {
		this.idOffertaSI = idOffertaSI;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public AstaSuperamentoImmediato getAsta() {
		return asta;
	}

	public void setAsta(AstaSuperamentoImmediato asta) {
		this.asta = asta;
	}

	public UtenteRegistrato getOfferente() {
		return offerente;
	}

	public void setOfferente(UtenteRegistrato offerente) {
		this.offerente = offerente;
	}
}