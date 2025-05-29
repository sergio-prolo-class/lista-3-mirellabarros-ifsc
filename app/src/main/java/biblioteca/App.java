package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Gerenciador g = new Gerenciador();

        boolean status = false;

        // Usando operador ternário para simplificar o código na parte de cadastro
        // de autores, acervo e leitores
        status = g.cadastrarAutor("Sebastiao Salgado","pt");
        System.out.println(status ? "Autor cadastrado" : "Erro");

        status = g.cadastrarAutor("Stuart Russell","en");
        System.out.println(status ? "Autor cadastrado" : "Erro");

        status = g.cadastrarAutor("Peter Norvig","en");
        System.out.println(status ? "Autor cadastrado" : "Erro");

        status = g.cadastrarAutor("Thomas Cormen","en");
        System.out.println(status ? "Autor cadastrado" : "Erro");

        status = g.cadastrarAutor("Andrew Chaikin","en");
        System.out.println(status ? "Autor cadastrado" : "Erro");

        status = g.cadastrarAutor("Piers Bizony","en");
        System.out.println(status ? "Autor cadastrado" : "Erro");

        status = g.cadastrarAutor("Roger Launius","en");
        System.out.println(status ? "Autor cadastrado" : "Erro");

        status = g.cadastrarLivro("Algoritmos", "2233", 2, "Thomas Cormen");
        System.out.println(status ? "Acervo cadastrado" : "Erro");

        status = g.cadastrarLivro("Genesis", "1122", 2, "Sebastiao Salgado");
        System.out.println(status ? "Acervo cadastrado" : "Erro");

        status = g.cadastrarLivro("Inteligencia Artificial", "4455", 3, "Stuart Russell", "Peter Norvig");
        System.out.println(status ? "Acervo cadastrado" : "Erro");

        status = g.cadastrarLivro("The NASA Archives", "6677", 1, "Piers Bizony", "Andrew Chaikin", "Roger Launius");
        System.out.println(status ? "Acervo cadastrado" : "Erro");

        status = g.cadastrarLeitor("Joao da Silva", "Rua do Paraiso, 17", "48 988776655");
        System.out.println(status ? "Leitor cadastrado" : "Erro");

        status = g.cadastrarLeitor("Maria Joaquina", "Rua do Sonho, 25", "48 966554477");
        System.out.println(status ? "Leitor cadastrado" : "Erro");

        status = g.cadastrarLeitor("Fernanda Abelha", "Rua do Mel, 32", "48 977887799");
        System.out.println(status ? "Leitor cadastrado" : "Erro");

        // Ordenação: "autor", "isbn", "autor"
        String ordenacao = "titulo";
        String acervo = g.listarAcervo(ordenacao);
        System.out.println(acervo);

        ordenacao = "isbn";
        acervo = g.listarAcervo(ordenacao);
        System.out.println(acervo);

        ordenacao = "autor";
        acervo = g.listarAcervo(ordenacao);
        System.out.println(acervo);

        // Realizando um empréstimo (Sucesso)
        status = g.cadastrarEmprestimo("Genesis", "Fernanda Abelha");
        System.out.println(status ? "Emprestimo realizado" : "Erro");

        // O mesmo leitor tentandor fazer um empréstimo do mesmo livro (Erro)
        status = g.cadastrarEmprestimo("Genesis", "Fernanda Abelha");
        System.out.println(status ? "Emprestimo realizado" : "Erro");

        // Realizando um empréstimo (Sucesso)
        status = g.cadastrarEmprestimo("The NASA Archives", "Joao da Silva");
        System.out.println(status ? "Emprestimo realizado" : "Erro");

        // Um leitor tentando realizar um empréstimo de um livro que não está disponível (Erro)
        status = g.cadastrarEmprestimo("The NASA Archives", "Maria Joaquina");
        System.out.println(status ? "Emprestimo realizado" : "Erro");

        // Listar todos os autores em ordem alfabética
        String autores = g.listarAutores();
        System.out.println(autores);

        // Listar todos os leitores em ordem alfabética
        String leitores = g.listarLeitores("nome");
        System.out.println(leitores);

        // Listar todos os leitores em ordem de id
        leitores = g.listarLeitores("id");
        System.out.println(leitores);

    }
}
