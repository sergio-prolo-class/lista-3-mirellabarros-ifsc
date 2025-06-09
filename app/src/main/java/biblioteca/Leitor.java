package biblioteca;

import java.util.Objects;
import java.util.Random;

public class Leitor {
    private int id = 0;
    private String nome = "";
    private String endereco = "";
    private String telefone = "";

    // Cria um novo leitor e atribui um ID com valor aleatório. Menor valor é 1.
    public Leitor(String nome, String endereco, String telefone) {
        Random random = new Random();
        this.id = random.nextInt(9999) + 1;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    // Sobrescreve o equals.
    // Compara o nome do leitor.
    @Override
    public boolean equals(Object obj) {
        // Verifica se é o mesmo objeto (mesmo endereço de memória)
        if (this == obj) {
            return true;
        }

        // Verifica se é um objeto do tipo Autor
        if (!(obj instanceof Leitor)) {
            return false;
        }

        // Verifica se o leitor já existe
        Leitor leitor = (Leitor) obj;
        return this.nome.equals(leitor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
