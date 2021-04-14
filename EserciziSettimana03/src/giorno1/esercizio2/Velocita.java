package giorno1.esercizio2;

import java.util.Scanner;

public class Velocita {
	
	public static void main(String[] args){
		
		System.out.println("Calcolo della distanza percorsa e del consumo");
		try {
			calcoloVelocita();
		}
		catch(ArithmeticException a) {
			System.out.println(a.getMessage());
		}
		
	}
	
	public static void calcoloVelocita(){
		Scanner input = new Scanner(System.in);
		System.out.println("Inserire i km percorsi");
		int km = input.nextInt();
		System.out.println("Inserire i litri consumati");
		int litri = input.nextInt();
		input.close();
		if (litri != 0) {
			double rapporto = km/litri;
			System.out.println("Sono stati percorsi " + km + " kilometri e sono stati consumati " + litri + " litri di carburante con un rapporto di: " + rapporto);
		}
		else {
			throw new ArithmeticException("Errore");
		}
	}
	
}