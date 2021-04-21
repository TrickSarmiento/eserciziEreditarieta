package esercizioStreamLambda;

import java.time.LocalDate;

//IL corso di studi ha una titolo, una data di fondazione, un livello di difficolta' che puo' essere base, 
//intemedio, avanzato e un area che puo' essere STEM, Artistica o Letteraria

public class CorsoDiStudio {
	
	private String titolo;
	private LocalDate dataFondazione;
	private LivelloDifficolta livello;
	private Area area;
	
	public CorsoDiStudio(String titolo, LocalDate dataFondazione, LivelloDifficolta livello, Area area) {
		this.titolo = titolo;
		this.dataFondazione = dataFondazione;
		this.livello = livello;
		this.area = area;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataFondazione() {
		return dataFondazione;
	}

	public void setDataFondazione(LocalDate dataFondazione) {
		this.dataFondazione = dataFondazione;
	}

	public LivelloDifficolta getLivello() {
		return livello;
	}

	public void setLivello(LivelloDifficolta livello) {
		this.livello = livello;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	

}
