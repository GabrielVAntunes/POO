import java.io.Serializable;
import java.time.LocalDate;
   
enum TipoAtividade {
    DISTANCIA,
    ALTIMETRIA,
    REPETICOES,
    REPETICOES_PESO;
}

public abstract class Atividades implements Serializable{
    
    private String nomeAtividade;
    private LocalDate data;
    private double duracao;
    private TipoAtividade tipo;
    
    /* Construtores:
    *  Construtor por Omissão*/
    public Atividades(){
        this.data = LocalDate.now();
        this.duracao = 0;
        this.nomeAtividade = "";
        this.tipo = TipoAtividade.ALTIMETRIA;
    }

    /* Construtor Parametrizado*/
    public Atividades(String nomeAtividade, LocalDate data, double duracao, TipoAtividade tipo){
        this.data = data;
        this.duracao = duracao;
        this.nomeAtividade = nomeAtividade;
        this.tipo = tipo;
    }

    /* Construtor Cópia*/
    public Atividades(Atividades u){
        this.data = u.getData();
        this.duracao = u.getDuracao();
        this.nomeAtividade = u.getNomeAtividade();
        this.tipo = u.getTipo();
    }

    /* Getters e Setters */
    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getDuracao() {
        return this.duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getNomeAtividade() {
        return this.nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public TipoAtividade getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoAtividade tipo) {
        this.tipo = tipo;
    }

    // Métodos Úteis:
    public abstract Atividades clone();

    //equals
    public boolean equals(Object o){
        if(this == o) return true;
        if(this == null || this.getClass() != o.getClass()) return false;
        Atividades s = (Atividades) o;
        return(this.nomeAtividade == s.nomeAtividade && this.data.equals(s.data) && this.duracao == s.duracao
        && this.tipo == s.tipo);
    }

    // toString 
    public String toString(){
        return  "O nome da Atividade é: " + this.nomeAtividade + "\n" +
                "O duracao foi: "+ this.duracao + "\n" +
                "A data foi: "+ this.data + "\n" +
                "O tipo da Atividade é: "+ this.tipo;
    }

    // Método que calcula as calorias gastas numa atividade.
    public abstract double calculoDeCalorias(Utilizador utilizador);

    // Método que gera uma variante de uma atividade adequada ao plano de um utilizador
    public abstract void geraVariante(Utilizador utilizador);

    // Método que calcula as variantes de cada atividade
    protected abstract double calculoVariantes(double valor, double multNivel); 
}