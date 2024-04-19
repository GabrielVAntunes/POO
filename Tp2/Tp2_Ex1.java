import java.util.Scanner;
public class Tp2_Ex1 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Introduza o tamanho do array: ");
        int comprimento = input.nextInt();
        int[] array = new int[comprimento];

        for(int i = 0; i < comprimento; i++){
            System.out.print("Elemento nº " + (i + 1) + ": ");
            array[i] = input.nextInt();
        }

        // Criamos a instância da classe onde vamos criar os métodos dos exercícios.
        //Estes métodos serão desenvolvidos no ficheiro: "Tp2_Ex1Tester"
        Tp2_Ex1Tester arraytester = new Tp2_Ex1Tester(array, comprimento);
        
        // Chamamos o método correspondente à alínea a)
        int minimo = arraytester.minValue();
        System.out.println("O menor valor do array é " + minimo);

        // Chamamos o método correspondente à alínea b)
        System.out.println("Introduza 2 índices e serão retornados os elementos contidos nesse intervalo");
        System.out.print("Índice 1: ");
        int indexOne = input.nextInt();
        System.out.print("Índice 2: ");
        int indexTwo = input.nextInt();
        int[] entreIndices = arraytester.arrayIntervalo(indexOne, indexTwo);
        System.out.print("Os elementos entre esses índices são: {");

        for(int num : entreIndices){
            System.out.print(num + " ");
        }
        System.out.print("}");

        //Chamamos o método correspondente à alínea c)
        System.out.println("Introduza 2 arrays e retornaremos os elementos em comum");
        System.out.print("Introduza o tamanho do primeiro array: ");
        int comprimento1 = input.nextInt();
        System.out.print("Introduza o tamanho do segundo array: ");
        int comprimento2 = input.nextInt();

        int[] array1 = new int[comprimento1];
        int[] array2 = new int[comprimento2];

        System.out.println("Introduza os elementos do 1º array");
        for(int i = 0; i < comprimento1; i++){
            System.out.print("Elemento nº " + (i + 1) + ": ");
            array1[i] = input.nextInt();
        }

        System.out.println("Introduza os elementos do 2º array");
        for(int i = 0; i < comprimento2; i++){
            System.out.print("Elemento nº " + (i + 1) + ": ");
            array2[i] = input.nextInt();
        }

        int[] arrayComum = arraytester.valoresComuns(array1, array2);
        System.out.println("Os elementos comuns a ambos os arrays são: ");
        System.out.print("{");
        for(int num : arrayComum){
            System.out.print(num + " ");
        }
        System.out.print("}");
        input.close();
    }
}