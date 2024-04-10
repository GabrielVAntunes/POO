import java.util.Scanner;
public class Tp1_Exemplo4 {
    public static void main(String[] args){
        int soma, N;
        String ask;
        Scanner input = new Scanner(System.in);

        do {

            System.out.println("Quantos números vai somar?");

            N = input.nextInt();
            soma = 0;

            for(int i=0; i<N; i++){
                System.out.print(i+1 + "º Valor: ");
                soma += input.nextInt();
            }

            System.out.println("A soma é: " + soma);
            System.out.print("Quer realizar outra soma? [S/n]");

            ask = input.next();
        } while(ask.charAt(0) != 'n');

        input.close();
        System.out.println("Programa Terminado");

        }  
    }

