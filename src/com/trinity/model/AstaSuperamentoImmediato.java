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

public class AstaSuperamentoImmediato {
	
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
	
	@Column(name = "attiva", nullable=false)
	private int attiva;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn (name = "oggetto")
	private Oggetto oggetto;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name = "venditore")
	private UtenteRegistrato venditore;
	
	public AstaSuperamentoImmediato(){}
	
	public AstaSuperamentoImmediato(int baseAsta, Oggetto oggetto, UtenteRegistrato venditore){
		//super(baseAsta);
		setBaseAsta(baseAsta);
		setOraInizio(System.currentTimeMillis());
		setOraFine(System.currentTimeMillis() + 600000);
		setTimeSlot(3);
		setOggetto(oggetto);
		setVenditore(venditore);
		setAttiva(1);
	}
	
	public AstaSuperamentoImmediato(int idAsta, int baseAsta, long oraInizio, long oraFine, Oggetto oggetto, UtenteRegistrato venditore){
		//super(baseAsta);
		setIdAsta(idAsta);
		setBaseAsta(baseAsta);
		setOraInizio(oraInizio);
		setOraFine(oraFine);
		setTimeSlot(3);
		setOggetto(oggetto);
		setVenditore(venditore);
		setAttiva(1);
	}
	
	public AstaSuperamentoImmediato(int idAsta, int baseAsta, long oraInizio, long oraFine, int timeSlot, Oggetto oggetto, UtenteRegistrato venditore, int attiva){
		//super(baseAsta);
		setIdAsta(idAsta);
		setBaseAsta(baseAsta);
		setOraInizio(oraInizio);
		setOraFine(oraFine);
		setTimeSlot(timeSlot);
		setOggetto(oggetto);
		setVenditore(venditore);
		setAttiva(attiva);
	}
	
	public int getIdAsta() {
		return idAsta;
	}
	
	public void setIdAsta(int idAsta) {
		this.idAsta = idAsta;
	}
	
	public int getBaseAsta() {
		return baseAsta;
	}
	
	public void setBaseAsta(int baseAsta) {
		this.baseAsta = baseAsta;
	}
	
	public long getOraInizio() {
		return oraInizio;
	}
	
	public void setOraInizio(long oraInizio) {
		this.oraInizio = oraInizio;
	}
	
	public void setOraFine(long oraFine) {
		this.oraFine=oraFine;
	}
	
	public int getTimeSlot() {
		return timeSlot;
	}
	
	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}
	
	public long getOraFine() {
		return oraFine;
	}
	
	public Oggetto getOggetto() {
		return oggetto;
	}
	
	public void setOggetto(Oggetto oggetto) {
		this.oggetto = oggetto;
	}
	
	public UtenteRegistrato getVenditore() {
		return venditore;
	}
	
	public void setVenditore(UtenteRegistrato venditore) {
		this.venditore = venditore;
	}

	public int isAttiva() {
		return attiva;
	}

	public void setAttiva(int attiva) {
		this.attiva = attiva;
	}
}