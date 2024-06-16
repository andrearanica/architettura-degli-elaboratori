
public abstract class Esame {
	private int CFU;
	private String codice;
	
	public Esame(int CFU, String codice) throws EsameNonValidoException {
		if (CFU <= 0) {
			throw new EsameNonValidoException("CFU " + CFU + " is not a valid amount of CFU credits");
		} else {
			this.CFU = CFU;
		}
		
		if (codice == null || codice.isBlank() || codice.isEmpty()) {
			throw new EsameNonValidoException("Code " + codice + " is not a valid code for an exam");
		} else {
			this.codice = codice;
		}
	}
	
	public int getCFU() {
		return this.CFU;
	}
	
	public String getCodice() {
		return this.codice;
	}
	
	public abstract double voto();
	
	public String toString() {
		return this.codice+";"+this.CFU+";"+this.voto();
	}
	
	public boolean equals(Esame esame) {
		return esame.getClass() == this.getClass() && this.codice == esame.codice;
	}
	
	public int hashCode() {
		int hash = 0;
		for (char c: this.codice.toCharArray()) {
			hash += (int)c;
		}
		for (char c: this.getClass().toString().toCharArray()) {
			hash += (int)c;
		}
		return hash;
	}
}
