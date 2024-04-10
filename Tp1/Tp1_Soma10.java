import java.util.Scanner;
public class Tp1_Soma10 {
    
    public static void main(String[] args) {
        int soma = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Este programa irá somar os próximos 10 números introduzidos.\n");

        for (int i=0; i<10; i++) {
            System.out.print(i + 1 + "º valor: ");
            soma += input.nextInt();
        }

        System.out.println("O somatório é: " + soma);
        input.close();
    }

}
