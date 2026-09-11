package source;

public class Main {
    private static Scanner scnaner = new Scanner(System.in);
    private static List<Categoria> categoria = new ArrayList<>();
    private static Carro carroAtual;
    public static void main(String[] args){
        inicializarPrograma();
    }

    private static void inicializarPrograma() {
        exibirBemVindo();

        criarCatergorias();
    }
}
