package biblioteca;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Gerenciador {
    Set<Acervo> acervo = new LinkedHashSet<>();
    Set<Autor> autor = new LinkedHashSet<>();
    Set<Leitor> leitor = new LinkedHashSet<>();
    List<Emprestimo> emprestimo = new ArrayList<>();

    public boolean cadastrarAutor(String nome, String idioma){
        if (nome.isEmpty() && idioma.isEmpty()) {
            return false;
        }
        Autor autor = new Autor(nome, idioma);
        this.autor.add(autor);
        return true;
    }

    public boolean cadastrarLeitor(){
        return false;
    }

    public boolean cadastrarAcervo(){
        return false;
    }
}
