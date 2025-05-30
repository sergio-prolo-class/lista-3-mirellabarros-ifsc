package biblioteca;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Gerenciador {
    Set<Acervo> acervoDeLivros = new LinkedHashSet<>();
    Set<Autor> autores = new LinkedHashSet<>();
    Set<Leitor> leitores = new LinkedHashSet<>();
    List<Emprestimo> emprestimos = new ArrayList<>();

    // Cadastra um novo autor
    public boolean cadastrarAutor(String nome, String idioma){
        // Verifica se os valores estão vazios
        if (nome.isEmpty() && idioma.isEmpty()) {
            return false;
        }

        // Verifica se o autor já existe (critério nome)
        Autor autor = new Autor(nome, idioma);
        if (this.autores.contains(autor)) {
            return false;
        }

        // Adiciona um autor
        this.autores.add(autor);
        return true;
    }

    // Cadastra um novo leitor
    public boolean cadastrarLeitor(String nome, String endereco, String telefone){
        // Verifica se os valores estão vazios
        if (nome.isEmpty() && endereco.isEmpty() && telefone.isEmpty()) {
            return false;
        }

        Leitor leitor = new Leitor(nome, endereco, telefone);

        // Verifica se o leitor já existe (critério nome)
        if (this.leitores.contains(leitor)) {
            return false;
        }

        // Adiciona o leitor ao Set leitores
        this.leitores.add(leitor);
        return true;
    }

    // Cadastra novo livro e o adiciona ao acervo
    public boolean cadastrarLivro(String titulo, String isbn, int quantidade, String ...autores){
        // Verifica se os parâmetros são vazios
        if (titulo.isEmpty() && isbn.isEmpty() && quantidade < 0 && autores.length == 0) {
            return false;
        }

        // Cria uma List de autores cujos valores estão no array autores
        // Os autores são buscados no Set autores e os objetos adicionados à lista de autores
        List<Autor> listaDeAutores = new ArrayList<>();
        for (String autor : autores) {
            Autor a = buscarAutor(autor);
            if (a != null) {
                listaDeAutores.add(a);
            }
        }

        // Cria um objeto novoLivro e a List de autores é convertida e um array de forma que um novo livro possa receber
        // diversos objetos do tipo autor
        Livro novoLivro = new Livro(titulo, isbn, listaDeAutores.toArray(new Autor[0]));
        // Adiciona o novo livro ao acervo definindo a quantidade disponível
        Acervo novoAcervo = new Acervo(novoLivro, quantidade);
        this.acervoDeLivros.add(novoAcervo);
        return true;
    }

    // Cadastra um novo empréstimo de livro
    public boolean cadastrarEmprestimo(String titulo, String leitor, String dataEmprestimo){
        // Verifica se os parâmetros informados são vazios
        if (titulo.isEmpty() && leitor.isEmpty()) {
            return false;
        }

        // Retorna os objetos referentes aos parâmetros fornecidos
        Leitor objLeitor = buscarLeitor(leitor);
        Livro objLivro = buscarLivro(titulo);

        // Verifica se os objetos são nulos
        if (objLeitor == null || objLivro == null) {
            return false;
        }

        // Retorna a quantidade de livros disponíveis no acervo
        Acervo objAcervo = this.acervoDeLivros.stream().filter(livro -> livro.getLivro().equals(objLivro))
                .findFirst().orElse(null);
        int qtdDisponivel = objAcervo.getQtdDisponivel();

        // Retorna se o leitor já possui o livro que deseja tomar emprestado
        boolean leitorPossuiEsteLivro = this.emprestimos.stream()
                .anyMatch(e -> e.getLeitor().equals(objLeitor) && e.getLivro().equals(objLivro));

        // Retorna a quantidade de livros emprestados ao leitor
        int qtdLivrosEmprestados = (int) this.emprestimos.stream()
                .filter(e -> e.getLeitor().equals(objLeitor)).count();

        // Para que um livro seja emprestado, a quantidade disponível no acervo deve ser maior do que 0, o leitor
        // não pode possuir o livro e o leitor também deve ter menos do que 5 livros emprestados.
        if (qtdDisponivel > 0 && !leitorPossuiEsteLivro && qtdLivrosEmprestados < 5) {
            Emprestimo emprestimo = new Emprestimo(objLeitor, objAcervo, dataEmprestimo);
            this.emprestimos.add(emprestimo);
            return true;
        }
        return false;
    }

    // Busca por um autor no Set autores usando String - metodo auxiliar
    private Autor buscarAutor(String nome) {
        if (nome.isEmpty()) {
            return null;
        }

        for (Autor autor : this.autores) {
            if (autor.getNome().equalsIgnoreCase(nome)) {
                return autor;
            }
        }

        return null;
    }

    // Busca por um leitor no Set leitores - metodo auxiliar
    private Leitor buscarLeitor(String nome) {
        if (nome.isEmpty()) {
            return null;
        }

        for (Leitor leitor : this.leitores) {
            if (leitor.getNome().equalsIgnoreCase(nome)) {
                return leitor;
            }
        }

        return null;
    }

    // Busca por um livro no Set acervoDeLivros - metodo auxiliar
    private Livro buscarLivro(String nome) {
        if (nome.isEmpty()) {
            return null;
        }

        for (Acervo livro : this.acervoDeLivros) {
            if (livro.getLivro().getTitulo().equalsIgnoreCase(nome)) {
                return livro.getLivro();
            }
        }
        return null;
    }

    // Retorna todos os autores cadastrados em uma String, ordenados por nome
    public String listarAutores() {
        List<Autor> listaDeAutores = new ArrayList<>(this.autores);

        listaDeAutores.sort((autor1, autor2) -> {
            String a1 = autor1.getNome();
            String a2 = autor2.getNome();
            return a1.compareTo(a2);
        });

        String resultado = "";
        resultado += "---------------------------------\n";
        resultado += "Nome, Idioma\n";
        resultado += "---------------------------------\n";
        for (Autor autor : listaDeAutores) {
            resultado += autor.getNome() + ", ";
            resultado += autor.getIdioma() + "\n";
        }
        return resultado;
    }

    // Retorna todos os autores cadastrados em uma String, ordenados por nome ou id
    public String listarLeitores(String ordenacao) {
        if (ordenacao.isEmpty()) {
            return null;
        }

        List<Leitor> listaDeLeitores = new ArrayList<>(this.leitores);
        if (ordenacao.equals("nome")) {
            listaDeLeitores.sort((leitor1, leitor2) -> {
                String l1 = leitor1.getNome();
                String l2 = leitor2.getNome();
                return l1.compareTo(l2);
            });
        } else if (ordenacao.equals("id")) {
            listaDeLeitores.sort((leitor1, leitor2) -> {
                int l1 = leitor1.getId();
                int l2 = leitor2.getId();
                return Integer.compare(l1, l2);
            });
        } else {
            return null;
        }

        String resultado = "";
        resultado += "---------------------------------\n";
        resultado += "ID, Nome, Endereco, Telefone\n";
        resultado += "---------------------------------\n";
        for (Leitor leitor : listaDeLeitores) {
            resultado += leitor.getId() + " | ";
            resultado += leitor.getNome() + "\t ";
            resultado += leitor.getEndereco() + "\t ";
            resultado += leitor.getTelefone() + "\n";
        }

        return resultado;
    }

    // Retorna todos o acervo cadastrado em uma String, ordenados por título, isbn ou autor
    public String listarAcervo(String ordenacao) {
        if (ordenacao.isEmpty()) {
            return null;
        }

        List<Acervo> listaDeAcervos = new ArrayList<>(this.acervoDeLivros);

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
        } else {
            return null;
        }

        String resultado = "";
        resultado += "Acervo de livros ordenados por " + ordenacao + "\n";
        resultado += "---------------------------------\n";
        resultado += "Titulo, Autores, ISBN, Quantidade\n";
        resultado += "---------------------------------\n";
        for (Acervo acervo : listaDeAcervos) {
            resultado += acervo.getLivro().getTitulo() + ", ";
            for (Autor autor : acervo.getLivro().getAutor()) {
                resultado += autor.getNome() + ", ";
            }
            resultado += acervo.getLivro().getIsbn() + ", ";
            resultado += acervo.getQtdTotalDeLivros() + "\n";
        }
        return resultado;
    }

    // Retorna todos os empréstimos cadastrados em uma String, ordenados por data de empréstimo
    public String listarEmprestimos() {
        List<Emprestimo> listaDeEmprestimos = new ArrayList<>(this.emprestimos);
        listaDeEmprestimos.sort((emprestimo1, emprestimo2) -> {
            LocalDate e1 = emprestimo1.getDataEmprestimo();
            LocalDate e2 = emprestimo2.getDataEmprestimo();
            return e1.compareTo(e2);
        });
        String resultado = "";
        resultado += "---------------------------------\n";
        resultado += "Titulo, Leitor, Data\n";
        resultado += "---------------------------------\n";
        for (Emprestimo emprestimo : listaDeEmprestimos) {
            resultado += emprestimo.getLivro().getTitulo() + ", ";
            resultado += emprestimo.getLeitor().getNome() + ", ";
            resultado += emprestimo.getDataEmprestimoFormatada() + "\n";
        }
        return resultado;
    }

    // Sobrescreve o metodo listarEmprestimos com resultados filtrados por um leitor. A impressão muda
    // para não repetir o nome do leitor em cada livros emprestado.
    public String listarEmprestimos(String leitor) {
        if (leitor.isEmpty()) {
            return null;
        }

        Leitor l = this.buscarLeitor(leitor);
        if (l == null) {
            return null;
        }

        List<Emprestimo> listaDeEmprestimos = this.emprestimos.stream()
                .filter(emprestimo -> emprestimo.getLeitor().equals(l))
                .collect(Collectors.toList());

        listaDeEmprestimos.sort((emprestimo1, emprestimo2) -> {
            LocalDate e1 = emprestimo1.getDataEmprestimo();
            LocalDate e2 = emprestimo2.getDataEmprestimo();
            return e1.compareTo(e2);
        });

        String resultado = "";
        resultado += "Livros emprestados por: " + l.getNome() + "\n";
        resultado += "---------------------------------\n";
        resultado += "Titulo, Data\n";
        resultado += "---------------------------------\n";
        for (Emprestimo emprestimo : listaDeEmprestimos) {
            resultado += emprestimo.getLivro().getTitulo() + ", ";
            resultado += emprestimo.getDataEmprestimoFormatada() + "\n";
        }
        return resultado;
    }


}
