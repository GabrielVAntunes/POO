import java.time.LocalDate;
import java.util.ArrayList;

public class FBPost {
    
    private int identificador;
    private String nome;
    private LocalDate data;
    private String conteudo;
    private int likes;
    private ArrayList<String> comentarios;

    // Construtores:
    // Construtor por omissão
    public FBPost(){
        this.identificador = 0;
        this.nome = "";
        this.data = LocalDate.now();
        this.conteudo = "";
        this.likes = 0;
        this.comentarios = new ArrayList<>();
    }

    // Construtor parametrizado
    public FBPost(int identificador, String nome, LocalDate data, String conteudo, int likes, ArrayList<String> comentarios){
        this.identificador = identificador;
        this.nome = nome;
        this.data = data;
        this.conteudo = conteudo;
        this.likes = likes;
        this.comentarios = new ArrayList<>(comentarios);
    }

    // Construtor Cópia
    public FBPost(FBPost f){
        this.identificador = f.getIdentificador();
        this.nome = f.getNome();
        this.data = f.getData();
        this.conteudo = f.getConteudo();
        this.likes = f.getLikes();
        this.comentarios = f.getComentarios();
    }

    //Getters:
    public int getIdentificador(){
        return this.identificador;
    }

    public String getNome(){
        return this.nome;
    }

    public LocalDate getData(){
        return this.data;
    }

    public String getConteudo(){
        return this.conteudo;
    }

    public int getLikes(){
        return this.likes;
    }

    public ArrayList<String> getComentarios(){
        return new ArrayList<>(this.comentarios);
    }

    // Setters:
    public void setIdentificador(int identificador){
        this.identificador = identificador;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }       

    public void setLikes(int likes){
        this.likes = likes;
    }   

    public void setComentarios(ArrayList<String> comentarios){
        this.comentarios = new ArrayList<>(comentarios);
    }

    public FBPost clone(){
        return new FBPost(this);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        FBPost f = (FBPost) o;
        return this.identificador == f.identificador &&
               this.nome.equals(f.getNome()) &&
               this.data.equals(f.getData()) &&
               this.conteudo.equals(f.getConteudo()) &&
               this.likes == f.getLikes() &&
               this.comentarios.equals(f.getComentarios());
    }

    public String toString(){
        return "Identificador: " + this.identificador + "\n" +
               "Nome: " + this.nome + "\n" +
               "Data: " + this.data + "\n" +
               "Conteudo: " + this.conteudo + "\n" +
               "Likes: " + this.likes + "\n" +
               "Comentários: " + this.comentarios + "\n";
    }

    public void addComentario (String comentario){
        this.comentarios.add(comentario);
    }

    public void addLike(){
        this.likes++;
    }

    
}
