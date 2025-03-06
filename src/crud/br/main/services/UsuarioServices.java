package crud.br.main.services;


import java.util.List;
import java.util.Scanner;

import crud.br.models.Usuario;


public class UsuarioServices {
	
	private static Scanner scan = new Scanner(System.in);
	
	public void cadastrarUsuario(List<Usuario> bancoUsuario) {
		
		Usuario novoUsuario = new Usuario();
		
		System.out.println("\n*******************\n");		
		System.out.println("Digite o ID que deseja cadastrar: ");
		novoUsuario.setId(scan.nextLong());
		System.out.println("Digite o nome que deseja cadastrar: ");
		novoUsuario.setNome(scan.next());
		System.out.println("Digite o CPF que deseja cadastrar: ");
		novoUsuario.setCpf(scan.next());
		System.out.println("Digite o email que deseja cadastrar: ");
		novoUsuario.setEmail(scan.next());
		
		System.out.println(novoUsuario);
		
		bancoUsuario.add(novoUsuario);
		
	}

	 public Usuario buscaUsuarioById(Long id, List<Usuario> bancoUsuario) {
		for (Usuario usuario : bancoUsuario) {
			if (usuario.getId() == id) {
				return usuario;
			}}
		return null;
	}

	public void atualizarUsuario() {
		System.out.println("Atualização");
	
	}

	public void deletarUsuario() {
		System.out.println("Exclusão");
		
	}

	
		

}
