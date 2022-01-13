package controller;
import model.Noppa;

public class Tehtava4Ohjain implements IView {
	private Noppa[] nopat = new Noppa[5];
	private int heittojeLkm;
	public Tehtava4Ohjain() {
		for(int i = 0; i < nopat.length; i++) {
			this.nopat[i] = new Noppa(6);
		}
	}
	public int nopanArvo() {
		int summa = 0;
		for(int i = 0; i < nopat.length; i++) {
			summa += nopat[i].getArvo();
		}
		return summa;
	}
	public int heitäNoppa() {
		int summa = 0;
		for(int i = 0; i < nopat.length; i++) {
			summa += this.nopat[i].heitä();
		}
		heittojeLkm++;
		return summa;
	}
	public int heittojenLkm() {
		return heittojeLkm;
	}
	public String tulos() {
		String arvot = "";
		int summa = 0;
		for(int i = 0; i < nopat.length; i++) {
			nopat[i].heitä();
			summa += nopat[i].getArvo();
			arvot += nopat[i].getArvo() + ", ";
		}
		arvot += " SUMMA: " + summa;
		return arvot;
	}
}
