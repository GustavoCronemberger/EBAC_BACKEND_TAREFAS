

/**
 * @author gusta
 */
public class Cliente {

    private String categoria;
    private boolean temPj;

    public Cliente(String categoria, boolean temPj) {
        this.categoria = categoria;
        this.temPj = temPj;
    }

    public boolean temPj() {
        return temPj;
    }

    public String getCategoria() {
        return categoria;
    }
}
