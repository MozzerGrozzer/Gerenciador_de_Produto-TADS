package source;

import java.util.ArrayList;
import java.util.List;

public class ModeloCarro {
    private String nome;
    private java.util.Map<String, Peca> pecasExclusivas;

    public ModeloCarro(String nome) {
        this.nome = nome;
        this.pecasExclusivas = new java.util.HashMap<>();
    }

    public String getNome() {
        return nome;
    }
    public void adicionarPecaExclusiva(String categoria, Peca peca){
        pecasExclusivas.put(categoria, peca);
    }

    public Peca getPecaExclusiva(String categoria) {
        return pecasExclusivas.get(categoria);
    }

    public java.util.Map<String, Peca> getPecaExclusiva(){
        return pecasExclusivas;
    }
}
