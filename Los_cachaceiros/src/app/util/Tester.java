package app.util;

import java.sql.Connection;

public class Tester {

	public static void main(String[] args) {
		Connection con  = ConnectionFactory.getConnection();
		System.out.println("Coneção feita");
	}

}
