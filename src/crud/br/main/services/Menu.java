package crud.br.main.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import crud.br.models.Usuario;

public class Menu {

    private static Scanner scan = new Scanner(System.in);
    private UsuarioService usuarioServices = new UsuarioService();

    public void startaMenu(List<Usuario> bancoUsuario) {
        try {
            while (true) {
                try {
                    System.out.println("O que você deseja fazer: ");
                    System.out.println("1 - Cadastrar \n2 - Consultar \n3 - Atualizar \n4 - Deletar \n5 - Sair");

                    int opcaoSelecionada = scan.nextInt();
                    scan.nextLine();

                    switch (opcaoSelecionada) {
                        case 1:
                            usuarioServices.cadastrarUsuario(bancoUsuario);
                            break;
                        case 2:
                        usuarioServices.consultarUsuario(bancoUsuario, scan);
                            break;
                        case 3:
                            usuarioServices.atualizarUsuario(bancoUsuario, scan);
                            break;
                        case 4:
                            usuarioServices.deletarUsuario(bancoUsuario, scan);
                            break;
                        case 5:
                            System.out.println("Saindo...");
                            return;
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Entrada inválida. Digite apenas números.");
                    scan.nextLine(); 
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                   
                }
            }
        } catch (Exception e) {
            System.out.println("Erro crítico no menu: " + e.getMessage());
            
        }
    }
}
