<%@page contentType="text/html" pageEncoding="UTF-8"%>
   
     <%@include file="checkLogin.jsp" %>
     <jsp:useBean id="categoria" class="beans.CategoriaBean" scope="session" />
     <jsp:setProperty name="categoria" property="*" /> 
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Crea nuova asta</title>
</head>
<body>

<h3>Crea nuova Asta</h3>

<form method="POST" action="creaAsta">

Base d'asta <input type="text" size="40" maxlength="40" name="baseAsta" /><br />
Numero Time Slot <input type="text" size="40" maxlength="40" name="timeSlot" /><br />
Oggetto : <br>
Nome oggetto <input type="text" size="40" maxlength="40" name="nomeOggetto" /><br />
Descrizione <input type="text" size="40" maxlength="40" name="descrizione" /><br />
Categoria:

 <%

out.print("<select name=\"categoria\" size='1' >");

for (int var=0; var<categoria.nomeCategoria().size(); var++)
{
	out.println("<option>" + categoria.nomeCategoria().get(var) + "</option>");
}
out.print("</select>");

out.print("<input type=\"hidden\" name=\"email\"  value=" + utente.getEmail() + " />");
%>
<br>
<input type="SUBMIT" value="Conferma">
</form>



</body>
</html>