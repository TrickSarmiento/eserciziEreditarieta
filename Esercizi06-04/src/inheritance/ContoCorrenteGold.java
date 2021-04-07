package inheritance;

public class ContoCorrenteGold extends ContoCorrente {
	// I costruttori non vengono ereditati, il costruttore di classe figlia prima deve
	// invocare il costruttore della classe madre.
	
	private String codiceSegreto;
	
	public ContoCorrenteGold(double saldo, String codiceSegreto) {
		super(saldo);
		this.codiceSegreto = codiceSegreto;
		// Le variabili della classe figlia vanno inizializzate nella classe figlia, quelle
		// della madre vanno richiamate con il costruttore della classe madre.
	}
	public double bonifica (double ammontare, ContoCorrente destinazione) {
		saldo -= ammontare;
		destinazione.saldo += ammontare;
		return saldo;
	}
	public double deposita (double deposito) {
//		saldo += deposito + 1;
		super.deposita(deposito);
//		Nella riga implementata stiamo reimplementando il metodo da zero.
//		L'alternativa è reinvocare il metodo della madre e poi eseguire le modifiche.
		saldo += 1;
		return saldo;
	}
	public boolean confrontaCodiceSegreti (ContoCorrenteGold target) {
		if (target.codiceSegreto.length() > this.codiceSegreto.length()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
