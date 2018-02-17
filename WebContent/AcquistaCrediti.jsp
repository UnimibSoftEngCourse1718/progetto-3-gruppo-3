<%@page contentType="text/html" pageEncoding="UTF-8"%>
   
     <%@include file="checkLogin.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Acquista i tuoi crediti</title>
</head>
<body>
<p>Inserisci la quantità di euro da spendere per i tuoi crediti:</p>
<form method="post">
  <label>Euro</label>
  <input id="inputEuro" type="number" placeholder="Euro" oninput="creditConverter(this.value)" onchange="creditConverter(this.value)">
</p>
<p>Crediti: <span id="outputCrediti"></span></p>

<script>
function creditConverter(valNum) {
  valNum = parseFloat(valNum);
  document.getElementById("outputCrediti").innerHTML=(valNum*10);
}
</script>
<button type="submit" value="AcquistaCrediti">Conferma Acquisto Crediti</button>
</form>
</body>
</html>