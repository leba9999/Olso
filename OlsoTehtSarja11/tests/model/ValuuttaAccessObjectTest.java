package model;

/**
 * @author Auvo Häkkinen
 *
 * Tällä voi testata kummankin toteutustavan (OlsoTeht11 ja OlsoTeht12).
 *
 * TestMethodOrder tullut mukaan vasta JUnit 5.4:ssä.
 * Eclipse Photoniin integroitu JUnit on vanhempi.
 * Lataa uudempi JUnit ja lisää se Eclipse projektiin:
 *   - klikkaa projektin nimeä hiiren oikealla
 *   - valitse Build Path | Configure Build Path | Add External JAR's
 */

import org.junit.jupiter.api.Test;

/* Nämä löytyvät vasta Junit 5.4:stä alkaen. */
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;



/* Vasta JUnit 5.4:stä alkaen */
@DisplayName("ValuuttaDAO: tietokantatoimintojen (CRUD) testaus")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ValuuttaAccessObjectTest {

	private IValuuttaDAO valuuttaDAO = new ValuuttaAccessObject(); // Sama DAO

	private final String tunnus = "TST"; // Testauksessa käytettävän valuutan tunnus
	private final double vaihtokurssi = 2021.152;
	private final String nimi = "Juhlavuoden testausmarkka";
	private Valuutta valuutta = new Valuutta(tunnus, vaihtokurssi, nimi);
	private final double DELTA = 0.0001;

	// Testeissä aina sama valuutta
	@BeforeEach
	public void alkutoimet() {
		valuutta = new Valuutta(tunnus, vaihtokurssi, nimi);
	}
	
	// Koska tässä käytetään oikeaa tietokantaa, testeissä tehdyt muutokset
	// pitää tietysti perua, siksi AINA lopuksi deleteValuutta()
	@AfterEach
	public void lopputoimet() {
		valuuttaDAO.deleteValuutta(tunnus);
	}
 
	/* 
	================================================================================================================
	@Test
	@DisplayName("Tässä kaikki testit yhdessä metodissa.")
	public void testDAO() {
		// Jos joku testi ei mene läpi, tämän metodin suoritus päättyy heti.
		
		// Lisää valuutta
		assertTrue(valuuttaDAO.createValuutta(valuutta), "createValuutta(): Uuden valuutan lisääminen ei onnistu.");

		assertFalse(valuuttaDAO.createValuutta(valuutta),
				"createValuutta(): Saman valuutan pystyy lisäämään kahteen kertaan.");

		// Nyt haun tulee onnistua ja kenttien tulee tietenkin olla asetettu oikein
		assertTrue((valuutta = valuuttaDAO.readValuutta(tunnus)) != null,
				"readValuutta(): Juuri lisätyn valuutan hakeminen ei onnistunut");
		assertEquals(tunnus, valuutta.getTunnus(), "readValuutta(): Valuutan tunnus väärin.");
		assertEquals(vaihtokurssi, valuutta.getVaihtokurssi(), DELTA, "readValuutta(): Valuutan vaihtoarvo värin.");
		assertEquals(nimi, valuutta.getNimi(), "readValuutta(): Valuutan nimi väärin.");

		// Vaihtokurssin muutoksen tulee onnistua
		valuutta.setVaihtokurssi(2021.1206);
		assertTrue(valuuttaDAO.updateValuutta(valuutta),
				"updateValuutta(): Juuri lisätyn valuutan vaihtokurssin päivitys ei onnistunut.");
		valuutta = valuuttaDAO.readValuutta(tunnus);
		assertEquals(2021.1206, valuutta.getVaihtokurssi(), DELTA, "updateValuutta(): Vaihtokurssin arvo väärin.");

		// Valuutan nimen muutoksen tulee onnistua

		valuutta.setNimi("Suomen testivaluutta");
		assertTrue(valuuttaDAO.updateValuutta(valuutta),
				"updateValuutta(): Juuri lisätyn valuutan nimen päivitys ei onnistunut.");
		valuutta = valuuttaDAO.readValuutta(tunnus);
		assertEquals("Suomen testivaluutta", valuutta.getNimi(), "updateValuutta(): Valuutan nimi väärin.");

		// Testissä lisätyn valuutan poiston tulee onnistua
		assertTrue(valuuttaDAO.deleteValuutta(tunnus), "deleteValuutta(): Valuutan poisto ei onnistunut.");
		assertTrue(valuuttaDAO.readValuutta(tunnus) == null,
				"deleteValuutat(): Valuutan poisto ei onnistunut - valuutta voitiin hakea tietokannasta.");

		// Olemattoman valuutan poiston tulee "epäonnistua"
		assertFalse(valuuttaDAO.deleteValuutta("PUPPU"),
				"deleteValuutta(): Väittää poistaneensa olemattoman valuutan.");
	}
	===============================================================================================================
	*/

	/* Allaolevat testit suoritetaan tietyssä kiinteässä järjestyksessä.
	 * MUTTA siitä huolimatta edellisen testin tuloksesta ei voi olettaa yhtään mitään.
	 * Ne vaativat vähintään JUnit 5.4:n
	 * */
	@Test
	@DisplayName("Valuutan lisäämisen tulee onnistua")
	@Order(1)
	public void testLisää() {
		assertTrue(valuuttaDAO.createValuutta(valuutta), "createValuutta(): Uuden valuutan lisääminen ei onnistu.");
		
		// Nyt haun tulee onnistua ja jokaisen kentän tulee tietenkin olla asetettu oikein
		assertTrue((valuutta = valuuttaDAO.readValuutta(tunnus)) != null, "readValuutta(): Juuri lisätyn valuutan hakeminen ei onnistunut");
		assertEquals(tunnus, valuutta.getTunnus(), "readValuutta(): Valuutan tunnus väärin.");
		assertEquals(vaihtokurssi, valuutta.getVaihtokurssi(), DELTA, "readValuutta(): Valuutan vaihtoarvo värin.");
		assertEquals(nimi, valuutta.getNimi(), "readValuutta(): Valuutan nimi väärin.");
	}

	@Test
	@DisplayName("Samaa valuutta ei saa lisätä toistamiseen")
	@Order(2)
	public void testLisää2() {
		assertTrue(valuuttaDAO.createValuutta(valuutta), "createValuutta(): Uuden valuutan lisääminen ei onnistu.");
		assertFalse(valuuttaDAO.createValuutta(valuutta),
				"createValuutta(): Saman valuutan pystyy lisäämään kahteen kertaan.");
	}

	@Test
	@DisplayName("Valuutan haun tulee onnistua")
	@Order(3)
	public void testHaku() {
		assertTrue(valuuttaDAO.createValuutta(valuutta), "createValuutta(): Uuden valuutan lisääminen ei onnistu.");
		// Nyt haun tulee onnistua ja kenttien tulee tietenkin olla asetettu oikein
		assertTrue((valuutta = valuuttaDAO.readValuutta(tunnus)) != null,
				"readValuutta(): Juuri lisätyn valuutan hakeminen ei onnistunut");
		assertEquals(tunnus, valuutta.getTunnus(), "readValuutta(): Valuutan tunnus väärin.");
		assertEquals(vaihtokurssi, valuutta.getVaihtokurssi(), DELTA, "readValuutta(): Valuutan vaihtoarvo värin.");
		assertEquals(nimi, valuutta.getNimi(), "readValuutta(): Valuutan nimi väärin.");
	}

	@Test
	@DisplayName("Olemattoman valuutan haun tulee palauttaa null")
	@Order(4)
	public void testHaku2() {
		assertTrue(valuuttaDAO.readValuutta("NOP") == null, "readValuutta(): Olemattoman valuutan haun piti palauttaa false");
		assertEquals(tunnus, valuutta.getTunnus(), "readValuutta(): Valuutan tunnus väärin.");
		assertEquals(vaihtokurssi, valuutta.getVaihtokurssi(), DELTA, "readValuutta(): Valuutan vaihtoarvo värin.");
		assertEquals(nimi, valuutta.getNimi(), "readValuutta(): Valuutan nimi väärin.");
	}

	@Test
	@DisplayName("Valuutan vaihtokurssin muutoksen tulee onnistua")
	@Order(5)
	public void testVaihtokurssi() {
		assertTrue(valuuttaDAO.createValuutta(valuutta), "createValuutta(): Uuden valuutan lisääminen ei onnistu.");

		valuutta.setVaihtokurssi(2021.1206);
		assertTrue(valuuttaDAO.updateValuutta(valuutta), "updateValuutta(): Juuri lisätyn valuutan vaihtokurssin päivitys ei onnistunut.");
		valuutta = valuuttaDAO.readValuutta(tunnus);
		assertEquals(2021.1206, valuutta.getVaihtokurssi(), DELTA, "updateValuutta(): Vaihtokurssin arvo väärin.");
	}

	@Test
	@DisplayName("Valuutan nimen muutoksen tulee onnistua")
	@Order(6)
	public void testNimi() {
		assertTrue(valuuttaDAO.createValuutta(valuutta), "createValuutta(): Uuden valuutan lisääminen ei onnistu.");

		valuutta.setNimi("Suomen testivaluutta");
		assertTrue(valuuttaDAO.updateValuutta(valuutta), "updateValuutta(): Juuri lisätyn valuutan nimen päivitys ei onnistunut.");
		valuutta = valuuttaDAO.readValuutta(tunnus);
		assertEquals("Suomen testivaluutta", valuutta.getNimi(), "updateValuutta(): Valuutan nimi väärin.");
	}

	@Test
	@DisplayName("Valuutan poiston tulee onnistuttua")
	@Order(7)
	public void testPoisto() {
		assertTrue(valuuttaDAO.createValuutta(valuutta), "createValuutta(): Uuden valuutan lisääminen ei onnistu.");

		assertTrue(valuuttaDAO.deleteValuutta(tunnus), "deleteValuutta(): Valuutan poisto ei onnistunut.");
		assertTrue(valuuttaDAO.readValuutta(tunnus) == null,
				"deleteValuutat(): Valuutan poisto ei onnistunut - valuutta voitiin hakea tietokannasta.");
	}

	@Test
	@DisplayName("Olemattoman valuutan poistoyrityksen tulee palauttaa false")
	@Order(8)
	public void testPoisto2() {
		assertFalse(valuuttaDAO.deleteValuutta("NOP"), "deleteValuutta(): Väittää poistaneensa olemattoman valuutan.");
	}
	
}
