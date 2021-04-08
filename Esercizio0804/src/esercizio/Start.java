package esercizio;
 
import java.time.LocalDate;

import esercizio.Lavoratore.StatoLavoratore;
import esercizio.Studente.StatoStudente;

public class Start {
	
	public static void main(String[] args) {
		Persona p1 = new Persona("Ciao", "Bello");
		String persona = p1.info();
		System.out.println(persona);
		
		Studente s1 = new Studente("Bello", "Ciao", 123, "Medico", StatoStudente.FUORI_CORSO);
		String studente = s1.infoStudente();
		System.out.println(studente);
		
		Lavoratore l1 = new Lavoratore("Ciao", "Brutto", "abc", "Nokia", LocalDate.now(), StatoLavoratore.IN_ATTIVITA);
		String lavoratore = l1.infoLavoratore();
		System.out.println(lavoratore);
				
	}

}
