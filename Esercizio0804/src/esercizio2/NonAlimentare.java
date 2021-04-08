package esercizio2;

public class NonAlimentare extends Prodotto {
	
	private CategoriaMerceologica categoriaMerceologica;

	public NonAlimentare(String codiceUnivoco, String descrizioneSintetica, double prezzoUnitario, CategoriaMerceologica categoriaMerceologica) {
		super(codiceUnivoco, descrizioneSintetica, prezzoUnitario);
		this.categoriaMerceologica = categoriaMerceologica;
	}

	public CategoriaMerceologica getCategoriaMerceologica() {
		return categoriaMerceologica;
	}
	
	
	public void confeziona() {
		
	}
	
}
