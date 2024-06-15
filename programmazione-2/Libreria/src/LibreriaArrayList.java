import java.util.ArrayList;

public class LibreriaArrayList {
	private String nome;
	private ArrayList<Libro> libri;
	
	public Libreria(String nome) {
		this.nome = nome;
		this.libri = new ArrayList<Libro>();
	}
	
	public boolean aggiungiLibro(Libro libro) {
		for (Libro libroInList: this.libri) {
			if (libroInList.equals(libro)) {
				return false;
			}
		}
		this.libri.add(libro);
		return true;
	}
	
	public int conta() {
		return this.libri.size();
	}
	
	public ArrayList<Libro> rimuoviLibri(int anno) {
		ArrayList<Libro> removedLibri = new ArrayList<Libro>();
		for (Libro libroInList: this.libri) {
			if (libroInList.getAnno() == anno) {
				removedLibri.add(libroInList);
			}
		}
		for (Libro libroToRemove: removedLibri) {
			this.libri.remove(libroToRemove);
		}
		return removedLibri;
	}
}
