package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriaBean {

	public ArrayList<String> nomeCategoria(){
		try{
			// open a connection
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver");  // load the driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb","root","p0m0d0r1n1");
	
			// create the sql command
			PreparedStatement prep = con.prepareStatement("Select nomeCategoria from categoria");  
			
			ResultSet rs  = prep.executeQuery();
			ArrayList <String> risultati = new ArrayList<String>();
			while (rs.next()) {
				risultati.add(rs.getString(1));
			}
			return risultati;
			
		}catch(Exception sqlex)
		{
			System.out.println("DB error");
			return null;
		}
	}
}