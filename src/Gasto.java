public class Gasto {

    private float valor;
    private String categoria;
    private String descricao;

    public float getValor() {
        return valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {

        return descricao;
    }

    public Gasto(float valor, String categoria, String descricao) {
        this.valor = valor;
        this.categoria = categoria;
        this.descricao = descricao;
    }
}
