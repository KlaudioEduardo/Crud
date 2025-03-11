package crud.br.main.services;

import java.util.List;
import java.util.Scanner;

import crud.br.models.Usuario;

public class UsuarioService {

	private static Scanner scan = new Scanner(System.in);
	private Long idSelecionado;

	public void cadastrarUsuario(List<Usuario> bancoUsuario) {

		Usuario novoUsuario = new Usuario();

		System.out.println("\n*******************");

		Boolean continuar = true;

		while (continuar) {
			continuar = lerDadosUsuario(novoUsuario, scan, continuar, true);
			if (novoUsuario.getId() != null && novoUsuario.getNome() != null && novoUsuario.getCpf() != null
					&& novoUsuario.getEmail() != null) {
				bancoUsuario.add(novoUsuario);

				System.out.println("Usuario cadastrado com sucesso.");
				break;

			} else {
				System.out.println("Erro ao cadastrar usuario. Tente novamente.");
			}

		}
	}

	public void consultarUsuario(List<Usuario> bancoUsuario, Scanner scan) {
		System.out.println("\n ********** CONSULTA ************* ");

		if (verificaUsuario(bancoUsuario)) {
			System.out.print("Digite o ID que deseja consultar: ");
			
			Long idConsultado = scan.nextLong();

			for (Usuario usuario : bancoUsuario) {
				if (usuario.getId() == idConsultado) {	
					System.out.println(usuario);
						
				}
			}

			System.out.println("ID não encontrado.");
		}
		
	}

	public void atualizarUsuario(List<Usuario> bancoUsuario, Scanner scan) {
		System.out.println("\n ********** ATUALIZA ************* ");

		if (verificaUsuario(bancoUsuario)) {
			System.out.println("Digite o ID que deseja atualizar: ");
			idSelecionado = scan.nextLong();

			Usuario usuario = buscarUsuarioPorID(bancoUsuario, idSelecionado);

			if (usuario != null) {
				Boolean continuar = true;
				while (continuar) {

					continuar = lerDadosUsuario(usuario, scan, continuar, false);

				}

			} else {
				System.out.println("ID não encontrado.");
			}
		}
	}

	public void deletarUsuario(List<Usuario> bancoUsuario, Scanner scan) {

		System.out.println("Digite o ID do usuario a ser removido: ");
		idSelecionado = scan.nextLong();

		Usuario usuario = buscarUsuarioPorID(bancoUsuario, idSelecionado);

		if (bancoUsuario != null) {
			bancoUsuario.remove(usuario);
			System.out.println("Removido com sucesso.");
		} else {
			System.err.println("ID não encontrado.");
		}

	}

	private static Boolean lerDadosUsuario(Usuario usuario, Scanner scan, Boolean continuar, Boolean ehAtualizacao) {
		try {

			if (ehAtualizacao == true) {
				System.out.print("ID: ");
				usuario.setId(scan.nextLong());
			}

			System.out.print("Nome: ");
			usuario.setNome(scan.next());

			System.out.print("CPF: ");
			usuario.setCpf(scan.next());

			System.out.print("Email: ");
			usuario.setEmail(scan.next());
			return false;

		} catch (Exception e) {

			scan.nextLine();
			return true;
		}

	}

	public void exibeUsuariosCadastrados(List<Usuario> bancoUsuarios) {
		System.out.println("**********************************************************************************");
		System.out.println("ID\t\tNome\t\t\tCPF\t\t\tEmail");
		System.out.println("**********************************************************************************");

		for (Usuario usuario : bancoUsuarios) {
			System.out.print(usuario.getId() + "\t\t");
			System.out.print(usuario.getNome() + "\t\t");
			System.out.print(usuario.getCpf() + "\t\t");
			System.out.println(usuario.getEmail());
		}

		System.out.println("**********************************************************************************");
	}

	public static boolean verificaUsuario(List<Usuario> bancoUsuarios) {
		if (bancoUsuarios.isEmpty()) {
			System.out.println("O banco de usuarios está vazio.");
			return false;
		}
		return true;

	}

	public static Usuario buscarUsuarioPorID(List<Usuario> bancoUsuarios, Long iDSelecionado) {
		for (Usuario usuario : bancoUsuarios) {
			if (usuario.getId().equals(iDSelecionado)) {
				return usuario;
			}
		}
		return null;
	}
}
