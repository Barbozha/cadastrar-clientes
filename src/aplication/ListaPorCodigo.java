package aplication;

import java.util.Scanner;

import dao.DAOCliente;
import dao.DAOFactory;
import entities.Cliente;

public class ListaPorCodigo {

	public static void main(String[] args) {
		// Lista um registro da tabela
		Cliente cliente = null;
		boolean continua = false;
		char cont = 's';
		Scanner sc = new Scanner(System.in);
		while(!continua) {
			System.out.print("Digite o código: ");
			long codigo = sc.nextLong();
			DAOCliente daoCliente = DAOFactory.getDAOFactory().getDAOCliente();
			cliente = daoCliente.buscarPeloCodigo(codigo);
			if(cliente != null) {
				System.out.println("----- Cliente encontrado -----");
				System.out.printf("Código: %d\n", cliente.getId());
				System.out.printf("Nome: %s\n", cliente.getNome());
				System.out.printf("Telefone: %s\n", cliente.getTelefone());
				System.out.printf("E-mail: %s\n", cliente.getEmail());
				System.out.println();
			}else {
				System.out.println("Nenhum registro encontrado.");
			}
			boolean pergunta = false;
			while(!pergunta) {
				System.out.print("Gostaria de realizar outra consulta(s/n)? ");
				String resp = sc.next();
				cont = resp.charAt(0);
				if(cont == 's') {
					continua = false;
					pergunta = true;
				}else if(cont == 'n'){
						continua = true;
						pergunta = true;
				}else {
					pergunta = false;
				}
			}
		}
		System.out.println("Fim da Consulta.");
		sc.close();
	}

}
