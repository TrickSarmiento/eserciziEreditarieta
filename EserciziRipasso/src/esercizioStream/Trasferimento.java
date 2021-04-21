package esercizioStream;

import java.time.LocalDate;

public class Trasferimento {
	
	private LocalDate dataOperazione;
	private double sommaTrasferita;
	private TipoTrasferimento transazione;
	private String causale;
	private Cliente cliente;
	
	public Trasferimento(LocalDate dataOperazione, double sommaTrasferita, TipoTrasferimento transazione,
			String causale, Cliente cliente) {
		this.dataOperazione = dataOperazione;
		this.sommaTrasferita = sommaTrasferita;
		this.transazione = transazione;
		this.causale = causale;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataOperazione() {
		return dataOperazione;
	}

	public void setDataOperazione(LocalDate dataOperazione) {
		this.dataOperazione = dataOperazione;
	}

	public double getSommaTrasferita() {
		return sommaTrasferita;
	}

	public void setSommaTrasferita(double sommaTrasferita) {
		this.sommaTrasferita = sommaTrasferita;
	}

	public TipoTrasferimento getTransazione() {
		return transazione;
	}

	public void setTransazione(TipoTrasferimento transazione) {
		this.transazione = transazione;
	}

	public String getCausale() {
		return causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}


}
