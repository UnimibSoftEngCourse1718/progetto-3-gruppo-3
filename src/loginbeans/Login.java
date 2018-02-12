package loginbeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	String email;
	String password;

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

	boolean loggedIn = false;

	public Login() {

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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trinitydb", "root", "");

			// create the sql command
			prep = con.prepareStatement("Select email, password from utenteregistrato where email=? and password=?");
			if (prep != null) {
				prep.setString(1, email);
				prep.setString(2, password);

				rs = prep.executeQuery();
				if (rs != null) {

					if (rs.next()) {
						email = rs.getString(1);
						password = rs.getString(2);
						loggedIn = true;

					} else {
						loggedIn = false;

					}
				}
			}
		} catch (Exception sqlex) {
			loggedIn = false;
		}

		finally {
				try {
					if(prep != null)
					prep.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(con != null)
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(rs != null)
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return loggedIn;
	}

	public void logOut() {
		loggedIn = false;
	}
}