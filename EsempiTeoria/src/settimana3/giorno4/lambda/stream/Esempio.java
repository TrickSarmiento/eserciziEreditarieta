package settimana3.giorno4.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Esempio {
	
	public static void main(String[] args) {
		
		List <String> string = new ArrayList<>();
		string.add("Ciao");
		string.add("Bello");
		string.add("Andare");
		string.add("Lontano");
		
		Stream<String> filter = string.stream().filter(strings -> strings.contains("ao"));
		filter.forEach(elem -> System.out.println("La parola è: " + elem));
		
	}
	

}
