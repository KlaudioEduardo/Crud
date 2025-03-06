package crud.br.main;

import crud.br.main.services.Menu;
import crud.br.models.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       
        List<Usuario> bancoUsuarios = new ArrayList<>();
     
        Menu menu = new Menu();
        
        menu.startaMenu(bancoUsuarios);
    }
}
