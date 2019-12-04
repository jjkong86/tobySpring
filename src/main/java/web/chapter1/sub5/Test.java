package web.chapter1.sub5;

import java.sql.SQLException;

import web.chapter1.sub5.UserDao;
import web.model.User;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new UserDao(new CountingConnectionMaker(new SimpleConnectionMaker()));
		
		User user = new User();
		String id = "jj";
		if (!id.equals(dao.get(id).getId())) {
			user.setId(id);
			user.setName("정재공");
			user.setPassword("1234");
			dao.add(user);
			System.out.println(user.getId() + "등록 성공");
		}
		User users2 = dao.get(id);
		System.out.println(users2.toString());
	}
}
