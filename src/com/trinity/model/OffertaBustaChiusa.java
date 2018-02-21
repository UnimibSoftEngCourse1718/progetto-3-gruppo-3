package com.trinity.model;


public class OffertaBustaChiusa {

	private AstaBustaChiusa asta;
	private UtenteRegistrato offerente;
	private UtenteRegistrato venditore;

	public OffertaBustaChiusa(AstaBustaChiusa asta, UtenteRegistrato venditore, UtenteRegistrato offerente){
		setAsta(asta);
		setVenditore(venditore);
		setOfferente(offerente);
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
	public UtenteRegistrato getVenditore() {
		return venditore;
	}
	public void setVenditore(UtenteRegistrato venditore) {
		this.venditore = venditore;
	}
}