public class Tp2_Ex5Tester{
    private int[][] pauta;
    private int alunos;
    private int ucs;

    // Construtor de Classe
    public Tp2_Ex5Tester(int[][] pauta,int alunos, int ucs){
        this.pauta = pauta;
        this.alunos = alunos;
        this.ucs = ucs;
    }

    // Define ou altera uma nota 
    public void setNota(int aluno, int uc, int nota){
        this.pauta[aluno][uc] = nota;
    }

    // NOTA: Poderríamos ter aplicado algumas ideias de "polimorfismo" nos 4 métodos seguintes
    // não o fiz porque não assumi que o tamanho da matriz fosse definido.
    // Este método vai somar as notas de um determinado aluno
    public int somaNotasAluno(int aluno){
        int soma = 0;
        for (int uc = 0; uc < ucs; uc++){
            soma += pauta[aluno][uc];
        }
        return soma;
    }
    // Este método vai calcular a média de um determinado aluno
    public double calculaMediaAluno(int mediaDoAluno, int numUcs){
        double soma = somaNotasAluno(mediaDoAluno);
        double media = soma / numUcs;
        return media;
    }

    // Este método vai somar as Notas de uma determinada Uc
    public int somaNotasUc(int uc){
        int soma = 0;
        for (int aluno = 0; aluno < alunos; aluno++){
            soma += pauta[aluno][uc];
        }
        return soma;
    }
    // Este método vai calcular a média de uma determinada Uc
    public double calculaMediaUc(int mediaDaUc, int numAlunos){
        double soma = somaNotasUc(mediaDaUc);
        double media = soma / numAlunos;
        return media;
    }

    // Este método irá retornar a maior nota
    public int getMaiorNota(){
        int maiorNota = pauta[0][0];
        for(int aluno = 0; aluno < alunos; aluno++){
            for(int uc = 0; uc < ucs; uc++){
                maiorNota = Math.max(maiorNota, pauta[aluno][uc]);
            }
        }
        return maiorNota;
    }
    // Similar ao anterior mas irá retornar a menor nota
    public int getMenorNota(){
        int menorNota = pauta[0][0];
        for(int aluno = 0; aluno < alunos; aluno++){
            for(int uc = 0; uc < ucs; uc++){
                menorNota = Math.min(menorNota, pauta[aluno][uc]);
            }
        }
        return menorNota;
    }
    // Este método vai criar um array com as notas dos alunos aprovados
    public void aprovados(double notaMinima, int[] notasAprovadas){
        int i = 0;
        for(int aluno = 0; aluno < alunos; aluno++){
            for(int uc = 0; uc < ucs; uc++){
                if(pauta[aluno][uc] > notaMinima){
                    notasAprovadas[i] = pauta[aluno][uc];
                    i++;
                } 
            }
        }
    }
    // Este método irá converter a pauta para uma String
    public String pautaToString(String todasAsNotas){
        int i = 1;
            for(int aluno = 0; aluno < alunos; aluno++){
                for(int uc = 0; uc < ucs; uc++){
                    todasAsNotas += "Nota " + i + ": " + pauta[aluno][uc] + "; ";
                    i++;
                }
            }
        return todasAsNotas;
    }
    // Este método vai retornar o índice da cadeira com a média mais alta
    public int mediaMaisAlta(){
        int media = 0;
        int maxMedia = 0;
        int indexCadeira = 0;
        for(int uc = 0; uc < ucs; uc++){
            media = 0;
            for(int aluno = 0; aluno < alunos; aluno++){
                media += pauta[aluno][uc];
            }
            maxMedia = Math.max(maxMedia, media);
            if(maxMedia == media){
                indexCadeira = uc;
            }
        }
        return indexCadeira;
    }
}
    

    