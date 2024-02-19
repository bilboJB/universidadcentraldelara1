package controller;

import java.sql.*;

public class ConnectionDB {
	private final String url = "jdbc:postgresql://localhost/UniversidadCentraldeLara";
	private final String user = "postgres";
	private final String password = "1234";
	
	public ConnectionDB() {
		
	}
	
	public void conexion() {
		try(Connection con = DriverManager.getConnection(url,user,password);){
			if (con != null) {
				System.out.println("conectado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
