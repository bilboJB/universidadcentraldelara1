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
