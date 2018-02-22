package com.trinity.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.Date;
import java.lang.Object;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.*;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.*;
import org.hibernate.transform.Transformers;

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
 * Servlet implementation class AcquistaCrediti
 */
@WebServlet("/AcquistaCrediti")
public class AcquistaCrediti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcquistaCrediti() {
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
		
		int creditiAcquistati=Integer.parseInt(request.getParameter("outputCrediti"));
		int creditiDispPrec = (int) session.createQuery("select creditiDisp from com.trinity.model.UtenteRegistrato where email = :email").setParameter("email", request.getParameter("email")).uniqueResult();
		int creditiContPrec = (int) session.createQuery("select creditiCont from com.trinity.model.UtenteRegistrato where email = :email").setParameter("email", request.getParameter("email")).uniqueResult();
		
		int creditiDispAgg = creditiDispPrec + creditiAcquistati;
		int creditiContAgg = creditiContPrec + creditiAcquistati;
		
		Query d = session.createQuery("update com.trinity.model.UtenteRegistrato set creditiDisp= :creditiDisp where email = :email");
		d.setParameter("creditiDisp", creditiDispAgg);
		d.setParameter("email", request.getParameter("email"));
		d.executeUpdate();
		
		Query c = session.createQuery("update com.trinity.model.UtenteRegistrato set creditiCont= :creditiCont where email = :email");
		c.setParameter("creditiCont", creditiContAgg);
		c.setParameter("email", request.getParameter("email"));
		c.executeUpdate();
		
		
		session.getTransaction().commit();
		session.close();
		
		
		RequestDispatcher view = request.getRequestDispatcher("AcquistaCrediti_conferma.jsp");
		view.forward(request, response);
	}
}