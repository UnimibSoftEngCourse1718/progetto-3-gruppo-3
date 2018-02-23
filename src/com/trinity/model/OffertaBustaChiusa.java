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
@Table (name= "offertabustachiusa")
public class OffertaBustaChiusa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOffertaBC;
	
	@Column(name="valore", nullable = false)
	public int valore;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn (name = "asta", nullable = false)
	public AstaBustaChiusa asta;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn (name = "offerente", nullable = false)
	public UtenteRegistrato offerente;
	
	public OffertaBustaChiusa(int idOffertaBC, int valore, AstaBustaChiusa asta, UtenteRegistrato offerente) {
		this.idOffertaBC = idOffertaBC;
		this.valore = valore;
		this.asta = asta;
		this.offerente = offerente;
	}

	public OffertaBustaChiusa(int valore, AstaBustaChiusa asta, UtenteRegistrato offerente) {
		this.valore = valore;
		this.asta = asta;
		this.offerente = offerente;
	}
	
	public int getIdOffertaBC() {
		return idOffertaBC;
	}

	public void setIdOffertaBC(int idOffertaSI) {
		this.idOffertaBC = idOffertaSI;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public AstaBustaChiusa getAsta() {
		return asta;
	}

	public void setAsta(AstaBustaChiusa asta) {
		this.asta = asta;
	}

	public UtenteRegistrato getOfferente() {
		return offerente;
	}

	public void setOfferente(UtenteRegistrato offerente) {
		this.offerente = offerente;
	}
}