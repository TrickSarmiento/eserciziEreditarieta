package esercizio2;

import java.time.LocalDate;

public class Alimentare extends Prodotto {

	private LocalDate dataDiScadenza;
	private boolean vegano;
	
	public Alimentare (String codiceUnivoco, String descrizioneSintetica, double prezzoUnitario, LocalDate dataDiScadenza, boolean vegano) {
		super(codiceUnivoco, descrizioneSintetica, prezzoUnitario);
		this.dataDiScadenza = dataDiScadenza;
		this.vegano = vegano;
	}

	public LocalDate getDataDiScadenza() {
		return dataDiScadenza;
	}

	public void setDataDiScadenza(LocalDate dataDiScadenza) {
		this.dataDiScadenza = dataDiScadenza;
	}

	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}
//  Annotazioni che vengono lette dal compilatore e non dalla jvm.
//  Documentazione del codice, evita fare errori (riguardo le maiuscole).
//		
	@Override
	public void confeziona() {
		
	}
	
}
