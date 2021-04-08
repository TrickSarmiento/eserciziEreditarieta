package esercizio3;

import java.time.LocalDate;

public class Decespugliatore extends MacchinaAgricola {

	public boolean accensioneElettronica;

	public Decespugliatore(int numeroOrdine, String marca, LocalDate dataIngresso, boolean accensioneElettronica) {
		super(numeroOrdine, marca, dataIngresso);
		this.accensioneElettronica = accensioneElettronica;
	}

	public boolean isAccensioneElettronica() {
		return accensioneElettronica;
	}
	
	
	
	
	
}
