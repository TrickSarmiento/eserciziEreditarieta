package altroPackage;

import inheritance.ContoCorrente;
import inheritance.ContoCorrenteGold;

public class Start {
	
	public static void main(String[] args) {
		
		//Le variabili protected non sono visibili al di fuori del package della classe.
		
		ContoCorrente c = new ContoCorrente(1000);
		ContoCorrenteGold cg = new ContoCorrenteGold (2000, "123");
		double nuovoSaldo = cg.deposita(1000);
		System.out.println("Il nuovo saldo è: " + nuovoSaldo);
		nuovoSaldo = cg.bonifica(500, c);
		System.out.println("Il nuovo saldo è: " + nuovoSaldo);
		ContoCorrenteGold cg2 = new ContoCorrenteGold (5000, "321");
		//La sottoclasse essendo un'estensione della super classe e quindi i metodi
		//della super classe funzionano anche sulla sottoclasse.
		nuovoSaldo = cg2.bonifica(1000, (ContoCorrente)cg); // (ContoCorrente) lo fa automaticamente
		// Quindi non serve scriverlo. (Upcasting)
		System.out.println("Il nuovo saldo è: " + nuovoSaldo);
		int x = 10;
		long y = 10;
		x = (int)y; //narrowing cast. Da più grande a più piccolo quindi pericolo perdita di dati.
		y = x; //Widening cast. Automatico.
		boolean result = cg2.confrontaCodiceSegreti(cg);
//		result = cg2.confrontaCodiceSegreti(c); Non lo permette perché c non ha codice segreto. 
// 		Quindi il downcasting non è sempre permesso.
		System.out.println(result);
		ContoCorrente x1 = new ContoCorrenteGold(1000, "abc"); //Upcasting. CCG è una CC.
//		ContoCorrenteGold x2 = new ContoCorrente (1000); Downcasting. CC NON è una CCG.
	}

}
