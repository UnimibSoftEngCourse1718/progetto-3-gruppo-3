package com.trinity.model;

public class AstaBustaChiusa extends Asta{
	
	public UtenteRegistrato offerente;
	public int venditore;
	public OffertaBustaChiusa offerta;
	
	
	public AstaBustaChiusa(int nuovaIdAsta, int nuovaBaseAsta, int nuovaDurata, String nuovoStato, Oggetto nuovoOggettoInAsta, OffertaBustaChiusa nuovaOfferta) {
		super(nuovaIdAsta, nuovaBaseAsta, nuovaDurata, nuovoStato, nuovoOggettoInAsta);
		this.venditore = UtenteRegistrato.getIdUtente();
		this.offerta=0;
	}
	

}
