package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	int idUtente;
	String nome;
	String cognome;
	String email;
	String password;
	String indirizzo;
	String numeroCarta;
	int creditiDisp;
	int creditiCont;

	boolean loggedIn = false;

	public Login() {
		throw new UnsupportedOperationException();

	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public boolean login() {

		Connection con = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			// open a connection

			Class.forName("com.mysql.jdbc.Driver"); // load the driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb?useSSL=false", "root", "p0m0d0r1n1");

			// create the sql command
			
			prep = con.prepareStatement(
					"Select idUtente, nomeUtente, cognomeUtente, email, password, indirizzo, numeroCarta, creditiDisp, creditiCont from utenteregistrato where email= \""
							+ email + "\" and password=\"" + password + "\"");

			if (prep != null) {

				rs = prep.executeQuery();
				if (rs != null) {

					if (rs.next()) {
						idUtente = rs.getInt(1);
						nome = rs.getString(2);
						cognome = rs.getString(3);
						email = rs.getString(4);
						password = rs.getString(5);
						indirizzo = rs.getString(6);
						numeroCarta = rs.getString(7);
						creditiDisp = rs.getInt(8);
						creditiCont = rs.getInt(9);
						loggedIn = true;

					} else {
						System.out.println(rs);
						loggedIn = false;
					}
				}
			}
		} catch (Exception sqlex) {
			sqlex.printStackTrace();
			loggedIn = false;
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

		return loggedIn;
	}

	public int getId() {
		return idUtente;
	}

	public void setId(int idUtente) {
		this.idUtente = idUtente;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public int getCreditiDisp() {
		return creditiDisp;
	}

	public void setCreditiDisp(int creditiDisp) {
		this.creditiDisp = creditiDisp;
	}
	
	public int getCreditiCont() {
		return creditiCont;
	}

	public void setCreditiCont(int creditiCont) {
		this.creditiCont = creditiCont;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void logOut() {
		loggedIn = false;
	}
}