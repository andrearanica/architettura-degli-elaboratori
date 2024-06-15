


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LibreriaTest {

	@Test
	void test1() throws Exception {
		Libreria l = new Libreria("Librieria 1");
		boolean ok;
		ok = l.aggiungiLibro(new Libro("Topolino", "Titolo 1", 2010));
		assertTrue(ok);
		ok = l.aggiungiLibro(new Libro("Paperino", "Titolo A", 2020));
		assertTrue(ok);
		ok = l.aggiungiLibro(new Libro("Paperino", "Un titolo", 2010));
		assertTrue(ok);
		ok = l.aggiungiLibro(new Libro("Topolino", "Un altro titolo", 2020));
		assertTrue(ok);
		ok = l.aggiungiLibro(new Libro("Paperino", "Secondo 1", 2010));
		assertTrue(ok);
		ok = l.aggiungiLibro(new Libro("Topolino", "Secondo A", 2020));
		assertTrue(ok);
		
		ok = l.aggiungiLibro(new Libro("Topolino", "Titolo 1", 2010, 3));
		assertFalse(ok);
		ok = l.aggiungiLibro(new Libro("Paperino", "Un titolo", 2010, 4));
		assertFalse(ok);
		
		System.out.println(l.toString());
		
		int total = l.conta();
		assertEquals(6, total);
		
		List<Libro> rimossi = l.rimuoviLibri(2010);
		assertEquals(3, rimossi.size());
		total = l.conta();
		assertEquals(3, total);
		
		System.out.println(l.toString());		
	}

}
