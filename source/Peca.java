package source;

public class Peca {
    private String nome;
    private double preco;
    private String descricao;

    public Peca(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public String getDescricao() {
        return descricao;
    }
    @Override
    public String toString() {
        return String.format("$s - R$ %.2f\n %s",nome,preco,descricao);
    }
}

