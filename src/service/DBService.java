package service;

import java.sql.Connection;
import java.sql.DriverManager;

class DBService { // Dao 패키지에서 호출 할 수 없도록 캡슐화 시키기 위해 public을 붙히지않는다.
	public Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssh4733", "ssh4733", "tkdugs1!");
		return conn;
	}
}
