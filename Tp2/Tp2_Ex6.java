public class Tp2_Ex6 {
    public static void main(String[] args){
        int[][] matriz = {{1, 1, 2}, 
                          {3, 5, 8}, 
                         {13, 21, 34}};

        Tp2_Ex6Tester Ex6Mets = new Tp2_Ex6Tester(matriz, matriz.length, matriz[0].length);

        // Chamamos o método do exercício a)
        Ex6Mets.leMatriz(matriz);

        // Chamamos o método do exercício b)
        int[][] matriz2 = {{2,2,2},  
                           {2,2,2}, 
                           {2,2,2}};

        // int[][] matriz2 = {{0,0,0},    (exemplo de teste)
        //                    {0,0,0}, 
        //                    {0,0,0}};
                           
        System.out.println("Segue a matriz que irá ser somada com a original: ");
        Ex6Mets.leMatriz(matriz2);
        int[][] matrizSoma = Ex6Mets.somaMatriz(matriz2);
        System.out.println("O resultado da soma entre a matriz original e esta é: ");
        Ex6Mets.leMatriz(matrizSoma);

        // Chamamos o método do exercício c)
        System.out.println("Verifiquemos se o resultado da Soma é igual à matriz original");
        if(Ex6Mets.equalsMat(matrizSoma)){
            System.out.println("As matrizes são iguais!");
        } else {
            System.out.println("As matrizes são diferentes!");
        }

        // Chamamos o método do exercício d)
        int[][] matrizOposta = Ex6Mets.geraOposta();
        System.out.println("Segue se a matriz oposta à matriz original:");
        Ex6Mets.leMatriz(matrizOposta);
    }
}
