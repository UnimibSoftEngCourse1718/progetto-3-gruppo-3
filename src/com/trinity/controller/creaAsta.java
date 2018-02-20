package com.trinity.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;

import com.trinity.model.AstaSuperamentoImmediato;
import com.trinity.model.Categoria;
import com.trinity.model.Oggetto;
import com.trinity.model.UtenteRegistrato;

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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		//new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Categoria.class);
		
		Session session = factory.openSession();
		session.beginTransaction();
			
		int idC = (int) session.createQuery("select idCategoria from com.trinity.model.Categoria where nomeCategoria = :nome").setParameter("nome", request.getParameter("categoria")).uniqueResult();
		Categoria c = new Categoria (idC, request.getParameter("nomeCategoria"));
		
		session.cancelQuery();
		
		UtenteRegistrato u = (UtenteRegistrato) session.createQuery("select ut.idUtente as idUtente, ut.nomeUtente as nomeUtente, ut.cognomeUtente as cognomeUtente, ut.password as password, ut.email as email, ut.indirizzo as indirizzo, ut.numeroCarta as numeroCarta from com.trinity.model.UtenteRegistrato ut where ut.email = :email").setParameter( "email", request.getParameter("email")).setResultTransformer(Transformers.aliasToBean(UtenteRegistrato.class)).uniqueResult();
		
		Oggetto o = new Oggetto(request.getParameter("nomeOggetto"), request.getParameter("descrizione"), c);
		AstaSuperamentoImmediato a = new AstaSuperamentoImmediato(Integer.parseInt(request.getParameter("baseAsta")), o, u); 
		
		Date start= new Date(a.getOraFine());
		request.setAttribute("oraFine", start);
		
		session.save(o);
		session.save(a);
		session.getTransaction().commit();
		session.close();
		
		RequestDispatcher view = request.getRequestDispatcher("creaAsta_conferma.jsp");
		view.forward(request, response);
	}
}