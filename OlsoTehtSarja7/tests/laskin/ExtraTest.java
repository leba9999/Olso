package laskin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExtraTest extends AbstractParent {

    private static Laskin laskin = new Laskin();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testVirtaON() {
        System.out.println("@BeforeAll Virta ON (ennen ensimmäistä testiä)");
        laskin.virtaON();
    }

    @AfterAll
    public static void testVirtaOFF() {
        System.out.println("@AfterAll Virta OFF (kaikki testit ajettu).");
        laskin.virtaOFF();
        laskin = null;
    }

    @BeforeEach
    public void testNollaa() {
        System.out.println("  Nollaa laskin.");
        laskin.nollaa();
        assertEquals(0, laskin.annaTulos(), "Nollaus ei onnistunut");
    }

    @Test
    public void testNelio2() {
        laskin.nelio(2);
        assertEquals(4, laskin.annaTulos(), DELTA, "Luvun 2 Neliöön korotus väärin");
    }

    @Test
    public void testNelio4() {
        laskin.nelio(4);
        assertEquals(16, laskin.annaTulos(), DELTA, "Luvun 4 neliöön korotus väärin");
    }

    @Test
    public void testNelio5() {
        laskin.nelio(5);
        assertEquals(25, laskin.annaTulos(), DELTA,"Luvun 5 neliöön korotus väärin");
    }
    @Test
    public void testNeliojuuri2() {
		laskin.neliojuuri(2);
        assertEquals(Math.sqrt(2), laskin.annaTulos(), DELTA,"Luvun 2 neliöjuuri väärin");
    }

	@Test
	@DisplayName("jaa(): laskeeko jakolaskun oikein desimaaleilla")
	public void testJaa() {
		laskin.lisaa(5);
		laskin.jaa(2);
		assertEquals(2.5, laskin.annaTulos(), DELTA, "Lukujen 5 ja 2 jakolasku väärin");
	}
    @Test
    @DisplayName("Testaa negatiivinen neliöjuuri")
    public void testNeliojuuriNegat() {
		IllegalArgumentException poikkeus = assertThrows(IllegalArgumentException.class, () -> laskin.neliojuuri(-1), 
                "Negatiivisesta numerosta otettu neliöjuuri ei tuottanut poikkeusta");
		assertEquals("Negatiivisella luvulla ei ole neliöjuurta", poikkeus.getMessage(), "Väärä virheilmoitus");
    }
}