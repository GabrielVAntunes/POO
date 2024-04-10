import java.util.Scanner;
public class Tp1_Ex4 {
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        int[] intervaloDias = new int[2];
        int tempMedia, maiorVar;

        System.out.println("Quer introduzir a temperatura de quantos dias?");
        int N = input.nextInt();

        int[] temps = new int[N];

        for(int i = 0; i < N; i++){
            System.out.print("temperatura no " + (i + 1) + " dia: ");
            temps[i] = input.nextInt();
        }

        input.close();

        tempMedia = temperaturaMedia(temps, N);
        maiorVar = variacao(temps, N, intervaloDias);

        System.out.println("A médias das " + N + " temperaturas registadas foi de: " + tempMedia + "º.");
        if(maiorVar > 0){
            System.out.println("A maior variação registou-se entre os dias " + (intervaloDias[0] + 1) + " e " 
            + (intervaloDias [1] + 1) + " tendo a temperatura subido " + maiorVar + "º.");
        } else {
            System.out.println("A maior variação registou-se entre os dias " + (intervaloDias[0] + 1) + " e " 
            + (intervaloDias [1] + 1) + " tendo a temperatura descido " + Math.abs(maiorVar) + "º.");
        }
    }

    public static int temperaturaMedia(int[] temps, int N){
        int soma = 0;

        for(int temp: temps){
            soma += temp;
        }

        return (soma/N);
    }

    public static int variacao(int[] temps, int N, int[] intervaloDias){
        int maiorVar = 0;

        for(int i = 0; i < (N-1); i++) {
            if( Math.abs(temps[i + 1] - temps[i]) > Math.abs(maiorVar)){
                maiorVar = temps[i + 1] - temps[i];
                intervaloDias[0] = i;
                intervaloDias[1] = (i + 1);
            }
        }
        return maiorVar;
    }
}
