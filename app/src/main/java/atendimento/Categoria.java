package atendimento;

import java.util.LinkedHashMap;
import java.util.Map;

public class Categoria {
    Map<String, String> categoria = new LinkedHashMap<>();

    public Categoria() {
        categoria.put("0", "Suporte Tecnico");
        categoria.put("1", "Informacao");
        categoria.put("2", "Atendimento Financeiro");
    }

    public String getCategoria(String id) {
        return categoria.get(id);
    }

    public Map<String, String> getCategorias() {
        return categoria;
    }

    public boolean verificaCategoria(String id) {
        return categoria.containsKey(id);
    }
}
