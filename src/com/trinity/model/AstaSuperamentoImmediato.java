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
@Table(name = "astasuperamentoimmediato")
@SuppressWarnings("unused")
public class AstaSuperamentoImmediato  {
	
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
	
	@Column(name = "timeSlot", nullable = false)
	private int timeSlot;
	
	@OneToOne (fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn (name = "oggetto")
	private Oggetto oggetto;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name = "venditore")
	private UtenteRegistrato venditore;
	
	public AstaSuperamentoImmediato(){}
	
	public AstaSuperamentoImmediato(int baseAsta, int timeSlot, Oggetto oggetto, UtenteRegistrato venditore){
		//super(baseAsta);
		setBaseAsta(baseAsta);
		setOraInizio(System.currentTimeMillis());
		setOraFine(System.currentTimeMillis() + 1800000);
		setTimeSlot(timeSlot);
		setOggetto(oggetto);
		setVenditore(venditore);
	}
	
	public AstaSuperamentoImmediato(int idAsta, int baseAsta, long oraInizio, long oraFine, int timeSlot, Oggetto oggetto, UtenteRegistrato venditore){
		//super(baseAsta);
		setIdAsta(idAsta);
		setBaseAsta(baseAsta);
		setOraInizio(oraInizio);
		setOraFine(oraFine);
		setTimeSlot(timeSlot);
		setOggetto(oggetto);
		setVenditore(venditore);
	}
	
	private int getIdAsta() {
		return idAsta;
	}
	
	private void setIdAsta(int idAsta) {
		this.idAsta = idAsta;
	}
	
	private int getBaseAsta() {
		return baseAsta;
	}
	
	private void setBaseAsta(int baseAsta) {
		this.baseAsta = baseAsta;
	}
	
	private long getOraInizio() {
		return oraInizio;
	}
	
	private void setOraInizio(long oraInizio) {
		this.oraInizio = oraInizio;
	}
	
	private void setOraFine(long oraFine) {
		this.oraFine=oraFine;
	}
	
	private int getTimeSlot() {
		return timeSlot;
	}
	
	private void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}
	
	public long getOraFine() {
		return oraFine;
	}
	
	private Oggetto getOggetto() {
		return oggetto;
	}
	
	private void setOggetto(Oggetto oggetto) {
		this.oggetto = oggetto;
	}
	
	private UtenteRegistrato getVenditore() {
		return venditore;
	}
	
	private void setVenditore(UtenteRegistrato venditore) {
		this.venditore = venditore;
	}
}