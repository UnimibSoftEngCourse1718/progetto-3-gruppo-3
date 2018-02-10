<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "errorPage.jsp" %>
<jsp:useBean id="utente" class="loginbeans.Login" scope="session" />
<jsp:setProperty name="utente" property="*" /> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%
          session.setMaxInactiveInterval(0);  
          utente.login();
          
          if(utente.isLoggedIn()){
            out.println("Hello "+utente.getEmail()+"<br/>");
          }
          else{
        	  out.println("Invalid login<br />");
          }
         out.println("<a href='checkLogin.jsp'>check</A>");
        %>
        


    </body>
</html>