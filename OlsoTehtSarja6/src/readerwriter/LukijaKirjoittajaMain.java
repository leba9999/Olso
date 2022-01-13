package readerwriter;

public class LukijaKirjoittajaMain {
	public static void main(String[] args) throws InterruptedException {
		IntSailio sailio = new IntSailio();

		Kirjoittaja kirjoittaja = new Kirjoittaja(sailio);
		Lukija lukija = new Lukija(sailio);
		Lukija lukija2 = new Lukija(sailio);
		Lukija lukija3 = new Lukija(sailio);

		kirjoittaja.start();
		lukija.start();
		lukija2.start();
		lukija3.start();

		kirjoittaja.join();
		System.out.println("Kirjoittaja lopetti");

		lukija.join();
		System.out.println("Lukija lopetti");
		lukija2.join();
		System.out.println("Lukija 2 lopetti");
		lukija3.join();
		System.out.println("Lukija 3 lopetti");
	}
}
