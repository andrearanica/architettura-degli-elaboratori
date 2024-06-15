
public class Libro {
	private String autore;
	private String titolo;
	private int anno;
	private int numeroVolume;
	
	public Libro(String autore, String titolo, int anno) throws LibroException {
		if (autore == null || autore.isBlank()) {
			throw new LibroException("errore su autore");
		}
		this.autore = autore;
		if (titolo == null || titolo.isBlank()) {
			throw new LibroException("errore su titolo");
		}
		this.titolo = titolo;
		this.anno = anno;
		this.numeroVolume = 0;
	}

	public Libro(String autore, String titolo, int anno, int numeroVolume) throws LibroException {
		this(autore, titolo, anno);
		if (numeroVolume <= 0) {
			throw new LibroException("errore su volume");
		}
		this.numeroVolume = numeroVolume;
	}

	public String getAutore() {
		return autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getAnno() {
		return anno;
	}

	public int getNumeroVolume() {
		return numeroVolume;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + 
				", titolo=" + titolo + 
				", anno=" + anno + 
				", numeroVolume=" + numeroVolume + 
				"]";
	}
	
	public boolean equals(Libro libro) {
		return libro.anno == anno && libro.autore == autore && libro.titolo == titolo;
	}
}
