package giorno3.esercizio3;

import java.io.File;
import java.io.IOException;

/*Realizzare la classe RegistroPresenze che contiene un elenco variabile di presenze. Ogni presenza è
 *  composta da un nome del dipendente e da un intero che indica i giorni di presenza. Usando la classe
 *   Apache Commons IO FileUtils implementare un metodo di RegistroPresenze  che salvi su disco un file 
 *   con le presenze ed un secondo metodo che legga da disco il file e istanzi in
 *    memoria gli oggetti corrispondenti.

Utilizzare un formato simile al seguente per storicizzare i dati su file: 

Mario Rossi@5#Giorgio Bianchi@7#Gianni Verdi@7 */

public class RegistroPresenze {
	
	public void salvataggioPresenze() throws IOException {
		String aggiungiPresenza = Presenza.getGiorniDiPresenza();
		
		File file = new File(aggiungiPresenza);
		
		FileUtils.aggiungiPresenzaToFile(file, aggiungiPresenza, "UTF-8");
		
	}

}
