public class Tp2_Ex3 {
    public static void main(String[] args){

        int[] array = {2,1,5,7,3};

        // Os métodos desta instância serão desenvolvidos no ficheiro: "Tp2_Ex3Tester"
        Tp2_Ex3Tester Ex3Mets = new Tp2_Ex3Tester(array);

        // Chamamos o método da alínea a)
        Ex3Mets.ordenaArray();
        for(int num : array){
            System.out.print(num + " ");
        }
        System.out.println("");

        // Chamamos o método da alínea b) )
        // Procuremos o índice do número 3 no array
        int index = Ex3Mets.procuraNum(3);
        if (index >= 0){
            System.out.println("O número está no índice " + index + " do array original");
        } else {
            System.out.println("O número não está contido no array");
        }

        


    }
}
