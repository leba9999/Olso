package halkohomma;

import java.util.concurrent.ThreadLocalRandom;

/**
* @author Leevi Koskinen 14.9.2021
*/

public class Halonhakkaaja extends Thread {
	private final int halkojenPieninMäärä = 1;
	private final int halkojenSuurinMäärä = 10;
	private Halkovarasto halkovarasto;
	
	public Halonhakkaaja(Halkovarasto halkovarasto) {
		this.halkovarasto = halkovarasto;
	}
	public void run() {
		do {
			try {
				int halkoja = ThreadLocalRandom.current().nextInt(halkojenPieninMäärä, halkojenSuurinMäärä);
				halkovarasto.vieHalkoja(this, halkoja);
				// Halonhakkuu on hidasta puuhaa!!
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while(true);
	}
}