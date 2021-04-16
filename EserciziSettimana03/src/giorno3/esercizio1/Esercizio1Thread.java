package giorno3.esercizio1;

/* Creare un’applicazione con due thread figli. Ciascuno dei due thread
 * ha associato un simbolo (ad es. * o #). Fare in modo che ciascun thread
 * stampi su console il proprio simbolo per 10 volte, attendendo 1 secondo
 * tra una stampa e l'altra. */


public class Esercizio1Thread implements Runnable {
	
	private String simbolo;
	
	public Esercizio1Thread (String simbolo) {
		this.simbolo = simbolo;
		
	}
	
	public void run() {
		try {
			for (int i = 0; i <= 10; i++) {
				Thread.sleep(1000);
				System.out.println(simbolo);
			}
				
		}
		catch (InterruptedException e) {
			System.out.println("Errore");
		}
	}
	
}
