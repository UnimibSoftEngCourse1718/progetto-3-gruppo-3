<html>
    <head>
    	<link rel="stylesheet" type="text/css" href="css/style_login_registrazione.css">
    	<title>Controllo</title>
    </head>
     <body>
     <div class="log_reg-page">
	<div class="form">
<jsp:useBean id="utente" class="loginbeans.Login" scope="session" />
     <%
          if(!utente.isLoggedIn())
          {
           response.sendRedirect("login.html");  // Tell the browser to go to this page
           return; // do nothing more
          }
     %>

        <h3>Hello <%= utente.getEmail() %> </h3>
        <button type="submit" value="TORNA ALLA PAGINA PRECEDENTE" onclick="location.href='./login.jsp'">TORNA ALLA PAGINA PRECEDENTE</button>
	</div></div>
	</body>
</html>  