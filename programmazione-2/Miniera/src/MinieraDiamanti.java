
public class MinieraDiamanti extends Miniera {
	private int dimensioneDiamanti;
	private int purezzaDiamanti;
	
	public MinieraDiamanti(int riserva, int dimensioneDiamanti, int purezzaDiamanti) {
		super(riserva);
		this.dimensioneDiamanti = dimensioneDiamanti;
		this.purezzaDiamanti = purezzaDiamanti;
	}
	
	@Override
	protected int getValore() {
		return dimensioneDiamanti * purezzaDiamanti;
	}
}
