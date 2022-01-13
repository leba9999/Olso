package controller;
import model.Noppa;

public class Tehtava5Ohjain implements IView {
	private Noppa noppa;
	public Tehtava5Ohjain() {
		this.noppa = new Noppa(2);
	}
	public int nopanArvo() {
		return this.noppa.getArvo();
	}
	public int heitäNoppa() {
		return this.noppa.heitä();
	}
	public int heittojenLkm() {
		return this.noppa.getHeittojenLkm();
	}
	@Override
	public String tulos() {
		String kolikonPuoli = "Kruuna";
		if(this.noppa.getArvo() < 2) {
			kolikonPuoli = "Klaava";
		}
		return kolikonPuoli;
	}
}
