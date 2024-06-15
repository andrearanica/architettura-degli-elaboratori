
public class RiunioneInPresenza extends Riunione {
	private int distanza;
	
	public RiunioneInPresenza(int anno, int mese, int giorno, int durata, int distanza) throws RiunioneNonValidaException {
		super(anno, mese, giorno, durata);
		if (distanza <= 0) {
			throw new RiunioneNonValidaException("Distanza " + distanza + " non valida");
		} else {
			this.distanza = distanza;
		}
	}
	
	public int getImpegnoOrarioComplessivo() {
		return this.durata + 2*this.distanza;
	}
}
