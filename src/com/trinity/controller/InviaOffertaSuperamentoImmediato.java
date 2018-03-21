package com.trinity.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.trinity.model.Oggetto;
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
		Connection connection = null;
		Statement myStatement = null;
		try {
			//Connessione al db
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb","root","p0m0d0r1n1");
			
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
	        
			//oggetto e categoria
			int idOggetto = 0;
			Oggetto ogg = null;
			Categoria cat = null;
			
			idOggetto = (int) session.createQuery("select oggetto.idOggetto from com.trinity.model.AstaSuperamentoImmediato where idAsta= :idAsta").setParameter("idAsta",idAsta).uniqueResult();
System.out.println("Ok idOggetto");
			
			cat = (Categoria) session.createQuery("select categoria from com.trinity.model.Oggetto where idOggetto= :idOggetto").setParameter("idOggetto",idOggetto).uniqueResult();
System.out.println("Ok categoria");
			
			String nomeOgg = (String) session.createQuery("select nomeOggetto from com.trinity.model.Oggetto where idOggetto= :idOggetto").setParameter("idOggetto",idOggetto).uniqueResult();
			String descOgg = (String) session.createQuery("select descrizione from com.trinity.model.Oggetto where idOggetto= :idOggetto").setParameter("idOggetto",idOggetto).uniqueResult();
			
			ogg = new Oggetto(idOggetto, nomeOgg, descOgg, cat);
System.out.println("Ok istanziata categoria e oggetto");
			
	        //valore attuale dell'asta
			int valoreAttualeAsta = baseAsta;
System.out.println("Ok valore attuale asta=baseAsta");

	        //adesso
			long adesso = System.currentTimeMillis();
System.out.println("Ok adesso");
			
			//valore offerta precedente (se esiste. per ora assumo che esista)
			boolean offertaPrec=false;
			int valoreOffertaPrec = 0;
System.out.println("ok setto boolean e intero per valore offerta precedente");			
			long contOffPrec = (long) session.createQuery("select count(o.valore) from com.trinity.model.OffertaSuperamentoImmediato o where o.asta.idAsta = :idAsta").setParameter("idAsta", idAsta).uniqueResult();
System.out.println("ok conto quante offerte ci sono gia state per quest aasta="+contOffPrec);

			if(contOffPrec > 0) {
				offertaPrec = true;
				valoreOffertaPrec = (int) session.createQuery("select max(o.valore) from com.trinity.model.OffertaSuperamentoImmediato o where o.asta.idAsta = :idAsta").setParameter("idAsta", idAsta).uniqueResult();
			}
System.out.println("ok valore offerta precdente = "+ valoreOffertaPrec);
			
			//controlli per verificare se l'utente aveva già offerto per questa asta (se si, prendo lo scorso valore della sua offerta)
	        boolean primaOfferta = true;
	        int valoreOffertaPrecIdOfferente = 0;
	    
	        long quanti = (long) session.createQuery("select count(o.valore) from com.trinity.model.OffertaSuperamentoImmediato o where o.asta.idAsta = :idAsta and o.offerente.idUtente = :idOfferente").setParameter("idAsta", idAsta).setParameter("idOfferente", idOfferente).uniqueResult();
	        if(quanti > 0) {
	        	valoreOffertaPrecIdOfferente = (int) session.createQuery("select max(o.valore) from com.trinity.model.OffertaSuperamentoImmediato o where o.asta.idAsta = :idAsta and o.offerente.idUtente = :idOfferente").setParameter("idAsta", idAsta).setParameter("idOfferente", idOfferente).uniqueResult();
        		primaOfferta=false;
	        }
System.out.println("ok valore offerta precdente stesso utente = "+ valoreOffertaPrec);
	        
	        //setto valore attuale dell'asta. se esiste già un'offerta per questa asta allora quello è il valore dell'asta attuale. altrimenti rimane baseAsta
	        if(offertaPrec == true) {
	        	valoreAttualeAsta = (int) valoreOffertaPrec;
	        }
System.out.println("fine controlli");

System.out.println("inizio set parametri");
	 //set parametri per verificare se l'offerta è validabile
	        boolean validabile=false;
	        
	        //asta attiva
	        boolean astaIsAttiva = false;
	        if(attiva==1)
	        	astaIsAttiva=true;
	        
	        //asta attiva
	        boolean oraFineOk = false;
	        if(oraFine>adesso)
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
	        	if((offerente.getCreditiDisp() - valoreOfferta) >= 0)
	        		creditoSufficiente = true;
	        }
	        //calcolo in caso io abbia già fatto un'offerta
	        else {
	        	if((offerente.getCreditiDisp() + valoreOffertaPrecIdOfferente - valoreOfferta) >= 0)
	        		creditoSufficiente = true;
	        }
	        
	        //set validabile
	        if(astaIsAttiva && oraFineOk && idUtentiDiversi && offertaMaggioreValoreAsta && creditoSufficiente)
	        	validabile=true;
	        
	  //set parametri per gestione offerta
	        //times slot disponibili
	        boolean timeSlotDisp = false;
	        if(timeSlot > 0)
	        	timeSlotDisp = true;
	        
	        //decrementatimeSlot (se il tempo è minore di 5 minuti)
	        boolean decrementaTimeSlot = false;
	        if(oraFine-adesso < 300000)
	        	decrementaTimeSlot = true;
System.out.println("Ok4");

	   //creazione offerta	        
	        if(validabile == true) {
	        	//aggiorno timeSlot e orario di fine asta [se ho timeslot e il tempo è minore di un tot]
	        	if(timeSlotDisp && decrementaTimeSlot) {
	        		int tsl = timeSlot;
	        		tsl --;
	        		long time = oraFine;
	        		time += 300000;
	        		timeSlot = tsl;
	        		oraFine = time;
	        	}
	        	
	        	//calcolo creditiCont offerente se è la prima offerta per questa asta
	        	int _creditiDisp = offerente.getCreditiDisp() - valoreOfferta;
	        	
	        	//calcolo creditiCont offerente se NON è la prima offerta per questa asta
	        	if (!primaOfferta) {
	        		_creditiDisp += valoreOffertaPrecIdOfferente;
	        	}
	        	offerente.setCreditiCont(_creditiDisp);
	        	
	        	//setto valori asta
	        	asta = new AstaSuperamentoImmediato(idAsta, baseAsta, oraInizio, oraFine, timeSlot, ogg, uV, attiva);
	        	
	        	//istanza offerta
				OffertaSuperamentoImmediato offerta = new OffertaSuperamentoImmediato (valoreOfferta, asta, offerente);
	        					
				//inserisco offerta nel database
System.out.println("prima sessionsave");
				session.saveOrUpdate(offerta);
				
				//aggiorno offerente nel database
System.out.println("Okprima inser update offerente");
System.out.println("get crediti cont" + offerente.getCreditiCont());
				Query u = session.createQuery("update com.trinity.model.UtenteRegistrato u set u.creditiDisp= :creditiDisp where u.idUtente = :idOfferente");
System.out.println("u:"+u);
				u.setParameter("creditiDisp", offerente.getCreditiDisp());
System.out.println("1");
				u.setParameter("idOfferente", idOfferente);
System.out.println("2");
				u.executeUpdate();
System.out.println("3");
				//session.update(u);
System.out.println("Ok fine update offerente");
				


				//aggiorno asta nel database
				Query as = session.createQuery("update com.trinity.model.AstaSuperamentoImmediato a set a.oraFine= :oraFine , a.timeSlot= :timeSlot where a.idAsta = :idAsta");
System.out.print("get ora fine asta" + asta.getOraFine());
				as.setParameter("oraFine", asta.getOraFine());
				as.setParameter("timeSlot", asta.getTimeSlot());
				as.setParameter("idAsta", idAsta);
				as.executeUpdate();
				//session.update(as);
System.out.println("Ok fine update asta");
				
				//chiusura connessione
				session.getTransaction().commit();
				session.close();
				
				//reindirizzo alla conferma
				RequestDispatcher view = request.getRequestDispatcher("inviaOfferta_conferma.jsp");
				view.forward(request, response);
System.out.println("Ok");
	        }
	        else {
	        	RequestDispatcher view = request.getRequestDispatcher("inviaOfferta_fail.jsp");
				view.forward(request, response);
	        }
		}catch(Exception e)
		{
			System.out.println("Error");
			System.out.println(e.getMessage());
		}
		
		finally {
			try {
				if (myStatement != null)
					myStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQL exception");
				e.printStackTrace();
			}
			
		}
	}
}