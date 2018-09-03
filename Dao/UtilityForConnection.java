package servlets;

public class UtilityForConnection {
	private static final String databaseName = "employee";
	private static final String username = "root";
	private static final String password = "root";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String connectionClass = "com.mysql.jdbc.Driver";

	public static String getConnectionclass() {
		return connectionClass;
	}

	public static String getDatabasename() {
		return databaseName;
	}

	public static String getPassword() {
		return password;
	}

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return username;
	}
}