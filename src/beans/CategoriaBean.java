package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaBean {

	public ArrayList<String> nomeCategoria(){
		Connection con = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try{
			// open a connection
			
			Class.forName("com.mysql.jdbc.Driver");  // load the driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb?useSSL=false","root","p0m0d0r1n1");
	
			// create the sql command
			prep = con.prepareStatement("Select nomeCategoria from categoria");  
			
			rs  = prep.executeQuery();
			ArrayList <String> risultati = new ArrayList<String>();
			while (rs.next()) {
				risultati.add(rs.getString(1));
			}
			return risultati;
			//chiusura connessione?
		}catch(Exception sqlex)
		{
			System.out.println("DB error");
			return null;
		}
		
		finally {
			try {
				if (prep != null)
					prep.close();
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
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}