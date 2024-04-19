import java.util.Random;

public class Tp2_Ex7Tester {
    private int[] chave;
    private int keySize;

    // Instância que disponibiliza algumas funcionalidades relativas à geração de números aleatórios 
    Random random = new Random();

    // Construtor de Classe
    public Tp2_Ex7Tester(int[] chave, int keySize){
        this.chave = chave;
        this.keySize = keySize;
    }

    // Método que gera uma chave aleatóriamente
    public void geraChave(){
        for(int i = 0; i < 5; i++){
            chave[i] = random.nextInt(50) + 1;
        }
        for(int i = 5 ; i < keySize; i++){
            chave[i] = random.nextInt(9) + 1;
        }
    }

    // Este método vai ler a chave que receber
    public void leChave(int[] chave){
        for(int i = 0; i < 5; i++){
            if(chave[i] != 0)
            System.out.print("Número " + (i+1) + ": " + chave[i] + " ");
        }
        System.out.println("");
        for(int i = 5; i < keySize; i++){
            if(chave[i] != 0)
            System.out.print("Estrela " + (i - 4) + ": " + chave[i] + " ");
        }
    }

    // Este método não só vai escrever no array apenas os números em comum, como retorna um valor de acordo
    // com o grau de proximidade entre a chave original e a aposta
    public int keyCompare(int[] chaveAposta){
        int contaDifs = 0;
        for(int i = 0; i < keySize; i++){
            if(chave[i]!= chaveAposta[i]){
                chaveAposta[i] = 0;
                contaDifs += 1;
            }
        }
        if(contaDifs == keySize){
            return 0;                   // Seja 0 - Não acertar em nenhum valor
        } else if(contaDifs != 0){
            return 1;                   // Seja 1 - Acertar algum valor
        } else{
            return 2;                   // Seja 2 - Acertar todos os valores
        }
    }
}