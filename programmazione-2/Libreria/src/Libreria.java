import java.util.HashSet;
import java.util.ArrayList;

public class Libreria {
	private String nome;
	private HashSet<Libro> libri;
	
	public Libreria(String nome) {
		this.nome = nome;
		this.libri = new HashSet<Libro>();
	}
	
	public boolean aggiungiLibro(Libro libro) {
		boolean result = this.libri.add(libro);
		return result;
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
	
	public String toString() {
		String stringToReturn = "";
		for (Libro libro: this.libri) {
			stringToReturn += libro.getAutore() + " " + libro.getTitolo() + ";";
		}
		return stringToReturn;
	}
}
