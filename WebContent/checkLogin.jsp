<jsp:useBean id="utente" class="beans.Login" scope="session" />
     <%
          if(!utente.isLoggedIn())
          {
           response.sendRedirect("login.html");  // Tell the browser to go to this page
           return; // do nothing more
          }
     %>

      