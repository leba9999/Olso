package model;

public class Valuuttakone implements IValuuttakone {
	private IValuuttaDAO valuuttaDAO;
	private Valuutta[] valuutat;
	
	public Valuuttakone() {
		valuuttaDAO  = new ValuuttaAccessObject();
		valuutat = valuuttaDAO.readValuutat();
	}
	
	@Override
	public String[] getVaihtoehdot() {
		String[] nimet = new String[valuutat.length];
		for(int i = 0; i < valuutat.length; i++) {
			nimet[i] = valuutat[i].getNimi();
		}
		return nimet;
	}

	@Override
	public double muunna(int mistäIndeksi, int mihinIndeksi, double määrä) {
		double muunnos_1 = valuutat[mihinIndeksi].getVaihtokurssi() / valuutat[mistäIndeksi].getVaihtokurssi();
		return muunnos_1 * määrä;
	}
}
