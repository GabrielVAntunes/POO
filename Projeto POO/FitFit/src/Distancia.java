import java.time.LocalDate;
import java.util.Random;

public class Distancia extends Atividades{

    private double distancia;

    // Construtores:
    // Construtor por omissão.
    public Distancia() {
        super();
        this.distancia = 0;
    }

    // Construtor Cópia.
    public Distancia(Distancia u) {
        super(u);
        this.distancia = u.getDistancia();

    }

    // Construtor Parametrizado.
    public Distancia(String nomeAtividade, LocalDate data, double duracao, TipoAtividade tipo, double distancia) {
        super(nomeAtividade, data, duracao,  tipo);
        this.distancia = distancia;
    }

    // Getters e Setters.
    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    } 

    // Métodos Uteis
    //Método que verifica a igualdade entre o Utilizador e um outro objeto.
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Distancia s = (Distancia) o;
        return (this.distancia == s.distancia && super.equals(s));
    }
    
    //Método que devolve uma cópia do Utilizador.
    @Override
    public Distancia clone(){
        return new Distancia(this);
    }

    //Método que produz uma string no qual está representado o Utilizador.
    public String toString() {
        return (super.toString() + "Distancia Percorrida: " + this.distancia + "\n");
    }

    // Método que calcula as calorias gastas numa atividade de Distancia.
    public double calculoDeCalorias(Utilizador utilizador) {
        double fatorMetabolico;
    
        if (utilizador.getSexo().equals("M")) {
            fatorMetabolico = 2;
        } else {
            fatorMetabolico = 1.8;
        }
    
        if (utilizador.getFreqCardiacaMedia() <= 120) {
            fatorMetabolico *= 0.4; 
        } else {
            fatorMetabolico *= 0.6; 
        }
    
        double totalCalorias = fatorMetabolico * utilizador.getPeso() * getDistancia();
        double calorias = totalCalorias + utilizador.getNivel().levels * getDuracao();
    
        return calorias;
    } 

    protected double calculoVariantes(double valor, double multNivel){
        Random rand = new Random();
        return valor * multNivel * (rand.nextDouble(1.1) + 1);
    }

    public void geraVariante(Utilizador utilizador){
        this.setDistancia(calculoVariantes(this.distancia, utilizador.getNivel().levels));
        setDuracao(calculoVariantes(getDuracao(), utilizador.getNivel().levels)); 
    }
}