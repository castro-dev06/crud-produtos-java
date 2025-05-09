package entities;

public class Produto {
    private Integer id;
    private String nome;
    private Double preco;

    public Produto(Integer id, String nome, Double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return id + ", Produto: " + nome + ", Preço R$" + String.format("%.2f",preco);
    }
}
