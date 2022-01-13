package saikeet;

/**
* @author Leevi Koskinen 11.9.2021
*/

public class LuuppaavaSaie extends Thread {

    int pyydetytKierrokset;
    int kierretytKierrokset;

	public LuuppaavaSaie(int pyydetytKierrokset) {
		super(); // ei tarvii
		this.pyydetytKierrokset = pyydetytKierrokset;
	}

	public int getKierretytKierrokset() {
		return kierretytKierrokset;
	}
	public void run() {
		do {
			kierretytKierrokset++;
			System.out.println("Kierros: " + getKierretytKierrokset());
		} while(kierretytKierrokset != pyydetytKierrokset);
	}
}
