package biblioteca;

public class Emprestimo {
    private Leitor leitor;
    private Livro livro;

    public Emprestimo(Leitor leitor, Livro livro) {
        if (leitor != null && livro != null) {
            this.leitor = leitor;
            this.livro = livro;
        }
    }
}
