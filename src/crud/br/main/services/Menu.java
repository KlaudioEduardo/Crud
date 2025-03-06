package crud.br.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import crud.br.models.Usuario;



public class Menu {

	private static Scanner scan = new Scanner(System.in);

	private UsuarioServices usuarioServices = new UsuarioServices();
	

	public void startaMenu(List<Usuario> bancoUsuario) {
		while (true) {
			System.out.println("*************************");
			System.out.println("O que você deseja: ");
			System.out.println("1 - Cadastrar \n2 - Consultar \n3 - Atualizar \n4 - Deletar \n5 - Sair");
			
			int opcaoSelecionada = scan.nextInt();
			scan.nextLine();

			switch (opcaoSelecionada) {
			case 1:
				
				usuarioServices.cadastrarUsuario(bancoUsuario);
				break;
			case 2:
				usuarioServices.buscaUsuarioById(null, bancoUsuario);
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("Saindo...");
				return;
			default:
				System.out.println("Opção inválida, tente novamente.");
			}
		}
	}

}