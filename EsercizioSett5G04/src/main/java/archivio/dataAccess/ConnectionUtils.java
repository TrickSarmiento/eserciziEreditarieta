package archivio.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	public static final String user = "postgres";
	public static final String password = "postgres";
	public static final String schema = "negozio";
	public static final String url = String.format("jdbc:postgresql://localhost:5432/esercizio2204?current"
			+ "schema=%s&user=%s&password=%s", schema, user, password);
	
	public static Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url);
	}

}
