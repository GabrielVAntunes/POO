import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class FBFeed {
    
    private List<FBPost> posts;

    //Construtores:
    //Construtor por omissão
    public FBFeed(){
        this.posts = new ArrayList<>();
    }

    //Construtor parametrizado
    public FBFeed(List<FBPost> posts){
        this.posts = new ArrayList<>(posts);
    }

    //Construtor Cópia
    public FBFeed(FBFeed f){
        this.posts = f.getPosts();
    }

    //Getters:
    public ArrayList<FBPost> getPosts(){
        return new ArrayList<>(this.posts);
    }

    //Setters:
    public void setPosts(ArrayList<FBPost> posts){
        this.posts = new ArrayList<>(posts);
    }

    // Métodos de classe:
    public FBFeed clone(){
        return new FBFeed(this);
    }   

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        FBFeed f = (FBFeed) o;
        return this.posts.equals(f.getPosts());
    }   

    public String toString(){
        return "Posts: " + this.posts + "\n";
    }

    //Método que conta o número de posts de um utilizador
    public int nrPosts(String user){
        int count = 0;
        for(FBPost post: this.posts){
            if(post.getNome().equals(user)) count++;
        }
        return count;
    }

    //Método que devolve a lista de posts de um utilizador
    public List<FBPost> postOF(String user){
        List<FBPost> resp = new ArrayList<>();
        for(FBPost post: this.posts){
            if(post.getNome().equals(user)) resp.add(post);
        }
        return resp;
    }

    //Método que devolve a lista de posts de um utilizador num intervalo de tempo
    public List<FBPost> postOF(String user, LocalDate inicio, LocalDate fim){
        List<FBPost> resp = new ArrayList<>();
        for(FBPost post: this.posts){
            if(post.getNome().equals(user) && post.getData().isAfter(inicio) && post.getData().isBefore(fim)) resp.add(post);
        }
        return resp;
    }

    //Método que devolve um post com um determinado identificador
    public FBPost getPost(int id){
        for(FBPost post: this.posts){
            if(post.getIdentificador() == id) return post;
        }
        return null;
    }

    //Método que adiciona um comentário a um post
    public void comment(FBPost post, String comentario){
        for (FBPost p: this.posts){
            if(p.equals(post)){
                p.addComentario(comentario);
            }
        }
    }

    //Método que adiciona um comentário a um post com um determinado identificador
    public void comment(int postid, String comentario){
        getPost(postid).addComentario(comentario);
    }

    //Método que dá like a um post
    public void like(FBPost post){
        for (FBPost p: this.posts){
            if(p.equals(post)){
                p.addLike();
            }
        }
    }

    //Método que dá like a um post com um determinado identificador
    public void like(int postid){
        getPost(postid).addLike();
    }

    //Método que devolve a lista dos 5 posts com mais comentários
    public List<Integer> top5Comments(){
        List<Integer> lista = new ArrayList<>();
        for(FBPost post: this.posts){
            lista.add(post.getIdentificador());
        }
        List<Integer> listaOrd = lista.stream().sorted((a,b) -> getPost(b).getComentarios().size() - getPost(a).getComentarios().size())
        .limit(5)
        .collect(Collectors.toList());
        return listaOrd;
    }
}
