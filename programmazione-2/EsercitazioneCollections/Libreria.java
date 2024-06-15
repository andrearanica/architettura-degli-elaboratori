import java.util.ArrayList;

public class Libreria {
	private String nome;
	private ArrayList<Libro> libri;
	
	public Libreria(String nome) {
		this.nome = nome;
		ArrayList<Libro> libri = new ArrayList<Libro>();
	}
	
	public boolean aggiungiLibro(Libro libro) {
		for (Libro l: libri) {
			if (l.equals(libro)) {
				return false;
			}
		}
		libri.add(libro);
		return true;
	}
}