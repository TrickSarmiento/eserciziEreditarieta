package giorno2.esercizio3;

public class Start {
	
	public static void main(String[] args) {
		
		Rubrica contatti = new Rubrica();
		
		numeroTelefonico p1 = new numeroTelefonico("Acqua", "374 8728283");
		numeroTelefonico p2 = new numeroTelefonico("Vento", "375 8945749");
		numeroTelefonico p3 = new numeroTelefonico("Fuoco", "379 8723498");
		numeroTelefonico p4 = new numeroTelefonico("Terra", "383 8389470");
		
		contatti.inserisciContatto(p1.getNomeProprietario(), p1.getNumeroDiTelefono());
		contatti.inserisciContatto(p2.getNomeProprietario(), p2.getNumeroDiTelefono());
		contatti.inserisciContatto(p3.getNomeProprietario(), p3.getNumeroDiTelefono());
		contatti.inserisciContatto(p4.getNomeProprietario(), p4.getNumeroDiTelefono());
		
		contatti.stampaContatti();
		
		contatti.rimuoviContatto(p2.getNomeProprietario());
		
		contatti.stampaContatti();
		
		
		String nome = contatti.ricercaConNome(p1.getNomeProprietario());
		System.out.println(nome);
		
		String numero = contatti.ricercaConNumero(p3.getNumeroDiTelefono());
		System.out.println(numero);
	}
	
	
}
