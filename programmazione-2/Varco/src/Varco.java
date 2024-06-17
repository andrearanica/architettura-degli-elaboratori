import java.util.TreeSet;

public class Varco {
	private RegolaDiAccesso regolaAccesso;
	private TreeSet<Veicolo> multati;
	
	public Varco(RegolaDiAccesso regolaAccesso) {
		this.regolaAccesso = regolaAccesso;
		this.multati = new TreeSet<Veicolo>();
	}
	
	public void convalidaEntrata(Veicolo veicolo) {
		if (this.regolaAccesso != null && this.regolaAccesso.multa(veicolo)) {
			this.multati.add(veicolo);
		}
	}
	
	public TreeSet<Veicolo> getMultati() {
		return this.multati;
	}
	
	public String toString() {
		String message = this.regolaAccesso.descrizione+";";
		for (Veicolo veicolo: this.multati) {
			message += veicolo.getTarga() + ";";
		}
		return message;
	}
}
