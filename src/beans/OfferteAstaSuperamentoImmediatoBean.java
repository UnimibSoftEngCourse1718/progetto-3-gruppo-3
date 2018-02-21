package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OfferteAstaSuperamentoImmediatoBean {

	public int Max(){
		try{
			// open a connection
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb","root","p0m0d0r1n1");
			
			int max = 0;
			
			//recupero tutte le aste dal db
			PreparedStatement prep = connection.prepareStatement("SELECT max (valore) FROM offertasuperamentoimmediato WHERE asta=:idAsta");		//SELECT valore FROM offertasuperamentoimmediato WHERE asta=:idAsta and valore=(SELECT MAX (valore) FROM offertasuperamentoimmediato WHERE asta=:idAsta) 
			ResultSet all = prep.executeQuery();
			max = all.getInt(1);			
			
			return max;
			
		}catch(Exception sqlex){
			System.out.println("DB error");
			return 0;
		}
	}
}