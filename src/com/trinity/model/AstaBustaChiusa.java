package com.trinity.model;

import java.util.ArrayList;
import java.util.List;

public class AstaBustaChiusa extends Asta{
	
	public UtenteRegistrato offerente;
	public int venditore;
	private List<OffertaBustaChiusa> listaOfferte = new ArrayList<OffertaBustaChiusa>();

	public AstaBustaChiusa(int nuovaBaseAsta, int nuovaDurata, String nuovoStato, Oggetto nuovoOggettoInAsta) {
		super(nuovaBaseAsta, nuovaDurata, nuovoStato, nuovoOggettoInAsta);
		
		
	}

	public List<OffertaBustaChiusa> getListaOfferte() {
		return listaOfferte;
	}

	public void setListaOfferte(List<OffertaBustaChiusa> listaOfferte) {
		this.listaOfferte = listaOfferte;
	}
	
	public void addOfferta(OffertaBustaChiusa offerta) {
		this.listaOfferte.add(offerta);
	}

}
