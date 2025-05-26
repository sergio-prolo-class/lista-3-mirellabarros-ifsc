package atendimento;

import java.util.*;

public class Controle {
    private Queue<Chamado> fila = new LinkedList<Chamado>();
    private List<Chamado> atendidos = new ArrayList<Chamado>();
    private Map<String, Cliente> clientes = new HashMap<>();

    public boolean inserir(String nome, String telefone, String categoria, String descricao) {
        // Verifica se os valores não são vazios
        if (nome.isEmpty() || telefone.isEmpty() || categoria.isEmpty() || descricao.isEmpty()) {
            return false;
        }

        // Verifica se a categoria existe
        Categoria cat = new Categoria();
        if (!cat.verificaCategoria(categoria)) {
            return false;
        }

        // Verifica se o cliente já existe
        Cliente cliente = null;
        if (!this.clientes.containsKey(telefone)) {
            cliente = new Cliente(nome, telefone);
            this.clientes.put(telefone, cliente);
        } else {
            cliente = this.clientes.get(telefone);
        }

        // Cria o novo chamado
        Chamado chamado = new Chamado(cliente, categoria, descricao);
        fila.add(chamado);
        return true;
    }

    // Cria uma lista e adiciona os telefones dos clientes que estão no Map clientes
    public List<String> listarTelefones() {
        List<String> telefones = new ArrayList<>();
        for (Cliente cliente : this.clientes.values()) {
            telefones.add(cliente.getTelefone());
        }
        return telefones;
    }

    // Retorna o primeiro cliente da fila de atendimento, sem removê-lo.
    public String proximoCLiente() {
        if (fila.isEmpty()) {
            return "A fila esta vazia.";
        }
        return fila.peek().getCliente().getNome();
    }

    // Atende o próximo chamado da fila
    public String atenderProximoCLiente() {
        // Verifica se a fila está vazia
        if (this.fila.isEmpty()) {
            return "A fila esta vazia.";
        }
        // Remove o primeiro chamado da fila e o adiciona em na lista de atendidos
        Chamado chamado = this.fila.poll();
        this.atendidos.add(chamado);
        return chamado.getCliente().getNome();
    }

    // Retorna o nome dos clientes já atendidos da lista de clientes atendidos.
    public List<String> listarAtendidos() {
        List<String> atendidos = new ArrayList<>();
        for (Chamado chamado : this.atendidos) {
            atendidos.add(chamado.getCliente().getNome());
        }
        return atendidos;
    }

    // Cria uma lista e adiciona os telefones dos clientes que estão no Map clientes
    public List<String> listarTelefonesEmEspera() {
        List<String> telefones = new ArrayList<>();
        for (Chamado chamado : this.fila) {
            telefones.add(chamado.getCliente().getTelefone());
        }
        return telefones;
    }

    // Retorna o relatório dos chamados
    public Double[] relatorio() {
        double totalDeSolicitacoes = fila.size() + atendidos.size();
        double totalAtendidos = atendidos.size();
        double totalEmEspera = fila.size();
        double percentualEmEspera = (totalEmEspera / totalDeSolicitacoes) * 100;
        double percentualAtendidos = (totalAtendidos / totalDeSolicitacoes) * 100;

        Double[] relatorio = new Double[5];
        relatorio[0] = totalDeSolicitacoes;
        relatorio[1] = totalAtendidos;
        relatorio[2] = totalEmEspera;
        relatorio[3] = percentualEmEspera;
        relatorio[4] = percentualAtendidos;
        return relatorio;
    }

}
