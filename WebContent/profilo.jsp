<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="checkLogin.jsp"%>
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
<title>Il mio account</title>
</head>

<body>
	<div class="container">
		<%
			out.println("Nome: " + utente.getNome() + "<br/>");
			out.println("Cognome: " + utente.getCognome() + "<br/>");
			out.println("Indirizzo: " + utente.getIndirizzo() + "<br/>");
			out.println("Indirizzo email: " + utente.getEmail() + "<br/>");
			out.println("Crediti Disponibili: " + utente.getCreditiDisp() + "<br/>");
			out.println("Crediti Contabili: " + utente.getCreditiCont() + "<br/>");
			out.println("Numero carta di credito: " + utente.getNumeroCarta() + "<br/>");
			out.println("Password: " + utente.getPassword() + "<br/>");
		%>
		<button onlick="location.href='./update.jsp'">Aggiorna dati</button>
		<button onclick="location.href='./AcquistaCrediti.jsp'">Acquista
			crediti</button>
	</div>
</body>
</html>