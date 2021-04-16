package giorno3.esercizio2;

import java.util.Random;

/*Scrivere un programma multithread in Java che dato un array di 3000 
 * valori numerici generati casualmente ne esegue la somma in modo parallelo
 * Creare 3 thread e assegnare ad ogni thread una partizione dell’array (1000 valori)
 * Ogni thread esegue la somma dei propri valori e mettere il risultato in una struttura
 * dati del thread main contenente i risultati parziali. Il thread main deve sincronizzarsi
 * sulla terminazione (join) dei thread figli dopodiché somma i risultati parziali e li stampa su console.
 */

public class Start {
	
	public static void main(String[] args) {
		
		int[] arrayNumeri = new int[3000];
		int[] risultato = new int[3];
		totaleNumeri(arrayNumeri);
		
		Esercizio2Thread thread1 = new Esercizio2Thread(arrayNumeri, 0, 0, risultato);
		Esercizio2Thread thread2 = new Esercizio2Thread(arrayNumeri, 1000, 1, risultato);
		Esercizio2Thread thread3 = new Esercizio2Thread(arrayNumeri, 2000, 2, risultato);
		
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		Thread t3 = new Thread(thread3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			System.out.println("La somma dei tre threads è di: " + (risultato[0] + risultato[1] + risultato[2]));
		}
		catch (InterruptedException e) {
			System.out.println("Errore");
		}
		
	}
	
	public static void totaleNumeri (int[] numeri) {
		Random r = new Random();
		int totale = 0;
		for (int i = 0; i < 3000; i++) {
			numeri[i] = r.nextInt();
			totale += numeri[i];
		}
		System.out.println("La somma dei 3000 numeri è: " + totale);
			
		
		
	}

}
