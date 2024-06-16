
public class EsameScritto extends Esame {
	final int PESO_TEORIA = 40;
	private double votoTeoria;
	private double votoPratica;
	
	public EsameScritto(int CFU, String codice, int votoTeoria, int votoPratica) throws EsameNonValidoException {
		super(CFU, codice);
		if (votoTeoria < 18 || votoTeoria > 31) {
			throw new EsameNonValidoException("Mark " + votoTeoria + " is not a valid mark for the theory part of the exam");
		} else {
			this.votoTeoria = votoTeoria;
		}
		
		if (votoPratica < 18 || votoPratica > 31) {
			throw new EsameNonValidoException("Mark " + votoTeoria + " is not a valid mark for the theory part of the exam");
		} else {
			this.votoPratica = votoPratica;
		}
	}
	
	public double voto() {
		return (this.PESO_TEORIA*this.votoTeoria + (100-this.PESO_TEORIA)*this.votoPratica) / 100;
	}
}
