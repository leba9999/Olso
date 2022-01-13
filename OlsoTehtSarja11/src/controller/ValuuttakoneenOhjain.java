package controller;

import model.*;
import view.IValuuttakoneenUI;

public class ValuuttakoneenOhjain implements IValuuttakoneenOhjain {

	private IValuuttakoneenUI view;
	private IValuuttakone kone;
	
	public ValuuttakoneenOhjain(IValuuttakoneenUI view) {
		this.view = view;
		this.kone = new Valuuttakone();
	}

	@Override
	public void muunnos() {
		view.setTulos(this.kone.muunna(view.getMistäIndeksi(), view.getMihinIndeksi(), view.getMäärä()));
	}

	@Override
	public String[] getValuutat() {
		return kone.getVaihtoehdot();
	}

}
