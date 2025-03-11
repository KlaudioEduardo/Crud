package crud.br.main.services;

import java.util.List;
import java.util.Scanner;

import crud.br.models.Usuario;


public class UsuarioServices {

	private static Scanner scan = new Scanner(System.in);
	private Long iDSelecionado;

	public void cadastrarUsuario(List<Usuario> bancoUsuario) {

		Usuario novoUsuario = new Usuario();

		System.out.println("\n*******************");

		while (true) {
			lerDadosUsuario(novoUsuario, scan);
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

	public Usuario consultarUsuario(List<Usuario> bancoUsuario, Scanner scan) {
		System.out.println("\n ********** CONSULTA ************* ");

		if (verificaUsuario(bancoUsuario)) {
			System.out.print("Digite o ID que deseja consultar: ");
			Long idConsultado = scan.nextLong();

			for (Usuario usuario : bancoUsuario) {
				if (usuario.getId().equals(idConsultado)) {
					exibeUsuariosCadastrados(bancoUsuario);
					return usuario;
				}
			}

			System.out.println("ID não encontrado.");
		}
		return null;
	}

	public void atualizarUsuario(List<Usuario> bancoUsuario, Scanner scan) {
		System.out.println("\n ********** ATUALIZA ************* ");

		if (verificaUsuario(bancoUsuario)) {
			System.out.println("Digite o ID que deseja atualizar: ");
			Long iDSelecionado = scan.nextLong();

			Usuario usuario = buscarUsuarioPorID(bancoUsuario, iDSelecionado);

			if (usuario != null) {
				while (true) {
					try {
						System.out.print("Novo Nome: ");
						usuario.setNome(scan.next());

						System.out.print("Novo CPF: ");
						usuario.setCpf(scan.next());

						System.out.print("Novo Email: ");
						usuario.setEmail(scan.next());

						System.out.println("Usuario atualizado com sucesso!");
						break;
					} catch (Exception e) {
						System.out.println("Erro, tente novamente.");
						scan.nextLine();
					}
				}
			} else {
				System.out.println("ID não encontrado.");
			}
		}
	}

	public void deletarUsuario(List<Usuario> bancoUsuario, Scanner scan) {
		
		System.out.println("Digite o ID do usuario a ser removido: ");
		iDSelecionado = scan.nextLong();

		Usuario usuario = buscarUsuarioPorID(bancoUsuario, iDSelecionado);

		if (bancoUsuario != null) {
			bancoUsuario.remove(usuario);
			System.out.println("Removido com sucesso.");
		} else {
			System.err.println("ID não encontrado.");
		}

	}

	private static void lerDadosUsuario(Usuario usuario, Scanner scan) {
		try {
			System.out.print("ID: ");
			usuario.setId(scan.nextLong());

			System.out.print("Nome: ");
			usuario.setNome(scan.next());

			System.out.print("CPF: ");
			usuario.setCpf(scan.next());

			System.out.print("Email: ");
			usuario.setEmail(scan.next());

		} catch (Exception e) {

			scan.nextLine();
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
