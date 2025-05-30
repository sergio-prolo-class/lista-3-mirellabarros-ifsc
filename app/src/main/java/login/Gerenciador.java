package login;

import java.util.LinkedHashSet;
import java.util.Set;

public class Gerenciador {
    private static Set<Usuario> usuarios = new LinkedHashSet<>();

    public static boolean criarUsuario(String login, String senha) {
        // Verifica se as variáveis não estão vazias.
        if (login.isEmpty() || senha.isEmpty()) {
            return false;
        }

        // Cria um novo usuário e adiciona à lista
        Usuario u = new Usuario(login.toLowerCase(), senha);

        // Verifica se o login já existe
        if (usuarios.contains(u)) {
            return false; // login já existe
        }

        usuarios.add(u);
        return true;
    }

    public static boolean removerUsuario(String login) {
        if (!login.isEmpty()) {
            if (usuarios.removeIf(u -> u.getLogin().equals(login.toLowerCase()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean login(String login, String senha) {
        if (!login.isEmpty() || !senha.isEmpty()) {
            for (Usuario u : usuarios) {
                if (u.getLogin().equals(login.toLowerCase())) {
                    if (u.getSenha().equals(senha)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String[] listarUsuarios() {
        String[] lista = new String[usuarios.size()];
        int i = 0;
        for (Usuario u : usuarios) {
            lista[i] = u.getLogin();
            i++;
        }
        return lista;
    }
}
