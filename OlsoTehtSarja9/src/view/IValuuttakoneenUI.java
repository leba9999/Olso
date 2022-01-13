package view;
/**
 * @author Leevi Koskinen
 */

public interface IValuuttakoneenUI {
	public abstract int getMistäIndeksi();
	public abstract int getMihinIndeksi();
	public abstract double getMäärä();
	public abstract void setTulos(double määrä);
}
