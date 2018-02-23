<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="checkLogin.jsp"%>
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
<title>Acquista i tuoi crediti</title>
</head>
<body>
	<div class="container">

		<p>Inserisci la quantità di euro da spendere per i tuoi crediti:</p>
		<form method="post" action="AcquistaCrediti">
			<label>Crediti</label> <input name="outputCrediti" id="inputEuro"
				type="number" placeholder="Crediti"
				oninput="creditConverter(this.value)"
				onchange="creditConverter(this.value)">

			<p>
				Euro: <span id="conversione"></span> €
			</p>

			<script>
				function creditConverter(valNum) {
					valNum = parseInt(valNum);
					document.getElementById("conversione").innerHTML = (valNum);
				}
			</script>

			<%
				out.print("<input type=\"hidden\" name=\"email\"  value=" + utente.getEmail() + " />");
				out.print("<input type=\"hidden\" name=\"creditiDispPrec\"  value=" + utente.getCreditiDisp() + " />");
				out.print("<input type=\"hidden\" name=\"creditiContPrec\"  value=" + utente.getCreditiCont() + " />");
			%>
			<button type="submit" value="AcquistaCrediti">Conferma
				Acquisto Crediti</button>
		</form>
	</div>
	<br>
</body>
</html>