package com.trinity.model;

import java.util.ArrayList;
import java.util.List;

public class AstaBustaChiusa extends Asta{
	
	public UtenteRegistrato offerente;
	public int venditore;
	public List<OffertaBustaChiusa> listaOfferte = new ArrayList<OffertaBustaChiusa>();

	public AstaBustaChiusa(int nuovaBaseAsta, int nuovaDurata, String nuovoStato, Oggetto nuovoOggettoInAsta) {
		super(nuovaBaseAsta, nuovaDurata, nuovoStato, nuovoOggettoInAsta);
		
		
	}
	

}
