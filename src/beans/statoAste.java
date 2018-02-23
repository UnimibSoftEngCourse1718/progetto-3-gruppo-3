package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class statoAste {
	
	long stop = System.currentTimeMillis();
	long slot = 300000;
	long t = 120000;
	
	public void aggiornaStato(){
	try{
        // open a connection
         Connection con = null;
         Class.forName("com.mysql.jdbc.Driver");  // load the driver
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb?useSSL=false","root","");

         // create the sql command
         System.out.println(stop);
         PreparedStatement prep = con.prepareStatement("update astasuperamentoimmediato set oraInizio=oraFine, oraFine = oraFine + " + slot + ", timeSlot = timeSlot-1  where attiva != 0 AND timeSlot>0 AND oraFine - oraInizio <= " + t + " AND oraFine > " + stop );
         System.out.println(prep);
         prep.executeUpdate();
         
         PreparedStatement prep1 = con.prepareStatement("update astasuperamentoimmediato set attiva = 0 where attiva!=0 AND oraFine <=" + stop);
         System.out.println(prep1);
         prep1.executeUpdate();
	
	}catch(Exception sqlex)
	{
		System.out.println(sqlex.getMessage());
      }  
	
	}
}


