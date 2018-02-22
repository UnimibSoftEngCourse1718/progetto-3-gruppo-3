package com.trinity.model;

import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "astabustachiusa")
@SuppressWarnings("unused")

public class AstaBustaChiusa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAsta", nullable = false, unique = true)
	private int idAsta;
	
	@Column(name = "baseAsta", nullable = false)
	private int baseAsta;
	
	@Column(name = "oraInizio", nullable = false)
	private long oraInizio;
	
	@Column(name = "oraFine", nullable=false)
	private long oraFine;
	
	@Column(name = "attiva", nullable=false)
	private int attiva;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn (name = "oggetto")
	private Oggetto oggetto;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name = "venditore")
	private UtenteRegistrato venditore;
		
public AstaBustaChiusa(){}
	
	public AstaBustaChiusa(int baseAsta, Oggetto oggetto, UtenteRegistrato venditore){
		//super(baseAsta);
		setBaseAsta(baseAsta);
		setOraInizio(System.currentTimeMillis());
		setOraFine(System.currentTimeMillis() + 600000);
		setOggetto(oggetto);
		setVenditore(venditore);
		setAttiva(1);
	}
	
	public AstaBustaChiusa(int idAsta, int baseAsta, Oggetto oggetto, UtenteRegistrato venditore){
		//super(baseAsta);
		setIdAsta(idAsta);
		setBaseAsta(baseAsta);
		setOraInizio(System.currentTimeMillis());
		setOraFine(System.currentTimeMillis() + 600000);
		setOggetto(oggetto);
		setVenditore(venditore);
		setAttiva(1);
	}
	
	public AstaBustaChiusa(int idAsta, int baseAsta, long oraInizio, long oraFine, Oggetto oggetto, UtenteRegistrato venditore){
		//super(baseAsta);
		setIdAsta(idAsta);
		setBaseAsta(baseAsta);
		setOraInizio(oraInizio);
		setOraFine(oraFine);
		setOggetto(oggetto);
		setVenditore(venditore);
		setAttiva(1);
	}
	
	public int getAttiva() {
		return attiva;
	}
	
	public void setAttiva(int attiva) {
		this.attiva = attiva;
	}

	public void setIdAsta(int idAsta) {
		this.idAsta = idAsta;
	}
	
	public int getIdAsta() {
		return idAsta;
	}
	
	public void setBaseAsta(int baseAsta) {
		this.baseAsta = baseAsta;
	}
	
	public int getBaseAsta() {
		return baseAsta;
	}
	
	public void setOraInizio(long oraInizio) {
		this.oraInizio = oraInizio;
	}
	
	public long getOraInizio() {
		return oraInizio;
	}
	
	public void setOraFine(long oraFine) {
		this.oraFine=oraFine;
	}
	
	public long getOraFine() {
		return oraFine;
	}
	
	public void setOggetto(Oggetto oggetto) {
		this.oggetto = oggetto;
	}
	
	public Oggetto getOggetto() {
		return oggetto;
	}
	
	public void setVenditore(UtenteRegistrato venditore) {
		this.venditore = venditore;
	}
	
	public UtenteRegistrato getVenditore() {
		return venditore;
	}
}