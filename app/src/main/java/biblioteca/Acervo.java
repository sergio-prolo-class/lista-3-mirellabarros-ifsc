package biblioteca;

import java.util.Objects;

public class Acervo {
    private Livro livro;
    private int qtdTotalDeLivros = 0;
    private int qtdDisponivel = 0;

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

    public void emprestarLivro() {
        qtdDisponivel--;
    }

    public void devolverLivro() {
        qtdDisponivel--;
    }
}
