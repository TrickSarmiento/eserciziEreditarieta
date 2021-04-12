package giorno1.eccezioni;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Random;

public class EsempiBaseEccezioni {
	
	public static void main(String[] args) {
		
		System.out.println("Inizio programma.");
		try {
			funzioneUno();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Fine del programma.");
		
	}
	public static void funzioneUno() throws SQLException {
		System.out.println("Inizio della funzione Uno.");
		try {
			funzioneDue();
		}
		catch(FileNotFoundException x) {
			System.out.println("Ho gestito l'eccezione.");
			System.out.println(x.getMessage());
		}
		finally {
			System.out.println("Questo succede sempre.");
		}
//		catch(SQLException s) {
//			System.out.println("Ho gestito l'eccezione.");
//			System.out.println(s.getMessage());
//		}
		System.out.println("Fine della funzione Uno.");
		
	}
	public static void funzioneDue() throws FileNotFoundException, SQLException {
		System.out.println("Inizio della funzione Due.");
		funzioneTre();
		System.out.println("Fine della funzione Due.");
		
	}
	public static void funzioneTre() throws FileNotFoundException, SQLException {
		Random r = new Random();
		int dado = r.nextInt(2);
		if (dado == 0) {
			throw new FileNotFoundException ("File non trovato.");
		}
		else {
			throw new SQLException("Errore SQL.");
		}			
//		System.out.println("Inizio della funzione Tre.");
//		throw new FileNotFoundException ("Messaggio dell'eccezione.");
//		Dopo il lancio dell'eccezione, non arriverà mai alla fine e quindi da "unreachable code"
//		System.out.println("Fine della funzione Tre.");	
		
//		Solo col checked va dichiarato.
	}
}
