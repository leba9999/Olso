package kahvila;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * Author Auvo Häkkinen 10.2.2013, muutos 20.8.2019: JUnit Jupiter.
 */

@DisplayName("Tuote-luokan testaus")
public class TuoteTest {

	@BeforeEach
	public void setUp() {
		Tuote.alustaSeuraavaVapaaTuotenumero();
	}

	@Test
	@DisplayName("Tuotenumeron alustus arvoon 1")
	public void testAlustaSeuraavaVapaaTuotenumero() {
		Tuote pulla = new Tuote("Rähmäpulla", 5); // Ekan numero 1
		assertEquals(1, pulla.getTuotenumero(), "Tuotenumero on väärin.");
		
		Tuote.alustaSeuraavaVapaaTuotenumero(); // Numerointi alkaa taas 1:stä
		pulla = new Tuote("Kotipulla", 5);
		assertEquals(1, pulla.getTuotenumero(), "Tuotenumeron alustus väärin.");
	}

	@Test
	@DisplayName("Tuotteen luonti, tuotenumeron nouto ja tuotenumeron kasvatus")
	public void testNewTuote() {
		Tuote pulla = new Tuote("Rähmäpulla", 5);
		pulla = new Tuote("Kotipulla", 3.5);
		
		assertEquals(2, pulla.getTuotenumero(), "Tuotenumero kasvatus väärin.");
	}

	@Test
	@DisplayName("Tuotteen nimen ja hinnan nouto")
	public void testGetNimiGetHinta() {
		Tuote tuote = new Tuote("Ystävänpäivän munkki", 2.55);
		
		assertEquals("Ystävänpäivän munkki", tuote.getNimi(), "Tuotteen nimi väärin.");
		assertEquals(2.55, tuote.getHinta(), 0.001, "Tuotteen hinta väärin.");
		// Kun tulos liukuluku, kolmantena parametrina tarkkuus (delta),
		// joka ilmaisee minkä verran saatu tulos voi poiketa odotetusta.
	}

	@Test
	@DisplayName("toString(): Tuotteen merkkijonoesitys")
	public void testToString() {
		Tuote tuote = new Tuote("Ystävänpäivän munkki", 2.55);
			
		String result = tuote.toString();
		assertTrue(result.contains("Ystävänpäivän munkki"), "Tuotenimi väärin tai puuttuu.");
		assertTrue(result.contains("1"), "Tuotenumero väärin tai puuttuu.");
		assertTrue(result.contains("2.55"), "Hinta väärin tai puuttuu.");
	}
}

