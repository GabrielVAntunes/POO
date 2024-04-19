public class Tp2_Ex6Tester {

    private int[][] matriz;
    private int linhas;
    private int colunas;
    // Contrutor de classe
    public Tp2_Ex6Tester(int[][] matriz, int linhas, int colunas){
        this.matriz = matriz;
        this.linhas = linhas;
        this.colunas = colunas;
    }

    // Método que vai ler a matriz
    public void leMatriz(int [][] matriz){
        for(int l = 0; l < linhas; l++){
            for(int c = 0; c < colunas; c++){
                System.out.print(matriz[l][c] + " ");
            }
            System.out.println("");
        }
    }

    // Este método irá somar a matriz que receber à matriz original e retornar o resultado numa nova matriz
    public int[][] somaMatriz(int[][] matriz2){
        int[][] matrizSoma = new int[linhas][colunas];
        for(int l = 0; l < linhas; l++){
            for(int c = 0; c < colunas; c++){
                matrizSoma[l][c] = matriz[l][c] + matriz2[l][c];
            }
        }
        return matrizSoma;
    }
    // Este método vai comparar a matriz recebida à matriz original e retornar true/false consoante sejam ou não iguais 
    public boolean equalsMat(int[][] matrizComp){
        int l = 0;
        int c = 0;
        boolean flag = true;
        for( l = 0; l < linhas && flag; l++){
            for( c = 0; c < colunas && flag; c++){
                if (matriz[l][c] != matrizComp[l][c]){
                    flag = false;
                }
            }
        }
        return flag;
    }
    // Este método vai retornar a matriz oposta á matriz original
    public int[][] geraOposta(){
        int[][] matrizOposta = new int[linhas][colunas];
        for(int l = 0; l < linhas; l++){
            for(int c = 0; c < colunas; c++){
                matrizOposta[l][c] = matriz[l][c] * (-1);
            }
        }
        return matrizOposta;
    }
}
