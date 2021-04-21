package esercizioStreamLambda;

import java.time.LocalDate;

//Una prova di esame deve registrare la data in cui e' stata tenuta, il punteggio
//tra zero e cento, lo studente a cui appartiene, e se si tratta di una prova scritta o orale o 
//un quiz.

public class ProvaDiEsame {
	
	private LocalDate dataEsame;
	private int punteggio;
	private TipoProva tipologiaProva;
	private Studente studente;
	
	public ProvaDiEsame(LocalDate dataEsame, int punteggio, TipoProva tipologiaProva, Studente studente) {
		this.dataEsame = dataEsame;
		this.punteggio = punteggio;
		this.tipologiaProva = tipologiaProva;
		this.studente = studente;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	public TipoProva getTipologiaProva() {
		return tipologiaProva;
	}

	public void setTipologiaProva(TipoProva tipologiaProva) {
		this.tipologiaProva = tipologiaProva;
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	
	
	
		
	
}
