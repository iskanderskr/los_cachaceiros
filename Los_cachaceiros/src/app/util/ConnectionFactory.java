package app.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection() {		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/los_cachaceiros";
			String user = "root";
			String pass = "root";
			
			return DriverManager.getConnection(url, user, pass);
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
