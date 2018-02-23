package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OfferteAstaSuperamentoImmediatoBean {
	
	//ritorna un arraylist contenente idOffertaMassima, valore, idOfferente
	public ArrayList<Integer> Max(int idAsta){
		try{
			// open a connection
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb?useSSL=false","root","");
			
			ArrayList<Integer> max = new ArrayList <Integer>();
			
			PreparedStatement prep = connection.prepareStatement("Select idOffertaSI, valore, offerente from offertasuperamentoimmediato where asta= \"" + idAsta + "\"");
			
			ResultSet all = prep.executeQuery();
			
			int valore=0;
			int idOfferta=0;
			int idOfferente=0;
			
			while (all.next()) {
				if(all.getInt(2)>valore) {
					idOfferta=all.getInt(1);
					valore=all.getInt(2);
					idOfferente=all.getInt(3);
				}
			}

			max.add(idOfferta);	
			max.add(valore);
			max.add(idOfferente);
			
			return max;
			
		}catch(Exception sqlex){
			System.out.println("DB error");
			return null;
		}
	}
}