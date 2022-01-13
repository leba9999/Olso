package laskin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
 
public class NelioTest {

	private Laskin laskin = new Laskin();
	private final double DELTA = 0.001;

	// Parametriparit taulukossa (CSV, comma separated values)
	@ParameterizedTest(name="Luvun {0} neliö on {1}")
	@CsvSource({ "0, 0", "1, 1", "2, 4", "4, 16", "5, 25", "6, 36" }) // Korjattu luku 6 neliö ei voi olla 35 vaan 36
	public void testNelio(int luku,  int tulos) {
		laskin.nelio(luku);
		assertEquals(tulos, laskin.annaTulos(), DELTA, "Neliöön korotus ei nyt kyllä skulaa");
	}
}
