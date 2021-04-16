package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	// check user e password
	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=jacko";

	public static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(jdbcUrl);
		
	}

}