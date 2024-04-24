import java.util.ArrayList;

public class Telemovel {
    
    private String marca;
    private String modelo;
    private int resolucaoX;
    private int resolucaoY;
    private int dimTexto;
    private int dimFotosApps;
    private int dimFotos;
    private int dimApps;
    private int espacoOcupado;
    private int numFotos;
    private int numApps;
    private ArrayList<String> appsInstaladas;

    // Construtores:
    // Construtor por Omissão
    public Telemovel(){
    this.marca = "";
    this.modelo = "";
    this.resolucaoX = 0;
    this.resolucaoY = 0;
    this.dimTexto = 0;
    this.dimFotosApps = 0;
    this.dimFotos = 0;
    this.dimApps = 0;
    this.espacoOcupado = 0;
    this.numFotos = 0;
    this.numApps = 0;
    this.appsInstaladas = new ArrayList<>();
    }

    // Construtor Parametrizado
    public Telemovel(String marca, String modelo, int resolucaoX,
                     int  resolucaoY, int dimTexto, int dimFotosApps,
                     int dimFotos, int dimApps, int espacoOcupado,
                     int numFotos, int numApps, ArrayList<String> appsInstaladas){
        this.marca = marca;
        this.modelo = modelo;
        this.resolucaoX = resolucaoX;
        this.resolucaoY = resolucaoY;
        this.dimTexto = dimTexto;
        this.dimFotosApps = dimFotosApps;
        this.dimFotos = dimFotos;
        this.dimApps = dimApps;
        this.espacoOcupado = espacoOcupado;
        this.numFotos = numFotos;
        this.numApps = numApps;
        this.appsInstaladas = appsInstaladas;
    }

    // Construtor Cópia
    public Telemovel(Telemovel t){
        this.marca = t.getMarca();
        this.modelo = t.getModelo();
        this.resolucaoX = t.getResolucaoX();
        this.resolucaoY = t.getResolucaoY();
        this.dimTexto = t.getDimTexto();
        this.dimFotosApps = t.getDimFotosApps();
        this.dimFotos = t.getDimFotos();
        this.dimApps = t.getDimApps();
        this.espacoOcupado = t.getEspacoOcupado();
        this.numFotos = t.getNumFotos();
        this.numApps = t.getNumApps();
        this.appsInstaladas = new ArrayList<>(t.getAppsInstaladas());
    }

    // Getters:
    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getResolucaoX(){
        return this.resolucaoX;
    }

    public int getResolucaoY(){
        return this.resolucaoY; 
    }

    public int getDimTexto(){
        return this.dimTexto;
    }

    public int getDimFotosApps(){
        return this.dimFotosApps;
    }

    public int getDimFotos(){
        return this.dimFotos;
    }   

    public int getDimApps(){
        return this.dimApps;
    }   

    public int getEspacoOcupado(){
        return this.espacoOcupado;
    }

    public int getNumFotos(){
        return this.numFotos;
    }

    public int getNumApps(){
        return this.numApps;
    }   

    public ArrayList<String> getAppsInstaladas(){
        return this.appsInstaladas;
    }

    // Setters:
    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setResolucaoX(int resolucaoX){
        this.resolucaoX = resolucaoX;
    }

    public void setResolucaoY(int resolucaoY){
        this.resolucaoY = resolucaoY;
    }

    public void setDimTexto(int dimTexto){
        this.dimTexto = dimTexto;
    }

    public void setDimFotosApps(int dimFotosApps){
        this.dimFotosApps = dimFotosApps;
    }

    public void setDimFotos(int dimFotos){
        this.dimFotos = dimFotos;
    }

    public void setDimApps(int dimApps){
        this.dimApps = dimApps;
    }

    public void setEspacoOcupado(int espacoOcupado){
        this.espacoOcupado = espacoOcupado;
    }

    public void setNumFotos(int numFotos){
        this.numFotos = numFotos;
    }

    public void setNumApps(int numApps){
        this.numApps = numApps;
    }

    public void setAppsInstaladas(ArrayList<String> appsInstaladas){
        this.appsInstaladas = appsInstaladas;
    }

    public String toString(){
        return "Marca: " + this.marca + "\n" +
               "Modelo: " + this.modelo + "\n" +
               "Resolução X: " + this.resolucaoX + "\n" +
               "Resolução Y: " + this.resolucaoY + "\n" +
               "Dimensão do Texto: " + this.dimTexto + "\n" +
               "Dimensão das Fotos das Apps: " + this.dimFotosApps + "\n" +
               "Dimensão das Fotos: " + this.dimFotos + "\n" +
               "Dimensão das Apps: " + this.dimApps + "\n" +
               "Espaço Ocupado: " + this.espacoOcupado + "\n" +
               "Número de Fotos: " + this.numFotos + "\n" +
               "Número de Apps: " + this.numApps + "\n" +
               "Apps Instaladas: " + this.appsInstaladas + "\n";
    }

    public Telemovel clone(){
        return new Telemovel (this);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (( o == null) || (this.getClass() != o.getClass())) return false;
        Telemovel t = (Telemovel) o;
        return(this.marca == t.marca && this.modelo == t.modelo && this.resolucaoX == t.resolucaoX &&
        this.resolucaoY == t.resolucaoY && this.dimTexto == t.dimTexto  && this.dimFotosApps == t.dimFotosApps &&
        this.dimFotos == t.dimFotos && this.dimApps == t.dimApps && this.espacoOcupado == t.espacoOcupado &&
        this.numFotos == t.numFotos && this.numApps == t.numApps && this.appsInstaladas == t.appsInstaladas);
    }

    // Método que vai verificar se existe espaço para instalar algum conteúdo
    public boolean existeEspaco(int numeroBytes){
        return(this.dimFotosApps - this.espacoOcupado >= numeroBytes);
    }

    // Método que vai instalar uma aplicação caso exista espaço para tal
    public void instalaApp(String nome, int tamanho){
        if(this.existeEspaco(tamanho)){
            this.appsInstaladas.add(nome);
            this.numApps++;
            this.espacoOcupado += tamanho;
            this.dimApps += tamanho;
            this.dimFotosApps += tamanho;
        } else {
            System.out.println("Não é possivel instalar a aplicação, armazenamento insuficiente");
        }
    }

    // Método que vai permitir que se receba uma mensagem caso exista espaço
    public void recebeMsg(String msg){
        if(this.existeEspaco(msg.length())){
            this.dimTexto += msg.length();
            this.espacoOcupado += msg.length();
        } else {
            System.out.println("Não foi possível receber a mensagem, armazenamento insuficiente");
        }
    }

    // Método que vai calcular o tamanho médio das Apps
    public double tamMedioApps(){
        return(this.espacoOcupado / this.numApps);
    }

    /*          public String maiorMsg(){
     *   
     *          }
     * 
     *          alínea e) não sei fazer acho que seria preciso uma V.I (varíavel de Instância)
     *          que guardasse as mensagens recebidas
     *
     */         

    // Método que remove aplicações do telemovel
    public void removeApp(String nome, int tamanho){
        for(int i = 0; i < this.appsInstaladas.size(); i++){
            if(this.appsInstaladas.get(i) == nome){
                this.appsInstaladas.remove(i);
            }
            espacoOcupado -= tamanho;
            this.dimApps += tamanho;
            this.dimFotosApps += tamanho;
        }
    }
}
