package giorno2.esercizio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Rubrica {
	
	private Map<String, String> rubrica = new HashMap<>();
	
	public void inserisciContatto(String nome, String numero) {
		rubrica.put(nome, numero);
	}
	
	public void rimuoviContatto (String nome) {
		rubrica.remove(nome);
	}
	
	public String ricercaConNome (String nome) { 
//		rubrica.containsKey(nome);
		return rubrica.get(nome);
	}
	
	public String ricercaConNumero (String numero) {
		for (Entry<String, String> coppia : rubrica.entrySet()) {
			if (coppia.getValue().equals(numero)) {
				return coppia.getKey();
			}
		}
		return null;
	}
	
	public void stampaContatti() {
		System.out.println("Elenco dei contatti:");
		for(Entry<String, String> coppia : rubrica.entrySet()) {
			System.out.println("Nome: ");
			System.out.println(coppia.getKey());
			System.out.println("Numero telefonico: ");
			System.out.println(coppia.getValue());
		}
	}
	

}
