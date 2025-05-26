package biblioteca;

import java.util.LinkedHashSet;
import java.util.Set;

public class Livro {
    private String titulo = "";
    private String isbn = "";
    private Set<Autor> autor = new LinkedHashSet<>();

    public Livro(String titulo, String isbn, Autor ...autor) {
        if (!titulo.isEmpty() && !isbn.isEmpty() && autor != null) {
            this.titulo = titulo;
            this.isbn = isbn;
            for (Autor a : autor) {
                this.autor.add(a);
            }
        }
    }
}
