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

        System.out.print("Qual o nome do seu carro?");
        String nomeCarro = scanner.nextLine();

        carroAtual = new Carro(nomeCarro);

        loopPrincipal();
    }

    private static void exibirBemVindo() {
        System.out.println("Gerenciador de carros customizados");
    }

    private static void criarCatergorias() {
        Categoria motores = new Categoria("Motores");
        motores.adicionarPeca(new Peca("Motor 1.0"));
        motores.adicionarPeca(new Peca("Motor 2.0"));
        motores.adicionarPeca(new Peca("Motor 3.0"));
        categorias.add(motores);

        Categoria rodas = new Categoria("Rodas");
        motores.adicionarPeca(new Peca("Roda 1.0"));
        motores.adicionarPeca(new Peca("Roda 2.0"));
        motores.adicionarPeca(new Peca("Roda 3.0"));
        categorias.add(rodas);
    }

    private static void loopPrincipal() {
        boolean continuar = true;

        while (continuar) {
            int opcao = exibirMenuPrincial();
            switch (opcao) {
                case 1:
                    customizarCarro();
                    break;
                case 2:
                    carroAtual.exibirResumo();
                    break;
                case 3:
                    System.out.Println("\n Obrigado por usar o gerenciador de carros");
                    continuar = false;
                    break;
                default:
                    System.out.println("\n Opção inválida.");
            }
        }
        scanner.close();
    }
    private static int exibirMenuPrincial() {
        System.out.println("Menu principal");
        System.out.println("1 - customizar seu carro");
        System.out.println("2 - ver resumo do carro");
        System.out.println("3 - fechar programa");

        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            return opcao;
        } catch (NumberFormatException e) {
            System.out.println("Digite um número válido");
            return -1;
        }
    }
    private static void customizarCarro() {
        System.out.println("Customize seu carro");

        for (Categoria categoria : categoria) {
            escolherPecaDaCategoria(categoria);
        }
        System.out.println("\n Customização completa!");
    }
    private static void escolherPecaDaCategoria(Categoria categoria){
        boolean pecaSelecionada = false;

        while (!pecaSelecionada) {
            System.out.println(categoria.toString());
            System.out.print("Escolha uma peça (número ou nome) para " + categoria.getNome() +":");
            String escolha = scanner.nextLine().trim();

            try {
                int indice = Integer.parseInt(escolha) - 1;

                if (indice >= -0 && indice < categoria.getTotalPecas()) {
                    peca pecaSelecionada_obj = categoria.getPecaPOrIndice(indice);
                    carroAtual.adicionarPecaSelecionada(categoria.getNome(),pecaSelecionada_obj);

                    System.out.println(pecaSelecionada_obj.getNome() + "adicionado");
                    pecaSelecionada = true;
                    
                } else {
                    System.out.println("Numero inválido!");
                }
            } catch (NumberFormatException e) {
                pecaSelecionada = procurarPorNome(categoria, escolha);
                if (!pecaSelecionada) {
                    System.out.println("Peça não encontrada");
                }
            }
        }
    }
    private static boolean procurarPorNome(Categoria categoria, String nomeProcurado){
        for (Peca peca : categoria.getPecas()){
            if (peca.getNome().toLowerCase().contains(nomeProcurado.toLowerCase())){
                carroAtual.adicionarPecaSelecionada(categoria.getNome(), peca);
                System.out.println(peca.getNome()+ " adicionado!");
                return true;
            }
        }
        return false;
    }
}
