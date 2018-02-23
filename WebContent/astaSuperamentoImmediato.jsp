<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.trinity.model.AstaSuperamentoImmediato"%>
<%@page import="com.trinity.model.OffertaSuperamentoImmediato"%>
<%@include file="checkLogin.jsp"%>
<jsp:useBean id="contrAste" class="beans.statoAste">
	<%
		contrAste.aggiornaStato();
	%>
</jsp:useBean>

<jsp:useBean id="aste" class="beans.AsteSuperamentoImmediatoBean"
	scope="session" />
<jsp:setProperty name="aste" property="*" />

<jsp:useBean id="offerte"
	class="beans.OfferteAstaSuperamentoImmediatoBean" scope="session" />
<jsp:setProperty name="offerte" property="*" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<nav class="navbar navbar-expand-md bg-success navbar-dark sitcky-top">
<a class="navbar-brand" href="#"> <img src="media/logoTrinity.png"
	alt="logo" style="width: 40px;">
</a>
<button class="navbar-toggler" type="button" data-toggle="collapse"
	data-target="#collapsibleNavbar">
	<span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="collapsibleNavbar">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="home.jsp">Home</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="profilo.jsp">Il
				mio account</a></li>
		<li class="nav-item"><a class="nav-link" href="creaAsta.jsp">Nuova
				asta</a></li>
		<li class="nav-item"><a class="nav-link" href="leMieAste.jsp">Le
				mie aste</a></li>
		<li class="nav-item"><a class="nav-link" href="logout.jsp">
				Logout</a></li>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<form class="form-inline" action="/action_page.php">
			<input class="form-control mr-sm-2" type="text" placeholder="Search">
			<button class="btn btn-success" type="submit">Search</button>
		</form>
		</nav>
	</ul>
</div>
</nav>
<title>Asta superamento immediato</title>
</head>

<body>
	<div class="container">
		<h3>Asta</h3>
		<h5>tipo: Superamento immediato</h5>

		<%	
			int id = 45; 
			//Integer.parseInt(request.getParameter("tipoAsta"));
			
			AstaSuperamentoImmediato asta = aste.Asta(id);
			ArrayList<Integer> offertaMax = offerte.Max(id);

			out.println("id asta: " + asta.getIdAsta() + "<br>");
			out.println("ora inizio: " + asta.getOraInizio() + "<br>");
			out.println("ora fine: " + asta.getOraFine() + "<br>");
			out.println("asta attiva: " + asta.isAttiva() + "<br>");
			out.println("-------------------------------" + "<br>");
			out.println("Oggetto" + "<br>");
			out.println("nome: " + asta.getOggetto().getNomeOggetto() + "<br>");
			out.println("descrizione: " + asta.getOggetto().getDescrizione() + "<br>");
			//visualizzo anche categoria?
			out.println("-------------------------------" + "<br>");
			out.println("base asta: " + asta.getBaseAsta() + "<br>");
			out.println("time slot disponibili: " + asta.getTimeSlot() + "<br>");
			out.println("-------------------------------" + "<br>");

			if (offertaMax != null) {
				out.println("offerta attualmente piu' alta" + "<br>");
				out.println("id offerta: " + offertaMax.get(0) + "<br>");
				out.println("id offerente: " + offertaMax.get(2) + "<br>");
				out.println("valore: " + offertaMax.get(1) + "<br><br>");
			} else {
				out.println("ancora nessuna offerta" + "<br><br>");
			}
		%>

		<form method="POST" action="InviaOffertaSuperamentoImmediato">

			Invia offerta: <input type="text" size="40" maxlength="5"
				name="valoreOfferta" />
			<!-- maxlenght: settare questa lunghezza in base alla massima offerta che è possibile fare su Trinity. Questo è da decidere e inserire nel regolamento del sistema Trinity -->

			<%
				out.print("<input type=\"hidden\" name=\"idUtente\"  value=" + utente.getId() + " />");
				out.print("<input type=\"hidden\" name=\"idAsta\"  value=" + asta.getIdAsta() + " />");
			%>
			<br> <br> <input type="SUBMIT" value="Invia Offerta">
		</form>
	</div>
	<br>
</body>
</html>