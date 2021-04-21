package settimana4.giorno1.lambda;

import java.util.Comparator;

public class ComparatoreStudentiPerEta implements Comparator<Studente>{

	@Override
	public int compare(Studente o1, Studente o2) {
		int result = o1.getDataDiNascita().compareTo(o2.getDataDiNascita());
		return -result;
	}
	
	

}
