package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class statoAste {
	
	long stop = System.currentTimeMillis();
	
	public void aggiornaStato(){
	try{
        // open a connection
         Connection con = null;
         Class.forName("com.mysql.jdbc.Driver");  // load the driver
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb?useSSL=false","root","");

      
         
         //controllo se l'asta è scaduta
         PreparedStatement prep1 = con.prepareStatement("update astasuperamentoimmediato set attiva=0 where attiva!=0 AND oraFine <=" + stop);
        prep1.executeUpdate();
         PreparedStatement prep2 = con.prepareStatement("update astabustachiusa set attiva=0 where attiva!=0 AND oraFine <=" + stop);
        prep2.executeUpdate();
         
	con.close();
	}catch(Exception sqlex)
	{
		System.out.println(sqlex.getMessage());
      }  
	
	}
}


