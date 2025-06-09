package biblioteca;

import java.util.Objects;

public class Acervo {
    private Livro livro;
    private int qtdTotalDeLivros = 0;
    private int qtdDisponivel = 0;

    // Cria um acervo com o objeto livro e quantidade fornecida pelo usuário
    public Acervo(Livro livro, int quantidade) {
        this.livro = livro;
        this.qtdTotalDeLivros = quantidade;
        this.qtdDisponivel = quantidade;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getQtdTotalDeLivros() {
        return qtdTotalDeLivros;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    // Metodo usado para decrementar a quantidade disponível ao emprestar um livro
    public void emprestarLivro() {
        qtdDisponivel--;
    }
}
