import java.util.Scanner;

public class Tp2_Ex7 {
    public static void main(String[] args){

        int[] chave = new int[7];
        int[] chaveAposta = new int[7];
        Scanner input = new Scanner(System.in);

        Tp2_Ex7Tester Ex7Mets = new Tp2_Ex7Tester(chave, 7);

        Ex7Mets.geraChave();

        System.out.println("Faça a sua aposta: ");
        System.out.println("Introduza 5 números de 1-50");
        for(int i = 0; i < 5; i++){
            System.out.print("Número " + (i+1) + ": ");
            chaveAposta[i] = input.nextInt();
        }
        System.out.println("Introduza 2 estrelas de 1-9");
        for(int i = 5; i < 7; i++){
            System.out.print("Estrela " + (i - 4) + ": ");
            chaveAposta[i] = input.nextInt();
        }

        int[] chaveApostaCpy = chaveAposta;
        int result = Ex7Mets.keyCompare(chaveApostaCpy);
        if( result == 0){
            System.out.println("Não acertou nenhum número. Boa sorte para a proxima");
        } else if( result == 1){
            System.out.print("Acertou os seguintes números: ");
            Ex7Mets.leChave(chaveApostaCpy);
        } else {
            for(int j = 0; j < 50; j++){
                Ex7Mets.leChave(chave);
                }
                System.out.println("");
                System.out.println("          ! ! ! JackPot ! ! !");
            }
        input.close();
    }     
}

