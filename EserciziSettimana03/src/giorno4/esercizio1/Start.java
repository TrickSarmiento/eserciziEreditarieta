package giorno4.esercizio1;

import java.io.IOException;
import java.util.List;

public class Start {
	public static void main(String[] args) {
		
		try {
			Archivio ar = new Archivio();
			ar.stampaPubblicazioni();
			ElementoEditoriale e = ar.searchByISBN("abc123");
			System.out.println(e.getTitolo());
			List<ElementoEditoriale> ePerAutore = ar.searchByAuthor("Patrick");
			for (ElementoEditoriale ee : ePerAutore) {
				System.out.println(ee.getTitolo());
			}
			List<ElementoEditoriale> ePerAnno = ar.searchByYear(2005);
			for (ElementoEditoriale ea : ePerAnno) {
				System.out.println(ea.getTitolo() + " " + ea.getAnnoDiPubblicazione());
			}
			Libro l1 = new Libro("fnjkdsf", "Nuotare", 2012, 343, "SuperMario", "Sport");
			ar.addItem(l1);
			ar.salvaSuFile();
		} catch (IOException e) {
			System.out.println("C'è un problema con la sorgente dati, riprovate più tardi.");
			e.printStackTrace();
		}
	}

}
