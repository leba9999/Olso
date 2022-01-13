package model;

/**
 * @author Auvo Häkkinen
*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ValuuttaTest {

	private Valuutta valuutta;
	private final static double DELTA = 0.001;

	@BeforeEach
	public void setUp() {
		valuutta = new Valuutta("EUR", 1.0, "Euroopan euro");
	}

	@Test
	@DisplayName("getTunnus(): Onnistuuko valuutan tunnuksen nouto")
	@Order(1)
	public void testGetTunnus() {
		assertEquals("EUR", valuutta.getTunnus(), "Valuutan tunnus väärin");
	}

	@Test
	@DisplayName("getNimi(): Onnistuuko valuutan nimen nouto")
	@Order(2)
	public void testGetNimi() {
		assertEquals("Euroopan euro", valuutta.getNimi(), "Valuutan tunnus väärin");
	}

	@Test
	@DisplayName("getVaihtokurssi(): Onnistuuko valuutan vaihtokurssin nouto")
	@Order(3)
	public void testGetVaihtokurssi() {
		assertEquals(1.0, valuutta.getVaihtokurssi(), DELTA, "Valuutan vaihtoarvo väärin");
	}

	@Test
	@DisplayName("setTunnus(): Onnistuuko valuutan tunnuksen asetus")
	@Order(4)
	public void testSetTunnus1() {
		valuutta.setTunnus("TWD");
		assertEquals("TWD", valuutta.getTunnus(), "Valuutan tunnuksen asetus ei onnistunut.");
	}
	
	@Test
	@DisplayName("setTunnus(): Tallentaako tunnuksen aina isoilla kirjaimilla")
	@Order(4)
	public void testSetTunnus2() {
		valuutta.setTunnus("eur");
		assertEquals("EUR", valuutta.getTunnus(), "Valuutan tunnukseen kelpaa vain isot kirjaimet.");
	}	

	@Test
	@DisplayName("setTunnus(): Tarkastaako tunnuksen maksimipituuden")
	@Order(4)
	public void testSetTunnus3() {
		valuutta.setTunnus("PITKÄ");
		assertEquals("PIT", valuutta.getTunnus(), "Valuutan tunnus liian pitkä.");
	}	
	
	@Test
	@DisplayName("setNimi(): Onnistuuko nimen asetus")
	@Order(5)
	public void testSetNimi1() {
		valuutta.setNimi("Uuden taiwanin dollari");
		assertEquals("Uuden taiwanin dollari", valuutta.getNimi(), "Valuutan nimen asetus ei onnistunut");
	}
	
	@Test
	@DisplayName("setNimi(): Tarkastaako nimen maksimipituuden")
	@Order(5)
	public void testSetNimi2() {
		valuutta = new Valuutta("TWD", 1.0, "Etelä-Afrikan randin kansainvälinen tunnus 12345678901234567890");
		assertEquals("Etelä-Afrikan randin kansainvälinen tunnus 1234567", valuutta.getNimi(), "Valuutan nimi virheellinen");
	}
	
	@Test
	@DisplayName("setVaihtokurssi(): Onnistuuko vaihtokurssin asetus")
	@Order(6)
	public void testSetVaihtokurssi() {
		valuutta.setVaihtokurssi(1.01);
		assertEquals(1.01, valuutta.getVaihtokurssi(), DELTA, "Valuutan vaihtokurssin päivitys väärin");
	}

	@Test
	@DisplayName("Konstruktori Valuutta(): Tarkastaako nimen maksimipituuden")
	@Order(7)
	public void testValuutta1() {
		valuutta = new Valuutta("TWD", 1.0, "Etelä-Afrikan randin kansainvälinen tunnus 12345678901234567890");
		assertEquals("Etelä-Afrikan randin kansainvälinen tunnus 1234567", valuutta.getNimi(), "Valuutan nimi virheellinen");
	}
	
	@Test
	@DisplayName("Konstruktori Valuutta(): Tarkastaako tunnuksen maksimipituuden")
	@Order(7)
	public void testValuutta2() {
		valuutta = new Valuutta("OKT", 1.0, "OLSO-kurssin testivaluutta");
		assertEquals("OKT", valuutta.getTunnus(), "Valuutan tunnus asetettu väärin");
		valuutta = new Valuutta("OK", 1.0, "OLSO-kurssin testivaluutta");
		assertEquals("OK", valuutta.getTunnus(), "Valuutan tunnus liian lyhyt");
		valuutta = new Valuutta("OKTV", 1.0, "OLSO-kurssin testivaluutta");
		assertEquals("OKT", valuutta.getTunnus(), "Valuutan tunnus liian pitkä");
	}
	
}