<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conferma creazione asta</title>
</head>
<body>

	<h2>Nuova asta creata</h2>
		<hr>
			
		Oggetto in asta:
		<%
			String nomeOggetto = request.getParameter("nomeOggetto");
			out.print(nomeOggetto);
		%>
		<br /> Categoria:
		<%
			String nomeCategoria = request.getParameter("categoria");
			out.print(nomeCategoria);
		%>
		
		<br /> Base d'asta:
		<%
			String baseAsta = request.getParameter("baseAsta");
			out.print(baseAsta);
		%>
		
		<br /> Fine primo slot Asta:
		<%
			
			out.print(request.getAttribute("oraFine"));
		%>
		
		
		
		<br />
		<br />
</body>
</html>