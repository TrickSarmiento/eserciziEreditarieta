package esercizio3;

import java.time.LocalDate;

public abstract class MacchinaConRuote extends MacchinaAgricola {
	
	protected int numeroRuote;

	public MacchinaConRuote(int numeroOrdine, String marca, LocalDate dataIngresso, int numeroRuote) {
		super(numeroOrdine, marca, dataIngresso);
		this.numeroRuote = numeroRuote;
	}

	public int getNumeroRuote() {
		return numeroRuote;
	}

}
