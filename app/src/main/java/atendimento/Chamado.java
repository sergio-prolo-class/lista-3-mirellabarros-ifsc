package atendimento;

public class Chamado {
    private Cliente cliente;
    private String categoria;
    private String descricao;

    public Chamado(Cliente cliente, String categoria, String descricao) {
        this.cliente = cliente;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }
}
