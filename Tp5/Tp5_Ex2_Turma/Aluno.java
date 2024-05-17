public class Aluno{

    private String name;
    private int num;
    private String code;

    // Construtores:
    // Construtor por Omissão
    public Aluno(){
        this.name = "";
        this.num = 0;
        this.code = "";
    }

    // Construtor Parametrizado
    public Aluno(String name, int num, String code){
        this.name = name;
        this.num = num;
        this.code = code;
    }

    // Construtor Cópia
    public Aluno(Aluno aluno){
        this.name = aluno.getName();
        this.num = aluno.getNum();
        this.code = aluno.getCode();
    }

    // Getters e Setters
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNum(){
        return this.num;
    }

    public void setNum(int num){
        this.num = num;
    }

    public String getCode(){
        return this.code;
    }

    public void setCode(String code){
        this.code = code;
    }

    // Métodos Uteis:
    public String toString(){
        return "------- Aluno -------\nNome: " + this.name + "\nNúmero: " + this.num + "\nCódigo: " + this.code;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Aluno a = (Aluno) o;
        return (this.name.equals(a.name) && this.num == a.num && this.code.equals(a.code));
    }

    public Aluno clone(){
        return new Aluno(this);
    }
}