package kahvila;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Auvo Häkkinen 10.2.2013, muutos 20.8.2019: JUnit Jupiter.
 */

@DisplayName("Valikoima-luokan testaus")
public class ValikoimaTest {

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
    
    // Käyttää samoja tuotteita kaikissa testeissä.
    @BeforeEach
    public void setUp() {
        valikoima = new Valikoima();
        for (Tuote tuote : tuotteita) {
            valikoima.lisääTuote(tuote);
        }
    }

    // Kun yksi testimetodi suoritettu, alkaa tuotenumerointi taas 1:stä.
    @AfterEach
    public void tearDown() {
        Tuote.alustaSeuraavaVapaaTuotenumero();
    }

    @Test
    @DisplayName("Tuotteen lisääminen valikoimaan")
    public void testValikoimaLisääTuoteValikoimaan() {
    	// Huomaa: tuotteet lisätty testin setUP():ssa.
        System.out.println("--- ValikoimaTest: Lisäys - tulostus - haku");
        System.out.println("Lisätty tuotteet:");
        System.out.println(valikoima);

        assertEquals(tuotteita[0], valikoima.getTuote(1), "Haku tuotenumerolla ei täsmää.");
        assertEquals(tuotteita[1], valikoima.getTuote(2), "Haku tuotenumerolla ei täsmää.");
        assertEquals(tuotteita[2], valikoima.getTuote(3), "Haku tuotenumerolla ei täsmää.");
    }

    @Test
    @DisplayName("Tuotteen haku tuotenumerolla")
    public void testValikoimaGetTuote1() {
        System.out.println("--- ValikoimaTest: Haku tuotenumerolla 1");
    	// Hae tuotenumero 1, joka sijaitsee listassa indeksillä 0.
        Tuote tuote = valikoima.getTuote(1);
        System.out.println("Haettu tuote: " + tuote);
        
        // Vertaa kokonaisia olioita, vastinkenttien arvojen oltava samat.
        assertEquals(tuotteita[0], tuote, "Haku tuotenumerolla ei täsmää.");
    }
  
    @Test
    @DisplayName("Tuotteen haku nimellä")
    public void testValikoimaGetTuote3() {
        System.out.println("--- ValikoimaTest: Haku tuotteen nimellä \"Dallaspulla\".");
        Tuote tuote = valikoima.getTuote("Dallaspulla");
        System.out.println("Haettu tuote: " + tuote);
        assertEquals(tuotteita[2], tuote, "Haku tuotteen nimellä ei täsmää.");
    }
    
    @Test
    @DisplayName("Tuotteen poisto valikoimasta")
    public void testValikoimaPoistaTuoteValikoimasta() {
        System.out.println("--- ValikoimaTest: Poisto - tulostus - haku");

        int tuotenumero = 1;
        valikoima.poistaTuote(tuotenumero);

        System.out.println("Poistettu tuote: " + tuotenumero);
        System.out.println("Valikoimassa on tuotteet: ");
        System.out.println(valikoima);

        // Kun tuote poistettu, haun tulee palauttaa null.
        assertEquals(null, valikoima.getTuote(tuotenumero), "Tuotetta ei ole poistettu.");
    }
}
