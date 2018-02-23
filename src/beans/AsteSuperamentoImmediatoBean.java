package beans;

import com.trinity.model.AstaSuperamentoImmediato;
import com.trinity.model.Categoria;
import com.trinity.model.Oggetto;
import com.trinity.model.UtenteRegistrato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AsteSuperamentoImmediatoBean {
	
	int idAsta;
	int baseAsta;
	long oraInizio;
	long oraFine;
	int timeSlot;
	Oggetto oggetto;
	UtenteRegistrato venditore;
	int attiva;
	Categoria categoria;
	
	//metodo che restituisce un arraylist di tutte le aste a superamentoimmediato
	public ArrayList<AstaSuperamentoImmediato> Aste(){
		try{
			// open a connection
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb?useSSL=false","root","p0m0d0r1n1");
			
			ArrayList<AstaSuperamentoImmediato> aste = new ArrayList <AstaSuperamentoImmediato>();
			AstaSuperamentoImmediato a = new AstaSuperamentoImmediato();
			PreparedStatement prep1 = connection.prepareStatement("select idAsta, baseAsta, oraInizio, oraFine, timeSlot, o.idOggetto, o.nomeOggetto, o.descrizione, c.idCategoria, c.nomeCategoria, u.idUtente, u.nomeUtente, u.cognomeUtente, u.password, u.email, u.indirizzo, u.numeroCarta, attiva from astasuperamentoimmediato asi inner join utenteregistrato u on asi.venditore = u.idUtente inner join oggetto o on asi.oggetto = o.idOggetto inner join categoria c on o.categoria = c.idCategoria ");
			ResultSet rs = prep1.executeQuery();
			while(rs.next()){
				idAsta = rs.getInt(1);
				baseAsta = rs.getInt(2);
				oraInizio = rs.getLong(3);
				oraFine = rs.getLong(4);
				timeSlot = rs.getInt(5);
				categoria = new Categoria (rs.getInt(9), rs.getString(10));
				oggetto = new Oggetto(rs.getInt(6), rs.getString(7), rs.getString(8), categoria);
				
				venditore = new UtenteRegistrato(rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
				attiva = rs.getInt(18);
				a = new AstaSuperamentoImmediato(idAsta, baseAsta, oraInizio, oraFine, timeSlot, oggetto, venditore, attiva);
				aste.add(a);
			}
			connection.close();
			return aste;
			
		}catch(Exception sqlex){
			System.out.println("errore1");
			System.out.println(sqlex.getMessage());
			return null;
		}
	}
	
	//metodo che restituisce l'asta con dato id
	public AstaSuperamentoImmediato Asta(int id){
		try{
			ArrayList<AstaSuperamentoImmediato> aste = Aste();
			AstaSuperamentoImmediato asta = null;
						
			boolean trovato=false;
			for(int i=0; (i<aste.size()) && (trovato==false); i++) {
				if(aste.get(i).getIdAsta() == id) {
					asta=aste.get(i);
					trovato=true;
				}
			}
			
			return asta;
			
		}catch(Exception sqlex){
			System.out.println("errore2");
			System.out.println(sqlex.getMessage());
			return null;
		}
	}
}