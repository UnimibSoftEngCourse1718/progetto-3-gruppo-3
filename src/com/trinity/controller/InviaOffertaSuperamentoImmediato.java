package com.trinity.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trinity.model.AstaSuperamentoImmediato;
import com.trinity.model.OffertaSuperamentoImmediato;
import com.trinity.model.Oggetto;
import com.trinity.model.UtenteRegistrato;

/**
 * Servlet implementation class InviaOffertaSuperamentoImmediato
 */
@WebServlet(description = "Invia offerta Superamento Immediato", urlPatterns = { "/InviaOffertaSuperamentoImmediato" })
public class InviaOffertaSuperamentoImmediato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InviaOffertaSuperamentoImmediato() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Connessione al db
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb","root","p0m0d0r1n1");
			Statement myStatement = null;
	        myStatement = connection.createStatement();
	        
	        //dati offerta offerente
	        int valoreOfferta = Integer.parseInt(request.getParameter("valoreOfferta"));
			int idOfferente = Integer.parseInt(request.getParameter("idUtente"));
			
			//dati offerente
			UtenteRegistrato offerente = null;
			String queryOfferente ="SELECT * FROM utenteregistrato WHERE idUtente = " + idOfferente;
			ResultSet result = myStatement.executeQuery(queryOfferente);
			
			while (result.next()) {
				
			}
			
System.out.println("Ok1");
System.out.println(result.getInt(1));
System.out.println("Ok22");
			offerente = new UtenteRegistrato(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), result.getInt(8), result.getInt(9));	//int idUtente, String nomeUtente, String cognomeUtente, String email, String password, String indirizzo, String numeroCarta, int crediti
System.out.println("Ok3");
			
			//dati asta su cui fare l'offerta
			int idAsta = Integer.parseInt(request.getParameter("idAsta"));
			int idOggetto = 0;
			int idVenditore = 0;
			AstaSuperamentoImmediato asta = null;
			System.out.println("Ok222");
			String queryAsta ="SELECT * FROM astasuperamentoimmediato WHERE idAsta = \"" + idAsta + "\"";
	        result = myStatement.executeQuery(queryAsta);
	        asta = new AstaSuperamentoImmediato(result.getInt(0), result.getInt(1), result.getLong(2), result.getLong(3), result.getInt(4), null, null, result.getInt(7));	//int idAsta, int baseAsta, long oraInizio, long oraFine, int timeSlot, Oggetto oggetto, UtenteRegistrato venditore, int attiva
	        idOggetto=result.getInt(5);
	        idVenditore=result.getInt(6);
	        
	        //valore attuale dell'asta
			int valoreAttualeAsta = asta.getBaseAsta();
	        
	        //adesso
			long adesso = System.currentTimeMillis();
			
			//valore offerta precedente (se esiste. per ora assumo che esista)
			boolean offertaPrec=false;
			int valoreOffertaPrec = 0;
			String queryOffertaPrecedente ="SELECT max (valore) FROM offertasuperamentoimmediato WHERE asta = \"" + idAsta + "\"";	//controllare poi se non ritorna niente
	        result = myStatement.executeQuery(queryOffertaPrecedente);
	        if(!result.getString(0).equals(null)) {
	        	offertaPrec = true;
	        	valoreOffertaPrec = result.getInt(1);
	        }
			
			//controlli per verificare se l'utente aveva già offerto per questa asta (se si, prendo lo scorso valore della sua offerta)
	        boolean primaOfferta = true;
	        int valoreOffertaPrecIdOfferente = 0;
	        String queryQuantitaOfferte = "SELECT sum(valore) FROM offertasuperamentoimmediato WHERE asta = \"" + idAsta + "\" AND offerente = \"" + idOfferente + "\"";
	        String queryValorePrecOfferta = "SELECT max(valore) FROM offertasuperamentoimmediato WHERE asta = \"" + idAsta + "\" AND offerente = \"" + idOfferente + "\"";
			//controllo se ci sono altre offerte per questa asta da parte di questo offerente
	        if(myStatement.executeQuery(queryQuantitaOfferte).getInt(0) > 0) {
	        	primaOfferta=false;
	        	valoreOffertaPrecIdOfferente = myStatement.executeQuery(queryValorePrecOfferta).getInt(0);
	        }
	        
	        //setto valore attuale dell'asta. se esiste già un'offerta per questa asta allora quello è il valore dell'asta attuale. altrimenti rimane baseAsta
	        if(offertaPrec == true) {
	        	valoreAttualeAsta = valoreOffertaPrec;
	        }
	        System.out.println("Ok3");
	 //set parametri per verificare se l'offerta è validabile
	        boolean validabile=false;
	        
	        //asta attiva
	        boolean astaIsAttiva = false;
	        if(asta.isAttiva()==1)
	        	astaIsAttiva=true;
	        
	        //asta attiva
	        boolean oraFineOk = false;
	        if(asta.getOraFine()<adesso)
	        	oraFineOk = true;
	        
	        //offerente e venditore diversi
	        boolean idUtentiDiversi = false;
	        if(idOfferente != idVenditore)
	        	idUtentiDiversi = true;
	        
	        //offerta maggiore del valore attuale dell'asta
	        boolean offertaMaggioreValoreAsta = false;
	        if (valoreOfferta > valoreAttualeAsta)
	        	offertaMaggioreValoreAsta = true;
	        
	        //credito sufficiente
	        boolean creditoSufficiente = false;
	        //calcolo in caso sia la mia prima offerta
	        if(primaOfferta == true) {
	        	if((offerente.getCreditiCont() - valoreOfferta) >= 0)
	        		creditoSufficiente = true;
	        }
	        //calcolo in caso io abbia già fatto un'offerta
	        else {
	        	if((offerente.getCreditiCont() + valoreOffertaPrecIdOfferente - valoreOfferta) >= 0)
	        		creditoSufficiente = true;
	        }
	        
	        //set validabile
	        if(astaIsAttiva && oraFineOk && idUtentiDiversi && offertaMaggioreValoreAsta && creditoSufficiente)
	        	validabile=true;
	        
	  //set parametri per gestione offerta
	        //times slot disponibili
	        boolean timeSlotDisp = false;
	        if(asta.getTimeSlot() > 0)
	        	timeSlotDisp = true;
	        
	        //decrementatimeSlot (se il tempo è minore di 5 minuti
	        boolean decrementaTimeSlot = false;
	        if(asta.getOraFine()-adesso < 300000)
	        	decrementaTimeSlot = true;    
	        System.out.println("Ok4");
	   //creazione offerta	        
	        
	        if(validabile == true) {
	        	//aggiorno timeSlot e orario di fine asta [se ho timeslot e il tempo è minore di un tot]
	        	if(timeSlotDisp && decrementaTimeSlot) {
	        		int tsl = asta.getTimeSlot();
	        		tsl --;
	        		long time = asta.getOraFine();
	        		time += 300000;
	        		asta.setTimeSlot(tsl);
	        		asta.setOraFine(time);
	        	}
	        	
	        	//calcolo creditiCont offerente se è la prima offerta per questa asta
	        	int _creditiCont = offerente.getCreditiCont() - valoreOfferta;
	        	
	        	//calcolo creditiCont offerente se NON è la prima offerta per questa asta
	        	if (!primaOfferta) {
	        		_creditiCont += valoreOffertaPrecIdOfferente;
	        	}
	        	offerente.setCreditiCont(_creditiCont);
	        	
	        	//istanza offerta
				OffertaSuperamentoImmediato offerta = new OffertaSuperamentoImmediato (valoreOfferta, asta, offerente);
	        					
				//inserisco offerta nel database
				//myStatement.executeUpdate("INSERT INTO offertasuperamentoimmediato " + offerta);
				
		        //aggiorno offerente nel database
		        
		        //aggiorno asta nel database
				
				
				//reindirizzo alla conferma
				RequestDispatcher view = request.getRequestDispatcher("inviaOffertaSuperamentoImmediato_conferma.jsp");
				view.forward(request, response);
				System.out.println("Ok");
	        }
	        else {
	        	System.out.println("else");
	        }
		}catch(Exception e)
		{
			System.out.println("Error");
			System.out.println(e.getMessage());
		}
	}
}