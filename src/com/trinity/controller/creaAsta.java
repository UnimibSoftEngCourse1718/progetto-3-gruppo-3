package com.trinity.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

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

import com.trinity.model.AstaSuperamentoImmediato;
import com.trinity.model.Categoria;
import com.trinity.model.Oggetto;
import com.trinity.model.UtenteRegistrato;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class creaAsta
 */
@WebServlet(description = "Creazione Asta", urlPatterns = { "/creaAsta" })
public class creaAsta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creaAsta() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		//new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Categoria.class);
		
		Session session = factory.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("select idCategoria,nomeCategoria from com.trinity.model.Categoria where nomeCategoria = :nome ");
		query.setParameter("nome", request.getParameter("categoria"));
		List list = query.list();
		Categoria c = (Categoria) list.get(0);
		
		UtenteRegistrato v = new UtenteRegistrato("nome","cognome", "password", "email", "indirizzo", "cartadicredito"); //questo è per fare i test, poi bisogneà inserire come venditore il tizio loggato che crea l'asta 
		Oggetto o = new Oggetto(request.getParameter("nomeOggetto"), request.getParameter("descrizione"), c);
		AstaSuperamentoImmediato a = new AstaSuperamentoImmediato(Integer.parseInt(request.getParameter("baseAsta")), Integer.parseInt(request.getParameter("timeSlot")), o, v); 
		
		session.save(v);
		session.save(c);
		session.save(o);
		session.save(a);
		session.getTransaction().commit();
		session.close();
		
		
		RequestDispatcher view = request.getRequestDispatcher("creaAsta_conferma.jsp");
		view.forward(request, response);
	}

}
