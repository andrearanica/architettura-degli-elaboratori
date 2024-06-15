import java.util.TreeSet;

public class CicloRiunioni {
	private TreeSet<Riunione> ciclo;
	
	public CicloRiunioni() {
		this.ciclo = new TreeSet<Riunione>();
	}
	
	public void aggiungiRiunione(Riunione riunione) throws RiunioneNonValidaException {
		if (riunione != null) {
			ciclo.add(riunione);
		} else {
			throw new RiunioneNonValidaException("Riunione " + riunione + " non valida");
		}
	}
	
	public int getNumeroRiunioni() {
		return this.ciclo.size();
	}
	
	public int getNumeroRiunioniVirtuali() {
		int nRiunioniVirtuali = 0;
		for (Riunione riunione: this.ciclo) {
			if (riunione instanceof RiunioneVirtuale) {
				nRiunioniVirtuali++;
			}
		}
		return nRiunioniVirtuali;
	}
	
	public int calcolaImpegnoComplessivo() {
		int impegnoTot = 0;
		for (Riunione riunione: this.ciclo) {
			impegnoTot += riunione.getImpegnoOrarioComplessivo();
		}
		return impegnoTot;
	}
	
	public String toString() {
		String data = "";
		for (Riunione riunione: this.ciclo) {
			data += riunione.toString();
		}
		return data;
	}
}
