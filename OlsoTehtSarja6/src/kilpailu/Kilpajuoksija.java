package kilpailu;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author Leevi Koskinen 15.9.2021
 */

public class Kilpajuoksija extends Thread {
	private int numero;
	private final int MATKA = 400;
	private double aika;
	private int kaatumisAika;
	private boolean kaatunut = false;
	private int juostuMatka;

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
	public synchronized void run(){
		double kierrosaika = 0;
		do {
			kierrosaika = ThreadLocalRandom.current().nextDouble(1.075, 1.5);
			while(kaatunut) {
				try {
					wait();
					kierrosaika += kaatumisAika;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			aika += kierrosaika;
			try {
				Thread.sleep((long)Math.floor(kierrosaika*1000));
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
	
	public void kaadu(int aika) {
		System.out.println("Juoksija: " + numero + ", KAATUI!!!");
		kaatunut = true;
		kaatumisAika = aika;
	}
	public synchronized void nouse() {
		kaatunut = false;
		System.out.println("Juoksija: " + numero + ", NOUSI!!!");
		notifyAll();
	}
	public int getJuostuMatka() {
		return juostuMatka;
	}
	public double getAika(){
		return aika; 
	}
}
