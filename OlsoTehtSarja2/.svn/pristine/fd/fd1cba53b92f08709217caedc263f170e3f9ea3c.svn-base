package kahvila;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author Auvo Häkkinen 10.2.2013, muutos 20.8.2019: JUnit Jupiter.
 */
@DisplayName("Kahvila-luokan testaus")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KahvilaTest {

	private Tuote[] tuotteita = { 
		new Tuote("Ystävänpäivän munkki", 1.0), // tuotenumero = 1
		new Tuote("Runebergin torttu", 2.55), // tuotenumero = 2
		new Tuote("Dallaspulla", 2.25) // tuotenumero = 3
	};
	private Valikoima valikoima;

	
    @BeforeAll
    public static void initialise() {
    	// Asettaa tuotenumeroksi 1 ennenkuin luo instanssimuuttujat.
    	// Huom: seuraavaVapaaTuotenumero on staattinen muuttuja.
    	Tuote.alustaSeuraavaVapaaTuotenumero(); 
    }
    
	// Kaikissa testeissä sama valikoima
	@BeforeEach
	public void setUp() {
		Tuote.alustaSeuraavaVapaaTuotenumero();
		valikoima = new Valikoima();
		for (Tuote tuote : tuotteita) {
			valikoima.lisääTuote(tuote);
		}
	}

	@Test
	@DisplayName("lisääTilaus(): Tilaa yksi kappale kutakin tuotetta.")
	public void testLisääTilausKaikkea() {
		System.out.println("--- KahvilaTest: lisääTilaus(), Tilaa yksi kappale kutakin tuotetta.");

		Kahvila kahvila = new Kahvila(valikoima);

		Tilaus tilaus = new Tilaus();
		Tilausrivi tilausrivi;
		for (int tuotenro = 1; tuotenro <= tuotteita.length; tuotenro++) {
			tilausrivi = new Tilausrivi(valikoima, tuotenro, 1);
			tilaus.lisääRivi(tilausrivi);
		}
		kahvila.lisääTilaus(tilaus);
		
		System.out.println(kahvila);
		String result = kahvila.toString();
		assertTrue(result.contains("Ystävänpäivän munkki"), "Tuotteen nimi väärin tai puuttuu.");
		assertTrue(result.contains("Runebergin torttu"), "Tuotteen nimi väärin tai puuttuu.");
		assertTrue(result.contains("Dallaspulla"), "Tuotteen nimi väärin tai puuttuu.");

		// Tuotenumeron mukanaolon tarkastaminen ei suju yhtä suoraviivaisesti, koska
		// numero 1, 2 tai 3 voisi olla myös lukumäärässä tai hinnassa.
		assertTrue(result.contains("1.0"), "Tuotteen hinta väärin tai puuttuu.");
		assertTrue(result.contains("2.55"), "Tuoteen hinta väärin tai puuttuu.");
		assertTrue(result.contains("2.25"), "Tuotteen hinta väärin tai puuttuu.");
		assertTrue(result.contains("5.8"), "Kokonaishinta väärin tai puuttuu.");
	}

	@Test
	@Order(2)
	@DisplayName("lisääTilaus(): Tilaa 2 kpl tuotetta 3.")
	public void testLisääTilausYksi() {
		System.out.println("--- KahvilaTest: lisääTilaus(), Tilaa 2 kpl tuotetta 3.");
		Kahvila kahvila = new Kahvila(valikoima);

		Tilaus tilaus = new Tilaus();
		Tilausrivi tilausrivi = new Tilausrivi(valikoima, 3, 2);
		tilaus.lisääRivi(tilausrivi);
		kahvila.lisääTilaus(tilaus);
		
		System.out.println(kahvila);
		String result = kahvila.toString();
		assertTrue(result.contains("3"), "Tuotteen numero väärin tai puuttuu.");
		assertTrue(result.contains("Dallaspulla"), "Tuotteen nimi väärin tai puuttuu.");
		assertTrue(result.contains("2.25"), "Tuotteen hinta väärin tai puuttuu.");
		assertTrue(result.contains("4.5"), "Kokonaishinta väärin tai puuttuu.");
	}
	
	@Test
	@Order(1)
	@DisplayName("toString(): Kahvilan tilaukset merkkijonona.")
	public void testToString() {
		System.out.println("--- KahvilaTest: toString(), Kahvilan tilaukset merkkijonona.");
		Kahvila kahvila = new Kahvila(valikoima);

		Tilaus tilaus = new Tilaus();
		Tilausrivi tilausrivi = new Tilausrivi(valikoima, 3, 2);
		tilaus.lisääRivi(tilausrivi);
		kahvila.lisääTilaus(tilaus);
		
		System.out.println(kahvila);
		String result = kahvila.toString();
		assertTrue(result.contains("3"), "Tuotteen numero väärin tai puuttuu.");
		assertTrue(result.contains("Dallaspulla"), "Tuotteen nimi väärin tai puuttuu.");
		assertTrue(result.contains("2.25"), "Tuotteen hinta väärin tai puuttuu.");
	}
}
