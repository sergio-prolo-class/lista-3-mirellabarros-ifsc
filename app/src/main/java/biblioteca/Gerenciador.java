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
        if (this.autor.contains(autor)) {
            return false;
        }

        this.autor.add(autor);
        return true;
    }

    public boolean cadastrarLeitor(String nome, String endereco, String telefone){
        if (nome.isEmpty() && endereco.isEmpty() && telefone.isEmpty()) {
            return false;
        }

        Leitor leitor = new Leitor(nome, endereco, telefone);
        if (this.leitor.contains(leitor)) {
            return false;
        }

        this.leitor.add(leitor);
        return true;
    }

    public boolean cadastrarAcervo(String titulo, String isbn, int quantidade, String ...autores){
        if (titulo.isEmpty() && isbn.isEmpty() && quantidade < 0 && autores.length == 0) {
            return false;
        }

        List<Autor> listaDeAutores = new ArrayList<>();
        for (String autor : autores) {
            Autor a = buscarAutor(autor);
            if (a != null) {
                listaDeAutores.add(a);
            }
        }

        Livro novoLivro = new Livro(titulo, isbn, listaDeAutores.toArray(new Autor[0]));
        Acervo novoAcervo = new Acervo(novoLivro, quantidade);
        this.acervo.add(novoAcervo);
        return true;

    }

    public Autor buscarAutor(String nome) {
        if (nome.isEmpty()) {
            return null;
        }

        for (Autor autor : this.autor) {
            if (autor.getNome().equalsIgnoreCase(nome)) {
                return autor;
            }
        }

        return null; // Autor não encontrado
    }

    public String listarAcervo(String ordenacao) {
        if (ordenacao.isEmpty()) {
            return null;
        }

        List<Acervo> listaDeAcervos = new ArrayList<>(this.acervo);

        if (ordenacao.equals("titulo")) {
            listaDeAcervos.sort((livro1, livro2) -> {
                String t1 = livro1.getLivro().getTitulo();
                String t2 = livro2.getLivro().getTitulo();
                return t1.compareTo(t2);
            });
        } else if (ordenacao.equals("isbn")) {
            listaDeAcervos.sort((livro1, livro2) -> {
                String t1 = livro1.getLivro().getIsbn();
                String t2 = livro2.getLivro().getIsbn();
                return t1.compareTo(t2);
            });
        } else if (ordenacao.equals("autor")) {
            listaDeAcervos.sort((livro1, livro2) -> {
                String t1 = livro1.getLivro().getAutor().toString();
                String t2 = livro2.getLivro().getAutor().toString();
                return t1.compareTo(t2);
            });
        }

        String resultado = "";
        resultado += "---------------------------------\n";
        resultado += "Titulo, Autores, ISBN, Quantidade\n";
        resultado += "---------------------------------\n";
        for (Acervo acervo : listaDeAcervos) {
            resultado += acervo.getLivro().getTitulo() + ",";
            for (Autor autor : acervo.getLivro().getAutor()) {
                resultado += autor.getNome() + ",";
            }
            resultado += acervo.getLivro().getIsbn() + ",";
            resultado += acervo.getQuantidade() + "\n";
        }
        return resultado;
    }
}
