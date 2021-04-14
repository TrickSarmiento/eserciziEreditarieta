package giorno2.esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Esercizio1 {
	public static void main(String[] args) {
		
		esercizio();
		
	}
	public static void esercizio () {
		
		System.out.println("Dimmi quante parole vuoi inserire");
		Scanner input = new Scanner(System.in);
	//Si decide la dimensione del set.
		int numero = input.nextInt();
		input.nextLine();
	//Creazione di due set.
		Set<String> paroleDistinte = new HashSet<>();
		Set<String> paroleDuplicate = new HashSet<String>();
	//Inserimento della parola, se già presente va nel set duplicate, altrimenti va nell'altro.
		for (int i = 0; i < numero; i++) {
			System.out.println("Inserisci una nuova parola");
			String parola = input.nextLine();
		
			boolean hoInserito = paroleDistinte.add(parola);
		
			if (! hoInserito) {
			paroleDuplicate.add(parola);
			}
		}
	//Rimozione delle parole duplicate dal set parole distinte.
		paroleDistinte.removeAll(paroleDuplicate);
	
		System.out.println("Parole duplicate");
	
		for (String d : paroleDuplicate) {
			System.out.println(d);
		}
	
		System.out.println("Parole distinte");
		for (String c : paroleDistinte) {
			System.out.println(c);
		}
	
		System.out.println("Il numero delle parole distinte è: " + paroleDistinte.size());
		input.close();
	}
}
	



