
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PerusTyypitettyIOTest {

	private final String tiedosto = "Testi.bin";
	private final int luvut[] = { 1, 200, 3, 4, 5 };

	@Test
	@Order(1)
	@DisplayName("kirjoita(): Tiedostoon kirjoittaminen int-lukuina")
	public void testKirjoita() {
		PerusTyypitettyIO.kirjoita(luvut, tiedosto);

		int lkm = 0;
		try (FileInputStream f = new FileInputStream(tiedosto)) {
			lkm = f.available();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		assertTrue(20 == lkm, "Tiedostoon ei mene oikea lukumäärä dataa.");
	}

	@Test
	@Order(2)
	@DisplayName("annaKokonaisLukuina(): Tiedoston lukeminen int-lukuina")
	public void testAnnaKokonaislukuina() {
		int luetutLuvut[] = new int[5];

		PerusTyypitettyIO.kirjoita(luvut, tiedosto);
		luetutLuvut = PerusTyypitettyIO.annaKokonaislukuina(tiedosto);
		
		assertArrayEquals(luvut, luetutLuvut, "Kokonaislukuina lukemisessa vikaa");
	}

	@Test
	@Order(3)
	@DisplayName("annaTavuina(): Tiedoston lukeminen tavuina.")
	public void testAnnaTavuina() {
		int luvut[] = { 1, 2 };
		byte tavut[] = { 0, 0, 0, 1, 0, 0, 0, 2 };
		byte luetutTavut[] = new byte[8];

		PerusTyypitettyIO.kirjoita(luvut, tiedosto);
		luetutTavut = PerusTyypitettyIO.annaTavuina(tiedosto);

		assertArrayEquals(tavut, luetutTavut, "Tavuina lukemisessa vikaa");
	}

	@Test
	@DisplayName("kerroKoko(): Tiedoston koon palauttaminen.")
	public void testKerroKoko() {
		PerusTyypitettyIO.kirjoita(luvut, tiedosto);
		assertTrue(20 == PerusTyypitettyIO.kerroKoko(tiedosto), "Tiedoston koko ei täsmää.");
	}

}
