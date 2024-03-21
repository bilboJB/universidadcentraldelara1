/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
*/
package controller;

public class DbCon {
	private final String url;
	private final String user;
	private final String password;
	
	public DbCon() {
		this.url = "jdbc:postgresql://localhost/UniversidadCentraldeLara";
		this.user = "postgres";
		this.password = "1234";
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
}
