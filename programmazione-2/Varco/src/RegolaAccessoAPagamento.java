import java.util.HashSet;

public class RegolaAccessoAPagamento extends RegolaDiAccesso {
	public HashSet<String> registroTarghePaganti;
	
	public RegolaAccessoAPagamento(String descrizione) {
		super(descrizione);
		this.registroTarghePaganti = new HashSet<String>();
	}
	
	public void registraPagamento(String targa) throws VeicoloException {
		if (targa != null && !targa.isBlank()) {
			if (!this.registroTarghePaganti.add(targa)) {
				throw new VeicoloException("La targa " + targa + " fa già parte del registro");
			}
		}
	}
	
	public boolean multa(Veicolo veicolo) {
		return !this.registroTarghePaganti.contains(veicolo.getTarga());
	}
}
