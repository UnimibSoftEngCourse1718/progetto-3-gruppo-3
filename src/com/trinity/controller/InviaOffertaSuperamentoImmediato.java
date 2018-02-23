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

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;

import com.trinity.model.AstaSuperamentoImmediato;
import com.trinity.model.OffertaSuperamentoImmediato;
import com.trinity.model.UtenteRegistrato;
import com.trinity.model.Categoria;


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
System.out.println("ok creo connessione");
	        
	        //connessione db
	        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();			
			Session session = factory.openSession();
			session.beginTransaction();
System.out.println("Ok connessione al db");
			
			//dati offerta offerente
	        int valoreOfferta = Integer.parseInt(request.getParameter("valoreOfferta"));
			int idOfferente = Integer.parseInt(request.getParameter("idUtente"));
System.out.println("Ok dati offerta offerente");
System.out.println("id offerente:"+idOfferente);
			
			//dati offerente
			UtenteRegistrato offerente = null;
			offerente = (UtenteRegistrato) session.createQuery("select ut.idUtente as idUtente, ut.nomeUtente as nomeUtente, ut.cognomeUtente as cognomeUtente, ut.email as email, ut.password as password, ut.indirizzo as indirizzo, ut.numeroCarta as numeroCarta, ut.creditiDisp as creditiDisp, ut.creditiCont as creditiCont from com.trinity.model.UtenteRegistrato ut where ut.idUtente = :idUtente").setParameter( "idUtente", idOfferente).setResultTransformer(Transformers.aliasToBean(UtenteRegistrato.class)).uniqueResult();
System.out.println("Ok dati offerente");
			
			//dati asta su cui fare l'offerta
			int idAsta = Integer.parseInt(request.getParameter("idAsta"));
			int idOggetto = 0;
			int idVenditore = 0;
			AstaSuperamentoImmediato asta = null;
			
			int baseAsta = (int) session.createQuery("select baseAsta from com.trinity.model.AstaSuperamentoImmediato where idAsta= :idAsta").setParameter("idAsta",idAsta).uniqueResult();
			long oraInizio = (long) session.createQuery("select oraInizio from com.trinity.model.AstaSuperamentoImmediato where idAsta= :idAsta").setParameter("idAsta",idAsta).uniqueResult();
			long oraFine = (long) session.createQuery("select oraFine from com.trinity.model.AstaSuperamentoImmediato where idAsta= :idAsta").setParameter("idAsta",idAsta).uniqueResult();
			int timeSlot = (int) session.createQuery("select timeSlot from com.trinity.model.AstaSuperamentoImmediato where idAsta= :idAsta").setParameter("idAsta",idAsta).uniqueResult();
			UtenteRegistrato uV = (UtenteRegistrato) session.createQuery("select venditore from com.trinity.model.AstaSuperamentoImmediato where idAsta= :idAsta").setParameter("idAsta",idAsta).uniqueResult();
			idVenditore = uV.getIdUtente();
			int attiva = (int) session.createQuery("select attiva from com.trinity.model.AstaSuperamentoImmediato where idAsta= :idAsta").setParameter("idAsta",idAsta).uniqueResult(); 
			
			System.out.println("questa asta : " + idVenditore);
			System.out.println("questa asta : " + attiva);
System.out.println("Ok dati asta");
	        
	        //valore attuale dell'asta
			int valoreAttualeAsta = asta.getBaseAsta();
	        
	        //adesso
			long adesso = System.currentTimeMillis();
			
			//valore offerta precedente (se esiste. per ora assumo che esista)
			boolean offertaPrec=false;
			int valoreOffertaPrec = 0;
			String x = (String) session.createQuery("select valore from com.trinity.model.OffertaSuperamentoImmediato where asta = :idAsta").setParameter("idAsta", idAsta).uniqueResult();
			//il valore tornato dalla query è valido?
//verificare
			if(x != null) {
	        	offertaPrec = true;
	        	valoreOffertaPrec = Integer.parseInt(x);
	        }
			
			//controlli per verificare se l'utente aveva già offerto per questa asta (se si, prendo lo scorso valore della sua offerta)
	        boolean primaOfferta = true;
	        int valoreOffertaPrecIdOfferente = 0;
	        
	        int intquanti=0;
	        String stringquanti = (String) session.createQuery("select count(valore) from com.trinity.model.OffertaSuperamentoImmediato where asta = :idAsta and offerente = :idOfferente").setParameter("idAsta", idAsta).setParameter("idOfferente", idOfferente).uniqueResult();
	        String ValorePrecOfferta = (String) session.createQuery("select max(valore) from com.trinity.model.OffertaSuperamentoImmediato where asta = :idAsta and offerente = :idOfferente").setParameter("idAsta", idAsta).setParameter("idOfferente", idOfferente).uniqueResult();
	        //controllo se la quantita è accettabile
	        if(stringquanti != null) {	//se la quantità in stringa è valido la converto in intera e controllo sia maggiore di 0
	        	intquanti=Integer.parseInt(stringquanti);
	        	if(intquanti > 0) {
	        		valoreOffertaPrecIdOfferente = Integer.parseInt(ValorePrecOfferta);
	        		primaOfferta=false;
		        }
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
				session.save(offerta);
				session.getTransaction().commit();
				session.close();
				
				//aggiorno offerente nel database
				Query u = session.createQuery("update com.trinity.model.UtenteRegistrato set creditiDisp= :creditiDisp and creditiDisp= :creditiCont where idUtente = :idOfferente");
				u.setParameter("creditiDisp", offerente.getCreditiDisp());
				u.setParameter("creditiDisp", offerente.getCreditiCont());
				u.setParameter("idOfferente", idOfferente);
				u.executeUpdate();
		        
				//aggiorno asta nel database
				
				
				//reindirizzo alla conferma
				RequestDispatcher view = request.getRequestDispatcher("inviaOfferta_conferma.jsp");
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