package esercizi;

import esercizi.Dipendente.Dipartimento;
import esercizi.Dipendente.Livello;

public class GestioneDipendenti {
	
	public static void main(String[] args) {
		
		Dipendente dip1 = new Dipendente (Dipartimento.PRODUZIONE, "abc");
		Dipendente dip2 = new Dipendente (Dipartimento.PRODUZIONE, "cde");
		Dipendente dip3 = new Dipendente (Dipartimento.AMMINISTRAZIONE, "fgh", 1000, 30, Livello.IMPIEGATO);
		Dipendente dip4 = new Dipendente (Dipartimento.VENDITE, "ijk", 2000, 40, Livello.DIRIGENTE);
		
		Livello x =dip2.promuovi();
		System.out.println("Il nuovo livello dell'operaio è: " + x);
		
		Livello y = dip3.promuovi();
		System.out.println("Il nuovo livello dell'impiegato è: " + y);
		
		dip1.stampaDatiDipendente();
		dip2.stampaDatiDipendente();
		dip3.stampaDatiDipendente();
		dip4.stampaDatiDipendente();
		
		
		//double somma = Dipendente.calcolaPaga(dip1, 5);
		//somma += Dipendente.calcolaPaga(dip2, 5);
		//somma += Dipendente.calcolaPaga(dip3, 5);
		//somma += Dipendente.calcolaPaga(dip4, 5);
		
		double somma = dip1.calcolaPaga(5, true);
		somma += dip2.calcolaPaga(5, true);
		somma += dip3.calcolaPaga(5, true);
		somma += dip4.calcolaPaga(5, true);
		
		System.out.println("La somma degli stipendi è: " + somma);
	}
	
	

}
