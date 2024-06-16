import java.util.HashSet;

public class Libretto {
	private HashSet<Esame> esami;
	
	public Libretto() {
		this.esami = new HashSet<Esame>();
	}
	
	public boolean aggiungiEsame(Esame esame) throws EsameNonValidoException {
		if (esame == null) {
			throw new EsameNonValidoException("Exam " + esame + " has a value of 'null'");
		} else {
			boolean result = esami.add(esame);
			return result;
		}
	}
	
	public double calcolaMedia() {
		double markSum = 0;
		double creditSum = 0;
		for (Esame esame: this.esami) {
			markSum += esame.getCFU()*esame.voto();
			creditSum += esame.getCFU();
		}
		return markSum / creditSum;
	}
	
	public int numeroEsamiSoloOrale() {
		int nEsami = 0;
		for (Esame esame: this.esami) {
			if (esame instanceof EsameOrale) {
				nEsami++;
			}
		}
		return nEsami;
	}
	
	public String toString() {
		String result = "";
		for (Esame esame: this.esami) {
			result += esame;
		}
		return result;
	}
}
