package esercizioStream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Start {
	
	public static void main(String[] args) {
		
		
		List<Trasferimento> transazioni = new ArrayList<>();
		List<Cliente> clienti = new ArrayList<>();
		
		clienti.add(new Cliente("11", "Kyrie", "Irving", LocalDate.of(1984, 4, 12), "Maschio"));
		clienti.add(new Cliente("23", "LeBron", "James", LocalDate.of(1978, 7, 23), "Maschio"));
		clienti.add(new Cliente("97", "Doris", "Burke", LocalDate.of(1987, 8, 16), "Femmina"));
		clienti.add(new Cliente("91", "Doria", "Bur", LocalDate.of(1989, 5, 6), "Femmina"));
		
		
		transazioni.add(new Trasferimento(LocalDate.of(2019, 6, 10), 95000, TipoTrasferimento.BONIFICO, "Donazione", clienti.get(0)));
		transazioni.add(new Trasferimento(LocalDate.of(2020, 8, 11), 110000, TipoTrasferimento.DEPOSITO, "Regalo", clienti.get(1)));
		transazioni.add(new Trasferimento(LocalDate.of(2006, 10, 19), 88000, TipoTrasferimento.PRELIEVO, "Shopping", clienti.get(2)));
		transazioni.add(new Trasferimento(LocalDate.of(2016, 12, 29), 92000, TipoTrasferimento.DEPOSITO, "Beneficenza", clienti.get(3)));
		transazioni.add(new Trasferimento(LocalDate.of(2015, 7, 117), 95000, TipoTrasferimento.BONIFICO, "Donazione", clienti.get(0)));
		
	}

}
