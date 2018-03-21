package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OfferteAstaSuperamentoImmediatoBean {

	// ritorna un arraylist contenente idOffertaMassima, valore, idOfferente
	public ArrayList<Integer> Max(int idAsta) {
		Connection connection = null;
		Statement statement = null;
		PreparedStatement prep = null;
		ResultSet all = null;
		String query = "Select idOffertaSI, valore, offerente from offertasuperamentoimmediato where asta=?";
		try {
			// open a connection

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb?useSSL=false", "root", "p0m0d0r1n1");

			ArrayList<Integer> max = new ArrayList<Integer>();
			statement = connection.createStatement();

			all = statement.executeQuery("GETDATE()");
			prep = connection.prepareStatement(query);
			if (prep != null)
				prep.setInt(1, idAsta);
			else
				throw new NullPointerException();
			int valore = 0;
			int idOfferta = 0;
			int idOfferente = 0;

			while (all.next()) {
				if (all.getInt(2) > valore) {
					idOfferta = all.getInt(1);
					valore = all.getInt(2);
					idOfferente = all.getInt(3);
				}
			}

			max.add(idOfferta);
			max.add(valore);
			max.add(idOfferente);
			connection.close();
			return max;

		} catch (Exception sqlex) {
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
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQL exception");
				e.printStackTrace();
			}
			try {
				if (all != null)
					all.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}