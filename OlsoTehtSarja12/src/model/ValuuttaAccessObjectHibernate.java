package model;

import java.sql.*;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * @author Leevi Koskinen
 */

public class ValuuttaAccessObjectHibernate implements IValuuttaDAO {
	private SessionFactory istuntotehdas = null; 
	
	public ValuuttaAccessObjectHibernate() {
		try {
			istuntotehdas = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Istuntotehtaan luominen ei 	onnistunut.");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	@Override
	public boolean createValuutta(Valuutta valuutta) {
		Transaction transaktio = null;
		try {
			if(this.readValuutta(valuutta.getTunnus()) == null) {
				try (Session istunto = istuntotehdas.openSession()){
					transaktio = istunto.beginTransaction();
					istunto.saveOrUpdate(valuutta);
					transaktio.commit();
				} catch (Exception e) {
					if (transaktio!=null) transaktio.rollback();
					throw e;
				}
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public Valuutta readValuutta(String tunnus) {
		Valuutta val = null;
		try(Session istunto = istuntotehdas.openSession();){
			istunto.beginTransaction();
			Valuutta valuutta = new Valuutta();
			istunto.load(valuutta, tunnus);
			if(!valuutta.getTunnus().isEmpty()) {
				val = valuutta;
			}
			istunto.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	@Override
	public Valuutta[] readValuutat() {
		List result = null;
		try(Session istunto = istuntotehdas.openSession();){
			istunto.beginTransaction();
			result = istunto.createQuery( "from Valuutta" ).list();
			istunto.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Valuutta[] v = new Valuutta[result.size()];
		return (Valuutta[]) result.toArray(v);
	}

	@Override
	public boolean updateValuutta(Valuutta valuutta) {
		try(Session istunto = istuntotehdas.openSession();){
			istunto.beginTransaction();
			Valuutta v = (Valuutta)istunto.get(Valuutta.class, valuutta.getTunnus());
			if (v!= null){
				v.setVaihtokurssi(valuutta.getVaihtokurssi());
				v.setNimi(valuutta.getNimi());
			}
			istunto.getTransaction().commit();
			if (v!= null){
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteValuutta(String tunnus) {
		try(Session istunto = istuntotehdas.openSession();){
			istunto.beginTransaction();
			String hql = "delete Valuutta where tunnus = :tunnus ";
			Query kysely = istunto.createQuery(hql);
			kysely.setParameter("tunnus",  tunnus);
			int tulos = kysely.executeUpdate();

			istunto.getTransaction().commit();
			if(tulos > 0) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private void printSQLExceptions(String methodName, SQLException e) {
		System.err.println("Metodi: " + methodName);
		do {
			System.err.println("Viesti: " + e.getMessage());
			System.err.println("Virhekoodi: " + e.getErrorCode());
			System.err.println("SQL-tilakoodi: " + e.getSQLState());
		}while(e.getNextException() != null);
	}
	
}
