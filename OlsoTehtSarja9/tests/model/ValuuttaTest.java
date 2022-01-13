package model;

/**
 * @author hakka
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValuuttaTest {

	private Valuutta valuutta;
	private final static double DELTA = 0.001;

	@BeforeEach
	public void setUp() {
		valuutta = new Valuutta("Euroopan euro", 1.0);
	}

	@Test
	public void testValuutta() {
		try {
			 valuutta = new Valuutta("Euroopan euro", 1.0);
		} catch (Exception e) {
			fail("Valuutta-olion luonti ei onnistunut");
		}
	}

	@Test
	public void testGetNimi() {
		assertEquals("Euroopan euro", valuutta.getNimi(), "Valuutan nimi väärin");
	}

	@Test
	public void testGetVaihtokurssi() {
		assertEquals(1.0, valuutta.getVaihtokurssi(), DELTA, "Valuutan vaihtoarvo väärin");
	}

	@Test
	public void testSetVaihtokurssi() {
		valuutta.setVaihtokurssi(1.01);
		assertEquals(1.01, valuutta.getVaihtokurssi(), DELTA, "Valuutan vaihtokurssin asetus väärin");
	}

}
