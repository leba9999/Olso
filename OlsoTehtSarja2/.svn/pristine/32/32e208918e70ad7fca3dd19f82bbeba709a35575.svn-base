package kahvila;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Auvo Häkkinen 10.2.2013, muutos 20.8.2019: JUnit Jupiter.
 */

@DisplayName("Tilaus-luokan testaus")
public class TilausTest {

    @Test
    @DisplayName("Tilausrivin lisäys tilaukseen")
    public void testLisääRiviTilaukseen() {
        System.out.println("--- TilausTest: Lisä rivit - tulosta - loppusumma");

        Valikoima valikoima = new Valikoima();
        Tuote[] tuotteita = {
            new Tuote("Ystävänpäivän munkki", 1.0), // tuotenumero = 1
            new Tuote("Runebergin torttu", 2.55), // tuotenumero = 2
            new Tuote("Dallaspulla", 2.25) // tuotenumero = 3
        };

        for (Tuote tuote : tuotteita) {
            valikoima.lisääTuote(tuote);
        }
        System.out.println("Tuotevalikoima:\n" + valikoima);

        // Tilaa 10 kpl kutakin tuotetta
        Tilaus tilaus = new Tilaus();
        Tilausrivi tilausrivi;
        for (int tuotenro = 1; tuotenro <= tuotteita.length; tuotenro++) {
            tilausrivi = new Tilausrivi(valikoima, tuotenro, 10);
            tilaus.lisääRivi(tilausrivi);
        }
        double summa = tilaus.annaLoppusumma();
        System.out.println("Tilaus:");
        System.out.println(tilaus);
        System.out.println("Loppusumma on " + summa + "€");

        assertEquals(58.0, summa, 0.001, "Loppusumma ei täsmää.");
    }
}
