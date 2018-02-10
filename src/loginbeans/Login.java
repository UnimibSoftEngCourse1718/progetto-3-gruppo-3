package loginbeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Login {
   
    String email = "";
    String password = "";
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	boolean loggedIn = false;
    
    public Login()
    {
        
    }
    
   public boolean isLoggedIn()
   {
       return loggedIn;
   }
   
   public boolean login()
   {
     
	  
        try{
         // open a connection
          Connection con = null;
          Class.forName("com.mysql.jdbc.Driver");  // load the driver
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb","root","p0m0d0r1n1");

          // create the sql command
          PreparedStatement prep = con.prepareStatement("Select email, password from utenteregistrato where email=? and password=?");  
          prep.setString(1,email);
          prep.setString(2,password);
       
          ResultSet rs  = prep.executeQuery();
          
          if(rs.next())
          {
           email = rs.getString(1);
           password = rs.getString(2);
           loggedIn = true;
           
          }
          else{
        	 loggedIn = false; 
        	
          }
            
          prep.close();
          con.close();
          
         }
        catch(Exception sqlex)
        {
          loggedIn = false;  
        }  
        
        return loggedIn;
   }
   
   public void logOut()
   {
     loggedIn = false;
   }
}