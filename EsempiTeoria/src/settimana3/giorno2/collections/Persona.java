package settimana3.giorno2.collections;

import java.time.LocalDate;

public class Persona {
	
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private LocalDate dataDiNascita;
	
	public Persona (String nome, String cognome, String codiceFiscale, LocalDate dataDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataDiNascita = dataDiNascita;
		}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}
	
	
}
