import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Turma {
    
    private HashMap<String, Aluno> turma;

    // Contrutores:
    // Construtor por omissão:
    public Turma(){
        this.turma = new HashMap<>();
    }

    // Construtor Parametrizado
    public Turma(HashMap<String, Aluno> turma){
        setTurma(turma);
    }

    // Construtor Cópia
    public Turma(Turma t){
        this.turma = t.getTurma();
    }

    // Getters e Setters
    public HashMap<String, Aluno> getTurma(){
        return this.turma;
    }

    public void setTurma(HashMap<String, Aluno> turma){
        this.turma = new HashMap<>();
        for(String key: turma.keySet()){
            this.turma.put(key, this.turma.get(key).clone());
        }
    }

    // Métodos uteis 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String key: this.turma.keySet()){
            sb.append("Ficha do Aluno " + key + ":");
            sb.append(this.turma.get(key).toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Turma clone(){
        return new Turma(this);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass()!= o.getClass()) return false;
        Turma t = (Turma) o;
        return (this.turma.equals(t.turma));
    }

    // Exercicios:
    // ex1) Insere um Aluno no Map
    public void insereAluno(Aluno a){
        this.turma.put(a.getCode(), a);
    }

    // ex2) retorna um Aluno dado o seu código
    public Aluno getAluno(String codAluno){
        for(String key: this.turma.keySet()){
            if(key.equals(codAluno)){
                return this.turma.get(key).clone();
            }
        }
        return null;
    }

    // ex3) remove um Aluno dado o seu código
    public void removeAluno(String codAluno){
        for(String key: this.turma.keySet()){
            if(key.equals(codAluno)){
                this.turma.remove(key);
            }
        }
    }

    // ex4) devolver todos os códigos de alunos existentes
    public Set<String> todosOsCodigos(){
        Set<String> allCodes = new LinkedHashSet<>();
        for(String key: this.turma.keySet()){
            allCodes.add(key);
        }
        return allCodes;
    }

    // ex5) devolver o tamanho da turma
    public int qtsAlunos(){
        return this.turma.size();
    }

    // ex6) devolver os alunos ordenados por ordem alfabética
    public Collection<Aluno> alunosOrdemAlfabetica(){
        TreeSet<Aluno> alunosabc = new TreeSet<>(((aluno1, aluno2) -> aluno1.getName().compareTo(aluno2.getName())));
        for(String key: this.turma.keySet()){
            alunosabc.add(this.turma.get(key).clone());
        }
        return alunosabc;
    }

    public Collection<Aluno> alunosOrdemNumerica(){
        TreeSet<Aluno> alunosOrdNum = new TreeSet<>(((aluno1, aluno2) -> aluno1.getNum() - aluno2.getNum()));
        for(String key: this.turma.keySet()){
            alunosOrdNum.add(this.turma.get(key).clone());
        }
        return alunosOrdNum;
    }





}
