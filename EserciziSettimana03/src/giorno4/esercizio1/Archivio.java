package giorno4.esercizio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Archivio {
	
	private Map<String, ElementoEditoriale> archivio; // = new HashMap<>(); 
	// Non serve inizializzarla vuota dato che poi la assegnamo sotto in linea 24.
	
	private DataConnector sorgente = new FileDataConnector("Dati.txt");
	
	public Archivio() throws IOException {
	// Qui andremo a leggere i dati da file e popoleremo la mappa archivio.	
		List<ElementoEditoriale> pubblicazioni = sorgente.caricaElementi();
	//Ciclo ogni elemento nella lista pubblicazioni e poi li aggiungo all'archivio.
	//	for (ElementoEditoriale e : pubblicazioni) {
	//		archivio.put(e.getCodiceISBN(), e);
	//	}
	//Con uno stream di pubblicazioni inserisco gli elementi nella mappa prendendo la chiave e il valore.
		archivio = pubblicazioni.stream()
					  .collect(Collectors.toMap(ElementoEditoriale :: getCodiceISBN, e -> e));
	}
	
	//Map ha put mentre Set e List hanno add. Con il Map si usa sia il chiave e valore quindi
	//chiave: nome.getChiave, valore: nome;
	public void addItem(ElementoEditoriale newItem) {
		archivio.put(newItem.getCodiceISBN(), newItem);
	}
	
	// Non serve ciclare perché il codiceISBN è la chiave.
	public void removeItem(String codISBN) {
		archivio.remove(codISBN);
	}
	
	public ElementoEditoriale searchByISBN (String codISBN) {
		return archivio.get(codISBN);
	}
	
	//Dato che l'anno non è il codice, creiamo una lista dei libri di quell'anno, 
	//poi ciclo tutti gli elementi e tra l'archivio e aggiungo alla lista ogni elemento di quell'anno.
	public List<ElementoEditoriale> searchByYear (int year) {
		List<ElementoEditoriale> result = new ArrayList<>();
		for (ElementoEditoriale e : archivio.values()) {
			if ( e.getAnnoDiPubblicazione() == year) {
				result.add(e);
			}
			
		}
		return result;
	}
	
	//Facciamo uno stream dei libri in archivio, poi li filtriamo in base all'anno inserito.
	//Lo stream fa il for, p -> p è come se fosse una if.
	public List<ElementoEditoriale> searchByYearJ8(int anno) {
		
		List<ElementoEditoriale> result = archivio.values().stream()
															.filter(p -> p.getAnnoDiPubblicazione() == anno)
															.collect(Collectors.toList());
		return result;
	}
	
	// Questo essendo quasi uguale alla ricerca per anno è un metodo quasi uguale ma con il
	// Downcasting in quanto non tutti gli elementi editoriali hanno un autore.
	//Downcast con instanceof e ((Libro) e).
	public List<ElementoEditoriale> searchByAuthor (String autore) {
		List<ElementoEditoriale> result = new ArrayList<>();
		for (ElementoEditoriale e : archivio.values()) {		
			if (e instanceof Libro && ((Libro) e).getAutore().equals(autore)) {
				result.add(e);
			}
			
		}
		return result;
	}
	
	//Stream degli elementi editoriale, li filtro se l'elemento è un libro e poi in base all'autore.
	public List<ElementoEditoriale> searchByAuthorJ8 (String autore) {
		return archivio.values().stream()
								.filter(elem -> elem instanceof Libro && ((Libro)elem).getAutore().equals(autore))
								.collect(Collectors.toList());
	}
	
	
	//Creo un array list in cui salvo i valori dell'archivio(mappa) con il metodo salvaPubblicazioni.
	public void salvaSuFile() throws IOException {
		List<ElementoEditoriale> pubblicazioni = new ArrayList<>(archivio.values());
		sorgente.salvaPubblicazioni(pubblicazioni);
	}
	
	public void stampaPubblicazioni() {
		for (ElementoEditoriale e : archivio.values()) {
			System.out.printf("Tipo: %s, ISBN: %s, Titolo: %s%n", e.getClass().getSimpleName(), e.getCodiceISBN(), e.getTitolo());
		}
	}

}
