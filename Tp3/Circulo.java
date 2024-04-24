public class Circulo {
    //Variáveis de Instância
    private double x;
    private double y;
    private double raio;

    //Construtores de classe:
    //Construtor default / por omissão
    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    //Construtor parameterizado
    public Circulo(double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    //Construtor de cópia
    public Circulo(Circulo umCirculo){
        this.x = umCirculo.getX();
        this.y = umCirculo.getY();
        this.raio = umCirculo.getRaio();
    }

    //Getters:
    public double getX(){
        return this.x; 
    }

    public double getY(){
        return this.y; 
    }

    public double getRaio(){
        return this.raio; 
    }

    //Setters:
    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }
    
    //Seguindo as regras da criação de classes, todas as classes devem conter os métodos: "toString()", "equals()", "clone()";

    public String toString(){
        return "Circulo de centro: (x: " + this.x + ", y: " + this.y + ") e de raio: " + this.raio;
    }

    public Circulo clone(){
        return new Circulo (this);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        Circulo c = (Circulo) o;
        return(this.x == c.getX() && this.y == c.getY() && this.raio == c.getRaio());
    }

    // Alínea e). Método que altera o centro de um ponto já existente
    public void alteraCentro(double x, double y){
        this.x = x;
        this.y = y;
    }

    // Alínea f). Método que calcula a área do Círculo
    public double calculaArea(){
        return ((Math.PI) * Math.pow(this.raio , 2));
    }

    // Alínea g). Método que calcula o perímetro do Círculo
    public double calculaPerimetro(){
        return (2 * (Math.PI) * this.raio);
    }


}
