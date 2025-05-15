package login;

import java.util.HashSet;
import java.util.Set;

public class Gerenciador {
    private static Set<Usuario> usuarios = new HashSet<>();

    public static void criarUsuario(String usuario, String senha) {
        Usuario u = new Usuario(usuario, senha);
        usuarios.add(u);
    }

    public static void removerUsuario {

    }

    public static boolean login {

    }

    public static void listarUsuarios {

    }
}
