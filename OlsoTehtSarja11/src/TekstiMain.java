


import java.util.Scanner;
import model.*;

public class TekstiMain {
	static IValuuttaDAO valuuttaDAO = new ValuuttaAccessObject();
	static Scanner scanner = new Scanner(System.in);
	static final char CREATE = 'C', READ = 'R', UPDATE = 'U', DELETE = 'D', QUIT = 'Q', NIMI = 'N', KURSSI = 'K';

	public static void listaaValuutat() {
		for (Valuutta v : valuuttaDAO.readValuutat()) {
			System.out.println(v);
		}
	}

	public static void lisääValuutta() {
		String tunnus;
		String kurssi;
		String nimi;

		System.out.print("Syötä uuden valuutan tunnus:");
		tunnus = scanner.nextLine().toUpperCase();
		System.out.print("Syötä uuden valuutan kurssi:");
		kurssi = scanner.nextLine();
		boolean parsable = true;
		double parsedDouble = 0;
		do {
			try {
				parsedDouble = Double.parseDouble(kurssi);
				parsable = true;
			} catch (NumberFormatException e) {
				parsable = false;
			} catch (Exception e) {
				parsable = false;
				e.printStackTrace();
			}
		} while (!parsable);
		System.out.print("Syötä uuden valuutan nimi:");
		nimi = scanner.nextLine();
		valuuttaDAO.createValuutta(new Valuutta(tunnus, parsedDouble, nimi));
	}

	public static void päivitäValuutta() {
		String tunnus;
		String kurssi;
		String nimi = "";

		System.out.print("Syötä päivitettävän valuutan tunnus:");
		tunnus = scanner.nextLine().toUpperCase();
		Valuutta v = valuuttaDAO.readValuutta(tunnus);
		if (v != null) {
			char valinta = ' ';
			while (valinta != QUIT) {
				System.out.println(KURSSI + ": Päivitä valuutan kurssi");
				System.out.println(NIMI + ": Päivitä valuutan nimi");
				System.out.println(QUIT + ": Poistu päivittämisestä");
				valinta = (scanner.nextLine().toUpperCase()).charAt(0);
				switch (valinta) {
				case KURSSI:
					System.out.print("Syötä valuutan kurssi:");
					kurssi = scanner.nextLine();
					boolean parsable = true;
					double parsedDouble = 0;
					do {
						try {
							parsedDouble = Double.parseDouble(kurssi);
							parsable = true;
						} catch (NumberFormatException e) {
							parsable = false;
						} catch (Exception e) {
							parsable = false;
							e.printStackTrace();
						}
					} while (!parsable);
					v.setVaihtokurssi(parsedDouble);
					break;
				case NIMI:
					nimi = scanner.nextLine();
					v.setNimi(nimi);
					break;
				default:
					poistaValuutta();
					break;
				}
			}
			valuuttaDAO.updateValuutta(v);
			System.out.print("Valuutta: " + tunnus + " päivitettiin");
		}
	}

	public static void poistaValuutta() {
		String tunnus;

		System.out.print("Syötä poistettavan valuutan tunnus:");
		tunnus = scanner.nextLine().toUpperCase();
		Valuutta v = valuuttaDAO.readValuutta(tunnus);
		if (v != null) {
			valuuttaDAO.deleteValuutta(tunnus);
			System.out.print("Valuutta: " + tunnus + " poistettiin");
		}
	}


	public static void main(String[] args) {

		char valinta;
		do {
			System.out.println(CREATE + ": Lisää uusi valuutta tietokantaan");
			System.out.println(READ + ": Listaa tietokannassa olevien valuuttojen tiedot");
			System.out.println(UPDATE + ": Päivitä valuutan vaihtokurssi tietokantaan");
			System.out.println(DELETE + ": Poista valuutta tietokannasta");
			System.out.println(QUIT + ": Lopetus");
			System.out.print("Valintasi:");
			valinta = (scanner.nextLine().toUpperCase()).charAt(0);
			switch (valinta) {
			case READ:
				listaaValuutat();
				break;
			case CREATE:
				lisääValuutta();
				break;
			case UPDATE:
				päivitäValuutta();
				break;
			case DELETE:
				poistaValuutta();
				break;
			}
		} while (valinta != QUIT);
	}
}
