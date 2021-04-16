package giorno2.esercizio3;

public class Start {
	
	public static void main(String[] args) {
		
		Rubrica contatti = new Rubrica();
		
		Persona p1 = new Persona("Acqua", "374 8728283");
		Persona p2 = new Persona("Vento", "375 8945749");
		Persona p3 = new Persona("Fuoco", "379 8723498");
		Persona p4 = new Persona("Terra", "383 8389470");
		Persona p5 = new Persona("Terra", "383 8389470");
		//Se creiamo due Persone con gli stessi dati, il programma li considera diversi
		//perché hanno indirizzi(reference) diversi.
		
		
		contatti.inserisciContatto(p1, p1.getNumeroDiTelefono());
		contatti.inserisciContatto(p2, p2.getNumeroDiTelefono());
		contatti.inserisciContatto(p3, p3.getNumeroDiTelefono());
		contatti.inserisciContatto(p4, p4.getNumeroDiTelefono());
		
		contatti.stampaContatti();
		
		contatti.rimuoviContatto(p2);
		
		contatti.stampaContatti();
		
	//  Questo darebbe null perché nonostante p4 e p5 abbiano gli stessi dat
	//	Sono riconosciute come persone diverse con l'hashcode e p5 non essendo stato inserito
	//  non esiste.
	//	System.out.println(contatti.ricercaConNome(p5));
		System.out.println(contatti.ricercaConNome(p1));
		
		System.out.println(contatti.ricercaConNumero(p3.getNumeroDiTelefono()));
		// Grazie all'override di equals, ora p4 e p5 sono uguali grazie ai loro valori.
		System.out.println(p4 .equals(p5));
		// Però hanno comunque hashcode diversi. 
		// Andare su Persona per vedere l'override dell'Hashcode che li rende uguali.
		System.out.println(p4.hashCode());
		System.out.println(p5.hashCode());
	}
	
	
}
