import junit.framework.TestCase;

public class TestMiniere extends TestCase {

	public void testEstrazione() {
		Miniera miniere[] = {
			new MinieraDiamanti(2000, 6, 3),
			new MinieraMarmo(1700, 10),
			new MinieraCarbone(50),
			new MinieraMarmo(1200, 16),
			new MinieraCarbone(3000),
			new MinieraDiamanti(150, 4, 7),
		};

		assertEquals(900, miniere[0].estraiEVendi(50));
		assertEquals(44000, miniere[1].estraiEVendi(22));
		assertEquals(250, miniere[2].estraiEVendi(74));
		assertEquals(0, miniere[2].estraiEVendi(179));
		assertEquals(180224, miniere[3].estraiEVendi(22));
		assertEquals(5500, miniere[4].estraiEVendi(1100));
		assertEquals(1400, miniere[5].estraiEVendi(50));
		assertEquals(2800, miniere[5].estraiEVendi(3700));
	}
}