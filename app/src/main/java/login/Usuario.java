package login;
import java.util.Objects;

public class Usuario {
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    // Sobrescreve o equals.
    // Compara o login (e não todos os atributos ou o endereço de memória).
    @Override
    public boolean equals(Object obj) {
        // Verifica se é o mesmo objeto (mesmo endereço de memória)
        if (this == obj) return true;

        // Verifica se é um objeto do tipo Usuario
        if (!(obj instanceof Usuario)) return false;

        // Verifica se o login já existe
        Usuario u = (Usuario) obj;
        return this.login.equals(u.login);
    }

    // Sobrescreve o hashCode
    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
