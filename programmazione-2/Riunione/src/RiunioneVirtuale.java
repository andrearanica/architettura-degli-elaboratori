
public class RiunioneVirtuale extends Riunione {
	public RiunioneVirtuale(int anno, int mese, int giorno, int durata) throws RiunioneNonValidaException {
		super(anno, mese, giorno, durata);
	}
	
	public int getImpegnoOrarioComplessivo() {
		return this.durata;
	}
}
