package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class statoAste {
	
	long stop = System.currentTimeMillis();
	
	public void aggiornaStato(){
		Connection con = null;
		PreparedStatement prep1 = null;
		PreparedStatement prep2 = null;
	try{
        // open a connection
       
         Class.forName("com.mysql.jdbc.Driver");  // load the driver
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb?useSSL=false","root","p0m0d0r1n1");

      
         
         //controllo se l'asta è scaduta
         prep1 = con.prepareStatement("update astasuperamentoimmediato set attiva=0 where attiva!=0 AND oraFine <=" + stop);
        prep1.executeUpdate();
         prep2 = con.prepareStatement("update astabustachiusa set attiva=0 where attiva!=0 AND oraFine <=" + stop);
        prep2.executeUpdate();
         
	con.close();
	}catch(Exception sqlex)
	{
		System.out.println(sqlex.getMessage());
      } 
	
	finally {
		try {
			if (prep1 != null)
				prep1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL exception");
			e.printStackTrace();
		}
		try {
			if (prep2 != null)
				prep2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	}
}


