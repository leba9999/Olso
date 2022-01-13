package controller;
import model.Noppa;

public class Ohjain implements IView {
	private Noppa noppa;
	public Ohjain() {
		this.noppa = new Noppa(6);
	}
	public Ohjain(int sivujenLkm) {
		this.noppa = new Noppa(sivujenLkm);
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
		return Integer.toString(this.noppa.getArvo());
	}
}
