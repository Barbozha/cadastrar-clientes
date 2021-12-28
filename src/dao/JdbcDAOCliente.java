package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Cliente> listarTodos() {
		// Lista todos os clientes
		List<Cliente> clientes = new ArrayList<>();
		try {
			String sql = "select * from tab_cliente";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("Nome"));
				cliente.setTelefone(rs.getString("Telefone"));
				cliente.setEmail(rs.getString("Email"));
				clientes.add(cliente);
			}

		} catch (SQLException e) {
			throw new DAOException("Error! ao listar a tabela.", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
				throw new DAOException("Error! ao fechar o banco de dados", e);
			}
		}
		return clientes;
	}

}
