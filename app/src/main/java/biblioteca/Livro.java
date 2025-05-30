package biblioteca;

import java.util.*;

public class Livro {
    private String titulo = "";
    private String isbn = "";
    private Set<Autor> autores = new LinkedHashSet<>();

    // Metodo construtor recebe o título, isbn e objetos do tipo Autor em um array
    // Os objetos do tipo autor são salvos no Set autor.
    public Livro(String titulo, String isbn, Autor ...autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        Collections.addAll(this.autores, autor);
    }

    // Retorna o título do livro
    public String getTitulo() {
        return titulo;
    }

    // Retorna o ISBN do livro
    public String getIsbn() {
        return isbn;
    }

    // Retorna um List com os autores do livro
    public List<Autor> getAutor() {
        List<Autor> autores = new ArrayList<>(this.autores);
        return autores;
    }

    // Sobrescreve o equals.
    // Compara o título do livro.
    @Override
    public boolean equals(Object obj) {
        // Verifica se é o mesmo objeto (mesmo endereço de memória)
        if (this == obj) {
            return true;
        }

        // Verifica se é um objeto do tipo Autor
        if (!(obj instanceof Livro)) {
            return false;
        }

        // Verifica se o leitor já existe
        Livro livro = (Livro) obj;
        return this.titulo.equals(livro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }
}
