package readerwriter;

public class Kirjoittaja extends Thread {
	private IntSailio sailio;
	private boolean done = false;

	public Kirjoittaja(IntSailio sailio) {
		this.sailio = sailio;
	}

	public void run() {
		try {
			for (int i = 0; i < 10 && !done; i++) {
				int luku = 2 * i + 1;
				sailio.setInt(luku);
				System.out.println("=== Kirjoittaja kirjoitti luvun " + luku);
				sleep(500);
			}
			sailio.setInt(-1); // ei enää lukuja
		} catch (InterruptedException e) {
			System.out.println("Sleep keskeytyi poikkeukseen.");
		}
		System.out.println("Kirjoittajasäikeen suoritus päättyi");
	}

	public void terminate() {
		done = true;
	}
}
