public class Tp2_Ex5 {

    public static void main(String[] args){
        //
        int alunos = 5;
        int ucs = 5;

        int[][] pauta = {{18, 13, 20,  8, 15}, 
                         {15, 10, 12,  8, 11} ,
                         {10, 10, 10, 11, 10}, 
                         {0,  7,  8,  3,  10},
                         {18, 16, 20, 19, 17}};

        Tp2_Ex5Tester Ex5Mets = new Tp2_Ex5Tester(pauta, alunos, ucs);


        System.out.println("a Pauta atual é a seguinte: ");
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                System.out.print(pauta[i][j] + " ");
            }
            System.out.println("");
        }

        int ucTroca = 3;
        int alunoTroca = 3;
        // Altera a nota tanto na main como na instância
        // Chamamos o método da alínea a)
        Ex5Mets.setNota(alunoTroca, ucTroca, 20);

        System.out.println("a Pauta atual é a seguinte: ");
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                System.out.print(pauta[i][j] + " ");
            }
            System.out.println("");
        }
 
        //Chamamos o método para a alínea b)
        int ucASomar = 2;
        int somaUc = Ex5Mets.somaNotasUc(ucASomar);
        System.out.println("A soma das notas dessa Uc é: " + somaUc);
        
        // Chamamos o método para a alínea c)
        int mediaDoAluno = 0;
        double mediaAluno = Ex5Mets.calculaMediaAluno(mediaDoAluno, alunos);
        System.out.println("A média desse Aluno é: " + mediaAluno);

        //Chamamos o método para a alínea d)
        int mediaDaUc = 4;
        double mediaUc = Ex5Mets.calculaMediaUc(mediaDaUc, ucs);
        System.out.println("A média dessa Uc é: " + mediaUc);

        //Chamamos o método para a alínea e) 
        int maiorNota = Ex5Mets.getMaiorNota();
        System.out.println("A melhor nota do curso foi: " + maiorNota);

        //Chamamos o método para a alínea f)
        int menorNota = Ex5Mets.getMenorNota();
        System.out.println("A pior nota do curso foi: " + menorNota);

        //Chamamos o método da alínea g)
        int[] notasAprovadas = new int[25];
        double notaMin = 9.5;
        Ex5Mets.aprovados(notaMin, notasAprovadas);
        System.out.print("Seguem as notas aprovadas: ");
        for(int nota : notasAprovadas){
            if(nota != 0){
                System.out.print(nota + " ");
            }
        }
        System.out.println("");

        //Chamamos o método da alínea h)
        String todasAsNotas = "";
        todasAsNotas = Ex5Mets.pautaToString(todasAsNotas);
        System.out.println(todasAsNotas);

        //Chamamos o método da alínea i)
        int cadeiraMaisFacil = 0;
        cadeiraMaisFacil = Ex5Mets.mediaMaisAlta();
        System.out.println("A cadeira com maior média é a cadeira: " + cadeiraMaisFacil);
    }
}
