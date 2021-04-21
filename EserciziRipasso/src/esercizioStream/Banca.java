package esercizioStream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


public class Banca {
	
	List<Trasferimento> listaTransazioni = new ArrayList<>();
	public Banca(List<Trasferimento> listaTransazioni) {
		this.listaTransazioni = listaTransazioni;
	}
	
	public List<Trasferimento> getListaTransazioni() {
		return listaTransazioni;
	}

	public double sommaTransazioni(List<Trasferimento> transazioni) {
		return transazioni.stream()
						  .mapToDouble(e -> e.getSommaTrasferita())
						  .sum();
	}
	
	public double sommaTransazioniPrima1980(List<Trasferimento> transazioni) {
		return transazioni.stream().filter(e -> e.getCliente().getDataNascita().getYear() < 1980)
								   .mapToDouble(e -> e.getSommaTrasferita())
								   .sum();
	}
	
	public OptionalDouble mediaTransazioniFemmine (List<Trasferimento> transazioni) {
		return transazioni.stream().filter(e -> e.getCliente().getSesso().equals("Femmina"))
								   .mapToDouble(t -> t.getSommaTrasferita())
								   .average();
	}
	
	public String nomeClienteTransazioneMaggiore (List<Trasferimento> transazioni) {
		return transazioni.stream()
				   .max((t1, t2) ->(int) (Math.signum(t1.getSommaTrasferita() - t2.getSommaTrasferita())))
				   .get().getCliente().getNome();
		
		//return transazioni.stream()
		//                     .max((t1, t2) -> {
		//                          double dif = t1.getSommaTrasferita() - t2.getSommaTrasferita();
		//				  			double sign = Math.signum(dif);
		//							int result = (int) sign;
		//							return result;
		//						}).get().getCliente().getNome();
	}
	
	public boolean isThere100k (List<Trasferimento> transazioni) {
		//long c = transazioni.stream().filter(e -> e.getSommaTrasferita() >= 100000).count();		
		//Abbreviamo return c > 0 ? true : false;
		//return c > 0;
		return transazioni.stream().anyMatch(e -> e.getSommaTrasferita() >= 100000);
	}
	
	public double mediana (List<Trasferimento> transazioni) {
		
		
		// Con Boxed trasformiamo lo stream di Double primitive in uno stream di oggetti double.
		List<Double> listaAmmontare = transazioni.stream()
				   .mapToDouble(Trasferimento::getSommaTrasferita)
				   .sorted().boxed().collect(Collectors.toList());
		double mediana = 0;

		if (listaAmmontare.size()%2 != 0) { 
			mediana = listaAmmontare.get(listaAmmontare.size()/2);
		}
		else {
			mediana = (listaAmmontare.get(listaAmmontare.size()/2) + listaAmmontare.get(listaAmmontare.size()/2-1))/2;
		}
		return mediana;
	}
	
}
