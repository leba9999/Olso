package halkohomma;

import java.util.concurrent.ThreadLocalRandom;

/**
* @author Leevi Koskinen 14.9.2021
*/

public class Partiolainen extends Thread{

	private Halkovarasto halkovarasto;
	
	public Partiolainen(Halkovarasto halkovarasto) {
		this.halkovarasto = halkovarasto;
	}
	public void run() {
		do {
			try {
				int halkoja = ThreadLocalRandom.current().nextInt(1, 8);
				halkovarasto.haeHalkoja(this, halkoja);
				// Partiolainen käyttää halkoja!!!
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while(true);
	}
}