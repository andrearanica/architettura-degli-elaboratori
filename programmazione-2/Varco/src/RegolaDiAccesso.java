
public abstract class RegolaDiAccesso {
	public String descrizione;
	
	public RegolaDiAccesso(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public abstract boolean multa(Veicolo veicolo);
}
