
public class Veicolo implements Comparable<Veicolo> {
	private String targa;
	private String carburante;
	
	public Veicolo(String targa, String carburante) throws VeicoloException {
		if (targa == null || targa.isBlank()) {
			throw new VeicoloException("La targa "+ targa + " non è una targa valida");
		} else {
			this.targa = targa;
		}
		
		if (!Carburante.carburanteValido(carburante)) {
			throw new VeicoloException("Il carburante " + carburante + " non è un carburante valido");
		} else {
			this.carburante = carburante;
		}
	}
	
	public String getTarga() {
		return this.targa;
	}
	
	public String getCarburante() {
		return this.carburante;
	}
	
	public boolean equals(Veicolo veicolo) {
		return this.hashCode() == veicolo.hashCode();
	}
	
	public int hashCode() {
		int hash = 0;
		for(char c: this.targa.toCharArray()) {
			hash += (int)c;
		}
		return hash;
	}
	
	public int compareTo(Veicolo veicolo) {
		return this.targa.compareTo(veicolo.targa);
	}
}
