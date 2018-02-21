package com.trinity.model;

public class OffertaSuperamentoImmediato {
	
	private int idOffertaSI;
	private int valore;
	private AstaSuperamentoImmediato asta;
	private UtenteRegistrato offerente;
	
	public OffertaSuperamentoImmediato(int idOffertaSI, int valore, AstaSuperamentoImmediato asta, UtenteRegistrato offerente) {
		//super();
		this.idOffertaSI = idOffertaSI;
		this.valore = valore;
		this.asta = asta;
		this.offerente = offerente;
	}

	public OffertaSuperamentoImmediato(int valore, AstaSuperamentoImmediato asta, UtenteRegistrato offerente) {
		//super();
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