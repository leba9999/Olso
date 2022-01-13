package saikeet;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author Leevi Koskinen 11.9.2021
 */

public class Kilpajuoksija extends Thread {
	private int numero;
	private final int MATKA = 400;
	private double aika;

	private static int seuraavaNumero=1;
	
	public Kilpajuoksija() {
		numero = seuraavaNumero;
		seuraavaNumero++;
	}
	public static void setSeuraavaNumero(int seuraavaNumero) {
		Kilpajuoksija.seuraavaNumero = seuraavaNumero;
	}

	public int getNumero() {
		return numero;
	}
	@Override
	public void run(){
		int juostuMatka = 0;
		double kierrosaika = 0;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		do {
			kierrosaika = ThreadLocalRandom.current().nextDouble(1.075, 1.5);
			//kierrosaika =(Math.random() * (1.5 - 1.075) + 1.075);
			aika += kierrosaika;
			try {
				Thread.sleep((long)Math.floor(kierrosaika));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juostuMatka += 10;
			if(juostuMatka % 50 == 0) {
				System.out.println("Juoksija: " + numero + ", juostu matka:" + juostuMatka + ", aika:" + aika);
			}
		}while(juostuMatka < MATKA);
		System.out.println("Juoksijan: " + numero + ", Aika: " + aika);
	}

	public double getAika(){
		return aika; 
	}
}
