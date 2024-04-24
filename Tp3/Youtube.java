import java.util.Date;
import java.util.ArrayList;

public class Youtube {
    
    private String nome;
    private byte[] conteudo;
    private Date data;
    private int resolucao;
    private String duracao;
    private ArrayList<String> comentarios;
    private int like;
    private int dislike;

    //Construtores:
    //Construtor por omissão
    public Youtube(){
        this.nome="";
        this.conteudo = new byte[0];
        this.data = null;
        this.resolucao = 0;
        this.duracao = "";
        this.comentarios = new ArrayList<>();
        this.like = 0;
        this.dislike = 0;
    }

    //contrutor parametrizado
    public Youtube(String nome, byte[] conteudo, Date data, int resolucao, 
    String duracao, ArrayList<String> comentarios, int like, int dislike){

        this.nome = nome;
        this.conteudo = conteudo;
        this.data = data;
        this.resolucao = resolucao;
        this.duracao = duracao;
        this.comentarios = comentarios;
        this.like = like;
        this.dislike = dislike;
    }

    //Construtor Copia
    public Youtube(Youtube video){
        this.nome = video.getNome();
        this.conteudo = video.getConteudo();
        this.data = video.getData();
        this.resolucao = video.getResolucao();
        this.duracao = video.getDuracao();
        this.comentarios = new ArrayList<>(video.getcomentarios());
        this.like = video.getLike();
        this.dislike = video.getDislike();    
    }
    
    // Gets e Sets:
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public byte[] getConteudo() {
        return conteudo;
    }
    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public int getResolucao() {
        return resolucao;
    }
    public void setResolucao(int resolucao) {
        this.resolucao = resolucao;
    }
    public String getDuracao() {
        return duracao;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    public ArrayList<String> getcomentarios() {
        return comentarios;
    }
    public void setcomentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
    }
    public int getLike() {
        return like;
    }
    public void setLike(int like) {
        this.like = like;
    }
    public int getDislike() {
        return dislike;
    }
    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String toString(){
        return "Nome: " + this.nome + "\n" +
        "Conteudo: " + this.conteudo + "\n" +
        "Data: " + this.data + "\n" +
        "Resolução: " + this.resolucao + "\n" +
        "Duração: " + this.duracao + "\n" +
        "comentarios: " + this.comentarios + "\n" +
        "Likes: " + this.like + "\n" +
        "Dislikes: " + this.dislike + "\n";
    }

    public Youtube clone(){
        return new Youtube (this);
    }

    public boolean equals(Object o){
        if(o == this) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        Youtube video = (Youtube) o;
        return(this.nome == video.nome && this.conteudo == video.conteudo && this.data == video.data
                && this.resolucao == video.resolucao && this.duracao == video.duracao && this.comentarios == video.comentarios
                && this.like == video.like && this.dislike == video.dislike);
    }

    // Método que vai inserir comentário à lista de comentarios do video
    public void inserecomentario(String comentario){
        this.comentarios.add(comentario);
    }

    // Metodo que vai incrementar o numero de likes
    public void thumbsUp(){
        this.like++;
    }

    // faltou a alínea da data, e a do processar, (daria para fazer a data se estivesse definida como string)
}

