package settimana4.giorno1.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EsempiLambda {
	
	public static void main(String[] args) {
		
		List<Integer> lista = new ArrayList<>();
		
		lista.add(27);
		lista.add(24);
		lista.add(49);
		
		Collections.sort(lista);		
		System.out.println(lista);
		
		
		List<Studente> listaStudenti = new ArrayList<>();
		
		listaStudenti.add(new Studente("Wade", "Wilson", LocalDate.of(1990, 04, 15)));
	//*	Studente y = new Studente("Peter", "Parker", LocalDate.of(1995, 05, 12));
		listaStudenti.add(new Studente("Peter", "Parker", LocalDate.of(1995, 05, 12)));
		listaStudenti.add(new Studente("Steve", "Rogers", LocalDate.of(1965, 03, 10)));
		
		Collections.sort(listaStudenti);
		System.out.println(listaStudenti.toString());
		
	// Implementa un'interfaccia.	
		Comparator<Studente> comp = new ComparatoreStudentiPerEta();
	// Passo l'oggetto che implementa Comparator dato che non posso passare la funzione.
		Collections.sort(listaStudenti, comp);
		System.out.println(listaStudenti);
		
	// Con questo creo direttamente una classe anonima con il metodo dentro dato che la uso una sola volta.	
		Collections.sort(listaStudenti, new Comparator<Studente>() {
			@Override
			public int compare(Studente o1, Studente o2) {
				int result = o1.getDataDiNascita().compareTo(o2.getDataDiNascita());
				return -result;
			}
		});
	// Funzione lambda che compara in una lista di studenti le date di nascita di due studenti.	
		Collections.sort(listaStudenti, (s1, s2) -> s2.getDataDiNascita().compareTo(s1.getDataDiNascita()));
		System.out.println(listaStudenti);
		
		
		Comparator<Studente> comp2 = (s1, s2) -> s2.getDataDiNascita().compareTo(s1.getDataDiNascita());
		
		List <Studente> result = listaStudenti.stream()
											  .filter(e -> e.getDataDiNascita().getYear() > 1990)
											  .collect(Collectors.toList());
		
		System.out.println(result.toString());
		
		// Optional <Studente> studente = listaStudenti.stream().max((s1, s2) -> s2.getDataDiNascita().compareTo(s1.getDataDiNascita()));
		//     if (studente.isPresent()) {
		//			System.out.println(studente.get());
		//	   }
		
		Optional <Studente>studente = listaStudenti.stream().max(comp2);
		if (studente.isPresent()) {
			System.out.println(studente.get());
									   
		}
		
	}

}

