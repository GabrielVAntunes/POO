public class Tp2_Ex1Tester {
    // Neste caso a variavel de instancia é privada porque apenas a vamos usar dentro desta classe
    // Por outro lado os métodos são públicos para que os possamos chamar e utilizar na main

    // Declarar o array que vamos utilizar dentro desta classe
    private int[] array;
    private int comprimento;
    // Construtor de classe, vai inicializar as variaveis de instancia de modo que seja igual ao que recebemos da main
    public Tp2_Ex1Tester(int [] array, int comprimento){
        this.array = array;  
        this.comprimento = comprimento;    
    }
    
    // Método para calcular o menor valor de um array
    public int minValue(){
        int menor = array[0];

        for(int i = 0; i < comprimento; i++){
            if(array[i] < menor){
                menor = array[i];
            }
        }
        return menor;
    }

    //Método para calcular um intervalo de um array entre 2 índices dados
    public int[] arrayIntervalo(int indexOne, int indexTwo){
        int tamanhoIntervalo = indexTwo - indexOne + 1;
        int[] intervalo = new int[tamanhoIntervalo];

        if(indexOne > indexTwo || indexOne < 0 || indexTwo > array.length){
            // Instancia pré-definidia em java para quando o método é invocado com argumentos inválidos.
            // Mensagem associada descreve qual foi a origem do erro.
            throw new IllegalArgumentException("Valores inválidos!");
        } else {
            for(int i = indexOne; i <= indexTwo; i++){
                intervalo[i-indexOne] = array[i];
            }
        }
        return intervalo;
    }
    
    public int[] valoresComuns(int[] array1, int[] array2){ 
    int[] arrayComuns = new int[Math.min(array1.length, array2.length)];

    for (int i = 0; i < array1.length; i++){
        for(int j = 0; j < array2.length; j++){
            if(array1[i] == array2[j]){
                arrayComuns[i] = array1[i];
            }
        }
    }
    return arrayComuns;
    }
}
