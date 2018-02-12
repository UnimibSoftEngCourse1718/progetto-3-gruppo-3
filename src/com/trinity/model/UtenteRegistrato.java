package com.trinity.model;


import javax.persistence.Column;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UtenteRegistrato")
public class UtenteRegistrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUtente", nullable = false, unique = true)
	private int idUtente;

	@Column(name = "nomeUtente", length = 40, nullable = false)
	private String nomeUtente;

	@Column(name = "cognomeUtente", length = 40, nullable = false)
	private String cognomeUtente;

	@Column(name = "email", length = 40, nullable = false)
	private String email;

	@Column(name = "indirizzo", length = 40, nullable = false)
	private String indirizzo;

	@Column(name = "numeroCarta", length = 40, nullable = false)
	private String numeroCarta;
	
	@Column(name = "password", length = 40, nullable = false)
	private String password;
	
	@Column(name = "crediti", length = 40, nullable = true)
	private int credito;
	
	//private List<AstaBustaChiusa> storicoAsteBustaChiusa = new ArrayList<AstaBustaChiusa>();
	//private List<AstaSuperamentoImmediato> storicoAsteSuperamentoImmediato = new ArrayList<AstaSuperamentoImmediato>();

	public UtenteRegistrato(String nomeUtente, String cognomeUtente, String password, String email, String indirizzo,
			String numeroCarta) {
		this.nomeUtente = nomeUtente;
		this.cognomeUtente = cognomeUtente;
		this.email = email;
		this.indirizzo = indirizzo;
		this.numeroCarta = numeroCarta;
		this.password = password;
	}

	private String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	public int getIdUtente() {
		return idUtente;
	}

	private void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	private void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getCognomeUtente() {
		return cognomeUtente;
	}

	private void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	private void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	private void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	
	public int getCredito() {
		return credito;
	}
	
	public void setCredito(int credito) {
		this.credito = credito;
	}
	
	//acquista credito?
	
	public AstaBustaChiusa creaAstaBustaChiusa (int nuovaBaseAsta, int nuovaDurata, String nuovoStato, Oggetto nuovoOggettoInAsta) { // idAsta generato dall'utente o dal pc? 
		AstaBustaChiusa nuovaAsta = new AstaBustaChiusa(nuovaBaseAsta, nuovaDurata, nuovoStato, nuovoOggettoInAsta);
		nuovaAsta.venditore = this.idUtente;
		//storicoAsteBustaChiusa.add(nuovaAsta);
		return nuovaAsta;
	}
	
	//public void vediStoricoAsteBustaChiusa() { 
	//	System.out.println(storicoAsteBustaChiusa.toString());
	//}
	
	public AstaSuperamentoImmediato creaAstaSuperamentoImmediato(int nuovaBaseAsta, int nuovaDurata, String nuovoStato, Oggetto nuovoOggettoInAsta, int newNumTimeSlot, int newTimeSlotAgg){
		AstaSuperamentoImmediato nuovaAsta = new AstaSuperamentoImmediato(nuovaBaseAsta, nuovaDurata, nuovoStato, nuovoOggettoInAsta, newNumTimeSlot, newTimeSlotAgg);
		nuovaAsta.setVenditore(this.idUtente);
		//storicoAsteSuperamentoImmediato.add(nuovaAsta);
		
		return nuovaAsta;
	}
	
	//public void vediStoricoAsteSuperamentoImmediato() {
	//	System.out.println(storicoAsteSuperamentoImmediato.toString());
	//}
	
	public void proponiOffertaBustaChiusa(OffertaBustaChiusa offerta, AstaBustaChiusa asta) {
	
		//inserisci offerta nell'array della lista offerte per l'asta
		// passo un oggetto offerta già istanziato? ne istanzio uno nuovo nei parametri? o passo i punti come parametro
		// e all'interno del metodo istanzio il nuovo oggetto Offerta?
	}
	
	public void proponiOffertaSuperamentoImmediato(OffertaSuperamentoImmediato offerta, AstaSuperamentoImmediato asta) {
		
		// inserisci offerta nell'array della lista offerte per l'asta
	}

}