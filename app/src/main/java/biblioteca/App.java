package biblioteca;

public class App {
    public static void main(String[] args) {
        Gerenciador g = new Gerenciador();

        boolean status = false;

        status = g.cadastrarAutor("","");
        if (status) {
            System.out.println("Autor cadastrado");
        } else {
            System.out.println("Erro");
        }
    }
}
