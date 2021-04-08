package esercizio;

import java.time.LocalDate;

public class Lavoratore extends Persona {
	
	private String matricolaLavoratore;
	private String azienda;
	private LocalDate dataAssunzione;
	private StatoLavoratore stato;
	
	public static enum StatoLavoratore {
		IN_ATTIVITA, IN_FERIE, IN_MALATTIA
	}
	
	public Lavoratore (String nome, String cognome, String matricolaLavoratore, String azienda, LocalDate dataAssunzione, StatoLavoratore stato) {
		super(nome, cognome);
		this.matricolaLavoratore = matricolaLavoratore;
		this.azienda = azienda;
		this.dataAssunzione = dataAssunzione;
		this.stato = stato;
	}

	public String infoLavoratore () {
		String dati = info() + " " + matricolaLavoratore + " " + azienda + " " + stato;
		return dati;
	}
	

}
