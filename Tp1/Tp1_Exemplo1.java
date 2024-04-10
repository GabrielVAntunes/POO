import java.util.Scanner;

public class Tp1_Exemplo1 {

    public static void dizMaior(int a, int b){
        if (a > b) {
            System.out.println("O maior é: " + a);
        } else {
            System.out.println("O maior é: " + b);
        }
    }

    public static void main(String[] args) {
        int a, b;
        Scanner ler = new Scanner(System.in);

        System.out.print("Indique dois inteiros: ");
        a = ler.nextInt();
        b = ler.nextInt();
        dizMaior(a, b);
        ler.close();
    }
}
