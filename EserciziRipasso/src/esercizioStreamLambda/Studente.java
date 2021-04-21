package esercizioStreamLambda;

import java.time.LocalDate;

//Lo studente ha nome, cognome, sesso, data di nascita e corsodi studi

public class Studente {
	
	private String nome;
	private String cognome;
	private Sesso sesso;
	private LocalDate dataNascita;
	private CorsoDiStudio corso;
	
	public Studente(String nome, String cognome, Sesso sesso, LocalDate dataNascita, CorsoDiStudio corso) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		this.corso = corso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public CorsoDiStudio getCorso() {
		return corso;
	}

	public void setCorso(CorsoDiStudio corso) {
		this.corso = corso;
	}
	
	
	

}
