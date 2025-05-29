package biblioteca;

public class Acervo {
    private Livro livro;
    private int quantidade = 0;

    public Acervo(Livro livro, int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
