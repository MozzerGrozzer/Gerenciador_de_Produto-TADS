package source;

import java.util.HashMap;
import java.util.Map;

public class Carro {
    private String nome;
    private Map<String, Peca> pecasSelecionadas;

    public Carro(String nome) {
        this.nome = nome;
        this.pecasSelecionadas = new HashMap<>();
    }
    public String getNome() {
        return nome;
    }
    public void adicionarPecaSelecionada(String categoria, Peca peca) {
        pecasSelecionadas.put(categoria, peca);
    }
    public Peca getPecaSelecionada(String categoria){
        return pecasSelecionadas.get(categoria);
    }
    public double calcularPrecoTotal() {
        double total = 0;

        for(Map.Entry<String, Peca> entrada : pecasSelecionadas.entrySet()){
            total += entrada.getValue().getPreco();
        }
        return total;
    }
    public Map<String, Peca> getPecasSelecionadas() {
        return pecasSelecionadas;
    }
    public void exibirResumo() {
        System.out.println("Resumo do carro: " + nome);
        
        if(pecasSelecionadas.isEmpty()) {
            System.out.println("Nenhuma peça selecionada.");
            return;
        }
        for (Map.Entry<String, Peca> entrada : pecasSelecionadas.entrySet()){
            System.out.println(entrada.getKey() +":");
            System.out.println(entrada.getValue().getNome() + " R$ " + String.format("%.2f", entrada.getValue().getPreco()));
        }

        System.out.println("\n" + "=".repeat(40));
        System.out.println("Preço total: R$ " + String.format("%.2f", calcularPrecoTotal()));
        System.out.println("=".repeat(40)+ "\n");
    }
}
