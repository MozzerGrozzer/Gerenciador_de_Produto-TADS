import java.util.Scanner;

public class NewMain {
    static Scanner sc = new Scanner(System.in);

    // Categorias do veículo
    static String[] categorias = {
        "MOTORES",
        "RODAS",
        "INTERIOR",
        "SISTEMAS",
        "PINTURA"
    };

    // Peças padrão de cada categoria
    static String[][] pecasBase = {
        { "Motor 1.0", "Motor 2.0", "Motor 3.0", "Motor 4.0" },
        { "Rodas 1.0", "Rodas 2.0", "Rodas 3.0", "Rodas 4.0" },
        { "Interior 1.0", "Interior 2.0", "Interior 3.0", "Interior 4.0" },
        { "Sistema 1.0", "Sistema 2.0", "Sistema 3.0", "Sistema 4.0" },
        { "Azul", "Vermelho", "Verde", "Laranja", "Roxo" }
    };

    static double[][] precosBase = {
        { 5000, 8000, 25000, 5000 },
        { 5000, 8000, 25000, 5000 },
        { 2000, 6000, 12000, 10000 },
        { 1000, 5000, 4000, 8000 },
        { 3000, 2500, 4000, 3500, 5000 }
    };

    // Modelos disponíveis
    static String[] modelos = { "Pálio", "Gol", "Celta", "Uno" };

    // Peças exclusivas por modelo e categoria
    static String[][] pecasExclusivas = {
        { "Motor Flex Premium Pálio", "Rodas Aero Pálio 15\"", "Banco Conforto Pálio", "Multimídia Táctil Pálio", "Pintura Branca Marfim Pálio" },
        { "Motor 1.6 Turbo Gol", "Rodas Esportivas Gol 17\"", "Banco Esportivo Gol", "Multimídia Avançada Gol", "Pintura Cinza Tungstênio Gol" },
        { "Motor 1.4 Eco Celta", "Rodas Aero Celta 14\"", "Banco Standard Plus Celta", "Som Integrado Celta", "Pintura Amarela Solar Celta" },
        { "Motor 1.4 Familiar Uno", "Rodas Liga-Leve Uno 15\"", "Banco Familiar Uno", "Som Modular Uno", "Pintura Vermelho Chama Uno" }
    };

    static double[][] precosExclusivos = {
        { 7500, 5500, 4000, 3500, 4000 },
        { 12000, 6000, 5500, 4500, 4500 },
        { 6500, 4500, 3500, 2500, 3500 },
        { 7000, 5000, 4500, 3000, 4000 }
    };

    public static void main(String[] args) {
        exibirBemVindo();

        int modeloEscolhido = escolherModelo();

        int[] escolhas = new int[categorias.length];

        for (int i = 0; i < categorias.length; i++) {
            escolhas[i] = escolherPecaDaCategoria(i, modeloEscolhido);
        }

        exibirResumo(modeloEscolhido, escolhas);
    }

    static void exibirBemVindo() {
        System.out.println("Gerenciador de carros customizados");
    }

    static int escolherModelo() {
        System.out.println("\nEscolha um dos modelos de carro:");
        System.out.println("[1] - Pálio");
        System.out.println("[2] - Gol");
        System.out.println("[3] - Celta");
        System.out.println("[4] - Uno");

        int opcao = -1;

        while (opcao < 1 || opcao > 4) {
            System.out.print("Digite a opção desejada (1-4): ");
            try {
                opcao = Integer.parseInt(sc.nextLine());
                if (opcao < 1 || opcao > 4) {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            }
        }

        int indice = opcao - 1;
        System.out.println("Modelo escolhido: " + modelos[indice]);
        return indice;
    }

    static int escolherPecaDaCategoria(int categoriaIndex, int modeloIndex) {
        while (true) {
            System.out.println("\n=== " + categorias[categoriaIndex] + " ===");

            // Mostrar peças padrão
            for (int i = 0; i < pecasBase[categoriaIndex].length; i++) {
                System.out.println("[" + (i + 1) + "] " + pecasBase[categoriaIndex][i]
                    + " - R$ " + String.format("%.2f", precosBase[categoriaIndex][i]));
            }

            // Mostrar peça exclusiva do modelo
            int opcaoExclusiva = pecasBase[categoriaIndex].length + 1;
            System.out.println("[" + opcaoExclusiva + "] "
                + pecasExclusivas[modeloIndex][categoriaIndex]
                + " - R$ " + String.format("%.2f", precosExclusivos[modeloIndex][categoriaIndex])
                + " (EXCLUSIVA)");

            System.out.print("Escolha uma peça para " + categorias[categoriaIndex] + ": ");
            String entrada = sc.nextLine().trim();

            // Se for número
            if (entrada.matches("\\d+")) {
                int escolha = Integer.parseInt(entrada);

                if (escolha >= 1 && escolha <= pecasBase[categoriaIndex].length) {
                    return escolha - 1;
                }

                if (escolha == opcaoExclusiva) {
                    return -1; // -1 significa peça exclusiva
                }

                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            // Se for nome
            for (int i = 0; i < pecasBase[categoriaIndex].length; i++) {
                if (pecasBase[categoriaIndex][i].toLowerCase().contains(entrada.toLowerCase())) {
                    return i;
                }
            }

            if (pecasExclusivas[modeloIndex][categoriaIndex].toLowerCase().contains(entrada.toLowerCase())) {
                return -1;
            }

            System.out.println("Peça não encontrada! Tente novamente.");
        }
    }

    static void exibirResumo(int modeloIndex, int[] escolhas) {
        System.out.println("\n========================");
        System.out.println("Resumo do carro");
        System.out.println("Modelo: " + modelos[modeloIndex]);
        System.out.println("========================");

        double total = 0;

        for (int i = 0; i < categorias.length; i++) {
            String nomePeca;
            double precoPeca;

            if (escolhas[i] == -1) {
                nomePeca = pecasExclusivas[modeloIndex][i];
                precoPeca = precosExclusivos[modeloIndex][i];
            } else {
                nomePeca = pecasBase[i][escolhas[i]];
                precoPeca = precosBase[i][escolhas[i]];
            }

            total += precoPeca;

            System.out.println(categorias[i] + ": " + nomePeca + " - R$ " + String.format("%.2f", precoPeca));
        }

        System.out.println("\nTOTAL: R$ " + String.format("%.2f", total));
        System.out.println("========================");
    }
}