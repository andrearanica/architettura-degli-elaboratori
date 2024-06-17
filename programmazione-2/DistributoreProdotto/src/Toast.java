
public class Toast extends Prodotto {
	private final int costoBase;
	private final boolean grande;
	
	public Toast(int costoBase, boolean grande, int quantita) {
		super(quantita);
		this.costoBase = costoBase;
		this.grande = grande;
	}
	
	public int getPrezzoUnitario() {
		if (this.grande) {
			return 2*costoBase;
		} else {
			return costoBase;
		}
	}
}
