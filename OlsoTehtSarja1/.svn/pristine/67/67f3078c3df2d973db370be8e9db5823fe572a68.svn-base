package pokerikadet;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Auvo Häkkinen, 2.2.2013. Muutos 20.8.2019 JUnit Jupiter.
 */

public class KorttiTest {
	
	@BeforeAll
	public static void vihje() {
        System.out.println("--- KorttiTest: Konstuktorit, getterit ja setterit\n"
                + "eivät tarvitse yleensä erikseen omia testimetodeja.\n"
                + "Ne tulevat lähes aina testattua muiden metodien testien "
                + "yhteydessä.");
	}

    @Test
    public void testGetMaa() {
        System.out.print("--- KorttiTest: getMaa()");
        Kortti kortti = new Kortti(Kortti.HERTTA, 12);
        int maa = kortti.getMaa();
        assertEquals(Kortti.HERTTA, maa, "getMaa() palautti väärän maan - ");
        System.out.println(" -- OK");
    }

    @Test
    public void testGetArvo() {
        Kortti kortti = new Kortti(Kortti.HERTTA, 12);
        int arvo = kortti.getArvo();
        assertEquals(12, arvo, "getArvo() palautti väärän arvon - ");
        System.out.println("--- KorttiTest: getArvo() -- OK");
    }

    @Test
    public void testToString() {
        Kortti kortti = new Kortti(Kortti.HERTTA, 12); // Herttanen rouva
        String result = kortti.toString();
        assertEquals("Hertta 12", result, "toString() palautti väärän arvon - ");
        System.out.println("--- KorttiTest: toString() -- OK");
    }
}
