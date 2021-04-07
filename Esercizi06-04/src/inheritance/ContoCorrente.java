package inheritance;

public class ContoCorrente {

	protected double saldo; //Protected: visibilità nelle classi e sottoclassi.
	
	public ContoCorrente(double saldo) {
		this.saldo = saldo;
	}
//	public ContoCorrente() {
		
//	}
	public double getSaldo() {
		return saldo;
	}
	public double deposita(double deposito) {
		saldo += deposito;
		return saldo;
	}
	public double ritira(double ritiro) {
		saldo -= ritiro;
		return saldo;
	}
	
}
