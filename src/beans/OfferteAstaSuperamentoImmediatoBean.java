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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb","root","p0m0d0r1n1");
			
			ArrayList<Integer> max = new ArrayList <Integer>();
			
			//recupero le offerte relative a tale asta e ritorno i dati di quella con valore maggiore
			//PreparedStatement prep = connection.prepareStatement("SELECT * FROM offertasuperamentoimmediato WHERE asta= \"" + idAsta + "\"AND valore=(SELECT MAX (valore) FROM offertasuperamentoimmediato WHERE asta= \"" + idAsta + "\""); 
			//PreparedStatement prep = connection.prepareStatement("SELECT * FROM offertasuperamentoimmediato WHERE asta= \"" + idAsta);
			PreparedStatement prep = connection.prepareStatement("Select idOffertaSI, valore, offerente from offertasuperamentoimmediato where asta= \"" + idAsta + "\"");
			
			ResultSet all = prep.executeQuery();
			
			int valore=0;
			int idofferta=0;
			int offerente=0;
			
			while (all.next()) {
				if(all.getInt(2)>valore) {
					idofferta=all.getInt(1);
					valore=all.getInt(2);
					offerente=all.getInt(3);
				}
			}

			max.add(idofferta);			//idOffertaMassima
			max.add(valore);			//valore
			max.add(offerente);			//idOfferente
			
			return max;
			
		}catch(Exception sqlex){
			System.out.println("DB error");
			return null;
		}
	}
}