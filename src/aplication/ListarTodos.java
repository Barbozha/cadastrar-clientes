package aplication;

import java.util.List;

import dao.DAOCliente;
import dao.DAOFactory;
import entities.Cliente;

public class ListarTodos {

	public static void main(String[] args) {
		// Lista todos os clientes do banco
		DAOCliente daoCliente = DAOFactory.getDAOFactory().getDAOCliente();
		List<Cliente> clientes = daoCliente.listarTodos();
		System.out.println("----- Lista de Clientes encontrados -----");
		for(Cliente cli : clientes) {
			System.out.printf("Código: %d\n", cli.getId());
			System.out.printf("Nome: %s\n", cli.getNome());
			System.out.printf("Telefone: %s\n", cli.getTelefone());
			System.out.printf("E-mail: %s\n", cli.getEmail());
			System.out.println();
		}

	}

}
