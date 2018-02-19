<%@page contentType="text/html" pageEncoding="UTF-8"%>
   
     <%@include file="checkLogin.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Acquista i tuoi crediti</title>
</head>
<body>
<p>Inserisci la quantità di euro da spendere per i tuoi crediti:</p>
<form method="post" action="AcquistaCrediti">
  <label>Crediti</label>
  <input name="outputCrediti" id="inputEuro" type="number" placeholder="Crediti" oninput="creditConverter(this.value)" onchange="creditConverter(this.value)">


<p>Euro: <span id="conversione"></span> €</p>

<script>
function creditConverter(valNum) {
  valNum = parseInt(valNum);
  document.getElementById("conversione").innerHTML=(valNum/10);
}
</script>


<% out.print("<input type=\"hidden\" name=\"email\"  value=" + utente.getEmail() + " />"); 
	out.print("<input type=\"hidden\" name=\"creditiPrec\"  value=" + utente.getCrediti() + " />");%>
<button type="submit" value="AcquistaCrediti">Conferma Acquisto Crediti</button>
</form>
</body>
</html>