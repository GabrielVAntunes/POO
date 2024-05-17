import java.util.HashMap;
import java.time.LocalDate;

public class SistemaVideos{

    private HashMap<String, Youtube> sisVideos;

    // Construtores:
    // Construtor por Omissão
    public SistemaVideos(){
        this.sisVideos = new HashMap<>();
    }

    // Construtor Parametrizado
    public SistemaVideos(HashMap<String, Youtube> sisVideo){
        setSistemaVideos(sisVideo);
    }

    // Cosntrutor Cópia
    public SistemaVideos(SistemaVideos sV){
        this.sisVideos = sV.getSistemaVideos();
    }

    // Getters e Setters
    public HashMap<String, Youtube> getSistemaVideos(){
        return this.sisVideos;
    }

    public void setSistemaVideos(HashMap<String, Youtube> sVideos){
        this.sisVideos = new HashMap<String, Youtube>();
        for(String key: sVideos.keySet()){
            this.sisVideos.put(key,sVideos.get(key).clone());
        }
    }

    // Métodos Uteis:
    public String ToString(){
        StringBuilder sb = new StringBuilder();
        for(String key: this.sisVideos.keySet()){
            sb.append("Video: " + key);
            sb.append("\n");
            sb.append(this.sisVideos.get(key));
            sb.append("\n");
        }
        return sb.toString();
    }

    public SistemaVideos clone(){
        return new SistemaVideos(this);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SistemaVideos sV = (SistemaVideos) o;
        return (this.sisVideos.equals(sV.sisVideos));
    }

    // Exercicios:
    // ex1) Método que adiciona um video ao sistema
    public void addVideo(Youtube video){
        this.sisVideos.put(video.getNome(),video);
    }

    // ex2) Método que dado o titulo do video retorna o video
    public Youtube getVideo(String nome){
        for(String key: this.sisVideos.keySet()){
            if (key.equals(nome)) return this.sisVideos.get(key);
        }
        return null;
    }

    // ex3) Método que remove um video dado o seu nome
    public void removeVideo(String nome){
        for(String key: this.sisVideos.keySet()){
            if(key.equals(nome)) {
                this.sisVideos.remove(key);
                return;
            }
        }
    }

    // ex4) Método que adiciona um like a um video dado o seu nome
    public void addLike(String nome){
        getVideo(nome).thumbsUp();
    }

    // ex5) Método que devolve o vídeo com mais likes no sistema
    public Youtube toplikes(){
        int maxlikes = 0;
        String mostLikedVideo = "";
        for(String key: this.sisVideos.keySet()){
            if(this.sisVideos.get(key).getLike() > maxlikes){
                mostLikedVideo = this.sisVideos.get(key).getNome();
                maxlikes = this.sisVideos.get(key).getLike();
            }
        }
        return this.sisVideos.get(mostLikedVideo);
    }

    // ex6) Método que devolve o video com mais likes dentro de um intervalo de tempo determinado
    public Youtube toplikes(LocalDate strDate, LocalDate fnsDate){
        int maxlikes = 0;
        String mostLikedVideo = "";
        for(String key: this.sisVideos.keySet()){
            if(this.sisVideos.get(key).getData().isAfter(strDate) && this.sisVideos.get(key).getData().isBefore(fnsDate)){
                if(this.sisVideos.get(key).getLike() > maxlikes){
                    mostLikedVideo = this.sisVideos.get(key).getNome();
                    maxlikes = this.sisVideos.get(key).getLike();
                }
            }
        }
        return this.sisVideos.get(mostLikedVideo);
    }

    // ex7) Método que devolve o video mais longo
    // tive de fazer uma correção na classe youtube, e trocar a duração para "double"
    public Youtube getLongest(){
        double longestTime = 0;
        String longestVid = "";
        for(String key: this.sisVideos.keySet()){
            if(this.sisVideos.get(key).getDuracao() > longestTime){
                longestTime = this.sisVideos.get(key).getDuracao();
                longestVid = this.sisVideos.get(key).getNome();
            }
        }
        return this.sisVideos.get(longestVid);
    } 
}