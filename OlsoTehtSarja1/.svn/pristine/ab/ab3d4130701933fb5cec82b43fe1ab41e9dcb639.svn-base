package pokerikadet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;

/*
 *
 * @author hakka, 2.2.2013. Muutos 20.8.2019: JUnit Jupiter
 */

@DisplayName("KäsiTest.java: Käsi-luokan testaus")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class KasiTest {

	private Kortti[] kortit = new Kortti[5]; 
	private Kasi käsi;

	// Tämä metodi suoritetaan aina ennen kutakin testimetodia.
	// Kaikissa testeissä on siis lähtötilanteena tämä sama Käsi.
	// Kortteja voi vaihtaa eri testejä varten.
	@BeforeEach
	public void oletusKäsi() {
		kortit[0] = new Kortti(Kortti.HERTTA, 1);
		kortit[1] = new Kortti(Kortti.HERTTA, 3);
		kortit[2] = new Kortti(Kortti.HERTTA, 5);
		kortit[3] = new Kortti(Kortti.HERTTA, 7);
		kortit[4] = new Kortti(Kortti.HERTTA, 9);
	}

	// Tämä metodi suoritetaan aina kunkin testimetodin jälkeen.
	// Metodi tulostaa testissä käytetyn käden.
	@AfterEach
	public void tulostaKäsi() {
		System.out.println(käsi);
	}

	@Test
	@Order(2)
	@DisplayName("annaArvo(): onko tuloksena VÄRI")
	public void testKäsiVäri() {
		System.out.println("--- KäsiTest: annaArvo() -> VÄRI");
		käsi = new Kasi(kortit);
		assertEquals(Kasi.VÄRI, käsi.annaArvo(), "Piti tulla VÄRI");
		assertTrue(Kasi.VÄRISUORA != käsi.annaArvo(), "Piti tulla vain VÄRI, ei VÄRISUORA");	
	}
	
	@Test
	@Order(3)
	@DisplayName("annaArvo(): onko tuloksena EI VÄRI")
	public void testKäsiEiVäri() {
		System.out.println("--- KäsiTest: annaArvo() -> EI VÄRI");
		kortit[0] = new Kortti(Kortti.PATA, 13); // vaihda yksi kortti
		käsi = new Kasi(kortit);
		assertFalse(Kasi.VÄRI == käsi.annaArvo(), "Ei saanut tulla VÄRI");
		assertFalse(Kasi.VÄRISUORA == käsi.annaArvo(), "Ei saanut tulla VÄRISUORA");
	}

	//@Disabled("Liittyy jatkotehtäviin")
	@Test
	@Order(4)
	@DisplayName("annaArvo(): onko tuloksena EI SUORA")
	public void testKäsiEiSuora() {
		System.out.println("--- KäsiTest: annaArvo() -> EI SUORA");
		käsi = new Kasi(kortit);
		assertFalse(Kasi.SUORA == käsi.annaArvo(), "Ei saanut tulla SUORA");
		assertFalse(Kasi.VÄRISUORA == käsi.annaArvo(), "Ei saanut tulla VÄRISUORA");
	}

	//@Disabled("Liittyy jatkotehtäviin")
	@Test
	@Order(5)
	@DisplayName("annaArvo(): onko tuloksena SUORA")
	public void testKäsiSuora() {
		System.out.println("--- KäsiTest: annaArvo() -> SUORA");
		kortit[0] = new Kortti(Kortti.HERTTA, 9);
		kortit[1] = new Kortti(Kortti.RUUTU, 10);
		kortit[2] = new Kortti(Kortti.RISTI, 12);
		kortit[3] = new Kortti(Kortti.PATA, 11);
		kortit[4] = new Kortti(Kortti.HERTTA, 8);
		käsi = new Kasi(kortit);
		assertEquals(Kasi.SUORA, käsi.annaArvo(), "Piti tulla SUORA");
		assertTrue(Kasi.VÄRISUORA != käsi.annaArvo(), "Piti tulla vain SUORA, ei VÄRISUORA)");
	}

	
	//@Disabled("Liittyy jatkotehtäviin")
	@Test
	@Order(6)
	@DisplayName("annaArvo(): onko tuloksena SUORA, kun Ässä=1")
	public void testKäsiÄssäSuora() {
		System.out.println("--- KäsiTest: annaArvo() -> SUORA");
		kortit[0] = new Kortti(Kortti.HERTTA, 1);
		kortit[1] = new Kortti(Kortti.RUUTU, 2);
		kortit[2] = new Kortti(Kortti.RISTI, 3);
		kortit[3] = new Kortti(Kortti.PATA, 4);
		kortit[4] = new Kortti(Kortti.HERTTA, 5);
		käsi = new Kasi(kortit);
		assertEquals(Kasi.SUORA, käsi.annaArvo(), "Piti tulla SUORA (Ässä=1)");
		assertTrue(Kasi.VÄRISUORA != käsi.annaArvo(), "Piti tulla vain SUORA (Ässä=1), ei VÄRISUORA");
	}

	//@Disabled("Liittyy jatkotehtäviin")
	@Test
	@Order(7)
	@DisplayName("annaArvo(): onko tuloksena SUORA, kun Ässä=14")
	public void testKäsiÄssäSuora2() {
		System.out.println("--- KäsiTest: annaArvo() -> SUORA");
		kortit[0] = new Kortti(Kortti.HERTTA, 1); // tulkitaan arvoksi 14
		kortit[1] = new Kortti(Kortti.RUUTU, 10);
		kortit[2] = new Kortti(Kortti.RISTI, 11);
		kortit[3] = new Kortti(Kortti.PATA, 12);
		kortit[4] = new Kortti(Kortti.HERTTA, 13);
		käsi = new Kasi(kortit);
		assertEquals(Kasi.SUORA, käsi.annaArvo(), "Piti tulla SUORA (Ässä=14)");
		assertTrue(Kasi.VÄRISUORA != käsi.annaArvo(), "Piti tulla vain SUORA (Ässä=14), ei VÄRISUORA");
	}

	//@Disabled("Liittyy jatkotehtäviin")
	@Test
	@Order(8)
	@DisplayName("annaArvo(): onko tuloksena EI VÄRISUORA")
	public void testKäsiEiVäriSuora() {
		System.out.println("--- KäsiTest: annaArvo() -> EI VÄRISUORA");
		kortit[0] = new Kortti(Kortti.PATA, 13);
		käsi = new Kasi(kortit);
		assertEquals(Kasi.EISUORA, käsi.annaArvo(), "Ei saanut tulla VÄRISUORA");
	}

	//@Disabled("Liittyy jatkotehtäviin")
	@Test
	@Order(9)
	@DisplayName("annaArvo(): onko tuloksena VÄRISUORA")
	public void testKäsiVäriSuora() {
		System.out.println("--- KäsiTest: annaArvo() -> VÄRISUORA");
		kortit[0] = new Kortti(Kortti.RUUTU, 3);
		kortit[1] = new Kortti(Kortti.RUUTU, 4);
		kortit[2] = new Kortti(Kortti.RUUTU, 5);
		kortit[3] = new Kortti(Kortti.RUUTU, 6);
		kortit[4] = new Kortti(Kortti.RUUTU, 7);
		käsi = new Kasi(kortit);
		assertEquals(Kasi.VÄRISUORA, käsi.annaArvo(), "Piti tulla VÄRISUORA");
	}

	@Test
	@Order(1)
	@DisplayName("toString(): onko tuloksena oikein muotoiltu merkkijono")
	public void testKäsiToString() {
		System.out.println("--- KäsiTest: toString()");
		Pakka pakka = new Pakka(); // sekoittamaton
		käsi = new Kasi(pakka);
		String expResult = "Hertta 1, Hertta 2, Hertta 3, Hertta 4, Hertta 5";
		String result = käsi.toString();
		assertEquals(expResult, result,"Merkkijonon muotoilu väärin");
	}
}
