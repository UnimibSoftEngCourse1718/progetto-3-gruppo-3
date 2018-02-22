<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="css/style_login_registrazione.css">
<title>Conferma registrazione</title>
</head>
<body>

	<div class="log_reg-page">
		<div class="form">
			<h2>Nuovo utente inserito</h2>
			<hr>

			Nome:
			<%
				String nomeUtente = request.getParameter("nomeUtente");
				out.print(nomeUtente);
			%>
			<br /> Cognome:
			<%
				String cognomeUtente = request.getParameter("cognomeUtente");
				out.print(cognomeUtente);
			%>
			<br /> Email:
			<%
				String email = request.getParameter("email");
				out.print(email);
			%>
			<br /> Password:
			<%
				String password = request.getParameter("password");
				out.print(password);
			%>
			<br /> Indirizzo:
			<%
				String indirizzo = request.getParameter("indirizzo");
				out.print(indirizzo);
			%>
			<br /> Numero Carta:
			<%
				String numeroCarta = request.getParameter("numeroCarta");
				out.print(numeroCarta);
			%>
			<br /> <br />

			<button onclick="location.href='./login.html'">Accedi</button>
		</div>
		<div id="push"></div>
	</div>
	<div class="footer">
		<img src="media/logoTrinity.png" title="Logo Trinity"
			alt="Immagine - Logo Trinity" id="img_footer" align="left">
		Footer-text <img src="media/logoTrinity.png" title="Logo Trinity"
			alt="Immagine - Logo Trinity" id="img_footer" align="right">
	</div>
</body>
</html>