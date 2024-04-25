public class Lampada {
    
    private Estado estado;
    private int consumoOn;
    private int consumoEco;
    private int milisecs;

    public enum Estado{
        ON, OFF, ECO
    }

    // Construtores:
    // Construtor por omissão
    public Lampada(){
        this.estado = Estado.OFF;
        this.consumoOn = 0;
        this.consumoEco = 0;
        this.milisecs = 0;
    }

    // Construtor parametrizado
    public Lampada(Estado estado, int consumoOn, int consumoEco, int milisecs){
        this.estado = estado;
        this.consumoOn = consumoOn;
        this.consumoEco = consumoEco;
        this.milisecs = milisecs;
    }

    // Construtor Cópia
    public Lampada(Lampada l){
        this.estado = l.getEstado();
        this.consumoOn = l.getConsumoOn();
        this.consumoEco = l.getConsumoEco();
        this.milisecs = l.getMilisecs();
    }

    //Getters:
    public Estado getEstado(){
        return this.estado;
    }

    public int getConsumoOn(){
        return this.consumoOn;
    }

    public int getConsumoEco(){
        return this.consumoEco;
    }

    public int getMilisecs(){
        return this.milisecs;
    }

    // Setters:
    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public void setConsumoOn(int consumoOn){
        this.consumoOn = consumoOn;
    }

    public void setConsumoEco(int consumoEco){
        this.consumoEco = consumoEco;
    }
    
    public void setMilisecs(int milisecs){
        this.milisecs = milisecs;
    }

    // Método que vai mudar o estado da Lampada para ON
    public void lampON(){
        this.setEstado(Estado.ON);
    }

    // Análogo ao anterior, vai mudar o estado da Lampada para OFF
    public void lampOFF(){
        this.setEstado(Estado.OFF);
        this.setMilisecs(0);
    }

    // Agora para ECO
    public void lampECO(){
        this.setEstado(Estado.ECO);
    }

    public double totalConsumo(){
        switch (this.estado){
            case ON:
                return this.milisecs * this.consumoOn;

            case ECO:
                return this.milisecs * this.consumoEco;
                
            default:
                return 0;
        }
    }

    // Não entendi como era para fazer a alínea e), talvez com (Métodos da instancia LocalDate e calcular em tempo real)

    public String toString(){
        return "Estado : " + this.estado + "\n" +
               "Estado ON, Consumo: " + this.consumoOn + "\n" +
               "Estado ECO, Consumo: " + this.consumoEco + "\n" + 
               "Ligada há " + milisecs + " milissegundos";
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Lampada l = (Lampada) o;
        return(this.estado == l.estado && this.consumoOn == l.consumoOn && 
        this.consumoEco == l.consumoEco && this.milisecs == l.milisecs);
    }

    public Lampada clone(){
        return new Lampada(this);
    }
}
