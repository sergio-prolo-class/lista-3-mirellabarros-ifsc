package atendimento;

public class App {
    public static void main(String[] args) {

        Controle controle = new Controle();

        // Variáveis para facilitar o teste
        String nome = "";
        String telefone = "";
        String categoria = "";
        String descricao = "";
        boolean status = false;

        // Abrir um chamado para Maria
        nome = "Maria";
        telefone = "48911223344";
        categoria = "0";
        descricao = "Atendimento para suporte tecnico";
        status = controle.inserir(nome, telefone, categoria, descricao);
        if (status) {
            System.out.println("Chamado de " + nome + " Cadastrado com sucesso!\n");
        } else {
            System.out.println("Erro ao criar chamado.\n");
        }

        // Abrir um chamado para João
        nome = "Joao";
        telefone = "48955667788";
        categoria = "1";
        descricao = "Atendimento para informacao";
        status = controle.inserir(nome, telefone, categoria, descricao);
        if (status) {
            System.out.println("Chamado de " + nome + " Cadastrado com sucesso!\n");
        } else {
            System.out.println("Erro ao criar chamado.\n");
        }

        // Abrir um chamado para João e um novo objeto não deve ser criado
        nome = "Joao 2";
        telefone = "48955667788";
        categoria = "0";
        descricao = "Atendimento para suporte tecnico";
        status = controle.inserir(nome, telefone, categoria, descricao);
        if (status) {
            System.out.println("Chamado de " + nome + " Cadastrado com sucesso!\n");
        } else {
            System.out.println("Erro ao criar chamado.\n");
        }

        // Abrir um chamado com valores inválidos
        nome = "";
        telefone = "";
        categoria = "";
        descricao = "";
        status = controle.inserir(nome, telefone, categoria, descricao);
        if (status) {
            System.out.println("Chamado de " + nome + " Cadastrado com sucesso!\n");
        } else {
            System.out.println("Erro ao criar chamado.\n");
        }

        // Retorna o telefone dos clientes
        System.out.println("Telefones dos clientes.");
        for (String telefoneCliente : controle.listarTelefones()) {
            System.out.println(telefoneCliente);
        }
        System.out.println();

        // Retorna o próximo cliente da fila
        System.out.println("Proximo cliente da fila: " + controle.proximoCLiente());
        System.out.println();

        // Atende o próximo cliente da fila. O chamado é removido da fila e inserido na lista de atendidos
        System.out.println("Atendendo o proximo cliente: " + controle.atenderProximoCLiente());
        System.out.println();

        // Atende o próximo cliente da fila. O chamado é removido da fila e inserido na lista de atendidos
        System.out.println("Atendendo o proximo cliente: " + controle.atenderProximoCLiente());
        System.out.println();

        // Retorna os clientes já atendidos
        System.out.println("Clientes ja atendidos com sucesso!");
        for (String clienteAtendido : controle.listarAtendidos()) {
            System.out.println(clienteAtendido);
        }
        System.out.println();

        // Retorna o próximo cliente da fila após o atendimento do primeiro
        System.out.println("Proximo cliente da fila: " + controle.proximoCLiente());
        System.out.println();

        // Retorna os telefones dos clientes que estão na fila de espera
        System.out.println("Telefones dos clientes em fila de espera.");
        for (String telefoneClienteEmEspera : controle.listarTelefonesEmEspera()) {
            System.out.println(telefoneClienteEmEspera);
        }
        System.out.println();

        // Retorna o relatório estatístico
        System.out.println("Relatorio.");
        Double[] relatorio = controle.relatorio();
        System.out.println("solicitacoes registradas: " + relatorio[0]);
        System.out.println("solicitacoes atendidas: " + relatorio[1]);
        System.out.println("solicitacoes em espera: " + relatorio[2]);
        System.out.println("Em espera: " + relatorio[3] + "%");
        System.out.println("Atendidas: " + relatorio[4] + "%");
    }
}
