package kahvila;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Auvo Häkkinen 10.2.2013, muutos 20.8.2019: JUnit Jupiter.
 */

@DisplayName("Tilausrivi-luokan testaus")
public class TilausriviTest {
	
	private static Valikoima valikoima;
	private static Tilausrivi tilausrivi;
	
	// Kaikissa testeissä sama valikoima ja sama tilausrivi
	@BeforeAll
	public static void setUp() {
		Tuote.alustaSeuraavaVapaaTuotenumero(); // aloita numerosta 1
		Tuote[] tuotteita = { 
				
				new Tuote("Ystävänpäivän munkki", 1.0), // tuotenumero = 1
				new Tuote("Runebergin torttu", 2.55), // tuotenumero = 2
				new Tuote("Dallaspulla", 2.25) // tuotenumero = 3
		};

		valikoima = new Valikoima();
		for (Tuote tuote : tuotteita) {
			valikoima.lisääTuote(tuote);
		}
		
		tilausrivi = new Tilausrivi(valikoima, 3, 5); // tuote 3, 5 kpl
	}
	
	@Test
	@DisplayName("Tilausrivin luonti ja kokonaishinta")
	public void testAnnaSumma() {
		System.out.println("--- TilausriviTest: annaSumma() + tulosta()");

		System.out.println(valikoima);

		// Tilattu 5 kpl tuotetta nro 3. Summa 3*2.25 = 11.25.
		System.out.println("Tilausrivi: ");
		System.out.println(tilausrivi);
		double expResult = 11.25;
		double result = tilausrivi.annaSumma();
		System.out.println("Loppusumma = " + result + " €");
		assertEquals(expResult, result, 0.001, "Kokonaissumma väärin.");
	}
	
	@Test
	@DisplayName("Tilausrivin merkkijonoesitys")
	public void testToString() {
		System.out.println("--- TilausriviTest: toString()");
		String result = tilausrivi.toString();
		System.out.println(result);
		
		assertTrue(result.contains("3"), "Tuotenumero väärin tai puuttuu.");
		assertTrue(result.contains("Dallaspulla"),"Tuotenimi väärin tai puuttuu.");
		assertTrue(result.contains("2.25"), "Yksikköhinta väärin tai puuttuu.");
	}
}
