import saikeet.OmaSaie;

/**
 * @author Leevi Koskinen 11.9.2021
 */

public class OmaSaieMain {

	public static void main(String[] args) throws InterruptedException {
		OmaSaie saie;
		System.out.println("Säiepääohjelma");

		saie = new OmaSaie(15);
		
		System.out.println("Alkuarvot ovat " + saie.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());
		saie.start();
		saie.join();
		System.out.println("Uudet arvot ovat " + saie.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());

		saie = new OmaSaie(2021);
		System.out.println("Alkuarvot ovat " + saie.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());

		saie.start();
		saie.join();
		System.out.println("Uudet arvot ovat " + saie.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());

	}

}
