/**
* @author Leevi Koskinen 7.9.2021
*/

import java.io.*;

public class PerusTyypitettyIO {

	public static void kirjoita(int luvut[], String tiedosto) {
		FileOutputStream fileOut = null;
		DataOutputStream dataOut = null;
		// Yritetään tallentaa tiedostoon
		try {
			fileOut = new FileOutputStream(tiedosto);
			dataOut = new DataOutputStream(fileOut);
			for(int luku : luvut) {
				dataOut.writeInt(luku);
			}
		} catch (Exception e) {
			System.out.println(tiedosto + "-tiedostoon tallentaminen ei onnistunut");
		} finally {
			if(dataOut != null) {
				try {
					dataOut.close();
				}catch(Exception e) {
					System.out.println("Kirjoitusta ei voitu sulkea!!!");
					e.printStackTrace();
				}
			}
		}
	}

	public static int kerroKoko(String tiedosto) {
		FileInputStream f = null;
		try {
			f = new FileInputStream(tiedosto);
			return f.available();
		} catch(FileNotFoundException e) {
			System.out.println("Tiedostoa " + tiedosto + " ei löytynyt");
		} catch(Exception e) {
			System.out.println("Tiedoston " + tiedosto + " lukeminen ei onnistunut");
		} finally {
			if(f != null) {
				try {
					f.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	public static byte[] annaTavuina(String tiedosto) {
		FileInputStream f = null;
		byte[] bytes = null;
		try {
			f = new FileInputStream(tiedosto);
			bytes = new byte[f.available()];
			f.read(bytes);
		} catch(FileNotFoundException e) {
			System.out.println("Tiedostoa " + tiedosto + " ei löytynyt");
		} catch(Exception e) {
			System.out.println("Tiedoston " + tiedosto + " lukeminen ei onnistunut");
		} finally {
			if(f != null) {
				try {
					f.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return bytes; // Palauta byte-taulukko
	}

	public static int[] annaKokonaislukuina(String tiedosto) {
		FileInputStream f = null;
		DataInputStream din = null;
		int[] bytes = null;
		try {
			f = new FileInputStream(tiedosto);
			din = new DataInputStream(f);
			bytes = new int[f.available()/Integer.BYTES];
			for(int i = 0; i <= bytes.length; i++) {
				bytes[i] = din.readInt();
			}
		} catch(FileNotFoundException e) {
			System.out.println("Tiedostoa " + tiedosto + " ei löytynyt");
		} catch(EOFException e) {
			System.out.println("Tiedoston " + tiedosto + " lukeminen päättyi");
		} catch(Exception e) {
			System.out.println("Tiedoston " + tiedosto + " lukeminen ei onnistunut");
		} finally {
			if(din != null) {
				try {
					din.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return bytes; // Palauta int-taulukko
	}


	public static void main(String args[]) {
		String tiedosto = "Luvut.bin";
		int luvut[] = { 1, 200, 3, 4, 5 };
		byte tavut[];
		int iLuvut[];

		kirjoita(luvut, tiedosto);

		System.out.println("Tiedostossa on " + kerroKoko(tiedosto) + " tavua");

		System.out.println ("Tiedoston sisältö tavuittain:");
		tavut = annaTavuina(tiedosto);
		for (int i = 0; i < tavut.length; i++) {
			System.out.print(tavut[i] + " ");
		}

		System.out.println ("\nTiedoston sisältö kokonaislukuina:");
		iLuvut = annaKokonaislukuina(tiedosto);
		for (int i = 0; i < iLuvut.length; i++) {
			System.out.print(iLuvut[i] + " ");
		}
	}

}
