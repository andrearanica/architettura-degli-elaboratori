import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEsame {

	@Test
	void testEsameOraleValido() throws EsameNonValidoException {
		Esame e = new EsameOrale(4, "Prog2", 18);
		assertTrue(e.getCFU() == 4);
		assertTrue(e.getCodice().equals("Prog2"));
		assertTrue(e.voto() == 18);

	}

	@Test
	void testEsameOraleNonValido() {
		try {
			Esame e = new EsameOrale(0, "Prog2", 18);
			fail();
		} catch (EsameNonValidoException e) {
			// OK: deve sollevare l'eccezione
		}
		try {
			Esame e2 = new EsameOrale(4, "Prog2", 17);
			fail();
		} catch (EsameNonValidoException e2) {
			// OK: deve sollevare l'eccezione
		}
		try {
			Esame e2 = new EsameOrale(4, "Prog2", 32);
			fail();
		} catch (EsameNonValidoException e2) {
			// OK: deve sollevare l'eccezione
		}
		try {
			Esame e2 = new EsameOrale(4, null, 32);
			fail();
		} catch (EsameNonValidoException e2) {
			// OK: deve sollevare l'eccezione
		}
	}

	@Test
	void testToStringEsameOrale() throws Exception {
		Esame e = new EsameOrale(4, "prProg2og2", 31);
		String s = e.toString();
		assertTrue(s.contains("4") && s.contains("Prog2") && s.contains("31"));
	}

	@Test
	void testToStringEsameScritto() throws Exception {
		Esame e = new EsameScritto(4, "Prog2", 31, 27);
		String s = e.toString();
		if (!(s.contains("4") && s.contains("Prog2") && s.contains("28.6"))) {
			fail();
		}
	}

	@Test
	void testEsameScrittoValido() {
		try {
			Esame e = new EsameScritto(4, "Prog2", 23, 18);
			assertTrue(e.getCFU() == 4);
			assertTrue(e.getCodice().equals("Prog2"));
			assertEquals(20, e.voto(), 0.001);
		} catch (EsameNonValidoException e) {
			fail();
		}
	}

	@Test
	void testEsameScrittoNonValido() {
		try {
			Esame e1 = new EsameScritto(0, "Prog2", 18, 18);
			fail();
		} catch (EsameNonValidoException e) {
			// OK: deve sollevare l'eccezione
		}
		try {
			Esame e2 = new EsameScritto(4, "Prog2", 17, 18);
			fail();
		} catch (EsameNonValidoException e2) {
			// OK: deve sollevare l'eccezione
		}
		try {
			Esame e2 = new EsameScritto(4, "Prog2", 18, 17);
			fail();
		} catch (EsameNonValidoException e2) {
			// OK: deve sollevare l'eccezione
		}
	}

	@Test
	void testEsameEquals() {
		try {
			Esame e1 = new EsameOrale(4, "Prog2", 18);
			Esame e2 = new EsameOrale(3, "Prog2", 18);
			Esame e3 = new EsameOrale(3, "Prog2", 20);
			Esame e = new EsameOrale(4, "Prog1", 18);
			
			assertTrue(e1.equals(e2));
			assertTrue(e1.equals(e3));
			assertFalse(e1.equals(e));
			
			
			Esame es = new EsameScritto(4, "Prog2", 23, 18);

			assertFalse(e1.equals(es));

			Esame es1 = new EsameScritto(3, "Prog2", 23, 18);
			Esame es2 = new EsameScritto(4, "Prog2", 22, 18);
			Esame es3 = new EsameScritto(4, "Prog2", 23, 19);
			Esame es4 = new EsameScritto(4, "Prog1", 23, 18);
			assertTrue(es.equals(es1));
			assertTrue(es.equals(es2));
			assertTrue(es.equals(es3));
			assertFalse(es.equals(es4));
			
		} catch (EsameNonValidoException e) {
			fail();
		}
	}
	
	
	@Test
	void testLibrettoAggiungiEsame() throws Exception {
		Libretto libretto = new Libretto();
		Esame e = new EsameScritto(4, "Prog2", 18, 18);
		assertTrue(libretto.aggiungiEsame(e));
		assertFalse(libretto.aggiungiEsame(e));
	}

	@Test
	void testMedia() throws Exception {
		Esame e1 = new EsameOrale(8, "Prog2", 21);
		Esame e2 = new EsameOrale(4, "Fisica1", 31);
		Esame e3 = new EsameOrale(12, "Analisi2", 26);
		Libretto libretto = new Libretto();
		assertTrue(libretto.aggiungiEsame(e1));
		assertTrue(libretto.aggiungiEsame(e2));
		assertTrue(libretto.aggiungiEsame(e3));
		assertEquals(25.17, libretto.calcolaMedia(), 0.01);
	}

	@Test
	void testNumeroEsamiSoloOrale() throws Exception {
		Esame e1 = new EsameOrale(8, "Prog2", 21);
		Esame e2 = new EsameScritto(4, "Algo1", 31, 27);
		Esame e3 = new EsameOrale(4, "Fisica1", 31);
		Esame e4 = new EsameScritto(4, "Algo2", 18, 25);
		Esame e5 = new EsameOrale(12, "Analisi2", 26);
		Libretto libretto = new Libretto();
		assertTrue(libretto.aggiungiEsame(e1));
		assertTrue(libretto.aggiungiEsame(e2));
		assertTrue(libretto.aggiungiEsame(e3));
		assertTrue(libretto.aggiungiEsame(e4));
		assertTrue(libretto.aggiungiEsame(e5));
		assertEquals(3, libretto.numeroEsamiSoloOrale());
	}


}
