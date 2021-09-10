package com.ritallopes.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String URL = "jdbc:mysql://localhost:3306/";
	private static String NOME = "userbd";
	private static String SENHA = "abcXyz.2021";
	private static final String MySQLDriver = "com.mysql.cj.jdbc.Driver";  

	public static Connection connection() throws ClassNotFoundException, SQLException {  
	      Class.forName(MySQLDriver);  
	      return DriverManager.getConnection(URL, NOME, SENHA);  
	   }

}
