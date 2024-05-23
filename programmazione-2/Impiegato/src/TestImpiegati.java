
public class TestImpiegati {
	public static void main(String[] args) {
		Impiegato[] impiegati = {
			new Salariato("Rossi", 1500),
			new Salariato("Ferrari", 200),
			new AdOre("Orazio", 20, 20),
			new AdOre("Re", 20, 40),
			new AdOre("Ranica", 100, 1)
		};
		
		stampaOrdinaImpiegati(impiegati);
	}
	
	public static void stampaOrdinaImpiegati(Impiegato[] impiegati) {
		for(int i = 0; i < impiegati.length; i++) {
			for (int j = i+1; j < impiegati.length; j++) {
				if (impiegati[i].paga() > impiegati[j].paga()) {
					Impiegato temp = impiegati[i];
					impiegati[i] = impiegati[j];
					impiegati[j] = temp;
				}
			}
			
		}
		for (int i = 0; i < impiegati.length; i++) {
			System.out.println(impiegati[i]);
		}
	}
}
