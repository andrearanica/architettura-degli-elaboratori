
public class EsameOrale extends Esame {
	private double voto;
	
	public EsameOrale(int CFU, String codice, int voto) throws EsameNonValidoException {
		super(CFU, codice);
		if (voto < 18 || voto > 31) {
			throw new EsameNonValidoException("Mark " + voto + " is not a valid mark for an exam");
		} else {
			this.voto = voto;
		}
	}
	
	public double voto() {
		return this.voto;
	}
}
