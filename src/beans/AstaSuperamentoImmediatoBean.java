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

public class AstaSuperamentoImmediatoBean {

	public ArrayList<AstaSuperamentoImmediato> idAsta(){
		try{
			// open a connection
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb","root","p0m0d0r1n1");
			
			//recupero tutti gli utenti dal db
			PreparedStatement prep = connection.prepareStatement("Select * from utenteregistrato");  
			ResultSet all = prep.executeQuery();
			ArrayList<UtenteRegistrato> utenti = new ArrayList<UtenteRegistrato>();
			while (all.next()) {
				//dati utenteregistrato: int idUtente, String nomeUtente, String cognomeUtente, String password, String email, String indirizzo, String numeroCarta
				utenti.add(new UtenteRegistrato(all.getInt(1), all.getString(2), all.getString(3), all.getString(4), all.getString(5),all.getString(6),all.getString(7)));
			}
			
			//recupero tutte le categorie dal db
			PreparedStatement prep2 = connection.prepareStatement("Select * from categoria"); 								//eventualmente, riutilizzare la variabile "prep" come sopra [quindi già dichiarato] 
			ResultSet all2 = prep2.executeQuery(); 																			//eventualmente, riutilizzare la variabile "all" già dichiarata
			ArrayList<Categoria> categorie = new ArrayList<Categoria>();
			while (all2.next()) { 																							//inserisco tutte le categorie del db in una lista
				categorie.add(new Categoria(all2.getInt(1), all2.getString(2)));											//dati categoria: int idCategoria, String nomeCategoria
			}
			
			//recupero tutti gli oggetti dal db
			PreparedStatement prep3 = connection.prepareStatement("Select * from categoria"); 								//eventualmente, riutilizzare la variabile "prep" come sopra [quindi già dichiarato] 
			ResultSet all3 = prep3.executeQuery();																			//eventualmente, riutilizzare la variabile "all" già dichiarata
			ArrayList<Oggetto> oggetti = new ArrayList<Oggetto>();
			boolean trovato=false;
			while (all3.next()) {																							//per ogni oggetto cerco la categoria a cui appartiene, poi lo inserisco nella lista di oggetti
				int idCategoria=all3.getInt(4);
				Categoria categoria = null;
				for(int i=0; (i<categorie.size()) && (trovato==false); i++) {												//cerco la categoria dell'oggetto
					if(idCategoria == categorie.get(i).getIdCategoria()) {
						categoria=categorie.get(i);
						trovato=true;
					}
				}
				oggetti.add(new Oggetto(all3.getInt(1), all3.getString(2), all3.getString(3), categoria));					//dati oggetto: int idOggetto, String nomeOggetto, String descrizione, Categoria categoria
			}
			
			//recupero tutte le aste dal db
			PreparedStatement prep4 = connection.prepareStatement("Select * from categoria"); 								//eventualmente, riutilizzare la variabile "prep" come sopra [quindi già dichiarato] 
			ResultSet all4 = prep4.executeQuery();																			//eventualmente, riutilizzare la variabile "all" già dichiarata
			ArrayList<AstaSuperamentoImmediato> aste = new ArrayList<AstaSuperamentoImmediato>();
			while (all4.next()) {																							//per ogni asta cerco l'oggetto ed il venditore (utenteRegistrato), poi la inserisco nella lista di aste
				int idOggetto=all4.getInt(6);
				Oggetto oggetto = null;
				int idVenditore=all4.getInt(7);
				UtenteRegistrato venditore = null;
				trovato=false;
				for(int i=0; (i<oggetti.size()) && (trovato==false); i++) {													//cerco l'oggetto dell'asta
					if(idOggetto == oggetti.get(i).getIdOggetto()) {
						oggetto=oggetti.get(i);
						trovato=true;
					}
				}
				trovato=false;
				for(int i=0; (i<utenti.size()) && (trovato==false); i++) {													//cerco il venditore dell'asta
					if(idVenditore == utenti.get(i).getIdUtente()) {
						venditore=utenti.get(i);
						trovato=true;
					}
				}
				aste.add(new AstaSuperamentoImmediato(all4.getInt(1), all4.getInt(2), all4.getLong(3), all4.getInt(5), oggetto, venditore));			//dati asta: int idAsta, int baseAsta, long oraInizio, long oraFine, int timeSlot, Oggetto oggetto, UtenteRegistrato venditore				
			}
			
			return aste;
			
		}catch(Exception sqlex){
			System.out.println("DB error");
			return null;
		}
	}
}