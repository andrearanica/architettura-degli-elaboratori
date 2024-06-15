
public abstract class Riunione implements Comparable<Riunione> {
	private int anno;
	private int mese;
	private int giorno;
	protected int durata;
	
	public Riunione(int anno, int mese, int giorno, int durata) throws RiunioneNonValidaException {
		if (anno >= 2021) {
			this.anno = anno;
		} else {
			throw new RiunioneNonValidaException("Anno " + anno + " non valido");
		}
		
		if (mese >= 1 && mese <= 12) {
			this.mese = mese;
		} else {
			throw new RiunioneNonValidaException("Mese " + mese + " non valido");
		}
		
		if (giorno >= 1 && giorno <= 31) {
			this.giorno = giorno;
		} else {
			throw new RiunioneNonValidaException("Giorno " + giorno + " non valido");
		}
		
		if (durata >= 1) {
			this.durata = durata;
		} else {
			throw new RiunioneNonValidaException("Durata " + durata + " non valida");
		}
	}
	
	public abstract int getImpegnoOrarioComplessivo();
	
	public String getData() {
		return this.giorno + "/" + this.mese + "/" + this.anno;
	}
	
	public String toString() {
		return getData() + ";" + this.getImpegnoOrarioComplessivo();
	}
	
	public boolean equals(Riunione riunione) {
		return this.getData().equals(riunione.getData());
	}
	
	public int compareTo(Riunione riunione) {
		if (riunione == this) {
			return 0;
		}
		else if (riunione == null) {
			return 1;
		}
		else if (riunione.anno > this.anno) {
			return -1;
		} else if (riunione.mese > this.mese) {
			return -1;
		} else if (riunione.giorno > this.giorno) {
			return -1;
		} else if (riunione.giorno == this.giorno && riunione.mese == this.mese && riunione.anno == this.anno) {
			return 0;
		} else {
			return 1;
		}
	}
}
