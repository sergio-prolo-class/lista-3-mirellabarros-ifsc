package biblioteca;

import java.util.Random;

public class Leitor {
    private int id = 0;
    private String nome = "";
    private String endereco = "";
    private String telefone = "";

    public Leitor(String nome, String endereco, String telefone) {
        if (!nome.isEmpty() && !endereco.isEmpty() && telefone.isEmpty()) {
            Random random = new Random();
            this.id = random.nextInt(9999) + 1;
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
        }
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
}
