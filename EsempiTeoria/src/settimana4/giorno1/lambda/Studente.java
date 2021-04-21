package settimana4.giorno1.lambda;

import java.time.LocalDate;

public class Studente implements Comparable<Studente> {
	
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	
	public Studente(String nome, String cognome, LocalDate dataDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	@Override
	public int compareTo(Studente o) {
		return (this.getCognome().length() - o.getCognome().length());
		
//		if (this.getCognome().length() > o.getCognome().length()) {
//			return 1;
//		}
//		else if (this.getCognome().length() < o.getCognome().length()) {
//			return -1;
//		}
//		else {
//			
//		}
//		return 0;
		
	}
	
	public String toString() {
		return String.format("Nome: %s, Cognome: %s, Data di Nascita: %s", nome, cognome, dataDiNascita);
	}
	
	
	
	

}
