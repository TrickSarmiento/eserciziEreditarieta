package esercizio3;

import java.time.LocalDate;

public abstract class MacchinaAgricola {
	
	protected int numeroOrdine;
	protected String marca;
	protected LocalDate dataIngresso;
	
	public MacchinaAgricola (int numeroOrdine, String marca, LocalDate dataIngresso) {
		this.numeroOrdine = numeroOrdine;
		this.marca = marca;
		this.dataIngresso = dataIngresso;
	}
	
	protected Lavorazione[] lavorazioni = new Lavorazione[10];
	protected int numeroLavorazioni;
	
	public double costoRiparazione() {
		double costo = 0;
		for (int i = 0; i < numeroLavorazioni; i++) {
			costo += lavorazioni[i].getCosto();
			
		}
		return costo;
	}
	
	public LocalDate getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(LocalDate dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public int getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}


}
