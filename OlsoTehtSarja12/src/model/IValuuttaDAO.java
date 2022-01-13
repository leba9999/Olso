package model;

public interface IValuuttaDAO {
	public boolean createValuutta(Valuutta valuutta);
	public Valuutta readValuutta(String tunnus);
	public Valuutta[] readValuutat();
	public boolean updateValuutta(Valuutta valuutta);
	public boolean deleteValuutta(String tunnus);
}
