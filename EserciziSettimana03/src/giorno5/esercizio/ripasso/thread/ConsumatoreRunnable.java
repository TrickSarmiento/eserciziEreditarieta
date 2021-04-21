package giorno5.esercizio.ripasso.thread;

import java.util.List;
import java.util.Random;

public class ConsumatoreRunnable implements Runnable {
	
	private List<Integer> array;
	private int somma;
	
	public ConsumatoreRunnable(List<Integer> array) {
		this.array = array;
	}

	//Con synchronized solo uno dei due può operare con la chiave custodita dall'array.
	//Che ha le chiave perché è l'oggetto che stiamo proteggendo.
	@Override
	public void run() {
		Random r = new Random();
		for (int i = 0; i < 10;) {
			int time = r.nextInt(5000);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(array) {
				if(array.isEmpty()) {
					System.out.println("Mannaggia, il produttore dorme ancora!");
				}
				else {
					int last = array.remove(array.size()-1);
					somma += last;
					i++;
				}
			}
		}
		System.out.println("La somma dei numeri consumati è: " + somma);
		
	}

}
