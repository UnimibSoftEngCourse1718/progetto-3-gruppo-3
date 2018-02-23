<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="checkLogin.jsp"%>
<%@ page import="java.util.Date"%>
<jsp:useBean id="astesi" class="beans.AsteSuperamentoImmediatoBean" scope="session" />
	<jsp:useBean id="astebc" class="beans.AsteBustaChiusaBean" scope="session" />
	<jsp:useBean id="statoAste" class="beans.statoAste" scope="session" >
	<%statoAste.aggiornaStato();%> </jsp:useBean>
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
<title>Trinity</title>
</head>

<body>

	<div class="container">
		<div class="header">
			<h1>
				<strong> ASTE LIVE </strong>
			</h1>
		</div>
	</div>
	<div class="container">
		<h2>
			<strong> Aste a superamento immediato</strong>
		</h2>
		<%
			for (int i = 0; i < astesi.Aste().size(); i++) {
				if (astesi.Aste().get(i).isAttiva() != 0) {
					
					out.println("Oggetto in asta:  " + astesi.Aste().get(i).getOggetto().getNomeOggetto() + "<br><br>");
					out.println(
							"Descrizione oggetto:  " + astesi.Aste().get(i).getOggetto().getDescrizione() + "<br><br>");
					out.println("Base d'asta:  " + astesi.Aste().get(i).getBaseAsta() + "<br><br>");
					Date start = new Date(astesi.Aste().get(i).getOraInizio());
					Date end = new Date(astesi.Aste().get(i).getOraFine());
					out.println("Ora d'inizio:  " + start + "<br><br>");
					out.println("Ora di fine:  " + end + "<br><br>");
					out.println("Time Slot rimanenti:  " + astesi.Aste().get(i).getTimeSlot() + "<br><br>");
					out.println("Venditore:  " + astesi.Aste().get(i).getVenditore().getNomeUtente());
					out.println(astesi.Aste().get(i).getVenditore().getCognomeUtente() + "<br><br>");
					out.print("<form method=\"POST\" action=\"IdAstaToAstaPage\">");
					int idAsta = astesi.Aste().get(i).getIdAsta();
					int tipoAsta = 1; //asta superamentoimmediato vale 1
					out.print("<input type=\"hidden\" name=\"idAsta\"  value=" + idAsta + " />");
					out.print("<input type=\"hidden\" name=\"tipoAsta\"  value=" + tipoAsta + " />");
					out.print("<input name=\"vedi\" type=\"SUBMIT\" value=\"Vedi Asta\"> </form>");
					out.print("<br> <br>");
				}
			}
		%>
	</div>

	<div class="container">
		<h2>
			<strong>Aste a busta chiusa</strong>
		</h2>
		<%
			for (int i = 0; i < astebc.Aste().size(); i++) {
				if (astebc.Aste().get(i).getAttiva() != 0) {
					
					out.println("Oggetto in asta:  " + astebc.Aste().get(i).getOggetto().getNomeOggetto() + "<br><br>");
					out.println(
							"Descrizione oggetto:  " + astebc.Aste().get(i).getOggetto().getDescrizione() + "<br><br>");
					out.println("Base d'asta:  " + astebc.Aste().get(i).getBaseAsta() + "<br><br>");
					Date start = new Date(astebc.Aste().get(i).getOraInizio());
					Date end = new Date(astebc.Aste().get(i).getOraFine());
					out.println("Ora d'inizio:  " + start + "<br><br>");
					out.println("Ora di fine:  " + end + "<br><br>");
					out.println("Venditore:  " + astebc.Aste().get(i).getVenditore().getNomeUtente());
					out.println(astebc.Aste().get(i).getVenditore().getCognomeUtente() + "<br><br>");
					out.print("<form method=\"POST\" action=\"IdAstaToAstaPage\">");
					int idAsta = astebc.Aste().get(i).getIdAsta();
					int tipoAsta = 0; //asta superamentoimmediato vale 1
					out.print("<input type=\"hidden\" name=\"idAsta\"  value=" + idAsta + " />");
					out.print("<input type=\"hidden\" name=\"tipoAsta\"  value=" + tipoAsta + " />");
					out.print("<input name=\"vedi\" type=\"SUBMIT\" value=\"Vedi Asta\"> </form>");
					out.print("<br> <br>");
				}
				else
				out.println("Nessuna asta in corso");
			}
		%>
	</div>

	<br>

</body>
</html>