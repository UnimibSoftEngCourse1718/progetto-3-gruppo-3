
public class OffertaBustaChiusa extends Offerta {

	private AstaBustaChiusa asta;
	private UtenteRegistrato offerente;
	private UtenteRegistrato venditore;

	public OffertaBustaChiusa(AstaBustaChiusa asta, UtenteRegistrato venditore, UtenteRegistrato offerente){
		super();
		setAsta(asta);
		setVenditore(venditore);
		setOfferente(offerente);
	}
	
	private AstaBustaChiusa getAsta() {
		return asta;
	}
	private void setAsta(AstaBustaChiusa asta) {
		this.asta = asta;
	}
	private UtenteRegistrato getOfferente() {
		return offerente;
	}
	private void setOfferente(UtenteRegistrato offerente) {
		this.offerente = offerente;
	}
	private UtenteRegistrato getVenditore() {
		return venditore;
	}
	private void setVenditore(UtenteRegistrato venditore) {
		this.venditore = venditore;
	}
	
	
	
	
		

	

	

}
