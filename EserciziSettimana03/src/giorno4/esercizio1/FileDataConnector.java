package giorno4.esercizio1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class FileDataConnector implements DataConnector {

	private String path;
	
	public FileDataConnector(String path) {
		this.path = path;
	}

	@Override
	public List<ElementoEditoriale> caricaElementi() throws IOException {
		File f = new File(path);
//Facciamo uno stream di lines e le mappiamo per trasformare la stringa
//in elemento editoriale e poi la mettiamo nella lista.
		List<String> lines = FileUtils.readLines(f, "UTF-8");	
//		return lines.stream().map(l -> ElementoEditoriale.parse(l))
//							 .collect(Collectors.toList());
		
//method reference, dare l'indirizzo di un metodo.		
//Se la lambda prende l'input e lo passa alla funzione, è meglio dare il nome della
//funzione a cui passare l'input con ::
		return lines.stream().map(ElementoEditoriale::parse)
								.collect(Collectors.toList());
	}


	@Override
	public void salvaPubblicazioni(List<ElementoEditoriale> e) throws IOException {
		File f = new File(path);
		
	    List<String> lines = e.stream()
	    					.map(p -> p.toCSVString()) // .map(ElementoEditoriale::toCSVString())
	    					.collect(Collectors.toList());
	    
	    FileUtils.writeLines(f, "UTF-8", lines);
	
	}
	
	
}
