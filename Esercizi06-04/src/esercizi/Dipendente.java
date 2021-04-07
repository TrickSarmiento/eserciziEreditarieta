package esercizi;

public class Dipendente {
	
	static final double stipendioBase = 1000;
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Dipartimento dipartimento;
	private Livello livello;
	private double oreStraordinario = 5;
	
	public static enum Livello {
		OPERAIO, IMPIEGATO, QUADRO, DIRIGENTE
	}
	
	public static enum Dipartimento {
		PRODUZIONE, AMMINISTRAZIONE, VENDITE
	}
	
	public Dipendente (Dipartimento dipartimento, String matricola) {
		stipendio = stipendioBase;
		importoOrarioStraordinario = 30;
		livello = Livello.OPERAIO;
		this.dipartimento = dipartimento;
		this.matricola = matricola;
	}
	
	public Dipendente (Dipartimento dipartimento, String matricola, double stipendio,
			double importoOrarioStraordinario, Livello livello) {
		this.dipartimento = dipartimento;
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
	}
	public double getOreStraordinario() {
		return oreStraordinario;
	}
	public void setOreStraordinario(double oreStraordinario) {
		this.oreStraordinario = oreStraordinario;
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public String getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public Livello getLivello() {
		return livello;
	}
	
	public void stampaDatiDipendente() {
		System.out.println(" Matricola: " + matricola + " " + "Stipendio: " + stipendio + " " + 
				" Importo Orario Straordinario" + importoOrarioStraordinario + " " + 
				" Livello: " + livello + " " + " Dipartimento: "+ dipartimento);
	}
	
	public Livello promuovi() {
		switch (livello) {
		case OPERAIO:
			livello = Livello.IMPIEGATO;
			stipendio = stipendioBase * 1.2;
			break;
		case IMPIEGATO:
			livello = Livello.QUADRO;
			stipendio = stipendioBase * 1.5;
			break;
		
		case QUADRO:
			livello = Livello.DIRIGENTE;
			stipendio = stipendioBase * 2;
			break;
		case DIRIGENTE:
			System.out.println("Non posso promuovere un dirigente.");
			break;
		}
		return livello;
	}
	
	public static double calcolaPaga (Dipendente n1) {
		return n1.stipendio;
	}
	public static double calcolaPaga (Dipendente n2, double ore) {
		double stipendioTotale = n2.stipendio + n2.importoOrarioStraordinario * ore;
		return stipendioTotale;
	}
	public double calcolaPaga (double oreStraordinario, boolean isSimulation) {
		double oreEffettive = 0;
		if (isSimulation == true) {
			oreEffettive = oreStraordinario;
		}
		else {
			oreEffettive = this.oreStraordinario;
		}
		
		double stipendioTotale = this.stipendio + this.importoOrarioStraordinario * oreEffettive;
		return stipendioTotale;
	}
	public static double calcolaStipendioMensile (Dipendente[] staff, double[] oreStraordinario) {
		double stipendioTotale = 0;
		for (int i = 0; i < staff.length; i++) {
			stipendioTotale += staff[i].calcolaPaga(oreStraordinario[i], true);
		}
		return stipendioTotale;
	}
	
	public static double calcolaStipendioMensile (Dipendente[] staff) {
		double stipendioTotale = 0;
		for (int i = 0; i < staff.length; i++) {
			stipendioTotale += staff[i].calcolaPaga(0, false);
		}
		return stipendioTotale;
	}
	
}
