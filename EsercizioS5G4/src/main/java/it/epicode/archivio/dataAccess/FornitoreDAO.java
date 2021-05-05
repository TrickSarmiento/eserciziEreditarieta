package it.epicode.archivio.dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.epicode.archivio.model.Fornitore;

public class FornitoreDAO implements AbstractFornitoreDAO{

	public static final String LISTA_FORNITORI = "SELECT codice_fornitore, nome, indirizzo, citta FROM negozio.fornitore";	
	@Override
	public List<Fornitore> listaFornitori() throws SQLException {
		
		List<Fornitore> lista = new ArrayList<>();

		try (Connection connect = ConnectionUtils.createConnection();
				Statement st = connect.createStatement();
				ResultSet rs = st.executeQuery(LISTA_FORNITORI)) {
			while (rs.next()) {
				Fornitore f = new Fornitore(rs.getInt("codice_fornitore"), rs.getString("nome"),
						rs.getString("indirizzo"), rs.getString("citta"));
				lista.add(f);
			}
			return lista;
		}

	}

	public static final String AGGIUNGI_FORNITORE = "INSERT INTO negozio.fornitore (codice_fornitore, nome, indirizzo, citta) VALUES (?, ?, ?, ?)";
	@Override
	public void aggiungiFornitore(Fornitore f) throws SQLException {
		
		try (Connection connect = ConnectionUtils.createConnection();
				PreparedStatement ps = connect.prepareStatement(AGGIUNGI_FORNITORE)) {
			ps.setInt(1, f.getCodiceFornitore());
			ps.setString(2, f.getNome());
			ps.setString(3, f.getIndirizzo());
			ps.setString(4, f.getCitta());
			ps.executeUpdate();
		}
		
	}

	public static final String EDIT_FORNITORE = "UPDATE negozio.fornitore SET nome = ?, indirizzo = ?, citta = ? WHERE codice_fornitore = ?";

	@Override
	public void modificaFornitore(Fornitore f) throws SQLException {
		 
		try (Connection connect = ConnectionUtils.createConnection();
				PreparedStatement ps = connect.prepareStatement(EDIT_FORNITORE)) {
			ps.setString(1, f.getNome());
			ps.setString(2, f.getIndirizzo());
			ps.setString(3, f.getCitta());
			ps.setInt(4, f.getCodiceFornitore());
			ps.executeUpdate();
		}
		
	}
	public static final String DELETE_FORNITORE = "DELETE FROM negozio.fornitore WHERE codice_fornitore = ?;";
	@Override
	public void eliminaFornitore(Fornitore f) throws SQLException {
		
		try (Connection connect = ConnectionUtils.createConnection();
				PreparedStatement ps = connect.prepareStatement(DELETE_FORNITORE)) {
			ps.setInt(1, f.getCodiceFornitore());
			ps.executeUpdate();
		}
		
	}
	
	
	
}
