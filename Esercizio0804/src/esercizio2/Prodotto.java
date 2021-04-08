package esercizio2;
// Con abstract sarà impossibile istanziare oggetti di classe Prodotto.
public abstract class Prodotto {
	
	protected String codiceUnivoco;
	protected String descrizioneSintetica;
	protected double prezzoUnitario;
	
	public Prodotto (String codiceUnivoco, String descrizioneSintetica, double prezzoUnitario) {
		this.codiceUnivoco = codiceUnivoco;
		this.descrizioneSintetica = descrizioneSintetica;
		this.prezzoUnitario = prezzoUnitario;
	}
	
	public abstract void confeziona();
	
	public void applicaSconto () {
		prezzoUnitario -= prezzoUnitario*0.05;
	}
	
	public String datiProdotto () {
		String dati = codiceUnivoco + " " + descrizioneSintetica + " " + " " + prezzoUnitario;
		return dati;
	}

	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}

	public void setCodiceUnivoco(String codiceUnivoco) {
		this.codiceUnivoco = codiceUnivoco;
	}

	public String getDescrizioneSintetica() {
		return descrizioneSintetica;
	}

	public void setDescrizioneSintetica(String descrizioneSintetica) {
		this.descrizioneSintetica = descrizioneSintetica;
	}

	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	

}
