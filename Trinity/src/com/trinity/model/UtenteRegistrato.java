package com.trinity.model;


import javax.persistence.Column;
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
	@Column(name = "idutente", nullable = false, unique = true)
	private int idUtente;

	@Column(name = "nomeutente", length = 40, nullable = false)
	private String nomeUtente;

	@Column(name = "cognomeutente", length = 40, nullable = false)
	private String cognomeUtente;

	@Column(name = "email", length = 40, nullable = true)
	private String email;

	@Column(name = "indirizzo", length = 40, nullable = true)
	private String indirizzo;

	@Column(name = "numerocarta", length = 40, nullable = true)
	private int numeroCarta;
	
	@Column(name = "password", length = 40, nullable = true)
	private String password;

	public UtenteRegistrato(String nomeUtente, String cognomeUtente, String password, String email, String indirizzo,
			int numeroCarta) {
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

	private int getIdUtente() {
		return idUtente;
	}

	private void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	private String getNomeUtente() {
		return nomeUtente;
	}

	private void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	private String getCognomeUtente() {
		return cognomeUtente;
	}

	private void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	private String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private String getIndirizzo() {
		return indirizzo;
	}

	private void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	private int getNumeroCarta() {
		return numeroCarta;
	}

	private void setNumeroCarta(int numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

}