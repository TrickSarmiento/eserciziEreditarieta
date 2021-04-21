package giorno5.esercizio.ripasso.stream;

//La classe impiegato ha nome, cognome, sesso e stipendio.
//Creazione lista di 3/4 impiegati. Somma di stipendi di tutti gli impiegati.
//Minimo stipendio dei maschi e massimo delle femmine. (min m < max f).
//String di tutti i nomi degli impiegati.

public class Impiegato {
	
	private String nome;
	private String cognome;
	private String sesso;
	private double stipendio;
	
	public Impiegato (String nome, String cognome, String sesso, double stipendio) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.stipendio = stipendio;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public double getStipendio() {
		return stipendio;
	}

	
}
