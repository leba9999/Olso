package model;

public class Noppa {

	private int sivulkm;
	private int arvo;
	private int heittolkm;
	public Noppa(int sivulkm) {
		this.sivulkm = sivulkm;
	}
	public int heitä() {
		arvo = (int)(Math.random() * sivulkm) + 1;
		heittolkm++;
		return arvo;
	}
	public int getArvo() {
		return arvo;
	}
	public int getHeittojenLkm() {
		return heittolkm;
	}
	
}
