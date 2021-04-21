package esercizioStreamLambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) {
		
		List<ProvaDiEsame> listaEsami = new ArrayList<>();
		
		CorsoDiStudio c1 = new CorsoDiStudio("Rinascimento", LocalDate.of(2012, 5, 7), LivelloDifficolta.AVANZATO, Area.ARTISTICA);
		CorsoDiStudio c2 = new CorsoDiStudio("Poesia", LocalDate.of(2016, 4, 9), LivelloDifficolta.BASE, Area.LETTERARIA);
		CorsoDiStudio c3 = new CorsoDiStudio("Matematica", LocalDate.of(2013, 9, 12), LivelloDifficolta.INTERMEDIO, Area.STEM);
		CorsoDiStudio c4 = new CorsoDiStudio("Tatuaggio", LocalDate.of(2016, 3, 16), LivelloDifficolta.BASE, Area.ARTISTICA);
			
		Studente s1 = new Studente("Kyrie", "Irving", Sesso.M, LocalDate.of(1988, 12, 6), c4);
		Studente s2 = new Studente("LeBron", "James", Sesso.M, LocalDate.of(1984, 10, 16), c2);
		Studente s3 = new Studente("Jayson", "Tatum", Sesso.M, LocalDate.of(1998, 5, 12), c3);
		Studente s4 = new Studente("Jaylen", "Brown", Sesso.M, LocalDate.of(1998, 1, 6), c1);
		
		ProvaDiEsame p1 = new ProvaDiEsame(LocalDate.of(2015, 12, 5), 90, TipoProva.SCRITTA, s1);
		ProvaDiEsame p2 = new ProvaDiEsame(LocalDate.of(2015, 12, 5), 80, TipoProva.QUIZ, s1);
		ProvaDiEsame p3 = new ProvaDiEsame(LocalDate.of(2015, 12, 5), 75, TipoProva.ORALE, s4);
		ProvaDiEsame p4 = new ProvaDiEsame(LocalDate.of(2015, 12, 5), 22, TipoProva.QUIZ, s3);
		ProvaDiEsame p5 = new ProvaDiEsame(LocalDate.of(2015, 12, 5), 91, TipoProva.ORALE, s2);
		
		listaEsami.add(p1);
		listaEsami.add(p2);
		listaEsami.add(p3);
		listaEsami.add(p4);
		listaEsami.add(p5);
		
		GestioneEsami esame = new GestioneEsami();
		
		System.out.println(esame.stampaStudenti(listaEsami));
		
		esame.contaStudentiPerArea(listaEsami);
		esame.stampaProveDiEsame(listaEsami);
		
	}

}
