package saikeet;

/**
* @author Simo Silander. Muutettu 1/2021, Auvo Häkkinen (JUnit 5)
*/


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LuuppaavaSaieTest {

	private LuuppaavaSaie saie;
	private final int KIERROSLKM = 10;

	@BeforeEach
	public void setUp() throws Exception {
		saie = new LuuppaavaSaie(KIERROSLKM);
	}

	@Test
	@DisplayName("run(): suorittaako oikean määrän kierroksia?")
	public void testRun() throws InterruptedException {
		saie.start();
		saie.join();
		// Muuttujilla pakkaustason näkyvyys, joten niihin voi viitata suoraan.
		assertEquals(saie.pyydetytKierrokset, saie.kierretytKierrokset, "run(): kierromäärät eivät täsmää.");
	}

	@Test
	@DisplayName("Konstruktori: alustaako pyydetytKierrokset oikein?")
	public void testLuuppaavaSaie() {
		// Muuttujilla pakkaustason näkyvyys, joten niihin voi viitata suoraan.
		assertEquals(KIERROSLKM, saie.pyydetytKierrokset, "Alustus konstruktorissa ei toimi oikeins");
	}

	@Test
	@DisplayName("getKierretytKierrokset(): palauttaako oikean lukumäärän?")
	public void testGetKierretytKierrokset() {
		// Muuttujilla pakkaustason näkyvyys, joten niihin voi viitata suoraan.
		assertEquals(saie.kierretytKierrokset, saie.getKierretytKierrokset(), "getKierretytKierrokset ei toimi oikein");
	}
}
