package giorno5.esercizio.ripasso.thread;

import java.util.ArrayList;
import java.util.List;

//Array List di Integer, 2 thread hanno accesso (produttore e consumatore)
//Per 100 volte il produttore rimane in sleep per 0/10 secondi e poi inserirà un num random
//nell'array list, la seconda anche lei sleep e poi toglierà l'ultimo elemento
//dell'array list, se l'array è vuoto stampa che è vuoto, altrimenti prende l'elemento e se lo somma
//fino a raggiungere 10 elementi.
public class Esercizio {
	
	public static void main(String[] args) {
	
		List<Integer> listaInteri = new ArrayList<>();
		Thread produttore = new Produttore(listaInteri);
		ConsumatoreRunnable c1 = new ConsumatoreRunnable(listaInteri);
		Thread consumatore = new Thread(c1);

// 		Possibilità di creare direttamente un runnable con la lambda senza la classe Runnable	
//		Si sarebbe creata una classe interna anonima, avrebbe implementato il runnable.		

//		Thread consumatore = new Thread(() -> {
			//Qui ci sarebbe stato il body di Runnable.
//		});
		
		produttore.start();
		consumatore.start();
		
	}

}
