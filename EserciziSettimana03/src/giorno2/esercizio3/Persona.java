package giorno2.esercizio3;

public class Persona {
	
	private String nome;
	private String numeroDiTelefono;
	
	public Persona (String nome, String numeroDiTelefono) {
		this.nome = nome;
		this.numeroDiTelefono = numeroDiTelefono;
	}

	public String getNome() {
		return nome;
	}

	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}
	
	
	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (this.getClass() != o.getClass()) {
			return false;
		}
		//Copiamo l'indirizzo nella reference o nella reference other.
		//Lo facciamo per puntare l'oggetto che prima era o nella reference di classe Persona.
		//Con (Persona) o faccio un cast forzato per confermare che è una persona
		Persona other = (Persona) o;
	
		if (this.nome == null && other.nome!= null) {
			return false;
		}
		//Se il mio nome NON è uguale al nome dell'altro, non siamo uguali. 
		else if (!this.nome .equals(other.nome)) {
			return false;
		}
		if (this.numeroDiTelefono == null && other.numeroDiTelefono!= null) {
			return false;
		}
		else if (!this.numeroDiTelefono .equals(other.numeroDiTelefono)) {
			return false;
		}
		return true;
		
	}
	
	//In questo modo l'Hashcode si baserà sul nome e il numero.
	@Override
	public int hashCode() {
		return nome.hashCode() + 49*numeroDiTelefono.hashCode();
	}

}
