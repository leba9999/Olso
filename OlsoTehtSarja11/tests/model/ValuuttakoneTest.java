package model;

/**
 * @author Auvo Häkkinen
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

class ValuuttakoneTest {

	private IValuuttakone valuuttakone = new Valuuttakone();
	private static IValuuttaDAO valuuttaDAO = new ValuuttaAccessObject();
	
	// Huom: valuutan tunnus on maksimissan 3 merkkiä
	private static Valuutta valuutta1 = new Valuutta("TV1", 10, "Testivaluutta 1");
	private static Valuutta valuutta2 = new Valuutta("TV2", 20, "Testivaluutta 2");
	private final double DELTA = 0.001;
	
	@BeforeAll
	public static void alkutoimet() {
		// Luo kantaan kaksi Valuuttaa näitä testejä varten
		valuuttaDAO.createValuutta(valuutta1);
		valuuttaDAO.createValuutta(valuutta2);
	}
	
	@AfterAll
	public static void lopputoimet() {
		// Poista lopuksi näissä testeissä käytetyt Valuutat tietokannasta
		valuuttaDAO.deleteValuutta(valuutta1.getTunnus());
		valuuttaDAO.deleteValuutta(valuutta2.getTunnus());
		// Yhteyden lopettaminen on valuutaDAO:n destruktorissa 
	}
 	
	@Test
	@DisplayName("Testaa valuuttanimien haku tietokannasta merkkijonotauluun")
	void testGetVaihtoehdot() {
		boolean valuutta1Found = false, valuutta2Found = false;
		String [] valuutat = valuuttakone.getVaihtoehdot();
		for (int i = 0; i < valuutat.length; i++) {
			if  (valuutat[i].equals("Testivaluutta 1")) {
				valuutta1Found = true;
			}
			if  (valuutat[i].equals("Testivaluutta 2")) {
				valuutta2Found = true;
			}
		}
		assertTrue(valuutta1Found && valuutta2Found, "getVaihtoehdot(): Valuuttanimien haku taulukkoon ei onnistunut");
	}

	@Test
	@DisplayName("Testaa valuuttamuunnos")
	void testMuunna() {
		String [] valuutat = valuuttakone.getVaihtoehdot();
		int index1=-1, index2=-1;
		for (int i = 0; i < valuutat.length; i++) {
			if  (valuutat[i].contains("Testivaluutta 1")) {
				index1 = i;
			}
			if  (valuutat[i].contains("Testivaluutta 2")) {
				index2 = i;
			}
		}
		if (index1 == -1) {
			fail("Testivaluutta 1 ei tietokannassa.");
		}
		if (index2 == -1) {
			fail("Testivaluuta 2 ei tietokannassa.");
		}
		
		double tulos = valuuttakone.muunna(index1, index2, 100); // Muunna 100 valuuttayksikköä
		assertEquals(200, tulos, DELTA, "Valuuttamuunnos ei onnistunut");
	}
}
