package halkohomma;

/**
* @author Leevi Koskinen 13.9.2021
*/

public class Halkovarasto {
	private final int kapasiteetti = 20;
	private int halot;

	public synchronized void vieHalkoja(Halonhakkaaja h, int halot) throws InterruptedException {
		while(this.halot + halot > kapasiteetti) {
			System.out.println(h + " Tuoja odottaa:" + halot);
			wait();
		}
		System.out.println(h + "viedään varastoon:" + halot);
		this.halot += halot;
		System.out.println("Halkoja varastossa:" + this.halot);
		notifyAll();
	}
	public synchronized int haeHalkoja(Partiolainen p, int määrä) throws InterruptedException {
		while(this.halot - määrä < 0) {
			System.out.println(p + " Hakija odottaa:" + määrä);
			wait();
		}
		System.out.println(p + "hakee varastosta:" + määrä);
		this.halot -= määrä;
		System.out.println("Halkoja varastossa:" + this.halot);
		notifyAll();
		return määrä;
	}
}