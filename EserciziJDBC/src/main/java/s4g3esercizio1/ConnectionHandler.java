package s4g3esercizio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectionHandler {
	
	private String dbUrl;
	private String schema;
	private String utente;
	private String password;
	private Connection connection;
	
	//Dopo aver definito i parametri, creo l'url usando i parametri.
	public ConnectionHandler(String dbUrl, String schema, String utente, String password) throws SQLException {
		this.dbUrl = dbUrl;
		this.schema = schema;
		this.utente = utente;
		this.password = password;
		this.connection = DriverManager.getConnection(String.format
				("jdbc:postgresql://%s?currentschema=%s&user=%s&password=%s",
						dbUrl, schema, utente, password));
	}
	
	public Connection getConnection() throws SQLException {
		if (this.connection == null || this.connection.isClosed()) {
			this.connection = DriverManager.getConnection(String.format
					("jdbc:postgresql://%s?currentschema=%s&user=%s&password=%s",
							dbUrl, schema, utente, password));
		}
		return this.connection;
	}
	
	public void closeConnection() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
	// Utilizzo dell'optional, in modo che se la connessione è chiusa ritorna l'optional vuoto, altrimenti l'optional di ps.
	public Optional<PreparedStatement> getPreparedStatement (String query) throws SQLException {
		if (connection == null || connection.isClosed()) {
			return Optional.empty();
		}
		PreparedStatement ps = connection.prepareStatement(query);
		return Optional.of(ps);
	}
}
