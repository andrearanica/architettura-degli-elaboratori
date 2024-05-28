import java.lang.IllegalArgumentException;

public class Data {
	private int giorno;
	private int mese;
	private int anno;
	
	public Data(int giorno, int mese, int anno) {
		setGiorno(giorno);
		setMese(mese);
		setAnno(anno);
	}
	
	public void setGiorno(int giorno) {
		if (mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12) {
			if (giorno >= 1 && giorno <= 31) {
				this.giorno = giorno;
			} else {
				throw new IllegalArgumentException("Giorno non valido: il mese ha 31 giorni");
			}
		} else if (mese == 4 || mese == 6 || mese == 9 || mese == 11) {
			if (giorno >= 1 && giorno <= 30) {
				this.giorno = giorno;
			} else {
				throw new IllegalArgumentException("Giorno non valido: il mese ha 30 giorni");	
			}
		} else {
			boolean isBisestile = false;
			if (this.anno % 4 == 0 || this.anno % 100 == 0) {
				isBisestile = true;
			}
			if (giorno >= 1 && giorno <= 28) {
				this.giorno = giorno;
			} else {
				if (giorno == 29 && isBisestile) {
					this.giorno = giorno;
				} else {
					String message = "L'hanno ha ";
					if (isBisestile) {
						message += " 29 giorni";
					} else {
						message += " 28 giorni";
					}
					throw new IllegalArgumentException(message);
				}
			}
		}
	}
	
	public void setMese(int mese) {
		if (mese < 1 || mese > 12) {
			throw new IllegalArgumentException("Mese non valido");
		} else {
			this.mese = mese;
		}
	}
	
	public void setAnno(int anno) {
		if (anno > 0) {
			this.anno = anno;
		} else {
			throw new IllegalArgumentException("Anno non valido");
		}
	}
	
	public static Data estrai(String data) {
		try {
			String[] fields = data.split("\\.");
			int giorno = Integer.parseInt(fields[0]);
			int mese = Integer.parseInt(fields[1]);
			int anno = Integer.parseInt(fields[2]);
			return new Data(giorno, mese, anno);
		} catch (Exception e) {
			throw new IllegalArgumentException("Formato della stringa non valido");
		}
	}
}
