<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conferma invio offerta</title>
</head>
<body>
	
	Offerta inviata con successo!
	<br>
	<br>
	id asta:
		<%
			String indirizzo = request.getParameter("idAsta");
			out.print(indirizzo);
		%>
		<br>
	
	valore offerta:
		<%
			out.print(request.getParameter("valoreOfferta"));
		%>
		<br><br>	
	<button onclick="location.href='home.jsp'">Home</button>
	
	<a class="nav-link" href="home.jsp">Home</a>
	
	
</body>
</html>