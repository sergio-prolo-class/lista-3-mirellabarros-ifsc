package biblioteca;

public class Acervo {
    private Livro livro;
    private int quantidade = 0;

    public Acervo(Livro livro, int quantidade) {
        if (livro != null && quantidade > 0) {
            this.livro = livro;
            this.quantidade = quantidade;
        }
    }
}
