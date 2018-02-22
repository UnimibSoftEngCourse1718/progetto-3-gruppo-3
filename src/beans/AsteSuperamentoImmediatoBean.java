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
	
	//metodo che restituisce un arraylist di tutte le aste a superamentoimmediato
	public ArrayList<AstaSuperamentoImmediato> Aste(){
		try{
			// open a connection
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb","root","p0m0d0r1n1");
			
			
			ArrayList<AstaSuperamentoImmediato> aste = new ArrayList <AstaSuperamentoImmediato>();
			AstaSuperamentoImmediato a = new AstaSuperamentoImmediato();
			PreparedStatement prep1 = connection.prepareStatement("select * from astasuperamentoimmediato asi inner join utenteregistrato u on asi.venditore = u.idUtente inner join oggetto o on asi.oggetto = o.idOggetto inner join categoria c on o.categoria = c.idCategoria ");
			ResultSet rs = prep1.executeQuery();
			while(rs.next()){
				idAsta=rs.getInt(1);
				baseAsta = rs.getInt(2);
				oraInizio = rs.getLong(3);
				oraFine = rs.getLong(4);
				timeSlot = rs.getInt(5);
				oggetto = (Oggetto) rs.getObject(6);
				venditore = (UtenteRegistrato) rs.getObject(7);
				attiva = rs.getInt(8);
				a = new AstaSuperamentoImmediato(idAsta, baseAsta, oraInizio, oraFine, timeSlot, oggetto, venditore, attiva);
				aste.add(a);
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