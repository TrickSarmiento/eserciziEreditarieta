package settimana3.giorno2.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EsempiCollections {

	public static void main(String[] args) {
		
		Set<String> frasi = new HashSet<>();
		//Aggiunta frasi.
		//Se Ciao Bello l'avessi messo due volte non me lo avrebbe aggiunto.
		frasi.add("Ciao");
		frasi.add("Buongiorno");
		frasi.add("Ciao bello");
		//Stampa della dimensione del set.
		System.out.println(frasi.size());
		//For each, ogni stringa del set frasi.
		for (String s : frasi) {
			System.out.println(s);
			
		}
		
		List<String> listaFrasi = new ArrayList<>();
		//Nonostante "Ciao" sia ripetuto, la lista lo conta
		//perché a differenza del set, la list accetta duplicati.
		listaFrasi.add("Ciao");
		listaFrasi.add("Buongiorno");
		listaFrasi.add("Ciao");
		System.out.println(listaFrasi.size());
		for (String s : listaFrasi) {
			System.out.println(s);
			
		}
		//Ciclo alternativo.
		for (int i = 0; i < listaFrasi.size(); i++) {
			System.out.println(listaFrasi.get(i));
		}	
		//L'iterator è un oggetto che mi da gli elementi di una collection
		//in maniera sequenziale attraverso il metodo next.
		
		//Inizializzo l'iteratore con l'iterator di listaFrasi.
		//it.hasNext(); è la condizione booleana che guarda se ci sta un next.
		//Ciclo con l'iterator che mi da tutti gli elementi della lista frasi.
		//listaFrasi.iterator equivale alla prima posizione
		for (Iterator<String> it = listaFrasi.iterator(); it.hasNext();) { 
			String s = it.next();
			System.out.println(s);
		//it.getClass stampa la classe dell'iteratore.
			System.out.println(it.getClass().getSimpleName());
		}
		
		List<String> listaLinkataFrasi = new LinkedList<>();
		//la LinkedList è il contrario dell'ArrayList, non sono collegati ma
		//ogni elemento ha l'indirizzo del prossimo come una catena. Però il primo
		//non è collegato al terzo, ecc..
		listaLinkataFrasi.add("Ciao");
		listaLinkataFrasi.add("Buongiorno");
		listaLinkataFrasi.add("Ciao");
		System.out.println(listaLinkataFrasi.size());
		//Con la LinkedList il ciclo classico porta a molte più operazioni perché
		//ad ogni incremento deve partire dal primo. 
		for (int i = 0; i < listaLinkataFrasi.size(); i++) {
			System.out.println(listaLinkataFrasi.get(i));
		}
		for (String x : listaLinkataFrasi) {
			System.out.println(x);
		}
		//Con l'iteratore invece si ricorda dell'ultimo che ha analizzato e passa al prossimo.
		for (Iterator<String> it2 = listaLinkataFrasi.iterator(); it2.hasNext();) {
			String y = it2.next();
			System.out.println(y);
		//Stampa anche la classe di appartenenza dell'iteratore.
			System.out.println(it2.getClass().getSimpleName());
		}
		
		Map <String, Persona> registro = new HashMap <>();
		//Creazione di Persona.
		Persona p1 = new Persona("Carlo", "Rosso", "abcde", LocalDate.of(1980, 8, 20));
		Persona p2 = new Persona("Paul", "Phoenix", "fghij", LocalDate.of(1990, 10, 10));
		//Inserimento delle persone nella mappa.
		registro.put(p1.getCodiceFiscale(), p1);
		registro.put(p2.getCodiceFiscale(), p2);
		//Recupero nella mappa il codice fiscale "abcde".
		Persona p = registro.get("abcde");
		//Se lo trova, stampa il nome della persona.
		if (p != null) {
			System.out.println(p.getNome());
		}
		//Creazione di persona con Codice Fiscale già esistente.
		Persona p3 = new Persona("Rosso", "Blu", "abcde", LocalDate.of(1999, 5, 5));
		//Controllo se nel registro è presente quel codice fiscale.
		boolean isPresent = registro.containsKey("abcde");
		System.out.println(isPresent);
		//Sostituzione nella mappa di Carlo con Mark e nella old ci ritorna Carlo.
		Persona old = registro.put(p3.getCodiceFiscale(), p3);
		System.out.println(old.getNome());
		//Stampa delle chiavi e del nome delle persone. Le chiavi sono in un set perché non hanno duplicati. 
		for (String chiave : registro.keySet()) {
			System.out.println(chiave);
			Persona x = registro.get(chiave);
			System.out.println(x.getNome());
		}
		//Stampa di valori precisi, in questo caso il cognome, ignorando le chiavi.
		for (Persona pe : registro.values()) {
			System.out.println(pe.getCognome());
		}
		//Accesso a tutte le chiavi e a tutti valori della mappa in maniera efficiente.
		//E' più efficiente del primo che fa più ricerche.
		//Map.Entry prende coppie di chiavi valori. In questo caso chiave Stringa e Persona.
		//Ogni coppia nel registro.
		for (Map.Entry<String, Persona> coppia : registro.entrySet()) {
			System.out.println(coppia.getKey());
			System.out.println(coppia.getValue().getNome());
		}
		
	}

}
