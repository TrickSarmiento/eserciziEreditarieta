package esercizio3;

import java.time.LocalDate;

public class Motozappa extends MacchinaConRuote {
	
	private int numeroFrese;

	public Motozappa(int numeroOrdine, String marca, LocalDate dataIngresso, int numeroRuote, int numeroFrese) {
		super(numeroOrdine, marca, dataIngresso, numeroRuote);
		this.numeroFrese = numeroFrese;
	}

	public int getNumeroFrese() {
		return numeroFrese;
	}
	
	

}
