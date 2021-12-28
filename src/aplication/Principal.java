package aplication;

import dao.DAOCliente;
import dao.DAOFactory;
import entities.Cliente;

public class Principal {

	public static void main(String[] args) {
		// Salvando registro no banco
		Cliente cliente = new Cliente();
		cliente.setNome("João da Silva");
		cliente.setTelefone("555-5555");
		cliente.setEmail("joao@gmail.com");
		DAOCliente daoCliente = DAOFactory.getDAOFactory().getDAOCliente();
		daoCliente.salvar(cliente);
		System.out.println("Registro salvo com sucesso!");
	}

}
