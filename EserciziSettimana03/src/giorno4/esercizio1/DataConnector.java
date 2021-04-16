package giorno4.esercizio1;

import java.io.IOException;
import java.util.List;

public interface DataConnector {
	
	List<ElementoEditoriale> caricaElementi() throws IOException;
	
	void salvaPubblicazioni (List<ElementoEditoriale> e) throws IOException;
}
