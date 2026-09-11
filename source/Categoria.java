package source;
import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nome;
    private List<Peca> pecas;

    public Categoria(String nome) {
        this.nome = nome;
        this.pecas = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }

    public void adicionarPeca(Peca peca) {
        pecas.add(peca);
    }

    public List<Peca> getPecas(){
        return pecas;
    }

    public Peca getPecaPorIndice(int indice){
        if (indice >= 0 && indice < pecas.size()){
            return pecas.get(indice);
        }
        return null;
    }

    public int getTotalPecas() {
        return pecas.size();
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("\n=== ").append(nome).append(" ===\n");
        
        for (int i = 0; i < getTotalPecas(); i++) {
            resultado.append("[").append(i + 1).append("] ");
            resultado.append(pecas.get(i)).append("\n");
        }
            return resultado.toString();
        }
    }