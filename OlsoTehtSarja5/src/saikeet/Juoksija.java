package saikeet;

/**
* @author Leevi Koskinen 11.9.2021
*/

public class Juoksija extends Thread {
	private volatile boolean jatkuu = true;
	private int kierrokset = 0;

	public Juoksija() {
		
	}
	
	@Override
	public void run(){
		do {
			kierrokset++;
			System.out.println("Kierros: " + getKierrokset());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while(jatkuu);
	}
	
	public int getKierrokset() {
		return kierrokset;
	}

	public void setKierrokset(int kierrokset) {
		this.kierrokset = kierrokset;
	}

	public boolean isJuoksemassa() {
		return jatkuu;
	}
	public void lopeta(){
		jatkuu = false;
	}
}
