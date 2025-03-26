import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); //serve pro scanner aceitar o . como numero decimal
        int op;                       //fiquei 30 min quebrando a cabeça com o terminal falando MIsmatchexception input 

        do {
            System.out.println("Conversor de temperatura Celsius para Fahrenheit e vice versa.");
            System.out.println("1- Celsius para Fahrenheit");
            System.out.println("2- Fahrenheit para Celsius");
            System.out.println("3- Sair"); //menu interativo

            op = scanner.nextInt();
            scanner.nextLine(); //lê a escolha do usuario

            switch (op) {
                case 1:
                    System.out.println("Digite a temperatura em Celsius para a conversão: ");
                    while (!scanner.hasNextFloat()) {
                        System.out.println("Número inválido. Para decimal use '.' .");
                        scanner.next(); // esse while aqui faz  usuario digitar um numero decimal com '.' ou um numero inteiro NA MARRA
                    }
                    float c = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("A temperatura em Fahrenheit é: " + conversor.converter(c)); // mostra o resultado
                    break;
                case 2:
                    System.out.println("Digite a temperatura em Fahrenheit para a conversão: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Número inválido. Para decimal use '.' ."); // memo esquema do outro while
                        scanner.next(); 
                    }
                    double f = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("A temperatura em Celsius é: " + conversor.converter(f));
                    break;
                case 3:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");// serve pra quando não digitar 1,2 ou 3
                    break;
            }
        } while (op != 3);

        scanner.close();
    }
}
