import java.io.Serializable;
//Classe que representa um utilizador no sistema
//@author GrupoTP-98
enum Dificuldades {
    PROFISSIONAL(1.1), 
    AMADOR(0.8), 
    PRATICANTE_OCASIONAL(0.6);

    double levels;

    Dificuldades(double levels) {
        this.levels = levels;
    }
}

public class Utilizador implements Serializable{

    private String codigoUtilizador;
    private String nome;
    private String morada;
    private String email;
    private int freqCardiacaMedia;
    private int altura; //altura centimetros
    private double peso; //peso em kg
    private Dificuldades nivel;
    private String sexo;
    
    // Construtores:
    // Construtor por Omissão.
    public Utilizador() {
        this.codigoUtilizador = "";
        this.nome = "";
        this.morada = "";
        this.email = "";
        this.freqCardiacaMedia = 0;
        this.altura = 0;
        this.peso = 0;
        this.nivel = Dificuldades.AMADOR;
        this.sexo = "M";
    }

    //Construtor de cópia.
    public Utilizador(Utilizador u) {
        this.codigoUtilizador = u.getCodigoUtilizador();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.email = u.getEmail();
        this.freqCardiacaMedia = u.getFreqCardiacaMedia();
        this.altura = u.getAltura();
        this.peso = u.getPeso();
        this.nivel = u.getNivel();
        this.sexo = u.getSexo();
    }

    //Construtor Parametrizado.
    public Utilizador(String codigo, String nome, String morada, String email, int freqCardiacaMedia, double peso, int altura, Dificuldades nivel, String sexo) {
        this.codigoUtilizador = codigo;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.freqCardiacaMedia = freqCardiacaMedia;
        this.altura = altura;
        this.peso = peso;
        this.nivel = nivel;
        this.sexo = sexo;
    }

    // Getters e Setters:
    public String getCodigoUtilizador() {
        return this.codigoUtilizador;
    }

    public void setCodigoUtilizador(String codigoUtilizador) {
        if (codigoUtilizador.length() > 3) {
            this.codigoUtilizador = codigoUtilizador;
        } else {
            throw new IllegalArgumentException("Codigo nao pode ter menos de 4 caracteres");
        }
    }

    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return this.morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email Invalido");
        }
    }

    public int getFreqCardiacaMedia() {
        return this.freqCardiacaMedia;
    }

    public void setFreqCardiacaMedia(int freqCardiacaMedia) {
        this.freqCardiacaMedia = freqCardiacaMedia;
    }
    public int getAltura(){
        return this.altura;
    }
    public void setAltura(int altura){
        this.altura = altura;
    }
    public double getPeso(){
        return this.peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }

    public Dificuldades getNivel() {
        return nivel;
    }

    public void setNivel(Dificuldades nivel) {
        this.nivel = nivel;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    } 

    // Métodos Uteis
    // Método que verifica a igualdade entre o Utilizador e um outro objeto.
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Utilizador s = (Utilizador) o;
        return (this.codigoUtilizador == s.codigoUtilizador && this.nome == s.nome && this.morada == s.morada && this.email == s.email 
        && this.freqCardiacaMedia == s.freqCardiacaMedia && this.altura == s.altura && this.peso == s.peso && this.nivel == s.nivel && this.sexo == s.sexo);
    }
    
    // Método que devolve uma cópia do Utilizador.
    public Utilizador clone() {
        return new Utilizador(this);
    }

    // Método que produz uma string no qual está representado o Utilizador.
    public String toString() {
        return ("O codigo do Utilizador é: " + this.codigoUtilizador+"\n"+
                "O nome do Utilizador é: " + this.nome + "\n"+
                "A moarda do Utilizador é: " + this.morada + "\n"+
                "O email do utilizador é " + this.email + "\n"+
                "A frquencia cardiaca mdeia do Utilizador é: " + this.freqCardiacaMedia + "\n"+
                "A altura do Utilizador é: "+ this.altura + "\n"+
                "O peso do Utilizador é: "+ this.peso + "\n"+
                "O nivel do Utilizador é: " + this.nivel + "\n"+
                "O Sexo do Utilizador é: "+ this.sexo);
    } 
}