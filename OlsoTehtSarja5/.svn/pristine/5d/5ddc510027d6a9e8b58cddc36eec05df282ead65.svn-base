package saikeet;

/**
* @author Auvo Häkkinen 2019, muutettu 1/2021 Auvo Häkkinen.
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KilpajuoksijaTest {

	@BeforeEach
	public void setUp() {
		Kilpajuoksija.setSeuraavaNumero(1);
	}
	
	@Test
	@Order(1)
	@DisplayName("new: asetetaanko juoksijanumerot oikein")
	public void testNewAlkuarvo() {
		Kilpajuoksija juoksija = new Kilpajuoksija();
		assertEquals(1, juoksija.getNumero(), "Juoksijanumeron alkuarvo väärin.");
		juoksija = new Kilpajuoksija();
		assertEquals(2, juoksija.getNumero(), "Juoksijanumeron kasvatus konstruktorissa väärin.");
	}
	
	@Test
	@Order(2)
	@DisplayName("run(): käynnistyykö säie")
	public void testRun() throws InterruptedException { 
		System.out.println("Säikeen käynnistys");
		Kilpajuoksija juoksija = new Kilpajuoksija();
		juoksija.start();
		assertTrue(juoksija.isAlive(), "Säikeen käynnistys ei onnistunut");
		System.out.println("Testilähtö peruutettu, säie lopetettu");
		juoksija.stop(); // deprecated, tässä OK
	}
	
	@DisplayName("getAika(): ODOTA juoksun päättymistä (yli 43 sek)! Onko aika realistinen.")
	@Test
	public void testRealistisuus() throws InterruptedException {
		System.out.println("Tarkastaa onko aika realistinen? ODOTA juoksun päättymistä.");
		Kilpajuoksija juoksija = new Kilpajuoksija();
		juoksija.start();
		
		juoksija.join();
		double aika = juoksija.getAika();
		assertTrue(aika>=43 && aika <=60, "Epärealistinen aika: " + juoksija + " (aika < 43s tai aika > 60s).");
	}

}
