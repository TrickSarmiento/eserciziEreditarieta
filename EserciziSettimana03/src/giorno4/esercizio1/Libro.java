package giorno4.esercizio1;

public class Libro extends ElementoEditoriale {
	
	
	private String autore;
	private String genere;
	
	public Libro(String codiceISBN, String titolo, int annoDiPubblicazione, int numeroPagine, String autore, String genere) {
		super(codiceISBN, titolo, annoDiPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
		
	}

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	public void stampaDettagli() {
		System.out.println(this.getCodiceISBN());
		System.out.println(this.getTitolo());
		System.out.println(this.getAnnoDiPubblicazione());
		System.out.println(this.getNumeroPagine());
		System.out.println(this.autore);
		System.out.println(this.genere);
	}
	
	public String toCSVString() {
		return super.toCSVString() + String.format(",%s,%s", autore, genere);
	}
	

}
