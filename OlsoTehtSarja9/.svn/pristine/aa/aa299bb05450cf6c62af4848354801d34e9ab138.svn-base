package model;

public class Valuuttakone implements IValuuttakone {
	private Valuutta[] valuutat = {new Valuutta("Euroopan euro", 1.0), new Valuutta("Ruotsin kruunu", 9.4780), new Valuutta("Norjan kruunu", 8.9018), new Valuutta("Yhdysvaltain dollari", 1.0629)};
	
	public Valuuttakone() {
		
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
