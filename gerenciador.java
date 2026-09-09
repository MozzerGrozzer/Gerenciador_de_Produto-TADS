import java.util.Scanner;

public class gerenciador{
    public static void main(String[] args) {
        String modelo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira as opções");
        System.out.println("1 - Modelo um");
        System.out.println("2 - Modelo dois");
        System.out.println("3 - Modelo três");
        System.out.println("4 - Modelo quatro");
        modelo = sc.nextLine();
        if (modelo.equals("1") || modelo.equals("um") || modelo.equals("Primeiro")){
            System.out.println("Você escolheu o primeiro modelo");
        } else if (modelo.equals("1") || modelo.equals("um") || modelo.equals("Primeiro")){
            System.out.println("Você escolheu o segundo modelo");
        } else if (modelo.equals("1") || modelo.equals("um") || modelo.equals("Primeiro")){
            System.out.println("Você escolheu o segundo modelo");
        } else if (modelo.equals("1") || modelo.equals("um") || modelo.equals("Primeiro")){
            System.out.println("Você escolheu o segundo modelo");
        } else {
            System.out.println("Insira um número válido");
        }
    }
}