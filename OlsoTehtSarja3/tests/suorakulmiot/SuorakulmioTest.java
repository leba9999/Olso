package suorakulmiot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Kun luokka on olemassa, sille voi luoda JUnit-testiluokan Eclipsessä
 * klikkaamalla testattavan Java-tiedoston nimeä hiiren oikealla ja valitsemalla
 * New | JUnit Test Case
 * 
 * @author hakka, 20.1.2013, muutos 20.8.2019: JUnit Jupiter.
 */
public class SuorakulmioTest {

	/*
	 * @BeforeAll -annotaatiolla merkitty metodi suoritetaan kerran alussa, ennen
	 * kuin JUnit suorittaa yhtäkään varsinaisia testimetodeja.
	 */
	@BeforeAll
	public static void setUpClass() throws Exception {
		System.out.println("===========================");
		System.out.println("SuorakulmioTest: @BeforeAll");
	}

	/*
	 * @AfterAll-annotaatiolla merkitty metodi suoritetaan kerran lopussa, kun JUnit
	 * on suorittanut kaikki testimetodit.
	 */
	@AfterAll
	public static void tearDownClass() throws Exception {
		System.out.println("SuorakulmioTest: @AfterAll");
		System.out.println("===========================");
	}

	/*
	 * @BeforeEach -annotaatiolla merkitty metodi suoritetaan aluksi, ennen kuin
	 * JUnit suorittaa yksittäisen testimetodin.
	 */
	@BeforeEach
	public void setUp() {
		System.out.println("SuorakulmioTest: @BeforeEach");
	}

	/*
	 * @AfterEach -annotaatiolla merkitty metodi suoritetaan lopuksi, kun JUnit on
	 * suorittanut yksittäisen testimetodin.
	 */
	@AfterEach
	public void tearDown() {
		System.out.println("Suorakulmiotest: @AfterEach");
		System.out.println("---------------------------");
	}

	@Test
	public void testKorkeus() {
		System.out.println("setKorkeus() ja getKorkeus()");
		int korkeus = 100;
		Suorakulmio instance = new Suorakulmio();
		instance.setKorkeus(korkeus);
		int result = instance.getKorkeus();
		assertEquals(korkeus, result, "setKorkeus() tai getKorkeus() ei kunnossa");
	}

	@Test
	public void testLeveys() {
		System.out.println("setLeveys() ja getLeveys()");
		int leveys = 0;
		Suorakulmio instance = new Suorakulmio();
		instance.setLeveys(leveys);
		int result = instance.getLeveys();
		assertEquals(leveys, result, "setLeveys() tai getLeveys() ei kunnossa");
	}

	@Test
	public void testAla() {
		System.out.println("ala()");
		Suorakulmio instance = new Suorakulmio(10, 5);
		int expResult = 50;
		int result = instance.ala();
		assertEquals(expResult, result, "ala() ei kunnossa");
	}

	@Test
	public void testToString() {
		System.out.println("toString()");
		Suorakulmio instance = new Suorakulmio(99, 10);
		String expResult = "leveys=99, korkeus=10";
		String result = instance.toString();
		assertEquals(expResult, result, "toString() ei kunnossa");
	}
}
