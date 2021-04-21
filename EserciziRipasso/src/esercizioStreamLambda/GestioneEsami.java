package esercizioStreamLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GestioneEsami {
	
	
	List<ProvaDiEsame> listaEsami = new ArrayList<>();
	List<Studente> listaStudenti = new ArrayList<>();
	
	
	//produrre e stampare una lista in cui appaiono in maniera distinta nome e cognome degli studenti che hanno
    //sostenuto almeno una prova.
	public List<String> stampaStudenti (List<ProvaDiEsame> esami) {
		return esami.stream().map(e -> e.getStudente().getNome() + " " + e.getStudente().getCognome()).distinct().collect(Collectors.toList());
	
	}
	
//	quanti studenti appartengono ad un corso di studi STEM, quanti a uno Artistico e quanti a uno letterario?
	public void contaStudentiPerArea (List<ProvaDiEsame> esami) {
		long a = esami.stream().filter(e -> e.getStudente().getCorso().getArea().equals(Area.ARTISTICA)).count();
		long b = esami.stream().filter(e -> e.getStudente().getCorso().getArea().equals(Area.STEM)).count();
		long c = esami.stream().filter(e -> e.getStudente().getCorso().getArea().equals(Area.LETTERARIA)).count();
		System.out.println("Gli studenti dell'artistico sono: " + a + "\n" + "Gli studenti di STEM sono: " + b + "\n" + "Gli studenti di letteraria sono: " + c);
	}
	
//	 quale delle tre aree ha il maggior valor medio nei voti? 
	public void areaMaggiorMedia (List<ProvaDiEsame> esami) {
//		double avgStem = listaEsami.stream().filter(p -> p.getStudente().getCorso().getArea() == Area.STEM)
//		.mapToInt(ProvaDiEsame::getPunteggio)
//		.average().orElse(0.0);
//		
//		double avgArt = listaEsami.stream().filter(p -> p.getStudente().getCorso().getArea() == Area.ARTISTICA)
//				.mapToInt(ProvaDiEsame::getPunteggio)
//				.average().orElse(0.0);
//		
//		double avgLett = listaEsami.stream().filter(p -> p.getStudente().getCorso().getArea() == Area.LETTERARIA)
//				.mapToInt(ProvaDiEsame::getPunteggio)
//				.average().orElse(0.0);
		
		double avgforStem = calcolaMediaInArea(esami, Area.STEM);
		double avgforLett = calcolaMediaInArea(esami, Area.LETTERARIA);
		double avgforArts = calcolaMediaInArea(esami, Area.ARTISTICA);
		
		System.out.printf("L'average per lo Stem è %.2f, L'average per la Letteratura è %.2f. L'average per l'Arte è %.2f", avgforStem, avgforLett, avgforArts);
	}
	
	public double calcolaMediaInArea(List<ProvaDiEsame> esami, Area a) {
		
		double avg = listaEsami.stream().filter(p -> p.getStudente().getCorso().getArea() == a)
				.mapToInt(ProvaDiEsame::getPunteggio)
				.average().orElse(0.0);
		return avg;
	}
	
	public Area areaStudenteMigliore (List<ProvaDiEsame> esami) {
		return esami.stream().max((p1, p2) -> p1.getPunteggio() - p2.getPunteggio()).get().getStudente().getCorso().getArea();
	}
	
//	public void gliStreamNonSonoRiutilizzabili (List<ProvaDiEsame> esami) {
//		Stream<Studente> ss = esami.stream().map(ProvaDiEsame::getStudente).filter(s -> s.getSesso() == Sesso.F);
//		// Questa è lazy perché dopo il filtraggio non fa niente.
//		
//		Optional<Studente> studentessaSeniorOpt = ss.min((s1, s2) -> s1.getDataNascita().compareTo(s2.getDataNascita()));
//		
//		if(studentessaSeniorOpt.isPresent()) {
//			System.out.println(studentessaSeniorOpt.get().getNome());
//		}
//		// Non potrei fare anche il max perché lo stream già è stato utilizzato.
//		
//		List<Studente> ls = esami.stream().map(ProvaDiEsame::getStudente).filter(s -> s.getSesso() == Sesso.F).collect(Collectors.toList());
//		// Questo si può riutilizzare e non è lazy perché deve popolare una lista.
//		
//		//ls.stream().max(null);
//	}
	
	public void verificaPunteggi (List<ProvaDiEsame> esami) {
		boolean nonCiSonoScarsi = esami.stream().filter(e -> e.getTipologiaProva() == TipoProva.QUIZ)
									.allMatch(e -> e.getPunteggio() > 40);
		boolean nonCiSonoSTEMAvanzatiScarsi = esami.stream()
				.filter(e -> e.getStudente().getCorso().getLivello() == LivelloDifficolta.AVANZATO && e.getStudente().getCorso().getArea() == Area.STEM)
				.allMatch(e -> e.getPunteggio() > 70);
		System.out.println(nonCiSonoScarsi);
		System.out.println(nonCiSonoSTEMAvanzatiScarsi);
	}
	
	public void stampaProveDiEsame (List<ProvaDiEsame> esami) {
		
		esami.stream().sorted(this::comparatoreDiEsami)
					  .forEach(p -> System.out.printf("Nome: %s, Cognome: %s, Data: %s, Tipo di prova: %s, Punteggio: %d, Area: %s%n", 
					  p.getStudente().getNome(), p.getStudente().getCognome(), p.getDataEsame(), p.getTipologiaProva(), p.getPunteggio(), p.getStudente().getCorso().getArea()));
		
		
	}
	
	private int comparatoreDiEsami(ProvaDiEsame p1, ProvaDiEsame p2) {
		
		Area a1 = p1.getStudente().getCorso().getArea();
		Area a2 = p2.getStudente().getCorso().getArea();
		
		if (a1 != a2) {
			if (a1 == Area.LETTERARIA) {
				return -1;
			}
			if (a1 == Area.ARTISTICA) {
				if (a2 == Area.LETTERARIA) {
					return 1;
				}
				else {
					return -1;
				}
			}
			return 1;
		}
		if (p1.getPunteggio() != p2.getPunteggio()) {
			return p2.getPunteggio() - p1.getPunteggio();
		}
		return p1.getStudente().getCognome().compareTo(p2.getStudente().getCognome());
	}
	
}
