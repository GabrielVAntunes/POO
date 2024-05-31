import java.time.LocalDate;
import java.util.Random;


public class Repeticoes extends Atividades{

    private int repeticoes;

    // Construtores:
    // Construtor por Omissão
    public Repeticoes(){
        super();
        repeticoes = 0;
    } 

    //Construtor de cópia.
    public Repeticoes(Repeticoes u) {
        super(u);
        this.repeticoes = u.getRepeticoes();
    }

    //Construtor Parametrizado.
    public Repeticoes(String nomeAtividade, LocalDate data, double duracao, TipoAtividade tipo, int repeticoes) {
        super(nomeAtividade, data, duracao, tipo);
        this.repeticoes = repeticoes;
    }

    // Getters e Setters.
    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    } 

    // Métodos Uteis
    //Método que verifica a igualdade
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Repeticoes s = (Repeticoes) o;
        return (this.repeticoes == s.repeticoes && super.equals(s));
    }

    // Método que devolve uma cópia
    @Override
    public Repeticoes clone(){
        return new Repeticoes(this);
    }

    // Método que produz uma string no qual está representado o Utilizador.
    public String toString() {
        return (super.toString()+ "Número de Repetições:  " + this.repeticoes +"\n");
    }

    public double calculoDeCalorias(Utilizador utilizador) {
        double peso = (0.0175 * utilizador.getPeso()) + 0.75;
        double fatorMetabolico;
    
        if (utilizador.getSexo().equals("M")) {
            fatorMetabolico = 0.8;
        } else {
            fatorMetabolico = 0.7;
        }
    
        if (utilizador.getFreqCardiacaMedia() <= 120) {
            fatorMetabolico *= 1.2; 
        } else if (utilizador.getFreqCardiacaMedia() > 120) {
            fatorMetabolico *= 1.5;
        }
    
        double calorias = (utilizador.getNivel().levels * peso * getRepeticoes() * getDuracao()) +  fatorMetabolico * utilizador.getAltura();
        return calorias;
    }

    protected double calculoVariantes(double valor, double multNivel){
        Random rand = new Random();
        return valor * multNivel * (rand.nextDouble(1.1) + 1);
    }

    public void geraVariante(Utilizador utilizador){
        this.setRepeticoes((int) calculoVariantes((double) this.repeticoes, utilizador.getNivel().levels));
        setDuracao(calculoVariantes(getDuracao(), utilizador.getNivel().levels)); 
    }
}