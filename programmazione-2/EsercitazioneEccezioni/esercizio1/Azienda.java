public class Azienda {

	private Dipendente[] dipendenti;
	
	public Azienda(int numMaxDipendenti) {
		if (numMaxDipendenti <= 0) {
			numMaxDipendenti = 10;
		}
		dipendenti = new Dipendente[numMaxDipendenti];
	}
	
	public void aggiungiDipendente(Dipendente d) {
		for (int i = 0; i < dipendenti.length; i++) {
			if (dipendenti[i] == null) {
				dipendenti[i] = d;
				break;
			}
		}
	}
	
	public double costoAnnuoDipendenti() {
		double somma = 0;
		for (int i = 0; i < dipendenti.length; i++) {
			if (dipendenti[i] != null) {
				somma += dipendenti[i].calcolaRal();
			}
		}
		return somma;
	}
}
