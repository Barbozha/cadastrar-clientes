package dao;

public abstract class DAOFactory {
	public static DAOFactory getDAOFactory(){
		return new JdbcDAOFactory();
	}
	
	public abstract DAOCliente getDAOCliente();
}
