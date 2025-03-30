import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); //serve pro scanner aceitar o . como numero decimal
        int op;                       //fiquei 30 min quebrando a cabeça com o terminal falando MIsmatchexception input
        float c;                        

        do {
            System.out.println("\nConversor de temperatura Celsius para Fahrenheit e vice versa.");
            System.out.println("1- Celsius para Fahrenheit");
            System.out.println("2- Fahrenheit para Celsius");
            System.out.println("3- Celsus para Fahrenheit, mas escolha para quanto vai arredondar");
            System.out.println("4- Sair"); //menu interativo

            op = scanner.nextInt();
            scanner.nextLine(); //lê a escolha do usuario

            switch (op) {
                case 1:
                    //conversão de celsius -> fahrenheit
                    System.out.println("Digite a temperatura em Celsius para a conversão: ");
                    while (!scanner.hasNextFloat()) {
                        System.out.println("Número inválido. Para decimal use '.' .");
                        scanner.next(); // esse while aqui faz  usuario digitar um numero decimal com '.' ou um numero inteiro NA MARRA
                    }
                    c = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("A temperatura em Fahrenheit é: " + conversor.converter(c)); // mostra o resultado
                    break;

                case 2:
                    // fahrenheit -> celsius
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

                    System.out.println("Digite a temperatura em Celsius para converter pra Fahrenheit: ");
                    while(!scanner.hasNextFloat()) {
                        System.out.println("Número inválido. Para decimal use '.' ."); // já falei pra que serve
                        scanner.next(); 
                    }
                    c= scanner.nextFloat();
                    scanner.nextLine();
                    float convertido = conversor.converter(c);  // converti antes o valor pra mostrar sem o arredondamento
                    System.out.println("\nTemperatura convertida sem o arredondamento: " + convertido + " Fahrenheit");
                    System.out.println("Quantas casas desejar arredondar? ex: 36F -> 38 F");
                    while(!scanner.hasNextInt()){
                        System.out.println("Número inválido. Digite um numero inteiro ."); 
                        scanner.next(); 
                    }
                    int arrd = scanner.nextInt(); //pede quantas casas arredondar
                    scanner.nextLine();
                    float resultado = convertido +  arrd; // soma a conversao com as casas digitadas
                    System.out.println("A temperatura convertida de Celsius para Fahrenheit com  arredondamento é: " + resultado +" Fahrenheit");
                    break;

                case 4:

                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Digite uma opção válida.");// serve pra quando não digitar 1,2,3 ou 4
                    break;
            }
        } while (op != 4); //vai ter o loop até  o usuario digitar o numero 4 pra sair

        scanner.close();
    }
}
