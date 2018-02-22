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
	
	//metodo che restituisce un arraylist di tutte le aste a superamentoimmediato
	public ArrayList<AstaSuperamentoImmediato> Aste(){
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
			PreparedStatement prep2 = connection.prepareStatement("Select * from categoria");
			ResultSet all2 = prep2.executeQuery();
			ArrayList<Categoria> categorie = new ArrayList<Categoria>();
			while (all2.next()) {
				categorie.add(new Categoria(all2.getInt(1), all2.getString(2)));
			}
			
			//recupero tutti gli oggetti dal db
			PreparedStatement prep3 = connection.prepareStatement("Select * from oggetto"); 
			ResultSet all3 = prep3.executeQuery();
			ArrayList<Oggetto> oggetti = new ArrayList<Oggetto>();
			boolean trovato=false;
			while (all3.next()) {
				int idCategoria=all3.getInt(4);
				Categoria categoria = null;
				for(int i=0; (i<categorie.size()) && (trovato==false); i++) {
					if(idCategoria == categorie.get(i).getIdCategoria()) {
						categoria=categorie.get(i);
						trovato=true;
					}
				}
				oggetti.add(new Oggetto(all3.getInt(1), all3.getString(2), all3.getString(3), categoria));
			}
			
			//recupero tutte le aste dal db
			PreparedStatement prep4 = connection.prepareStatement("Select * from astasuperamentoimmediato"); 
			ResultSet all4 = prep4.executeQuery();
			ArrayList<AstaSuperamentoImmediato> aste = new ArrayList<AstaSuperamentoImmediato>();
			//per ogni asta cerco l'oggetto ed il venditore (utenteRegistrato), poi la inserisco nella lista di aste
			while (all4.next()) {
				int idOggetto=all4.getInt(6);
				Oggetto oggetto = null;
				int idVenditore=all4.getInt(7);
				UtenteRegistrato venditore = null;
				trovato=false;
				//cerco l'oggetto dell'asta
				for(int i=0; (i<oggetti.size()) && (trovato==false); i++) {
					if(idOggetto == oggetti.get(i).getIdOggetto()) {
						oggetto=oggetti.get(i);
						trovato=true;
					}
				}
				trovato=false;
				//cerco il venditore dell'asta
				for(int i=0; (i<utenti.size()) && (trovato==false); i++) {
					if(idVenditore == utenti.get(i).getIdUtente()) {
						venditore=utenti.get(i);
						trovato=true;
					}
				}
				aste.add(new AstaSuperamentoImmediato(all4.getInt(1), all4.getInt(2), all4.getLong(3), all4.getInt(5), oggetto, venditore));		
			}
			
			return aste;
			
		}catch(Exception sqlex){
			System.out.println("DB error");
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
			System.out.println("DB error");
			return null;
		}
	}
}