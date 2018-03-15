package it.tulchiar.BarcodeList.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import it.tulchiar.BarcodeList.Properties_BarcodeList;

public class DBConnection {
	
	private String serverIp;
	private String user;
	private String password;
	
	public DBConnection(String serverIp, String user, String password) {
		super();
			
		this.serverIp = serverIp;
		this.user = user;
		this.password = password;
	}

	/***
	 * Costruttore con parametri di default
	 */
	public DBConnection() {
		super();
		this.serverIp = Properties_BarcodeList.serverIp;
		this.user = Properties_BarcodeList.user;
		this.password = Properties_BarcodeList.password;
	}
	
	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		
		String jdbcURL = "jdbc:mysql://"
				+ this.serverIp + "/barcodeList?"
				+ "user=" + this.user
				+ "&password=" + this.password;	
		
//		try {
//			Class.forName("com.mysql.jbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Driver JDBC non trovato", e);
//		}
	
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossibile connettersi al database!", e);
		}
	}



	
}
