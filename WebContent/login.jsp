<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "errorPage.jsp" %>
<jsp:useBean id="utente" class="beans.Login" scope="session" />
<jsp:setProperty name="utente" property="*" />
<jsp:useBean id="statoAste" class="beans.statoAste"
	scope="session" >
	<%statoAste.aggiornaStato();%> </jsp:useBean>
 
<!DOCTYPE html>
<html>
    <head>
    	<link rel="stylesheet" type="text/css" href="css/style_login_registrazione.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    	<div class="log_reg-page">
		<div class="form">
        <%
          session.setMaxInactiveInterval(0);  
          utente.login();
          
          if(utente.isLoggedIn()){
            out.println("Benvenuto "+utente.getEmail()+"<br/>");
            out.println("<a href='logout.jsp'>Logout</a> <br/>");
            out.print("<button type=\"submit\" value=\"VAI ALLA HOME\" onclick=\"location.href='./home.jsp'\">VAI ALLA HOME</button>");
          }
          else{
        	  out.println("I dati di accesso sono sbagliati! Controllali di nuovo!<br />");
        	  out.print("<button type=\"submit\" value=\"TORNA AL LOGIN\" onclick=\"location.href='./login.html'\">RIPROVA</button>");
          }

        %>
        <br/>
        
		</div></div>

    </body>
</html>