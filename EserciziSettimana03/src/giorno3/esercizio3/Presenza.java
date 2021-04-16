package giorno3.esercizio3;

public class Presenza {
	
	private String nomeDipendente;
	private int giorniDiPresenza;
	
	public Presenza(String nomeDipendente, int giorniDiPresenza) {
		this.nomeDipendente = nomeDipendente;
		this.giorniDiPresenza = giorniDiPresenza;
		
		
	}

	public String getNomeDipendente() {
		return nomeDipendente;
	}

	public void setNomeDipendente(String nomeDipendente) {
		this.nomeDipendente = nomeDipendente;
	}

	public int getGiorniDiPresenza() {
		return giorniDiPresenza;
	}

	public void setGiorniDiPresenza(int giorniDiPresenza) {
		this.giorniDiPresenza = giorniDiPresenza;
	}

}
