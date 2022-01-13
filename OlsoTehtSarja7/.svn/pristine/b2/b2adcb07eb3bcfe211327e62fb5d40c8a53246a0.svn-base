package laskin;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * T‰ss‰§ esitell‰‰n @BeforeEach, @AfterEach, @BeforeAll ja @AfterAll annotaatioita
 */
public abstract class AbstractParent {

    @BeforeAll
    public static void startTestSystem() {
        System.out.println("@BeforeAll TESTAAMINEN ALKAA.");
    }

    @AfterAll
    public static void stopTestSystem() {
        System.out.println("@AfterAll TESTAAMINEN VALMIS.");
    }

    @BeforeEach
    public void initTestSystem() {
        System.out.println("  @BeforeEach K‰ynnist‰ uusi testimetodi.");
    }

    @AfterEach
    public void cleanTestSystem() {
        System.out.println("  @AfterEach Testimetodi suoritettu.");
    }
}
