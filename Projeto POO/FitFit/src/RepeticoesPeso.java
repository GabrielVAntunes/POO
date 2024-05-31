import java.time.LocalDate;
import java.util.Random;

public class RepeticoesPeso extends Atividades{

    private int repeticoes;
    private double pesoHaltere;

    // Construtores:
    // Construtor de Omissao
    public RepeticoesPeso(){
        repeticoes = 0;
        pesoHaltere = 0; 
    }

    // Construtor Parametrizado
    public RepeticoesPeso(String nomeAtividade, LocalDate data, double duracao, TipoAtividade tipo, int repeticoes, double pesoHaltere){

        super(nomeAtividade, data, duracao, tipo);
        this.pesoHaltere = pesoHaltere;
        this.repeticoes = repeticoes;
    }

    // Construtor Cópia
    public RepeticoesPeso(RepeticoesPeso u){
        super(u);
        this.repeticoes = u.getRepeticoes();
        this.pesoHaltere = u.getPesoHaltere();
    }

    // Getters e Setters
    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public double getPesoHaltere() {
        return pesoHaltere;
    }

    public void setPesoHaltere(double pesoHaltere) {
        this.pesoHaltere = pesoHaltere;
    }

    // Métodos Uteis
    // Método que verifica a igualdade
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RepeticoesPeso s = (RepeticoesPeso) o;
        return (this.repeticoes == s.repeticoes && this.pesoHaltere == s.pesoHaltere && super.equals(s));
    }

    // Método que devolve um clone do objeto
    @Override
    public RepeticoesPeso clone(){
        return new RepeticoesPeso(this);
    }

    // Método que produz uma string no qual está representado o Utilizador.
    public String toString() {
        return (super.toString() + "Número de Repetições: " + this.repeticoes + "\n" +
        "Peso: " + this.pesoHaltere + "\n");
    }

    // Método que calcula as calorias gastas numa atividade do tipo Repeticoes com Peso.
    public double calculoDeCalorias(Utilizador utilizador) {
        double bmr;
    
        // Calculate Basal Metabolic Rate (BMR) based on sex
        if (utilizador.getSexo().equals("M")) {
            bmr = 6 + (9 * utilizador.getPeso()) + utilizador.getAltura() - 600.8;
        } else {
            bmr = 6 + (7 * utilizador.getPeso()) + utilizador.getAltura() - 400.7;
        }
    
        if (utilizador.getFreqCardiacaMedia() <= 120) {
            bmr *= 1.1; 
        } else if (utilizador.getFreqCardiacaMedia() > 120) {
            bmr *= 1.2; 
        }
    
        double calorias = (bmr * utilizador.getNivel().levels * getPesoHaltere() * getRepeticoes() * getDuracao()) / 1000;
        return calorias;
    }

    protected double calculoVariantes(double valor, double multNivel){
        Random rand = new Random();
        return valor * multNivel * ((double) rand.nextDouble(1.1)+1);
    }

    public void geraVariante(Utilizador utilizador){
        this.setRepeticoes((int) calculoVariantes((double) this.repeticoes, utilizador.getNivel().levels));
        this.setPesoHaltere(calculoVariantes(this.pesoHaltere, utilizador.getNivel().levels));
        setDuracao(calculoVariantes(getDuracao(), utilizador.getNivel().levels)); 
    }
}