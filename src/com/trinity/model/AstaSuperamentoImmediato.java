package com.trinity.model;

public class AstaSuperamentoImmediato extends Asta{
	private int numTimeSlot;
	private int timeSlotAggiuntivo;
	private UtenteRegistrato offerente;
	public int venditore;
	private OffertaSuperamentoImmediato offerta;
	
	
	public AstaSuperamentoImmediato(int nuovaBaseAsta, int nuovaDurata, String nuovoStato, Oggetto nuovoOggettoInAsta, int newNumTimeSlot, int newTimeSlotAgg){
		super(nuovaBaseAsta, nuovaDurata, nuovoStato, nuovoOggettoInAsta);
		this.numTimeSlot=newNumTimeSlot;
		this.timeSlotAggiuntivo = newTimeSlotAgg;
	}

	public int getNumTimeSlot() {
		return numTimeSlot;
	}

	public void setNumTimeSlot(int numTimeSlot) {
		this.numTimeSlot = numTimeSlot;
	}

	public int getTimeSlotAggiuntivo() {
		return timeSlotAggiuntivo;
	}

	public void setTimeSlotAggiuntivo(int timeSlotAggiuntivo) {
		this.timeSlotAggiuntivo = timeSlotAggiuntivo;
	}
	
	
	
}
