package model;

/**
 * @author hakka
 */

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.fail;
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ValuuttakoneTest {

	private Valuuttakone valuuttakone = new Valuuttakone();
	private final double DELTA = 0.000001;

	/*
	 * Tehtävän 4 testi: 
	 * Poista kommenteista, kun olet toteuttanut metodin getVaihtoehdot().
	 * 
     */
	@Test
	@DisplayName("Testaa, että kuvan 4 valuuttaa löytyvät")
	public void testGetVaihtoehdot() {
		String[] expected = { "Euroopan euro", "Ruotsin kruunu", "Norjan kruunu", "Yhdysvaltain dollari" };
		String[] vaihtoehdot = valuuttakone.getVaihtoehdot();

		// Jos vaadittasiin sama järjestys kuin tehtävänkuvassa, voi verrata kokonaisia taulukoita
		// assertArrayEquals(expected, vaihtoehdot, 
        //  				 "Valuuttojen nimitaulu ei sama kuin tehtävän kuvassa");

		// Jos ei, niin riittää tsekata yksitellen onko nuo neljä taulukossa jossain
		// järjestyksessä
		Arrays.sort(vaihtoehdot); // binäärihaku vaatii järjestetyn taulukon
		for (String nimi : expected) {
			if (Arrays.binarySearch(vaihtoehdot, nimi) < 0) {
				fail("Valuutan nimi " + nimi + " puuttuu vaihtoehtolistasta");
			}
		}

	}

	@Test
	public void testMuunna() {
		final int EUR = 0, SEK = 1, NOK = 2, USD = 3;
		int määrä = 100;

		String str = "Muunna " + määrä + " EUR "; // Euroopan euroista
		double EURExpected = 100.0;
		assertEquals(EURExpected, valuuttakone.muunna(EUR, EUR, määrä), DELTA, str + "-> EUR ei toimi oikein");
		double SEKExpected = 947.80;
		assertEquals(SEKExpected, valuuttakone.muunna(EUR, SEK, määrä), DELTA, str + "-> SEK ei toimi oikein");
		double NOKExpected = 890.18;
		assertEquals(NOKExpected, valuuttakone.muunna(EUR, NOK, määrä), DELTA, str + "-> NOK ei toimi oikein");
		double USDExpected = 106.29;
		assertEquals(USDExpected, valuuttakone.muunna(EUR, USD, määrä), DELTA, str + "-> USD ei toimi oikein");

		str = "Muunna " + määrä + " SEK"; // Ruotsin kruunuista
		EURExpected = 10.550749;
		assertEquals(EURExpected, valuuttakone.muunna(SEK, EUR, määrä), DELTA, str + "-> EUR ei toimi oikein");
		USDExpected = 11.214391;
		assertEquals(USDExpected, valuuttakone.muunna(SEK, USD, määrä), DELTA, str + "-> USD ei toimi oikein");
	}
}
