package biblioteca;

public class Emprestimo {
    private Leitor leitor;
    private Livro livro;

    public Emprestimo(Leitor leitor, Acervo acervo) {
        this.leitor = leitor;
        this.livro = acervo.getLivro();
        acervo.emprestarLivro();
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Livro getLivro() {
        return livro;
    }
}
