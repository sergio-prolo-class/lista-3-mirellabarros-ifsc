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
}
