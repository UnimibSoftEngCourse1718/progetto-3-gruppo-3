package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class statoAste {
	
	long stop = System.currentTimeMillis();
	
	public void aggiornaStato(){
	try{
        // open a connection
         Connection con = null;
         Class.forName("com.mysql.jdbc.Driver");  // load the driver
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb","root","p0m0d0r1n1");

         // create the sql command
         System.out.println(stop);
         PreparedStatement prep = con.prepareStatement("update astasuperamentoimmediato set attiva = 0 where attiva != 0 AND oraFine <= " + stop );
         System.out.println(prep);
         prep.executeUpdate();
	
	}catch(Exception sqlex)
	{
		System.out.println(sqlex.getMessage());
      }  
	
	}
}


