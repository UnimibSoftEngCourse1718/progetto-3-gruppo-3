<jsp:useBean id="utente" class="loginbeans.Login" scope="session" />
     <%
          if(!utente.isLoggedIn())
          {
           response.sendRedirect("login.html");  // Tell the browser to go to this page
           return; // do nothing more
          }
     %>

        <h3>Hello <%= utente.getEmail() %> </h3>