import java.util.Scanner;
public class Tp1_Ex3 {
    
    public static void main(String[] args){
        int N;
        int[] avaliados = {0,0,0,0};
        Scanner input = new Scanner(System.in);

        System.out.println("Quantas notas irá introduzir?");
        N = input.nextInt();

        double[] notas = new double[N];

        for(int i = 0; i < N; i++){
            System.out.print("nota número " + (i + 1) + ": ");
            notas[i] = input.nextDouble();
        }        
        
        input.close();

        avalia(notas, avaliados);

        for(int elemento: avaliados) System.out.println(elemento);
    }

    public static void avalia(double[] notas, int[] avaliados){
        for(double nota: notas){
            if(nota != 20) {
                avaliados[(int) (nota/5)] += 1;
            } else {
                avaliados[(int) ((nota - 1) / 5)] += 1;
            }
        }
    }
}
