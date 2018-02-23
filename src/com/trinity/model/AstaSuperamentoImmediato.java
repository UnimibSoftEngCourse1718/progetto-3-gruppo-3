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
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn (name = "oggetto")
	private Oggetto oggetto;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name = "venditore")
	private UtenteRegistrato venditore;
	
	@Column(name = "attiva", nullable=false)
	private int attiva;
	
	//costruttore utilizzato in ASIBean
	public AstaSuperamentoImmediato(int idAsta2, int baseAsta2, long oraInizio2, long oraFine2, int timeSlot2, int oggetto2, int venditore2, int attiva2){
		setIdAsta(idAsta2);
		setBaseAsta(baseAsta2);
		setOraInizio(oraInizio2);
		setOraFine(oraFine2);
		setTimeSlot(timeSlot2);
		
		setAttiva(attiva2);
	}
	
	public AstaSuperamentoImmediato(){
		
	}
	
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
		setIdAsta(idAsta);
		setBaseAsta(baseAsta);
		setOraInizio(oraInizio);
		setOraFine(oraFine);
		setTimeSlot(3);
		setOggetto(oggetto);
		setVenditore(venditore);
		setAttiva(1);
	}
	
	public AstaSuperamentoImmediato(int idAsta, int baseAsta, Oggetto oggetto, UtenteRegistrato venditore){
		//super(baseAsta);
		setIdAsta(idAsta);
		setBaseAsta(baseAsta);
		setOraInizio(System.currentTimeMillis());
		setOraFine(System.currentTimeMillis() + 600000);
		setTimeSlot(3);
		setOggetto(oggetto);
		setVenditore(venditore);
		setAttiva(1);
	}
	
	public AstaSuperamentoImmediato(int idAsta, int baseAsta, long oraInizio, long oraFine, int timeSlot, Oggetto oggetto, UtenteRegistrato venditore, int attiva){
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