package giorno2.esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Esercizio2 {

	public static void main(String[] args) {
		
		List<Integer> result = creazioneLista(5);
		System.out.println(result);
		
		stampaLista(result);
		System.out.println(result);
		
		stampaPariDispari(result, true);
		
	}
	
	public static List<Integer> creazioneLista(int n) {
		List<Integer> listaNumeri = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			listaNumeri.add(r.nextInt(101));
		}
		//Metterli in un ordine preciso.
		Collections.sort(listaNumeri);
		return listaNumeri;
		
	}
	public static List<Integer> stampaLista (List<Integer> original) {
		List<Integer> lista = new ArrayList<>();
		lista.addAll(original);
		Collections.reverse(original);
		lista.addAll(original);
		return lista;
			
	}
	public static void stampaPariDispari (List<Integer> listaNumeri, boolean b) {
		int start = 0;
		//if (b == false) {
		if (! b) { 
			start = 1;
		}
		for (int i = start; i < listaNumeri.size(); i+=2) {
			System.out.println(listaNumeri.get(i));
		}
		for (int i = b? 0:1; i < listaNumeri.size(); i += 2) {
			System.out.println(listaNumeri.get(i));
		}
	}	
}
