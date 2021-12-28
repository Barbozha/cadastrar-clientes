package dao;

import java.util.List;

import entities.Cliente;

public interface DAOCliente {
	public void salvar(Cliente cliente);
	
	public List<Cliente> listarTodos();
}
