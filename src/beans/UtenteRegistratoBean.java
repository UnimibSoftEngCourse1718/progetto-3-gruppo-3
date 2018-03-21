package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trinity.model.AstaSuperamentoImmediato;
import com.trinity.model.UtenteRegistrato;

public class UtenteRegistratoBean {

	public ArrayList <UtenteRegistrato> utenteRegistrato(){
		Connection con = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		try{
			// open a connection
			
			Class.forName("com.mysql.jdbc.Driver");  // load the driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb?useSSL=false","root","p0m0d0r1n1");
	
			// create the sql command
			prep = con.prepareStatement("Select * from UtenteRegistrato");  
			res = prep.executeQuery();
			
			//gestione risultato e creazione Utenteregistrato
			ArrayList <UtenteRegistrato> utente = new ArrayList <UtenteRegistrato>();
			while (res.next()) {
				utente.add(new UtenteRegistrato(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getInt(8), res.getInt(9)));
			}
			return utente;
			//chiusura connessione?
		}catch(Exception sqlex)
		{
			System.out.println("DB error");
			System.out.println(sqlex.getMessage());
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
				if (res != null)
					res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public UtenteRegistrato uR(int id){
		try{
			ArrayList<UtenteRegistrato> utenti = utenteRegistrato();
			UtenteRegistrato u = null;
			
			boolean trovato=false;
			for(int i=0; (i<utenti.size()) && (trovato==false); i++) {
				if(utenti.get(i).getIdUtente() == id) {
					u=utenti.get(i);
					trovato=true;
				}
			}
			
			return u;
			
		}catch(Exception sqlex){
			System.out.println("error");
			System.out.println(sqlex.getMessage());
			return null;
		}
	}
}