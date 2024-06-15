import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuditTest {

	@Test
	void testBenefitAlto1() throws Exception {
		Dirigente d = new Dirigente("Topolino", 10, 10000, 100000);
		Audit audit = new Audit();
		boolean result = audit.benefitTroppoAlto(d);
		assertTrue(result);		
	}

	@Test
	void testBenefitAlto2() throws Exception {
		Impiegato i = new Impiegato("Paperino", 10, 1000);
		Audit audit = new Audit();
		boolean result = audit.benefitTroppoAlto(i);
		assertFalse(result);		
	}
	
	@Test
	void testBenefitAlto3() {
		Audit audit = new Audit();
		boolean result = audit.benefitTroppoAlto(null);
		assertFalse(result);		
	}
	
	
/*	@Test
	void testIsSorted() throws InvalidArrayException {
		boolean sorted;
		Audit audit = new Audit();
		try {
			sorted = audit.isSorted(null);
			fail(); 
		} catch (InvalidArrayException e) {
			// OK: ci si aspetta che sia sollevata l'eccezione  
		}

		try {
			Dipendente[] array = new Dipendente[] {null, null};
			sorted = audit.isSorted(array);
			fail();
		} catch (InvalidArrayException e) {
			// OK: ci si aspetta che sia sollevata l'eccezione  
		}
		
		sorted = audit.isSorted(new Dipendente[0]);
		assertTrue(sorted); // ci si aspetta che l'array vuoto sia considerato "sorted"

		Dirigente d = new Dirigente("Topolino", 10, 10000, 100000);
		Impiegato i = new Impiegato("Paperino", 10, 1000);

		Dipendente[] array1 = new Dipendente[] {i, d};
		sorted = audit.isSorted(array1);
		assertFalse(sorted); // ci si aspetta che il check fallisca
		
		Dipendente[] array2 = new Dipendente[] {d, i};
		sorted = audit.isSorted(array2);
		assertTrue(sorted); // ci si aspetta che il check abbia successo
	}
*/	
	
/*	@Test
	void testTopRal() throws InvalidArrayException {
		Dipendente top;
		Audit audit = new Audit();
		try {
			Dipendente[] array = new Dipendente[] {null, null};
			top = audit.topRal(array);
			fail();
		} catch (InvalidArrayException e) {
			// OK: ci si aspetta che sia sollevata l'eccezione  
		}
		
		Dirigente d = new Dirigente("Topolino", 10, 10000, 100000);
		Impiegato i = new Impiegato("Paperino", 10, 1000);

		try {
			Dipendente[] array1 = new Dipendente[] {i, d}; // array non ordinato
			top = audit.topRal(array1);
			fail();
		} catch (InvalidArrayException e) {
			// OK: ci si aspetta che sia sollevata l'eccezione  
		}
		
		Dipendente[] array2 = new Dipendente[] {d, i};
		top = audit.topRal(array2);
		assertEquals(d, top); // ci si aspetta d

		try {
			top = audit.topRal(new Dipendente[0]);
		} catch (InvalidArrayException e) {
			// OK: ci si aspetta che sia sollevata l'eccezione  
		}
	}
*/	
}
