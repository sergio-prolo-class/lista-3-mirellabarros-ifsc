package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Gerenciador g = new Gerenciador();

        boolean status = false;

        status = g.cadastrarAutor("Autor 1","pt");
        if (status) {
            System.out.println("Autor cadastrado");
        } else {
            System.out.println("Erro");
        }

        status = g.cadastrarAutor("Autor 2","pt");
        if (status) {
            System.out.println("Autor cadastrado");
        } else {
            System.out.println("Erro");
        }

        status = g.cadastrarAutor("Autor 3","pt");
        if (status) {
            System.out.println("Autor cadastrado");
        } else {
            System.out.println("Erro");
        }

        status = g.cadastrarAcervo("Algoritmos", "1234", 3, "Autor 3", "Autor 2");

        if (status) {
            System.out.println("Acervo cadastrado");
        } else {
            System.out.println("Erro");
        }

        status = g.cadastrarAcervo("Genesis", "1234", 3, "Autor 2");

        if (status) {
            System.out.println("Acervo cadastrado");
        } else {
            System.out.println("Erro");
        }

        status = g.cadastrarAcervo("Inteligencia Artificial", "1234", 3, "Autor 2", "Autor 3");

        if (status) {
            System.out.println("Acervo cadastrado");
        } else {
            System.out.println("Erro");
        }

        String ordenacao = "autor";
        String acervo = g.listarAcervo(ordenacao);
        System.out.println(acervo);


    }
}
