package giorno3.esercizio1;

public class Start {
	
	public static void main(String[] args) throws InterruptedException {
		
		Esercizio1Thread thread1 = new Esercizio1Thread("*");
		Esercizio1Thread thread2 = new Esercizio1Thread("#");
		
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		
		t1.start();
		t2.start();
	}

}
