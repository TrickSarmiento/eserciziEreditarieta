package giorno4.esercizio1;

public abstract class ElementoEditoriale {
	
	private String codiceISBN;
	private String titolo;
	private int annoDiPubblicazione;
	private int numeroPagine;
	
	public ElementoEditoriale(String codiceISBN, String titolo, int annoDiPubblicazione, int numeroPagine) {
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoDiPubblicazione = annoDiPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public String getCodiceISBN() {
		return codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getAnnoDiPubblicazione() {
		return annoDiPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public abstract void stampaDettagli();
	
	//Con get.Class() ad ogni riga prima dei dettagli avremo la classe mentre con 
	//get.SimpleName() avremo il nome della classe ma senza il package.
	public String toCSVString() {	
		return String.format("%s,%s,%s,%d,%d",this.getClass().getSimpleName(), codiceISBN, titolo, annoDiPubblicazione, numeroPagine);
	}
	// Partire dalla stringa per ottenere l'oggetto.
	//Creiamo un array di stringhe che divide lines tra le virgole.
	//Poi se il primo valore dell'array è Libro allora ritorna il libro con i valori con String convertito in Integer quando serve.
	//e con periodicita.valueof convertiamo la stringa in periodicita.
	public static ElementoEditoriale parse (String lines) {
		String[] tokens = lines.split(",");
		if (tokens[0].equals("Libro")) {
			return new Libro(tokens[1], tokens[2], Integer.parseInt(tokens[3]) , Integer.parseInt(tokens[4]), tokens[5], tokens[6]);
		}
		else {
			return new Rivista(tokens[1], tokens[2], Integer.parseInt(tokens[3]) , Integer.parseInt(tokens[4]), Periodicita.valueOf(tokens[5]));
		}
	}
}
