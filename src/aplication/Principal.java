package aplication;

import dao.DAOCliente;
import dao.DAOFactory;
import entities.Cliente;

public class Principal {

	public static void main(String[] args) {
		// Salvando registro no banco
		Cliente cliente = new Cliente();
		cliente.setNome("Ana Maria dos Santos");
		cliente.setTelefone("555-56666");
		cliente.setEmail("ana@gmail.com");
		DAOCliente daoCliente = DAOFactory.getDAOFactory().getDAOCliente();
		daoCliente.salvar(cliente);
		System.out.println("Registro salvo com sucesso!");
		
	}

}
