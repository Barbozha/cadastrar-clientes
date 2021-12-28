package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import daoexception.DAOException;
import entities.Cliente;

public class JdbcDAOCliente implements DAOCliente {
	private Connection connection;

	public JdbcDAOCliente(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(Cliente cliente) {
		try {
			String sql = String.format("insert into Tab_cliente(nome,telefone,email) values (?,?,?)");
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getTelefone());
			ps.setString(3, cliente.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error! ao conectar ao banco.", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {

			}
		}

	}

}
