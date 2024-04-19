import java.util.Arrays;

public class Tp2_Ex3Tester {
    private int[] array;

    // Construtor de classe, vai inicializar as varíaveis de instância que vamos utilizar nesta classe 
    public Tp2_Ex3Tester(int[] array){
        this.array = array;
    }

    // Os métodos utilizados em ambas as alíneas constam na instância pré_definida em java
    // Estes acrescem algumas funcionalidades aos arrays (java.util.Array)

    // Este método vai ordenar o array por ordem crescente
    public void ordenaArray(){
        Arrays.sort(array);
    }

    // Este método vai retornar o índice do valor procurado, ou -1 caso o valor não pertença ao array ) 
    public int procuraNum(int num){
        int index = Arrays.binarySearch(array, num);
        return index;
    }
}
