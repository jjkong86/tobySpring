package web.chapter1.sub1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.model.User;

public class UserDao {
	public void add(User user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "mysql")) {
			try (PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values (?, ?, ?)")) {
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPassword());
				ps.executeUpdate();
			}
		}
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "mysql")) {
			try (PreparedStatement ps = c.prepareStatement("select * from users where id = ?")) {
				ps.setString(1, id);
				try (ResultSet rs = ps.executeQuery()) {
					rs.next();
					User user = new User();
					user.setId(rs.getString("id"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					return user;
				}
			}
		}
	}
}
