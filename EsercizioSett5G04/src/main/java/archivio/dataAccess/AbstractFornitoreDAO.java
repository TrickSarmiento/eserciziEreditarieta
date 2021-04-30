package archivio.dataAccess;

import java.sql.SQLException;
import java.util.List;

import archivio.model.Fornitore;

public interface AbstractFornitoreDAO {
	
	List<Fornitore> listaFornitori () throws SQLException;
	
	void aggiungiFornitore(Fornitore f) throws SQLException;
	
	void modificaFornitore(Fornitore f) throws SQLException;
	
	void eliminaFornitore(Fornitore f) throws SQLException;

}
