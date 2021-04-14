package settimana2.giorno4.interfacce;

public class Start {
	public static void main(String[] args) {
	
		Bici b = new Bici();
		Porsche po = new Porsche();
		partiPerLeVacanze(b);
		partiPerLeVacanze(po);
		MezzoDiTrasporto[] mezzi = new MezzoDiTrasporto[2];
		mezzi[0] = b;
		mezzi[1] = po;
		
	}
	public static void partiPerLeVacanze (MezzoDiTrasporto mt) {
		if (mt.getVelocita() > 100) {
			mt.avanza(50);
		}
	}
}
