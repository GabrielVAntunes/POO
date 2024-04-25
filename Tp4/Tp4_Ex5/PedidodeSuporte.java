import java.time.LocalDate;

public class PedidodeSuporte {
    
    private String utilizador;
    private LocalDate instantePedido;
    private String assunto;
    private String descricao;
    private String resposta;
    private LocalDate instanteResposta;
    private String info;

    //Construtores:
    //Construtor por omissão
    public PedidodeSuporte(){
        this.utilizador = "";
        this.instantePedido = LocalDate.now();
        this.assunto = "";
        this.descricao = "";
        this.resposta = "";
        this.instanteResposta = LocalDate.now();
        this.info = "";
    }

    //Construtor parametrizado
    public PedidodeSuporte(String pedido, LocalDate instantePedido, String assunto, String descricao, String resposta, LocalDate instanteResposta, String info){
        this.utilizador = pedido;
        this.instantePedido = instantePedido;
        this.assunto = assunto;
        this.descricao = descricao;
        this.resposta = resposta;
        this.instanteResposta = instanteResposta;
        this.info = info;
    }

    //Construtor Cópia
    public PedidodeSuporte(PedidodeSuporte p){
        this.utilizador = p.getUtilizador();
        this.instantePedido = p.getInstantePedido();
        this.assunto = p.getAssunto();
        this.descricao = p.getDescricao();
        this.resposta = p.getResposta();
        this.instanteResposta = p.getInstanteResposta();
        this.info = p.getInfo();
    }

    //Getters:
    public String getUtilizador(){
        return this.utilizador;
    }

    public LocalDate getInstantePedido(){
        return this.instantePedido;
    }

    public String getAssunto(){
        return this.assunto;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public String getResposta(){
        return this.resposta;
    }

    public LocalDate getInstanteResposta(){
        return this.instanteResposta;
    }

    public String getInfo(){
        return this.info;
    }

    //Setters:

    public void setUtilizador(String utilizador){
        this.utilizador = utilizador;
    }

    public void setInstantePedido(LocalDate instantePedido){
        this.instantePedido = instantePedido;
    }

    public void setAssunto(String assunto){
        this.assunto = assunto;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setResposta(String resposta){
        this.resposta = resposta;
    }

    public void setInstanteResposta(LocalDate instanteResposta){
        this.instanteResposta = instanteResposta;
    }

    public void setInfo(String info){
        this.info = info;
    }

    // Métodos uteis:
    public PedidodeSuporte clone(){
        return new PedidodeSuporte(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        PedidodeSuporte p = (PedidodeSuporte) o;
        return this.utilizador.equals(p.getUtilizador()) &&
               this.instantePedido.equals(p.getInstantePedido()) &&
               this.assunto.equals(p.getAssunto()) &&
               this.descricao.equals(p.getDescricao()) &&
               this.resposta.equals(p.getResposta()) &&
               this.instanteResposta.equals(p.getInstanteResposta()) &&
               this.info.equals(p.getInfo());
    }

    public String toString(){
        return "Pedido: " + this.utilizador + "\n" +
               "Instante do Pedido: " + this.instantePedido + "\n" +
               "Assunto: " + this.assunto + "\n" +
               "Descrição: " + this.descricao + "\n" +
               "Resposta: " + this.resposta + "\n" +
               "Instante da Resposta: " + this.instanteResposta + "\n" +
               "Info: " + this.info + "\n";
    }
}
