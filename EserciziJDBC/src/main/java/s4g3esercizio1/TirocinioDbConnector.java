package s4g3esercizio1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TirocinioDbConnector {
	private ConnectionHandler ch;
	public TirocinioDbConnector () throws SQLException {
		ch = new ConnectionHandler("localhost:5432/esercizi", "tirocinio", "postgres", "postgres");
	}
	
	
	public List<Object[]> cercaTirocinanti() throws SQLException {
		List<Object[]> tirocinanti = new ArrayList<>();		
		String query = "Select id, nome, cognome, classe from tirocinio.tirocinante";
		PreparedStatement ps = null;
		try {
			Optional<PreparedStatement> ops = ch.getPreparedStatement(query);
			if (ops.isEmpty()) {
				throw new IllegalStateException("Non è stato possibile creare il PreparedStatement, errore sulla connessione");
			}
			ps = ops.get();
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
				Object[] line = new Object[4];
				line[0] = rs.getInt("id");
				line[1] = rs.getString("nome");
				line[2] = rs.getString("cognome");
				line[3] = rs.getString("classe");
				tirocinanti.add(line);
				}
				return tirocinanti;
			}
						
		}
		finally 
		{
			try {
				if (ps != null) {
					ps.close();
				}
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public List<Object[]> cercaTutor () throws SQLException {
		List<Object[]> tutor = new ArrayList<>();
		String query = "Select id, nome, cognome, materia from tirocinio.tutor";
		Optional<PreparedStatement> ops = ch.getPreparedStatement(query);
		if (ops.isEmpty()) {
			throw new IllegalStateException("Non è stato possibile creare il PreparedStatement, errore sulla connesione");
		}
		PreparedStatement ps = ops.get();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Object[] line = new Object[4];
			line[0] = rs.getInt("id");
			line[1] = rs.getString("nome");
			line[2] = rs.getString("cognome");
			line[3] = rs.getString("materia");
			tutor.add(line);
		}
		return tutor;
	}
	
	public void insertTirocinante (int id, int matricola, String nome, String cognome, String classe, int idzienda, int idtutor) throws SQLException {
		String insert = "INSERT INTO tirocinio.tirocinante (id, matricola, nome, cognome, classe, idazienda, idtutor)" + "VALUES (?, ?, ?, ?, ?, ?, ?);";
		Optional<PreparedStatement> ops = ch.getPreparedStatement(insert);
		if (ops.isEmpty()) {
			throw new IllegalStateException("Non è stato possibile creare il PreparedStatement, errore sulla connessione");
		}
		PreparedStatement ps = ops.get();
		ps.setInt(1, id);
		ps.setInt(2, matricola);
		ps.setString(3, nome);
		ps.setString(4, cognome);
		ps.setString(5, classe);
		ps.setInt(6, idzienda);
		ps.setInt(7, idtutor);
		ps.executeUpdate();
	}
	
	public void updateTirocinante (int id, int matricola, String nome, String cognome, String classe, int idzienda, int idtutor) throws SQLException {
		String update = "UPDATE tirocinio.tirocinante matricola = ?, nome = ?, cognome = ?, classe = ?, idazienda = ?, idtutor = ?, WHERE id = ?;";
		Optional<PreparedStatement> ops = ch.getPreparedStatement(update);
		if (ops.isEmpty()) {
			throw new IllegalStateException("Non è stato possibile creare il PreparedStatement, errore sulla connessione");
		}
		PreparedStatement ps = ops.get();
		ps.setInt(1, matricola);
		ps.setString(2, nome);
		ps.setString(3, cognome);
		ps.setString(4, classe);
		ps.setInt(5, idzienda);
		ps.setInt(6, idtutor);
		ps.setInt(7, id);
		ps.executeUpdate();
	}
	
	public void deleteTirocinante (int id) throws SQLException {
		String delete = "DELETE FROM tirocinio.tirocinante WHERE id = ?;";
		Optional<PreparedStatement> ops = ch.getPreparedStatement(delete);
		if (ops.isEmpty()) {
			throw new IllegalStateException("Non è stato possibile creare il PreparedStatement, errore sulla connessione");
		}
		PreparedStatement ps = ops.get();
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public List<Object[]> cercaTirocinantiPerAzienda (String nomeAzienda) throws SQLException {
		List<Object[]> tirocinanti = new ArrayList<>();
		String queryPerAzienda = "SELECT id, nome, cognome, classe FROM tirocinio.tirocinante as tir INNER JOIN tirocinio.azienda as az ON tir.idazienda  = az.id WHERE az.nome = ?";
		Optional<PreparedStatement> ops = ch.getPreparedStatement(queryPerAzienda);
		if (ops.isEmpty()) {
			throw new IllegalStateException("Non è stato possibile creare il PreparedStatement, errore sulla connessione");
		}
		PreparedStatement ps = ops.get();
		ps.setString(1, nomeAzienda);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Object[] lines = new Object [4];
			lines[0] = rs.getInt("id");
			lines[1] = rs.getString("nome");
			lines[2] = rs.getString("cognome");
			lines[3] = rs.getString("classe");	
			tirocinanti.add(lines);
		}
		return tirocinanti;
	
	}
	

}
