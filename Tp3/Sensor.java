public class Sensor {
    // Variáveis de Instância
    private double pressao;

    // Construtores de Classe:
    // Construtor por omissão
    public Sensor(){
        this.pressao = 0;
    }

    // Construtor Parametrizado
    public Sensor(double pressao){
        this.pressao = pressao;
    }

    // Construtor Cópia
    public Sensor(Sensor s){
        this.pressao = s.getPressao();
    }

    // Setter
    public boolean setPressao(double pressao){
        if (pressao < 0){
            return false;
        } else {
            this.pressao = pressao;
        }
        return true;
    }

    // Getter
    public double getPressao(){
        return this.pressao;
    }

    // Alguns métodos Base
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Sensor s = (Sensor) o;
        return(this.pressao == s.pressao);
    }

    public String toString(){
        return "Pressão: " + this.pressao;
    }

    public Sensor clone(){
        return new Sensor(this);
    }
}
