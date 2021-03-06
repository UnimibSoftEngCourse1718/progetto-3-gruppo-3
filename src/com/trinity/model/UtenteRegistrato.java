package com.trinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UtenteRegistrato")
public class UtenteRegistrato{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUtente", nullable = false, unique = true)
	public int idUtente;

	@Column(name = "nomeUtente", length = 40, nullable = false)
	public String nomeUtente;

	@Column(name = "cognomeUtente", length = 40, nullable = false)
	public String cognomeUtente;

	@Column(name = "email", length = 40, nullable = false)
	public String email;

	@Column(name = "indirizzo", length = 40, nullable = false)
	public String indirizzo;

	@Column(name = "numeroCarta", length = 40, nullable = false)
	public String numeroCarta;
	
	@Column(name = "password", length = 40, nullable = false)
	public String password;
	
	@Column(name = "creditiDisp", length = 40, nullable = true)
	public int creditiDisp;
	
	@Column(name = "creditiCont", length = 40, nullable = true)
	public int creditiCont;
	
	public UtenteRegistrato(){
		
	}
	
	public UtenteRegistrato(int idUtente, String nomeUtente, String cognomeUtente, String password, String email, String indirizzo,
			String numeroCarta) {
		this.idUtente = idUtente;
		this.nomeUtente = nomeUtente;
		this.cognomeUtente = cognomeUtente;
		this.email = email;
		this.indirizzo = indirizzo;
		this.numeroCarta = numeroCarta;
		this.password = password;
	}
	
	public UtenteRegistrato(int idUtente, String nomeUtente, String cognomeUtente, String email, String password, String indirizzo,
			String numeroCarta, int creditiDisp, int creditiCont) {
		this.idUtente = idUtente;
		this.nomeUtente = nomeUtente;
		this.cognomeUtente = cognomeUtente;
		this.email = email;
		this.indirizzo = indirizzo;
		this.numeroCarta = numeroCarta;
		this.password = password;
		this.creditiDisp = creditiDisp;
		this.creditiCont = creditiCont;
	}
	
	public UtenteRegistrato(String nomeUtente, String cognomeUtente, String password, String email, String indirizzo,
			String numeroCarta) {
		this.nomeUtente = nomeUtente;
		this.cognomeUtente = cognomeUtente;
		this.email = email;
		this.indirizzo = indirizzo;
		this.numeroCarta = numeroCarta;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getCognomeUtente() {
		return cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	
	public int getCreditiDisp() {
		return creditiDisp;
	}
	
	public void setCreditiDisp(int creditiDisp) {
		this.creditiDisp = creditiDisp;
	}
	
	public int getCreditiCont() {
		return creditiCont;
	}
	
	public void setCreditiCont(int creditiCont) {
		this.creditiCont  = creditiCont;
	}
}