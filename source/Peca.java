package source;

public class Peca {
    private String nome;
    private double preco;
    private String descricao;
    private boolean exclusiva;

    public Peca(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.exclusiva = false;
    }
    public Peca(String nome, double preco, String descricao, boolean exclusiva){
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.exclusiva = exclusiva;
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
    public boolean isExclusiva() {
        return exclusiva;
    }

    @Override
    public String toString() {
        String marca = exclusiva ? "Estrela " : "";
        return String.format("%s%s - R$ %.2f\n   %s", marca, nome, preco, descricao);
    }
}

