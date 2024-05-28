
public class MinieraMarmo extends Miniera {
	private int latoBlocco;
	
	public MinieraMarmo(int riserva, int latoBlocco) {
		super(riserva);
		this.latoBlocco = latoBlocco;
	}
	
	protected int getValore() {
		return 2 * latoBlocco * latoBlocco * latoBlocco;
	}
}
