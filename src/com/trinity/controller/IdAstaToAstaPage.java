package com.trinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class creaAsta
 */
@WebServlet(description = "idAstaSiToAstaSiPage", urlPatterns = { "/idAstaSiToAstaSiPage" })
public class IdAstaToAstaPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdAstaToAstaPage() {
        super();
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recupero id asta
		int id = Integer.parseInt(request.getParameter("idAsta"));
		//recupero tipoasta
		int tipoAsta = Integer.parseInt(request.getParameter("tipoAsta"));
		
		request.setAttribute("idAsta", id);
		
		if(tipoAsta == 1) {	// 1 = Superamento Immediato
			RequestDispatcher view = request.getRequestDispatcher("astaSuperamentoImmediato.jsp");
			view.forward(request, response);
		}
		if(tipoAsta == 0) {	// 0 = Busta Chiusa
			RequestDispatcher view = request.getRequestDispatcher("astaBustaChiusa.jsp");
			view.forward(request, response);
		}
	}
}