package model;

import java.sql.*;
import java.util.ArrayList;
/**
 * @author Leevi Koskinen
 */

public class ValuuttaAccessObject implements IValuuttaDAO {
	
	private Connection conn;
	
	public ValuuttaAccessObject() {
		final String URL = "jdbc:mariadb://localhost/valuutat";
		final String USERNAME = "olso";
		final String PWD = "olso";
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PWD);
		}catch (SQLException e) {
				printSQLExceptions("ValuuttaAccessObject()", e);
			System.exit(-1);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean createValuutta(Valuutta valuutta) {
		try(PreparedStatement statement = conn.prepareStatement("INSERT INTO valuutta VALUES(?,?,?)");) {
			statement.setString(1, valuutta.getTunnus());
			statement.setDouble(2, valuutta.getVaihtokurssi());
			statement.setString(3, valuutta.getNimi());
			if(statement.executeUpdate() > 0) {
				return true;
			}
		}catch (SQLException e) {
				printSQLExceptions("createValuutta()", e);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Valuutta readValuutta(String tunnus) {
		//ResultSet rs = null;
		Valuutta valuutta = null;
		try(PreparedStatement statement = conn.prepareStatement("SELECT * FROM valuutta WHERE tunnus=?");) {
			statement.setString(1, tunnus.toUpperCase());
			try(ResultSet rs = statement.executeQuery();){
				while(rs.next()) {
					valuutta = new Valuutta(rs.getString("tunnus"), rs.getDouble("kurssi"), rs.getString("nimi"));
				}
			} catch (SQLException e) {
				printSQLExceptions("readValuutta()", e);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}catch (SQLException e) {
				printSQLExceptions("readValuutta()", e);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return valuutta;
	}

	@Override
	public Valuutta[] readValuutat() {
		ResultSet rs = null;
		ArrayList<Valuutta> valuutat = new ArrayList<Valuutta>();
		try(Statement statement = conn.createStatement();) {
			rs = statement.executeQuery("SELECT * FROM valuutta");
			while(rs.next()) {
				valuutat.add(new Valuutta(rs.getString("tunnus"), rs.getDouble("kurssi"), rs.getString("nimi")));
			}
			
		}catch (SQLException e) {
				printSQLExceptions("readValuutat()", e);
		}catch (Exception e) {
			e.printStackTrace();
		}
		Valuutta[] v = new Valuutta[valuutat.size()];
		return (Valuutta[]) valuutat.toArray(v);
	}

	@Override
	public boolean updateValuutta(Valuutta valuutta) {
		try(PreparedStatement updatestatement = conn.prepareStatement("UPDATE valuutta SET kurssi=?, nimi=? WHERE tunnus LIKE ?");) {
			updatestatement.setDouble(1, valuutta.getVaihtokurssi());
			updatestatement.setString(2, valuutta.getNimi());
			updatestatement.setString(3, valuutta.getTunnus());
			if(updatestatement.executeUpdate() > 0) {
				return true;
			}
		}catch (SQLException e) {
				printSQLExceptions("updateValuutta()", e);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteValuutta(String tunnus) {
		try(PreparedStatement updatestatement = conn.prepareStatement("DELETE FROM valuutta WHERE tunnus=?");) {
			updatestatement.setString(1, tunnus.toUpperCase());
			if(updatestatement.executeUpdate() > 0) {
				return true;
			}
		}catch (SQLException e) {
				printSQLExceptions("deleteValuutta()", e);
		}catch (Exception e) {
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
