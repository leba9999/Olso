
package suorakulmiot;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hakka, 20.1.2013, muutos 20.8.2019: JUnit Jupiter.
 */
public class NaytonSuorakulmioTest {

    private static final int LEVEYS = 1024;
    private static final int KORKEUS = 768;
	     
    /* Rajakohtien testaaminen tärkeää, sillä of-by-one virhe on helppo
     * tehdä: ts. kuuluuko vertailussa olla yhtäsuuruusmerkki vai ei?
     */
    
    /* Kun käytetään @DisplayName-annotaatiota, niin tuloksissa näkyy testimetodin
     * nimen sijasta itse valittu teksti.
     */
    @Test
    @DisplayName("mahtuu(): Liian leveä, ei mahdu")
    public void testMahtuu1() {
        System.out.println("mahtuu(): Liian leveä, ei mahdu");
        NaytonSuorakulmio suorakulmio = new NaytonSuorakulmio(225, 120, 800, 30);
        assertFalse(suorakulmio.mahtuu(LEVEYS, KORKEUS), LEVEYS + "x" + KORKEUS +": (" + suorakulmio +") ");
     }
   
    @Test
    @DisplayName("mahtuu(): Suurin leveys, joka vielä mahtuu")
    public void testMahtuu2() {
        System.out.println("mahtuu(): Suurin leveys, joka vielä mahtuu");
        NaytonSuorakulmio suorakulmio = new NaytonSuorakulmio(224, 120, 800, 30);
        assertTrue(suorakulmio.mahtuu(LEVEYS, KORKEUS), LEVEYS + "x" + KORKEUS +": (" + suorakulmio +") ");
     }
    
    @Test
    @DisplayName("mahtuu(): Liian korkea, ei mahdu")
    public void testMahtuu3() {
        System.out.println("mahtuu(): Liian korkea, ei mahdu");
        NaytonSuorakulmio suorakulmio = new NaytonSuorakulmio(200, 100, 800, 669);
        assertFalse(suorakulmio.mahtuu(LEVEYS, KORKEUS), LEVEYS + "x" + KORKEUS +": (" + suorakulmio +") ");
     }
  
    @Test
    @DisplayName("mahtuu(): Suurin korkeus, joka vielä mahtuu")
    public void testMahtuu4() {
        System.out.println("mahtuu(): Suurin korkeus, joka vielä mahtuu");
        NaytonSuorakulmio suorakulmio = new NaytonSuorakulmio(200, 100, 800, 668);
        assertTrue(suorakulmio.mahtuu(LEVEYS, KORKEUS), LEVEYS + "x" + KORKEUS +": (" + suorakulmio + ") ");
     }
    
    @Test
    @DisplayName("toString(): Oikea muotoilu")
    public void testToString() {
        System.out.println("toString(): Merkkijonon muotoilu");
        NaytonSuorakulmio suorakulmio = new NaytonSuorakulmio(225, 120, 800, 30);
        String expResult = "x=225, y=120, leveys=800, korkeus=30";
        String result = suorakulmio.toString();
        assertEquals(expResult, result, "Merkkijonoesitys ei täsmää.");
    }
}
