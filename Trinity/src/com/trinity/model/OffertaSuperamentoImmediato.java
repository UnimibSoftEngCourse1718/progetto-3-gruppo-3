
public class OffertaSuperamentoImmediato extends Offerta{
	
	private AstaSuperamentoImmediato asta;
	private UtenteRegistrato offerente;
	private UtenteRegistrato venditore;
	
	public OffertaSuperamentoImmediato(AstaSuperamentoImmediato asta, UtenteRegistrato venditore, UtenteRegistrato offerente){
		super();
		setAsta(asta);
		setVenditore(venditore);
		setOfferente(offerente);
	}

	private AstaSuperamentoImmediato getAsta() {
		return asta;
	}

	private void setAsta(AstaSuperamentoImmediato asta) {
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
