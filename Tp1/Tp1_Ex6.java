import java.util.Scanner;
public class Tp1_Ex6 {
    
    public static void main(String[] args){
        int N;
        Scanner input = new Scanner(System.in);

        System.out.println("Este programa irá listar todos os números primos menor que o número introduzido");
        System.out.print("Introduza um número: ");
        N = input.nextInt();

        for(int i = N; i > 0; i--){
            if(isPrime(i)) System.out.println(i);
        }

        input.close();
    }

    public static Boolean isPrime(int i){
        int divide;
        if(i <= 1) return false;
        else {
            for(divide = 2; divide < i; divide++){
                if(i % divide == 0) return false;
            }
        }
        return true;
    }
}
