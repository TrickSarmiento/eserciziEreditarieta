package esercizio;

public class Studente extends Persona {
	
	private int matricolaStudente;
	private String corsoDiLaurea;
	private StatoStudente stato;
	
	public static enum StatoStudente {
		IN_CORSO, FUORI_CORSO, LAUREATO, INTERROTTO
		}
	
	public Studente (String nome, String cognome, int matricolaStudente, String corsoDiLaurea, StatoStudente stato ) {
		super(nome, cognome);
		this.matricolaStudente = matricolaStudente;
		this.corsoDiLaurea = corsoDiLaurea;
		this.stato = stato;
		
	}

	public String infoStudente () {
		String dati = info() + " " + matricolaStudente + " " + corsoDiLaurea + " " + stato;
		return dati;		
	}

}
