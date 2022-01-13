package saikeet;
/**
* @author Simo Silander. Muutettu 28.9.2019, Auvo Häkkinen
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JuoksijaTest {

	@Test
	@Order(1)
	@DisplayName("new: onko kierrosmäärä alustettu oikein")
	public void testNew() { 
		Juoksija juoksija = new Juoksija();
		assertEquals(0, juoksija.getKierrokset(), "Kierrosmäärä alustettu väärin");
	}

	@Test
	@Order(2)
	@DisplayName("run(): käynnistyykö säie")
	public void testRun() throws InterruptedException { 
		Juoksija juoksija = new Juoksija();
		juoksija.start();
		assertTrue(juoksija.isAlive(), "Säikeen käynnistys ei onnistunut");
		juoksija.lopeta();
	}
	
	@Test
	@Order(3)
	@DisplayName("lopeta(): lopettaako säie pyydettäessä")
	public void testLopeta() throws InterruptedException {
		Juoksija juoksija = new Juoksija();
		juoksija.start();
		Thread.sleep(500); 
		juoksija.lopeta();
		
		assertFalse(juoksija.isJuoksemassa(), "lopeta()-metodi ei muuta lopetusehtoa");
	}

	@Test
	@Order(4)
	@DisplayName("getKierrokset(): kasvaako kierrosmäärä")
	public void testGetKierrokset() throws InterruptedException {
		Juoksija juoksija = new Juoksija();
		juoksija.start();
		
		int kierrokset = juoksija.getKierrokset();
		Thread.sleep(1000); // Yksi kierros 100 ms => 10 kierrosta
		juoksija.lopeta();
		
		int kierroksetNyt = juoksija.getKierrokset();
		assertTrue(kierroksetNyt > kierrokset, "Säikeen kierrokset eivät kasva");
	}
}

