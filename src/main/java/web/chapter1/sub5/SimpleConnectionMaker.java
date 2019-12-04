package web.chapter1.sub5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker implements ConnectionMaker {
	
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC";
		final String USER = "root";
		final String PW = "mysql";
		Class.forName(DRIVER);
		Connection c = DriverManager.getConnection(URL, USER, PW);
		return c;
	}
}
