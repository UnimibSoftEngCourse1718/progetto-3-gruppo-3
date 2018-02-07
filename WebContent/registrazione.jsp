<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Nuovo utente inserito</h3>
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
		String numeroCarta = request.getParameter("numerocarta");
		out.print(numeroCarta);
	%>
	<br />

</body>
</html>