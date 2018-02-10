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
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.trinity.model.UtenteRegistrato;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
		private static final long serialVersionUID = 1L;

		//...
		
		
		
		/*rimandare a login_conferma.jsp oppure rimandare direttamente alla home page, previa inizializzazione della sessione*/
		//RequestDispatcher view = request.getRequestDispatcher("Login_conferma.jsp");
		//view.forward(request, response);
}