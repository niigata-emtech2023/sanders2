package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * コネクションマネージャー
 * @author emtech-user
 *
 */
public class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/amaats_db";
	private static final String USER = "embexU";
	private static final String PASSWORD = "embexP";
	
	/* コネクションの作成 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection(URL, USER, PASSWORD);
		
	}

}