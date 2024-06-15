
public class VoloDiretto extends Volo {
	private int durataInMinuti;
	
	public VoloDiretto(String aeroportoPartenza, String aeroportoArrivo, int durataInMinuti) throws VoloNonValidoException {
		super(aeroportoPartenza, aeroportoArrivo);
		if (durataInMinuti > 0) {
			this.durataInMinuti = durataInMinuti;
		} else {
			throw new VoloNonValidoException(durataInMinuti + " non è una durata valida");
		}
	}
	
	public int getNumeroTratte() {
		return 1;
	}
	
	public int getDurataInMinuti() {
		return this.durataInMinuti;
	}
}
