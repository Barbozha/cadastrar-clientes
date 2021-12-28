package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcDAOFactory extends DAOFactory {
	private Connection connection;
	
	public JdbcDAOFactory() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/clientes?autoReconnect=true&useSSL=false", "root", "123456");
		}catch(Exception e) {
			throw new RuntimeException("Erro! de conexão.");
		}
	}

	@Override
	public DAOCliente getDAOCliente() {
		return new JdbcDAOCliente(connection);
	}

}
