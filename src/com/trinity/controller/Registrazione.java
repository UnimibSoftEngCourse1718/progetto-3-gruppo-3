package com.trinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.trinity.model.UtenteRegistrato;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("deprecation")
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		

		Session session = factory.openSession();
		session.beginTransaction();
		UtenteRegistrato u = new UtenteRegistrato(request.getParameter("nomeUtente"), request.getParameter("cognomeUtente"), request.getParameter("password"), request.getParameter("email"), request.getParameter("indirizzo"), request.getParameter("numeroCarta"));
		session.save(u);
		session.getTransaction().commit();
		session.close();
		
		RequestDispatcher view = request.getRequestDispatcher("registrazione_conferma.jsp");
		view.forward(request, response);
	}
}