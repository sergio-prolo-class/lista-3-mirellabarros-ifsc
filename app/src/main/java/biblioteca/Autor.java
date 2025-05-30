package biblioteca;

import java.util.Objects;

public class Autor {
    private String nome;
    private String idioma;

    public Autor(String nome, String idioma) {
        this.nome = nome;
        this.idioma = idioma;
    }

    public String getNome() {
        return nome;
    }

    public String getIdioma() {
        return idioma;
    }

    // Sobrescreve o equals.
    // Compara o nome do autor.
    @Override
    public boolean equals(Object obj) {
        // Verifica se é o mesmo objeto (mesmo endereço de memória)
        if (this == obj) {
            return true;
        }

        // Verifica se é um objeto do tipo Autor
        if (!(obj instanceof Autor)) {
            return false;
        }

        // Verifica se o autor já existe
        Autor autor = (Autor) obj;
        return this.nome.equals(autor.nome);
    }

    // Sobrescreve o hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
