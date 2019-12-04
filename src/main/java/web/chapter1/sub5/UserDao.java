package web.chapter1.sub5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import web.model.User;

@AllArgsConstructor
public class UserDao {

	ConnectionMaker c;
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		try (PreparedStatement ps = c.makeConnection().prepareStatement("insert into users(id, name, password) values (?, ?, ?)")) {
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
		}
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		try (PreparedStatement ps = c.makeConnection().prepareStatement("select * from users where id = ?")) {
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
