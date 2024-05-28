
public abstract class Miniera {
	private int riserva;
	
	public Miniera(int riserva) {
		this.riserva = riserva;
	}
	
	public void setRiserva(int riserva) {
		this.riserva = riserva;
	}
	
	public int getRiserva() {
		return this.riserva;
	}
	
	protected abstract int getValore();
			   
	public int estraiEVendi(int quantita) {
		int quantitaVenduta;
		if (quantita > this.getRiserva()) {
			quantitaVenduta = this.getRiserva();
			this.setRiserva(0);
		} else {
			this.setRiserva(this.getRiserva() - quantita);
			quantitaVenduta = quantita;
		}
		return quantitaVenduta*this.getValore();
	}
}
