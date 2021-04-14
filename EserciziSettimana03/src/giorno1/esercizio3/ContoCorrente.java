package giorno1.esercizio3;

public class ContoCorrente {
	
	String titolare;
	int nMovimenti;
	final int maxMovimenti = 50;
	double saldo;

	ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
	}

	void preleva(double x) throws BancaException {
		if (nMovimenti < maxMovimenti)
			saldo = saldo - x;
			if (saldo < 0) {
				throw new BancaException(BancaException.toString2());
			}
		else
			saldo = saldo - x - 0.50;
			if (saldo < 0) {
				throw new BancaException(BancaException.toString2());
			}
		nMovimenti++;
	}

	double restituisciSaldo() {
		return saldo;
	}

}
