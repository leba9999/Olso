package saikeet;

/**
* @author Simo Silander. Muutetteu 28.8.2019 Auvo Häkkinen
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OmaSaieTest {

	private OmaSaie saie;

	@BeforeEach
	public void setUp() throws Exception {
		saie = new OmaSaie(5);
		OmaSaie.setYhteisetAjokerrat(0); // Aloiteaan taas alusta
	}

	@AfterEach
	public void tearDown() throws Exception {
		saie = null;

	}

	@Test
	@DisplayName("run(): säikeen suorittaminen.")
	public void testRun() {
		int luku = 5; // Testissä asetettu luku
		int ajokerrat = 0; // Metodia run() ei ole kutsuttu (ei suorittavaa säiettä)

		saie.run(); // sekä luku että ajokerrat kasvavat nyt yhdellä
		assertEquals(luku + 1, saie.getLuku(), "Säikeen run ei toimi oikein (luku)");
		assertEquals(ajokerrat + 1, OmaSaie.getYhteisetAjokerrat(), "Säikeen run ei toimi oikein (staticLuku)");

		OmaSaie saie2 = new OmaSaie(); // luku alustuu 0:ksi
		saie2.run(); // sekä luku että ajokerrat kasvavat jälleen yhdellä
		assertEquals(1, saie2.getLuku(), "Säikeen run ei toimi oikein (luku)");
		assertEquals(ajokerrat + 2, OmaSaie.getYhteisetAjokerrat(), "Säikeen run ei toimi oikein (staticLuku)");
	}

	@Test
	@Order(1)
	@DisplayName("Säikeen luonti, ja arvon alustus konstruktorissa")
	public void testOmaSaie() {
		assertEquals(5, saie.getLuku(), "Alustus konstruktorissa ei toimi oikein");
	}

	@Test
	@Order(2)
	@DisplayName("setLuku(): arvon asetus.")
	public void testSetLuku() {
		saie.setLuku(10);
		assertEquals(10, saie.getLuku(), "setLuku() ei toimi oikein");
	}
	@Test
	@Order(3)
	@DisplayName("getLuku(): arvon palautus.")
	public void testGetLuku() {
		assertEquals(5, saie.getLuku(), "getLuku() ei toimi oikein");
	}

	@Test
	@Order(4)
	@DisplayName("setYhteisetAjokerrat(): ajokertojen lukumäärän asetus.")
	public void testSetYhteisetAjokerrat() {
		OmaSaie.setYhteisetAjokerrat(10);
		assertEquals(10, OmaSaie.getYhteisetAjokerrat(), "setYhteisetAjokerrat() ei toimi oikein");
	}
	@Test
	@Order(5)
	@DisplayName("getYhteisetAjokerrat(): ajokertojen lukumäärän palautus.")
	public void testGetYhteisetAjokerrat() {
		assertEquals(OmaSaie.getYhteisetAjokerrat(), OmaSaie.getYhteisetAjokerrat(),
				"getYhteisetAjokerrat() ei toimi oikein");
	}
}
