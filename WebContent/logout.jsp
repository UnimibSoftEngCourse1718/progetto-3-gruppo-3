<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "errorPage.jsp" %>
<jsp:useBean id="utente" class="beans.Login" scope="session" />
<!DOCTYPE html>
<html>
    <head>
    	<link rel="stylesheet" type="text/css" href="css/style_login_registrazione.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
    <div class="log_reg-page">
		<div class="form">
        <%
          out.print("Grazie per aver usufruito di Trinity! Torna a trovarci quando vuoi!");
          utente.logOut();
        %>
        <br/>
        <button type="submit" value="TORNA ALLA HOME" onclick="location.href='./index.html'">TORNA ALLA HOME</button>
        </div></div>
    </body>
</html>