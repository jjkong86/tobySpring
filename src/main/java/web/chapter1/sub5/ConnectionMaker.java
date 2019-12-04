package web.chapter1.sub5;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;

public interface ConnectionMaker {
	@Bean
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
