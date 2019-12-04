package web.chapter1.sub5;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CountingConnectionMaker implements ConnectionMaker {
	private int counter = 0;
	private ConnectionMaker realConnectionMaker;

	public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		System.out.println(++counter);
		return realConnectionMaker.makeConnection();
	}

	public int getCounter() {
		return this.counter;
	}

}
