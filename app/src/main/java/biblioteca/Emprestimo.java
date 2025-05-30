package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private Leitor leitor;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private static DateTimeFormatter dataPadraoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Ao fazer um emprestimo, são recebidos um leitor, um acervo
    // e uma data no formato brasileiro para efeito de testes (poderia ser automática)
    // A data é formatada para o padrão LocalDate
    public Emprestimo(Leitor leitor, Acervo acervo, String data) {
        this.leitor = leitor;
        this.livro = acervo.getLivro();
        this.dataEmprestimo = LocalDate.parse(data, dataPadraoBr);
        acervo.emprestarLivro();
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    // Retorna a data como LocalDate para fazer ordenações
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    // Retorna a data formatada no padrão brasileiro para impressões - dd/mm/aaaa
    public String getDataEmprestimoFormatada() {
        return dataEmprestimo.format(dataPadraoBr);
    }
}
