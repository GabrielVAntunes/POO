import java.time.LocalDate;
import java.util.Random;

public class Altimetria extends Atividades{

    private int alturaMax;
    private int alturaMedia;
    private double distancia;

    // Construtores:
    // Construtor por Omissão
    public Altimetria(){
        super();
        alturaMax = 0;
        alturaMedia = 0;
        distancia = 0;
 
    }

    // Contrutor Parametrizado
    public Altimetria(String nomeAtividade, LocalDate data, Double duracao, TipoAtividade tipo, int alturaMax, int alturaMedia, double distancia){
        super(nomeAtividade, data, duracao, tipo);
        this.alturaMax = alturaMax;
        this.alturaMedia = alturaMedia;
        this.distancia = distancia;
    }

    // Construtor Cópia
    public Altimetria(Altimetria a){
        super(a);
        this.alturaMax = a.alturaMax;
        this.alturaMedia = a.alturaMedia;
        this.distancia = a.distancia; 
    }
    
    // Getters e Setters
    public int getAlturaMedia() {
        return alturaMedia;
    }

    public void setAlturaMedia(int alturaMedia) {
        this.alturaMedia = alturaMedia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getAlturaMax() {
        return alturaMax;
    }

    public void setAlturaMax(int alturaMax) {
        this.alturaMax = alturaMax;
    }

    // Métodos Uteis
    public boolean equals(Object o){
        if (this == o) return true;
        if (this.getClass() != o.getClass())return false;
        Altimetria s = (Altimetria) o;
        return (this.alturaMedia == s.alturaMedia && this.distancia == s.distancia && super.equals(s));
    }

    public String toString(){
        return super.toString() + "Altura máxima alcançada: "+ this.alturaMax + "\n" + 
                "Altura média: "+ this.alturaMedia + "\n" +
                "Distancia percorrida: "+ this.distancia + "\n";
    }

    @Override
    public Altimetria clone(){
        return new Altimetria(this);
    }

    // Método que calcula as calorias gastas numa atividade do tipo Altimetria.
    public double calculoDeCalorias(Utilizador utilizador) {
        double calorias;

        if (utilizador.getSexo().equals("M")) {
            calorias = 0.13 * utilizador.getNivel().levels * utilizador.getPeso() * (getAlturaMax() - getAlturaMedia()) * (utilizador.getFreqCardiacaMedia() / 100); 
        } else {
            calorias = 0.08 * utilizador.getNivel().levels * utilizador.getPeso() * (getAlturaMax() - getAlturaMedia()) * (utilizador.getFreqCardiacaMedia() / 100);
        }
    

        double caloriasPorDistancia = getDuracao() * getDistancia(); 

        double totalCalorias = calorias + caloriasPorDistancia;
    
        return totalCalorias;
    }
    
    protected double calculoVariantes(double valor, double multNivel){
        Random rand = new Random();
        return valor * multNivel * (rand.nextDouble(1.1) + 1);
    }

    public void geraVariante(Utilizador utilizador){
        this.setAlturaMax((int) calculoVariantes((double) this.alturaMax, utilizador.getNivel().levels));
        this.setAlturaMedia((int) calculoVariantes((double) this.alturaMedia, utilizador.getNivel().levels));
        this.setDistancia(calculoVariantes(this.distancia, utilizador.getNivel().levels));
        setDuracao(calculoVariantes(getDuracao(), utilizador.getNivel().levels)); 
    }
}