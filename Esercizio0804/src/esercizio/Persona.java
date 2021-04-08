package esercizio;

public class Persona {
	
	protected String nome;
	protected String cognome;
	
	public Persona (String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public String info () {
		String dati = nome + " " + cognome;
		return dati;
	}

}
