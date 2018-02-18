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
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn (name = "oggetto")
	private Oggetto oggetto;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name = "venditore")
	private UtenteRegistrato venditore;
	
	//public UtenteRegistrato offerente;
	//public int venditore;
	//private List<OffertaBustaChiusa> listaOfferte = new ArrayList<OffertaBustaChiusa>();
	
public AstaBustaChiusa(){}
	
	public AstaBustaChiusa(int baseAsta, Oggetto oggetto, UtenteRegistrato venditore){
		//super(baseAsta);
		setBaseAsta(baseAsta);
		setOraInizio(System.currentTimeMillis());
		setOraFine(System.currentTimeMillis() + 1800000);
		setOggetto(oggetto);
		setVenditore(venditore);
	}
	
	public AstaBustaChiusa(int idAsta, int baseAsta, long oraInizio, long oraFine, Oggetto oggetto, UtenteRegistrato venditore){
		//super(baseAsta);
		setIdAsta(idAsta);
		setBaseAsta(baseAsta);
		setOraInizio(oraInizio);
		setOraFine(oraFine);
		setOggetto(oggetto);
		setVenditore(venditore);
	}
	
	private void setIdAsta(int idAsta) {
		this.idAsta = idAsta;
	}
	
	private int getIdAsta() {
		return idAsta;
	}
	
	private void setBaseAsta(int baseAsta) {
		this.baseAsta = baseAsta;
	}
	
	private int getBaseAsta() {
		return baseAsta;
	}
	
	private void setOraInizio(long oraInizio) {
		this.oraInizio = oraInizio;
	}
	
	private long getOraInizio() {
		return oraInizio;
	}
	
	private void setOraFine(long oraFine) {
		this.oraFine=oraFine;
	}
	
	public long getOraFine() {
		return oraFine;
	}
	
	private void setOggetto(Oggetto oggetto) {
		this.oggetto = oggetto;
	}
	
	private Oggetto getOggetto() {
		return oggetto;
	}
	
	private void setVenditore(UtenteRegistrato venditore) {
		this.venditore = venditore;
	}
	
	private UtenteRegistrato getVenditore() {
		return venditore;
	}
}