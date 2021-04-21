package giorno5.esercizio.ripasso.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Start {
	
	public static void main(String[] args) {
		
		List<Impiegato> lista = new ArrayList<>();
		
		Impiegato m1 = new Impiegato("Matto", "Rossi", "Maschio", 1000.0);
		Impiegato m2 = new Impiegato("Maggio", "Bianchi", "Maschio", 1200.0);
		Impiegato f1 = new Impiegato("Luna", "Neri", "Femmina", 1000.0);
		Impiegato f2 = new Impiegato("Magia", "Verdi", "Femmina", 2300.0);
		
		lista.add(m1);
		lista.add(m2);
		lista.add(f1);
		lista.add(f2);
		
		
		// Con il print f usiamo %.2f per fare spazio al double. .2 è per avere solo due cifre decimali.
		System.out.printf("La somma degli stipendi è %.2f%n", sommaStipendi(lista));
		System.out.printf("La somma degli stipendi con lo stream è %.2f%n", sommaStipendiJ8(lista));
		
		double maxStipendioFem = maxStipendioFemmine(lista);
		double minStipendioMas = minStipendioMaschi(lista);
		
		System.out.printf("Il massimo stipendio delle femmine è %.2f%n", maxStipendioFem);
		System.out.printf("Il minimo stipendio dei maschi è %.2f%n", minStipendioMas);
		
		System.out.printf("Il nome di tutti gli impiegati è: %s%n", stampaNomi(lista));
		System.out.printf("La lista dei nomi degli impiegati è %s%n", listaNomi(lista));
		
		if (maxStipendioFem < minStipendioMas) {
			System.out.println("Il mondo è come dovrebbe essere.");
		}
		else {
			System.out.println("Siamo rovinati");
		}
	}
	
	public static double sommaStipendi (List<Impiegato> e) {
		double somma = 0;
		for (Impiegato i : e) {
			somma += i.getStipendio();
		}
		return somma;
	}
	
	public static double sommaStipendiJ8 (List<Impiegato> lista) {
											   // (imp :: getStipendio());
		//OptionalDouble op = e.stream().mapToDouble(imp -> imp.getStipendio()).max();
		// OptionalDouble si ha per evitare la null pointer exception dato che non è
		//detto che la lista abbia dei valori.
		//double max = op.orElse(-1);
		//Nel max finisce o un double o 0 o -1;
		
		double max = lista.stream().mapToDouble(imp -> imp.getStipendio()).sum();
		return max;
	}
	
	public static double maxStipendioFemmine (List<Impiegato> lista) {
		double maxF = lista.stream()
							.filter(imp -> imp.getSesso()	
							.equals("Femmina")).mapToDouble(imp -> imp.getStipendio()).max().orElse(0);
		return maxF;
	}
	
	public static double minStipendioMaschi (List<Impiegato> lista) {
		double minM = lista.stream()
							.filter(imp -> imp.getSesso()	
							.equals("Maschi")).mapToDouble(imp -> imp.getStipendio()).min().orElse(0);
		return minM;
	}
	
	public static String stampaNomi (List<Impiegato> lista) {
		String nomi = lista.stream().map(imp -> imp.getNome()).collect(Collectors.joining(", "));
		// Stampa tutti i nomi separandoli dalle virgole
		// String nomi2 = lista.stream().map(imp2 -> imp2.toString()).reduce("", String::concat);
		return nomi;
	}
	
	public static List<String> listaNomi (List<Impiegato> lista) {
	return lista.stream().map(imp -> imp.getNome()).collect(Collectors.toList());
    }
}
