
public class RegolaAccessoVietatoMotoriDiesel extends RegolaDiAccesso {
	public RegolaAccessoVietatoMotoriDiesel(String descrizione) {
		super(descrizione);
	}
	
	public boolean multa(Veicolo veicolo) {
		return veicolo.getCarburante() == Carburante.DIESEL;
	}
}
