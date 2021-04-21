package esercizioStream;

import java.time.LocalDate;

public class Cliente {
	
	private String matricola;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String sesso;
	
	public Cliente(String matricola, String nome, String cognome, LocalDate dataNascita, String sesso) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
	

}
