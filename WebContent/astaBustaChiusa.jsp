<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.trinity.model.AstaBustaChiusa"%>
<%@page import="com.trinity.model.OffertaBustaChiusa"%>
<%@include file="checkLogin.jsp"%>
<%@ page import="java.util.Date"%>
<jsp:useBean id="contrAste" class="beans.statoAste">
	<%
		contrAste.aggiornaStato();
	%>
</jsp:useBean>

<jsp:useBean id="aste" class="beans.AsteBustaChiusaBean"
	scope="session" />
<jsp:setProperty name="aste" property="*" />

<jsp:useBean id="offerte"
	class="beans.OfferteAstaBustaChiusaBean" scope="session" />
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
				<li class="nav-item"><a class="nav-link" href="GuidaTrinity.html">Aiuto</a></li>
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
<title>Asta a busta chiusa</title>
</head>

<body>
	<div class="container">
		<h3>Asta</h3>
		<h5>tipo: Busta Chiusa</h5>

		<%
			int id = Integer.parseInt(request.getParameter("idAsta"));
			
			AstaBustaChiusa asta = aste.Asta(id);
			ArrayList<Integer> offertaMax = offerte.Max(id);

			out.println("id asta: " + asta.getIdAsta() + "<br>");
			Date start = new Date(asta.getOraInizio());
			Date end = new Date(asta.getOraFine());
			out.println("ora inizio: " + start + "<br>");
			out.println("ora fine: " + end+ "<br>");
			out.println("asta attiva: " + asta.getAttiva() + "<br>");
			out.println("-------------------------------" + "<br>");
			out.println("Oggetto" + "<br>");
			out.println("nome: " + asta.getOggetto().getNomeOggetto() + "<br>");
			out.println("descrizione: " + asta.getOggetto().getDescrizione() + "<br>");
			//visualizzo categoria?
			out.println("-------------------------------" + "<br>");
			out.println("base asta: " + asta.getBaseAsta() + "<br>");
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

		<form method="POST" action="InviaOffertaBustaChiusa">

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