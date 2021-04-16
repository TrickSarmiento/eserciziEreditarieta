package giorno4.esercizio1;

public class Rivista extends ElementoEditoriale {

	private Periodicita periodicita;
	
	public Rivista(String codiceISBN, String titolo, int annoDiPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(codiceISBN, titolo, annoDiPubblicazione, numeroPagine);
		this.periodicita = periodicita;
		
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public String toCSVString() {
		return super.toCSVString() + String.format(",%s", periodicita);
 	}

	@Override
	public void stampaDettagli() {
		System.out.println(this.getCodiceISBN());
		System.out.println(this.getTitolo());
		System.out.println(this.getAnnoDiPubblicazione());
		System.out.println(this.getNumeroPagine());
		System.out.println(this.periodicita);
	}

}
