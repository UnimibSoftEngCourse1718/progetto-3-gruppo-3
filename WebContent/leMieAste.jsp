<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="checkLogin.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.trinity.model.AstaSuperamentoImmediato"%>
<%@page import="com.trinity.model.OffertaSuperamentoImmediato"%>


<jsp:useBean id="aste" class="beans.AsteSuperamentoImmediatoBean"
	scope="session" />
<jsp:setProperty name="aste" property="*" />

<jsp:useBean id="offertesi"
	class="beans.OfferteAstaSuperamentoImmediatoBean" scope="session" />
<jsp:setProperty name="offertesi" property="*" />

<jsp:useBean id="offertebc"
	class="beans.OfferteAstaBustaChiusaBean" scope="session" />
<jsp:setProperty name="offertebc" property="*" />

<jsp:useBean id="astesi" class="beans.AsteSuperamentoImmediatoBean"
	scope="session" />

<jsp:useBean id="astebc" class="beans.AsteBustaChiusaBean"
	scope="session" />
	
<jsp:setProperty name="utenteregistrato" property="*" />

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
<title>Le mie aste</title>
</head>

<body>
	<div class="header">
		<h2>
			<strong> Le mie aste - attive</strong>
		</h2>
		<div class="container">
			<h4>
				<strong>Aste a superamento immediato</strong>
			</h4>
			<%
				for (int i = 0; i < astesi.Aste().size(); i++) {
					if (astesi.Aste().get(i).isAttiva() != 0
							&& astesi.Aste().get(i).getVenditore().getIdUtente() == utente.getId()) {

						out.println("Oggetto in asta:  " + astesi.Aste().get(i).getOggetto().getNomeOggetto() + "<br><br>");
						out.println(
								"Descrizione oggetto:  " + astesi.Aste().get(i).getOggetto().getDescrizione() + "<br><br>");
						out.println("Base d'asta:  " + astesi.Aste().get(i).getBaseAsta() + "<br><br>");
						out.println("Ora d'inizio:  " + astesi.Aste().get(i).getOraInizio() + "<br><br>");
						out.println("Ora di fine:  " + astesi.Aste().get(i).getOraFine() + "<br><br>");
						out.println("Time Slot rimanenti:  " + astesi.Aste().get(i).getTimeSlot() + "<br><br>");
						out.println("Venditore:  " + astesi.Aste().get(i).getVenditore().getNomeUtente());
						out.println(astesi.Aste().get(i).getVenditore().getCognomeUtente() + "<br><br>");

						out.print("<br> <br>");
					}
				}
			%>
			<h4>
				<strong>Aste a busta chiusa</strong>
			</h4>
			<%
				for (int i = 0; i < astebc.Aste().size(); i++) {
					if (astebc.Aste().get(i).getAttiva() != 0
							&& astebc.Aste().get(i).getVenditore().getIdUtente() == utente.getId()) {

						out.println("Oggetto in asta:  " + astebc.Aste().get(i).getOggetto().getNomeOggetto() + "<br><br>");
						out.println(
								"Descrizione oggetto:  " + astebc.Aste().get(i).getOggetto().getDescrizione() + "<br><br>");
						out.println("Base d'asta:  " + astebc.Aste().get(i).getBaseAsta() + "<br><br>");
						out.println("Ora d'inizio:  " + astebc.Aste().get(i).getOraInizio() + "<br><br>");
						out.println("Ora di fine:  " + astebc.Aste().get(i).getOraFine() + "<br><br>");
						out.println("Venditore:  " + astebc.Aste().get(i).getVenditore().getNomeUtente());
						out.println(astebc.Aste().get(i).getVenditore().getCognomeUtente() + "<br><br>");

						out.print("<br> <br>");
					}
				}
			%>
		</div>
	</div>
	<br>
	<br>
	<br>
	<div class="header">
		<h2>
			<strong> Le mie aste - concluse</strong>
		</h2>
		<div class="container">
			<h4>
				<strong>Aste a superamento immediato</strong>
			</h4>
			<%
				int id = 0;
				for (int i = 0; i < astesi.Aste().size(); i++) {
					if (astesi.Aste().get(i).isAttiva() == 0
							&& astesi.Aste().get(i).getVenditore().getIdUtente() == utente.getId()) {
						id=astesi.Aste().get(i).getIdAsta();
						out.println("Oggetto in asta:  " + astesi.Aste().get(i).getOggetto().getNomeOggetto() + "<br><br>");
						out.println(
								"Descrizione oggetto:  " + astesi.Aste().get(i).getOggetto().getDescrizione() + "<br><br>");
						out.println("Base d'asta:  " + astesi.Aste().get(i).getBaseAsta() + "<br><br>");
						out.println("Ora d'inizio:  " + astesi.Aste().get(i).getOraInizio() + "<br><br>");
						out.println("Ora di fine:  " + astesi.Aste().get(i).getOraFine() + "<br><br>");
						out.println("Time Slot rimanenti:  " + astesi.Aste().get(i).getTimeSlot() + "<br><br>");
						out.println("Venditore:  " + astesi.Aste().get(i).getVenditore().getNomeUtente());
						out.println(astesi.Aste().get(i).getVenditore().getCognomeUtente() + "<br><br>");

						
						//AstaSuperamentoImmediato asta = astesi.Asta(id);
						ArrayList<Integer> offertaMaxsi = offertesi.Max(id);
						
						if (offertaMaxsi != null && offertaMaxsi.get(1)>0) {
							out.println("<br> Il vincitore e' : <br>");
							out.println("id offerente: " + offertaMaxsi.get(2) + "<br>");
							out.println("id offerta: " + offertaMaxsi.get(0) + "<br>");
							out.println("valore: " + offertaMaxsi.get(1));
						} else {
							out.println("Nessuna offerta per questa asta");
						}
						out.println("<br>------------------------------------------------<br><br>");
					}
				}
			%>
			<h4>
				<strong>Aste a busta chiusa</strong>
			</h4>
			<%
				for (int i = 0; i < astebc.Aste().size(); i++) {
					if (astebc.Aste().get(i).getAttiva() == 0
							&& astebc.Aste().get(i).getVenditore().getIdUtente() == utente.getId()) {

						out.println("Oggetto in asta:  " + astebc.Aste().get(i).getOggetto().getNomeOggetto() + "<br><br>");
						out.println(
								"Descrizione oggetto:  " + astebc.Aste().get(i).getOggetto().getDescrizione() + "<br><br>");
						out.println("Base d'asta:  " + astebc.Aste().get(i).getBaseAsta() + "<br><br>");
						out.println("Ora d'inizio:  " + astebc.Aste().get(i).getOraInizio() + "<br><br>");
						out.println("Ora di fine:  " + astebc.Aste().get(i).getOraFine() + "<br><br>");
						out.println("Venditore:  " + astebc.Aste().get(i).getVenditore().getNomeUtente());
						out.println(astebc.Aste().get(i).getVenditore().getCognomeUtente() + "<br><br>");

						
						//AstaSuperamentoImmediato asta = astebc.Asta(id);
						ArrayList<Integer> offertaMaxbc = offertebc.Max(id);
						
						if (offertaMaxbc != null && offertaMaxbc.get(1)>0) {
							out.println("<br> Il vincitore e' : <br>");
							out.println("id offerente: " + offertaMaxbc.get(2) + "<br>");
							out.println("id offerta: " + offertaMaxbc.get(0) + "<br>");
							out.println("valore: " + offertaMaxbc.get(1));
						} else {
							out.println("Nessuna offerta per questa asta");
						}
						
						out.println("<br>------------------------------------------------<br><br>");
					}
				}
			%>
		</div>
	</div>
</body>
</html>
