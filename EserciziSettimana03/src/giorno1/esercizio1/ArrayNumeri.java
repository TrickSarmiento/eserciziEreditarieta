package giorno1.esercizio1;

import java.util.Random;
import java.util.Scanner;

public class ArrayNumeri {
	
	static int[] numeriRandom = new int[5];
	public static void main(String[] args) {
		
		stampaArray(numeriRandom);
		richiestaNumero();
		
	}
	
	public static void stampaArray(int [] array) {
		
		Random r = new Random ();
		for (int i = 0; i < array.length; i++) {	
			array[i] = r.nextInt(10)+1;
			System.out.println(array[i]);
		}
	}
	
	public static void richiestaNumero() {
	
		Scanner input = new Scanner(System.in);	
		System.out.println("Inserisci un numero");
		int valore = input.nextInt();
		System.out.println("Inserisci la posizione in cui vuoi inserire il numero");
		int posizione = input.nextInt();
		input.close();
		if(valore != 0) {
			for (int i = 0; i < numeriRandom.length; i++) {	
			numeriRandom[posizione-1] = valore;
			System.out.println(numeriRandom[i]);
			}
		}
		else {
			throw new ArrayIndexOutOfBoundsException("Sei fuori i limiti dell'array");
		}
		
		
	}

}
