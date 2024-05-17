public class Lugar{

    private String matricula;
    private String proprietario;
    private int minutos;
    private boolean permanente;

    //Construtores:
    //Construtor por omissão
    public Lugar(){
        this.matricula = "";
        this.proprietario = "";
        this.minutos = 0;
        this.permanente = false;
    }

    //Construtor parametrizado
    public Lugar(String matricula, String proprietario, int minutos, boolean permanente){
        this.matricula = matricula;
        this.proprietario = proprietario;
        this.minutos = minutos;
        this.permanente = permanente;
    }

    //Construtor de cópia
    public Lugar(Lugar l){
        this.matricula = l.getMatricula();
        this.proprietario = l.getProprietario();
        this.minutos = l.getMinutos();
        this.permanente = l.getPermanente();
    }

    //Getters
    public String getMatricula(){
        return this.matricula;
    }

    public String getProprietario(){
        return this.proprietario;
    }

    public int getMinutos(){
        return this.minutos;
    }

    public boolean getPermanente(){
        return this.permanente;
    }

    //Setters
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public void setProprietario(String proprietario){
        this.proprietario = proprietario;
    }

    public void setMinutos(int minutos){
        this.minutos = minutos;
    }

    public void setPermanente(boolean permanente){
        this.permanente = permanente;
    }

    //Métodos uteis
    public Lugar clone(){
        return new Lugar(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Lugar l = (Lugar) o;
        return this.matricula.equals(l.getMatricula()) && 
            this.proprietario.equals(l.getProprietario()) && ~
            this.minutos == l.getMinutos() && 
            this.permanente == l.getPermanente();
    }

    public String toString(){
        return "Matricula: " + this.matricula + "\n" +
            "Proprietario: " + this.proprietario + "\n" +
            "Minutos: " + this.minutos + "\n" +
            "Permanente: " + this.permanente + "\n";
    }

}