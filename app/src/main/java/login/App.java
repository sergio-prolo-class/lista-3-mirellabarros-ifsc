package login;

public class App {
    public static void main(String[] args) {
        // Cria usuário MAria (deve retornar verdadeiro)
        String login = "MAria";
        System.out.println("Cria um login " + login);
        if (Gerenciador.criarUsuario(login, "111")) {
            System.out.println("Usuario criado com sucesso. \n");
        } else {
            System.out.println("Erro ao criar usuario.\n");
        }

        // Cria usuário MAria novamente (deve retornar falso)
        System.out.println("Cria um login " + login + " novamente");
        if (Gerenciador.criarUsuario(login, "111")) {
            System.out.println("Usuario criado com sucesso.\n");
        } else {
            System.out.println("Erro ao criar usuario.\n");
        }

        // Cria usuário joao (deve retornar verdadeiro)
        login = "joao";
        System.out.println("Cria um login " + login);
        if (Gerenciador.criarUsuario(login, "222")) {
            System.out.println("Usuario criado com sucesso.\n");
        } else {
            System.out.println("Erro ao criar usuario.\n");
        }

        // Cria usuário pedro (deve retornar verdadeiro)
        login = "pedro";
        System.out.println("Cria um login " + login);
        if (Gerenciador.criarUsuario(login, "333")) {
            System.out.println("Usuario criado com sucesso.\n");
        } else {
            System.out.println("Erro ao criar usuario.\n");
        }

        // Cria usuário vazio (deve retornar falso)
        login = "";
        System.out.println("Cria um login sem valores definidos" + login);
        if (Gerenciador.criarUsuario(login, "")) {
            System.out.println("Usuario criado com sucesso.\n");
        } else {
            System.out.println("Erro ao criar usuario.\n");
        }

        // Imprime a lista de usuários cadastrados mantendo a ordem
        System.out.println("Imprime a lista de usuarios cadastrados mantendo a ordem");
        String[] usuarios = Gerenciador.listarUsuarios();
        for (String usuario : usuarios) {
            System.out.println(usuario);
        }
        System.out.println();

        // Realiza login e imprime o retorno do método login (boolean)
        System.out.println("Realiza login do usuario");
        boolean sucessoLogin = Gerenciador.login("maria", "111");
        if (sucessoLogin) {
            System.out.println("Login realizado com sucesso.\n");
        } else {
            System.out.println("Erro ao realizar login.\n");
        }

        // Remove um usuário e imprime o resultado do método removerUsuario (boolean)
        System.out.println("Remove um usuario");
        boolean sucessoRemover = Gerenciador.removerUsuario("joao");
        if (sucessoRemover) {
            System.out.println("Usuario removido com sucesso.\n");
        } else {
            System.out.println("Erro ao remover usuario.\n");
        }

        // Tenta remover um usuário inexistente.
        System.out.println("Tenta remover um usuario inexistente");
        sucessoRemover = Gerenciador.removerUsuario("joaoo");
        if (sucessoRemover) {
            System.out.println("Usuario removido com sucesso.\n");
        } else {
            System.out.println("Erro ao remover usuario.\n");
        }

        // Imprime a lista de usuários cadastrados, após a remoção.
        System.out.println("Imprime a lista de usuarios cadastrados mantendo a ordem");
        usuarios = Gerenciador.listarUsuarios();
        for (int i = 0; i < usuarios.length; i++) {
            System.out.println(usuarios[i]);
        }
    }
}
