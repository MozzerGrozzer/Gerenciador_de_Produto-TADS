package source;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Categoria> categorias = new ArrayList<>();
    private static Map<String, ModeloCarro> modelos = new HashMap<>();
    private static Carro carroAtual;
    public static void main(String[] args){
        inicializarPrograma();
    }

    private static void inicializarPrograma() { // exibição da lista e seus atributos até o loop
        exibirBemVindo();

        criarCategorias();

        criarModelos();

        String modeloEscolhido = escolherModelo();

        carroAtual = new Carro(modeloEscolhido);

        loopPrincipal();
    }

    private static void exibirBemVindo() {
        System.out.println("Gerenciador de carros customizados");
    }

    private static void criarCategorias() {
        Categoria motores = new Categoria("Motores");
        motores.adicionarPeca(new Peca("Motor 1.0", 5000, "Primeiro motor")); // para adicionar mais peças é
        motores.adicionarPeca(new Peca("Motor 2.0", 8000, "Segundo motor")); // só seguir o padrão
        motores.adicionarPeca(new Peca("Motor 3.0", 25000, "Terceiro motor"));
        motores.adicionarPeca(new Peca("Motor 4.0", 5000, "Quarto motor"));
        categorias.add(motores);

        Categoria rodas = new Categoria("Rodas");
        rodas.adicionarPeca(new Peca("rodas 1.0", 5000, "Primeiro rodas"));
        rodas.adicionarPeca(new Peca("rodas 2.0", 8000, "Segundo rodas"));
        rodas.adicionarPeca(new Peca("rodas 3.0", 25000, "Terceiro rodas"));
        rodas.adicionarPeca(new Peca("rodas 4.0", 5000, "Quarto rodas"));
        categorias.add(rodas);
        
        Categoria interior = new Categoria("INTERIOR");       
        interior.adicionarPeca(new Peca("interior 1.0", 2000, "Primeiro interior"));
        interior.adicionarPeca(new Peca("interior 2.0", 6000, "segundo interior"));
        interior.adicionarPeca(new Peca("interior 3.0", 12000, "terceiro interior"));
        interior.adicionarPeca(new Peca("interior 4.0", 10000, "quarto interior"));
        categorias.add(interior);
             
        Categoria sistemas = new Categoria("SISTEMA");       
        sistemas.adicionarPeca(new Peca("Sistema 1.0", 1000, "Sistema de áudio com 2 alto-falantes"));        
        sistemas.adicionarPeca(new Peca("Sistema 2.0", 5000, "Sistema premium com 6 alto-falantes"));        
        sistemas.adicionarPeca(new Peca("Sistema 3.0", 4000, "GPS integrado com mapas atualizados"));        
        sistemas.adicionarPeca(new Peca("Sistema 4;0", 8000, "Teto solar panorâmico com controle automático"));        
        categorias.add(sistemas); 
      
        Categoria pintura = new Categoria("PINTURA");        
        pintura.adicionarPeca(new Peca("Azul", 3000, "É azul"));        
        pintura.adicionarPeca(new Peca("Vermelho", 2500, "É vermelho"));        
        pintura.adicionarPeca(new Peca("Verde", 4000, "É verde"));        
        pintura.adicionarPeca(new Peca("Laranja", 3500, "é Laranja"));        
        pintura.adicionarPeca(new Peca("Roxo", 5000, "É roxo"));
        categorias.add(pintura);
    }

    private static void criarModelos() { // código das peças exclusivas, se caso por adicionar algo seguir padrão
        // ===== MODELO: PÁLIO =====
        ModeloCarro palio = new ModeloCarro("Pálio");
        palio.adicionarPecaExclusiva("MOTORES", new Peca("Motor Flex Premium Pálio", 7500, "Motor flex otimizado para Pálio", true));
        palio.adicionarPecaExclusiva("RODAS", new Peca("Rodas Aero Pálio 15\"", 5500, "Rodas aerodinâmicas exclusivas do Pálio", true));
        palio.adicionarPecaExclusiva("INTERIOR", new Peca("Banco Conforto Pálio", 4000, "Bancos com design exclusivo Pálio", true));
        palio.adicionarPecaExclusiva("SISTEMAS", new Peca("Multimídia Táctil Pálio", 3500, "Tela táctil com integração Pálio", true));
        palio.adicionarPecaExclusiva("PINTURA", new Peca("Pintura Branca Marfim Pálio", 4000, "Branco exclusivo para Pálio", true));
        modelos.put("Pálio", palio);

        // ===== MODELO: GOL =====
        ModeloCarro gol = new ModeloCarro("Gol");
        gol.adicionarPecaExclusiva("MOTORES", new Peca("Motor 1.6 Turbo Gol", 12000, "Motor turbinado para Gol", true));
        gol.adicionarPecaExclusiva("RODAS", new Peca("Rodas Esportivas Gol 17\"", 6000, "Rodas esportivas exclusivas Gol", true));
        gol.adicionarPecaExclusiva("INTERIOR", new Peca("Banco Esportivo Gol", 5500, "Bancos com design esportivo Gol", true));
        gol.adicionarPecaExclusiva("SISTEMAS", new Peca("Multimídia Avançada Gol", 4500, "Sistema de som premium Gol", true));
        gol.adicionarPecaExclusiva("PINTURA", new Peca("Pintura Cinza Tungstênio Gol", 4500, "Cinza exclusivo para Gol", true));
        modelos.put("Gol", gol);

        // ===== MODELO: CELTA =====
        ModeloCarro celta = new ModeloCarro("Celta");
        celta.adicionarPecaExclusiva("MOTORES", new Peca("Motor 1.4 Eco Celta", 6500, "Motor econômico para Celta", true));
        celta.adicionarPecaExclusiva("RODAS", new Peca("Rodas Aero Celta 14\"", 4500, "Rodas aerodinâmicas Celta", true));
        celta.adicionarPecaExclusiva("INTERIOR", new Peca("Banco Standard Plus Celta", 3500, "Bancos reforçados Celta", true));
        celta.adicionarPecaExclusiva("SISTEMAS", new Peca("Som Integrado Celta", 2500, "Som compacto Celta", true));
        celta.adicionarPecaExclusiva("PINTURA", new Peca("Pintura Amarela Solar Celta", 3500, "Amarelo exclusivo Celta", true));
        modelos.put("Celta", celta);

        // ===== MODELO: UNO =====
        ModeloCarro uno = new ModeloCarro("Uno");
        uno.adicionarPecaExclusiva("MOTORES", new Peca("Motor 1.4 Familiar Uno", 7000, "Motor robusto para Uno", true));
        uno.adicionarPecaExclusiva("RODAS", new Peca("Rodas Liga-Leve Uno 15\"", 5000, "Rodas leves Uno", true));
        uno.adicionarPecaExclusiva("INTERIOR", new Peca("Banco Familiar Uno", 4500, "Bancos espaçosos Uno", true));
        uno.adicionarPecaExclusiva("SISTEMAS", new Peca("Som Modular Uno", 3000, "Sistema modular Uno", true));
        uno.adicionarPecaExclusiva("PINTURA", new Peca("Pintura Vermelho Chama Uno", 4000, "Vermelho vibrante Uno", true));
        modelos.put("Uno", uno);
    }

    private static String escolherModelo() {
        System.out.println("Escolha um dos modelos de carro");
        System.out.println("[1] - Pálio");
        System.out.println("[2] - Gol");
        System.out.println("[3] - Celta");
        System.out.println("[4] - Uno");
        
        int opcao = -1;
        String[] modelos_array = {"Pálio", "Gol", "Celta", "Uno"};
        
        while (opcao < 1 || opcao > 4) {
            System.out.println("Escolha um modelo (1-4)");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao < 1 || opcao > 4) {
                    System.out.println("Opção inválida! Escolha entre 1 e 4");
                    opcao = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
                opcao = -1;
            }
        }
        
        String modeloEscolhido = modelos_array[opcao -1];
        System.out.println("Modelo escolhido: " + modeloEscolhido);

        return modeloEscolhido; // ModeloCarro.java
    }
        
    private static void loopPrincipal() {
        boolean continuar = true;

        while (continuar) {
            int opcao = exibirMenuPrincipal();
            switch (opcao) {
                case 1:
                    customizarCarro();
                    break;
                case 2:
                    carroAtual.exibirResumo();
                    break;
                case 3:
                    System.out.println("Obrigado por usar o gerenciador de carros");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
    private static int exibirMenuPrincipal() {
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
        System.out.println("Modelo: " + carroAtual.getModelo());

        ModeloCarro modelo = modelos.get(carroAtual.getModelo());

        for (Categoria categoria : categorias) {
            escolherPecaDaCategoria(categoria, modelo);
        }
        System.out.println( " Customização completa!");
    }
    
    private static void escolherPecaDaCategoria(Categoria categoria, ModeloCarro modelo) {
        boolean pecaSelecionada = false;

        while (!pecaSelecionada) {
            // Exibe as peças base da categoria
            System.out.println(categoria.toString());

            // Exibe a peça exclusiva do modelo
            Peca exclusiva = modelo.getPecaExclusiva(categoria.getNome());
            if (exclusiva != null) {
                System.out.println("[" + (categoria.getTotalPecas() + 1) + "] " + exclusiva);
            }

            System.out.print(" Escolha uma peça (número ou nome) para " + categoria.getNome() + ": ");
            String escolha = scanner.nextLine().trim();

            try {
                int indice = Integer.parseInt(escolha) - 1;

                // Verifica se é uma das peças base
                if (indice >= 0 && indice < categoria.getTotalPecas()) {
                    Peca pecaSelecionada_obj = categoria.getPecaPorIndice(indice);
                    carroAtual.adicionarPecaSelecionada(categoria.getNome(), pecaSelecionada_obj);
                    System.out.println(pecaSelecionada_obj.getNome() + " adicionado!");
                    pecaSelecionada = true;
                }
                // Verifica se é a peça exclusiva
                else if (indice == categoria.getTotalPecas() && exclusiva != null) {
                    carroAtual.adicionarPecaSelecionada(categoria.getNome(), exclusiva);
                    System.out.println(exclusiva.getNome() + " adicionado!");
                    pecaSelecionada = true;
                } else {
                    System.out.println("Número inválido! Tente novamente.\n");
                }
            } catch (NumberFormatException e) {
                // Tenta procurar pelo nome
                pecaSelecionada = procurarPorNome(categoria, escolha, modelo);
                if (!pecaSelecionada) {
                    System.out.println("Peça não encontrada! Tente novamente.\n");
                }
            }
        }
    }

    private static boolean procurarPorNome(Categoria categoria, String nomeProcurado, ModeloCarro modelo) {
        // Procura nas peças base
        for (Peca peca : categoria.getPecas()) {
            if (peca.getNome().toLowerCase().contains(nomeProcurado.toLowerCase())) {
                carroAtual.adicionarPecaSelecionada(categoria.getNome(), peca);
                System.out.println(peca.getNome() + " adicionado!");
                return true;
            }
        }

        // Procura na peça exclusiva
        Peca exclusiva = modelo.getPecaExclusiva(categoria.getNome());
        if (exclusiva != null && exclusiva.getNome().toLowerCase().contains(nomeProcurado.toLowerCase())) {
            carroAtual.adicionarPecaSelecionada(categoria.getNome(), exclusiva);
            System.out.println(exclusiva.getNome() + " adicionado!");
            return true;
        }
        return false;
    }
}
