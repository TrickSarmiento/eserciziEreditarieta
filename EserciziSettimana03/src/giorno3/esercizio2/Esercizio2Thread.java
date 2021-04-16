package giorno3.esercizio2;

public class Esercizio2Thread implements Runnable {
	
	private int[] numeri;
	private int start;
	private int posizione;
	private int[] risultati;
	
	public Esercizio2Thread(int[] numeri, int start, int posizione, int[] risultati) {
		this.numeri = numeri;
		this.start = start;
		this.posizione = posizione;
		this.risultati = risultati;
	}

	@Override
	public void run() {
		int totale = 0;
		for (int i = start; i < start + 1000; i++) {
			totale += numeri[i];
		}
		risultati[posizione] = totale;
		System.out.println("La somma del thread è: " + totale);
	}

}
