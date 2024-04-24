import java.util.ArrayList;

public class Triangulo {
    
    private ArrayList<Ponto> pontos;

    //Construtores:
    //Construtor por omissão
    public Triangulo(){
        this.pontos = new ArrayList<Ponto>();
    }

    //Construtor Parametrizado
    public Triangulo(ArrayList<Ponto> pontos){
        this.pontos = pontos;
        }

    //Construtor Cópia
    public Triangulo(Triangulo t){
        this.pontos = t.getPontos();
    }

    //Getters e Setters:
    public ArrayList<Ponto> getPontos(){
        return this.pontos;
    }

    public void setPontos(ArrayList<Ponto> pontos){
        this.pontos = pontos;
    }

    public Triangulo clone(){
        return new Triangulo(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        Triangulo t = (Triangulo) o;
        return (this.pontos == t.pontos);
    }

    public String toString(){
        return "Triangulo: " + this.pontos;
    }

    //Método que calcula a área do triângulo
    public double calculaArea(){
        double a = this.pontos.get(0).distancia(this.pontos.get(1));
        double b = this.pontos.get(1).distancia(this.pontos.get(2));
        double c = this.pontos.get(2).distancia(this.pontos.get(0));
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    //Método que calcula o perímetro do triângulo
    public double calculaPerimetro(){
        double a = this.pontos.get(0).distancia(this.pontos.get(1));
        double b = this.pontos.get(1).distancia(this.pontos.get(2));
        double c = this.pontos.get(2).distancia(this.pontos.get(0));
        return a+b+c;
    }

    //Método que calcula a altura do triângulo
    public double alturaTriangulo(){
        double pontob = Math.min(this.pontos.get(0).getY(), this.pontos.get(1).getY());
        pontob = Math.min(this.pontos.get(2).getY(), pontob);

        double pontoc = Math.max(this.pontos.get(0).getY(), this.pontos.get(1).getY());
        pontoc = Math.max(this.pontos.get(2).getY(), pontoc);

        return pontoc - pontob;
    }
}
