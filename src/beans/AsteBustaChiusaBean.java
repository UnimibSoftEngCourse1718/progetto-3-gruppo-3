package beans;

import com.trinity.model.AstaBustaChiusa;
import com.trinity.model.Categoria;
import com.trinity.model.Oggetto;
import com.trinity.model.UtenteRegistrato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AsteBustaChiusaBean {
	
	int idAsta;
	int baseAsta;
	long oraInizio;
	long oraFine;
	Oggetto oggetto;
	UtenteRegistrato venditore;
	int attiva;
	Categoria categoria;
	
	//metodo che restituisce un arraylist di tutte le aste a bustachiusa
	public ArrayList<AstaBustaChiusa> Aste(){
		try{
			// open a connection
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb?useSSL=false","root","p0m0d0r1n1");
			
			ArrayList<AstaBustaChiusa> aste = new ArrayList <AstaBustaChiusa>();
			AstaBustaChiusa b = new AstaBustaChiusa();
			PreparedStatement prep1 = connection.prepareStatement("select idAsta, baseAsta, oraInizio, oraFine, o.idOggetto, o.nomeOggetto, o.descrizione, c.idCategoria, c.nomeCategoria, u.idUtente, u.nomeUtente, u.cognomeUtente, u.password, u.email, u.indirizzo, u.numeroCarta, attiva from astabustachiusa abc inner join utenteregistrato u on abc.venditore = u.idUtente inner join oggetto o on abc.oggetto = o.idOggetto inner join categoria c on o.categoria = c.idCategoria ");
			ResultSet rs = prep1.executeQuery();
			while(rs.next()){
				idAsta = rs.getInt(1);
				baseAsta = rs.getInt(2);
				oraInizio = rs.getLong(3);
				oraFine = rs.getLong(4);
				categoria = new Categoria (rs.getInt(8), rs.getString(9));
				oggetto = new Oggetto(rs.getInt(5), rs.getString(6), rs.getString(7), categoria);
				
				venditore = new UtenteRegistrato(rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16));
				attiva = rs.getInt(17);
				b = new AstaBustaChiusa(idAsta, baseAsta, oraInizio, oraFine, oggetto, venditore, attiva);
				aste.add(b);
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
	public AstaBustaChiusa Asta(int id){
		try{
			ArrayList<AstaBustaChiusa> aste = Aste();
			AstaBustaChiusa asta = null;
						
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