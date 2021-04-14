package giorno1.esercizio3;

public class BancaException extends Exception {
	
	private String message;
	
	BancaException (String message) {
		this.message = message;
	}
	
	public String toString() {
		System.out.println("Il prelievo non è disponibile");
		return message;
	}

	public String toString2() {
		System.out.println("Il conto è in rosso");
		return message;
	}
}
