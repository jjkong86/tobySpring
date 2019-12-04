package web.chapter1.sub5;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import web.model.User;

public class ContextTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		
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
