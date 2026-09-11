package source;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Categoria> categorias = new ArrayList<>();
    private static Carro carroAtual;
    public static void main(String[] args){
        inicializarPrograma();
    }

    private static void inicializarPrograma() {
        exibirBemVindo();

        criarCategorias();

        System.out.print("Qual o nome do seu carro?");
        String nomeCarro = scanner.nextLine();

        carroAtual = new Carro(nomeCarro);

        loopPrincipal();
    }

    private static void exibirBemVindo() {
        System.out.println("Gerenciador de carros customizados");
    }

    private static void criarCategorias() {
        Categoria motores = new Categoria("Motores");
        motores.adicionarPeca(new Peca("Motor 1.0", 5000, "Primeiro motor"));
        motores.adicionarPeca(new Peca("Motor 2.0", 8000, "Segundo motor"));
        motores.adicionarPeca(new Peca("Motor 3.0", 25000, "Terceiro motor"));
        motores.adicionarPeca(new Peca("Motor 4.0", 5000, "Quarto motor"));
        categorias.add(motores);

        Categoria rodas = new Categoria("Rodas");
        rodas.adicionarPeca(new Peca("Motor 1.0", 5000, "Primeiro motor"));
        rodas.adicionarPeca(new Peca("Motor 2.0", 8000, "Segundo motor"));
        rodas.adicionarPeca(new Peca("Motor 3.0", 25000, "Terceiro motor"));
        rodas.adicionarPeca(new Peca("Motor 4.0", 5000, "Quarto motor"));
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
                    System.out.println("\n Obrigado por usar o gerenciador de carros");
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

        for (Categoria categoria : categorias) {
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
                    Peca pecaSelecionada_obj = categoria.getPecaPorIndice(indice);
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
