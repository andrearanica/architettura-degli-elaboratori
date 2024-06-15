
public abstract class Volo {
	private String aeroportoPartenza;
	private	String aeroportoArrivo;
	
	public Volo(String aeroportoPartenza, String aeroportoArrivo) throws VoloNonValidoException {
		if (Aeroporti.aeroportoValido(aeroportoPartenza)) {
			this.aeroportoPartenza = aeroportoPartenza;
		} else {
			throw new VoloNonValidoException("Aeroporto " + aeroportoPartenza + " non valido");
		}
		
		if (Aeroporti.aeroportoValido(aeroportoArrivo)) {
			this.aeroportoArrivo = aeroportoArrivo;
		} else {
			throw new VoloNonValidoException("Aeroporto " + aeroportoPartenza + " non valido");
		}
	}
	
	public String getAeroportoPartenza() {
		return this.aeroportoPartenza;
	}
	
	public String getAeroportoArrivo() {
		return this.aeroportoArrivo;
	}
	
	public abstract int getNumeroTratte();
	
	public abstract int getDurataInMinuti();
	
	public String toString() {
		return this.aeroportoPartenza + ";" + this.aeroportoArrivo + ";" + this.getNumeroTratte() + ";" + this.getDurataInMinuti();
	}
}
