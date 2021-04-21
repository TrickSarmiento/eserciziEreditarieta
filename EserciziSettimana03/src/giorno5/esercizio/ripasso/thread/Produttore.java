package giorno5.esercizio.ripasso.thread;

import java.util.List;
import java.util.Random;

public class Produttore extends Thread {
	
	private List<Integer> array;
	private int somma;
	
	public Produttore (List<Integer> array) {
		this.array = array;
	}

	@Override
	public void run() {
		Random r = new Random();
		for (int i = 0; i < 10; i++) {	
			int n = r.nextInt(101);
			somma += n;
			synchronized(array) {
			array.add(n);
			}
			int time = r.nextInt(5000);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("La somma dei numeri del produttori è %d%n", somma);
	}

}
