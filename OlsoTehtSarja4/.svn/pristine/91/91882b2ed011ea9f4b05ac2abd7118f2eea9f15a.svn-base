package valtiot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ValtioTest {
	private static Valtio valtio;

	@BeforeEach
	public void alkutoimet() {
		valtio = new Valtio("Suomi", "Helsinki", 634940);
	}

	@Test
	@Order(1)
	public void testGetNimi() {
		assertEquals("Suomi", valtio.getNimi(), "Nimi väärin ");
	}

	@Test
	@Order(2)
	public void testSetNimi() {
		valtio.setNimi("Finland");
		assertEquals("Finland", valtio.getNimi(),"Nimi väärin ");
	}

	@Test
	@Order(3)
	public void testGetPääkaupunki() {
		assertEquals("Helsinki", valtio.getPääkaupunki(),"Pääkaupunki väärin");
	}

	@Test
	@Order(4)
	public void testSetPääkaupunki() {
		valtio.setPääkaupunki("Helsingfors");
		assertEquals("Helsingfors", valtio.getPääkaupunki(),"Pääkaupunki väärin ");
	}

	@Test
	@Order(5)
	public void testGetAsukasluku() {
		assertEquals(634940, valtio.getAsukasluku(),"Asukasluku väärin" );
	}

	@Test
	@Order(6)
	public void testSetAsukasluku() {
		valtio.setAsukasluku(20);
		assertEquals(20, valtio.getAsukasluku(), "Asukasluku väärin ");
	}

	@Test
	public void testToString() {
		String str = valtio.toString();
		assertTrue(str.contains("Suomi"), "Valtion nimi väärin : pitäisi olla " + valtio.getNimi());
		assertTrue(str.contains("Helsinki"), "Pääkaupunki väärin : pitäisi olla " + valtio.getPääkaupunki());
		assertTrue(str.contains("634940"), "Asukasluku väärin : pitäisi olla " + valtio.getAsukasluku());
	}

}
