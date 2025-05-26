package atendimento;

import java.util.*;

public class Controle {
    Queue<Chamado> fila = new LinkedList<Chamado>();
    List<Chamado> atendidos = new ArrayList<Chamado>();
    Map<String, Cliente> cliente = new HashMap<>();


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
        if (!this.cliente.containsKey(telefone)) {
            cliente = new Cliente(nome, telefone);
            this.cliente.put(telefone, cliente);
        } else {
            cliente = this.cliente.get(telefone);
        }

        // Cria o novo chamado
        Chamado chamado = new Chamado(cliente, categoria, descricao);
        fila.add(chamado);
        return true;
    }
}
