import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SistemaSuporte {

    private ArrayList<PedidodeSuporte> sistema;

    //Construtores:
    //Construtor por omissão
    public SistemaSuporte(){
        this.sistema = new ArrayList<>();
    }

    //Construtor parametrizado
    public SistemaSuporte(ArrayList<PedidodeSuporte> sistema){
        this.sistema = new ArrayList<>(sistema);
    }

    //Construtor Cópia
    public SistemaSuporte(SistemaSuporte s){
        this.sistema = s.getSistema();
    }

    //Getters:
    public ArrayList<PedidodeSuporte> getSistema(){
        return new ArrayList<>(this.sistema);
    }

    //Setters:
    public void setSistema(ArrayList<PedidodeSuporte> sistema){
        this.sistema = new ArrayList<>(sistema);
    }

    // Métodos uteis:
    public SistemaSuporte clone(){
        return new SistemaSuporte(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        SistemaSuporte s = (SistemaSuporte) o;
        return this.sistema.equals(s.getSistema());
    }

    public String toString(){
        return "Pedidos de Suporte: " + this.sistema + "\n";
    }

    //Método que insere um novo pedido no Sistema
    public void inserePedido(PedidodeSuporte pedido){
        this.sistema.add(pedido);
    }

    //Método que vai devolver um pedido dados o utilizador e o instante
    public PedidodeSuporte procuraPedido(String utilizador, LocalDate data){
        for(PedidodeSuporte pedido: this.sistema){
            if(pedido.getUtilizador().equals(utilizador) && pedido.getInstantePedido().equals(data)) return pedido;
        } 
        return null;
    }

    // Método que vai atribuir o tecnico e a informação da resposta a um pedido
    public void resolvePedido(PedidodeSuporte pedido, String tecnico, String info){
        int i = this.sistema.indexOf(pedido);
        if(i != -1){
        this.sistema.get(i).setResposta(tecnico);
        this.sistema.get(i).setInfo(info);
        }
    }

    // Método que retorna uma lista com todos os pedidos que já têm resposta
    public List<PedidodeSuporte> resolvidos(){
        List<PedidodeSuporte> resp = new ArrayList<>();
        for(PedidodeSuporte pedido: this.sistema){
            if(pedido.getResposta() != "") resp.add(pedido);
        }
        return resp;
    }
        
    // Método que retorna o colaborador que resolveu mais pedidos
    public String colaboradorTop(){
        int max = 0;
        String top = "";
        for(PedidodeSuporte pedido: this.sistema){
            int count = 0;
            for(PedidodeSuporte pedido2: this.sistema){
                if(pedido.getResposta().equals(pedido2.getResposta())) count++;
            }
            if(count > max){
                max = count;
                top = pedido.getResposta();
            }
        }
        return top;
    }

    // Método que retorna uma lista com todos os pedidos resolvidos
    public List<PedidodeSuporte> resolvidos(LocalDate inicio, LocalDate fim){
        List<PedidodeSuporte> resp = new ArrayList<>();
        for(PedidodeSuporte pedido: this.sistema){
            if(pedido.getInstanteResposta().isAfter(inicio) && pedido.getInstanteResposta().isBefore(fim)){
                resp.add(pedido);
            }
        }
        return resp;
    }

    // Método que retorna o tempo médio de resolução dos pedidos.( Sempre ou num intervalo determinado pelos parametros)
    public double tempoMedioResolucao(){
        double soma = 0;
        for(PedidodeSuporte pedido: sistema){
            soma += ChronoUnit.DAYS.between(pedido.getInstanteResposta(),pedido.getInstantePedido());
        }
        return soma/this.sistema.size();
    }

    public double tempoMedioResolucao(LocalDate inicio, LocalDate fim){
        double soma = 0;
        int count = 0;
        for(PedidodeSuporte pedido: sistema){
            if(pedido.getInstanteResposta().isAfter(inicio) && pedido.getInstanteResposta().isBefore(fim))
            soma += ChronoUnit.DAYS.between(pedido.getInstanteResposta(),pedido.getInstantePedido());
            count++;
        }
        return soma/count;
    }

    // Métodos que retornam o pedido que demorou mais a obter resposta.( Sempre ou num intervalo determinado pelos parametros)
    public PedidodeSuporte pedidoMaisLongo(){
        PedidodeSuporte maisLongo = new PedidodeSuporte(this.sistema.get(0));
        double maisTempo = 0;
        for(PedidodeSuporte pedido: this.sistema){
            double intervalo = ChronoUnit.DAYS.between(pedido.getInstanteResposta(),pedido.getInstantePedido());
            if(maisTempo <  intervalo){
                maisTempo = intervalo;
                maisLongo = pedido.clone();
            }
        }
        return maisLongo;
    }

    public PedidodeSuporte pedidoMaisLongo(LocalDate inicio, LocalDate fim){
        PedidodeSuporte maisLongo = new PedidodeSuporte(this.sistema.get(0));
        double maisTempo = 0;
        for(PedidodeSuporte pedido: this.sistema){
            double intervalo = ChronoUnit.DAYS.between(pedido.getInstanteResposta(),pedido.getInstantePedido());
            if(maisTempo < intervalo && pedido.getInstanteResposta().isAfter(inicio) && pedido.getInstanteResposta().isBefore(fim)){
                maisTempo = intervalo;
                maisLongo = pedido.clone();
            }
        }
        return maisLongo;
    }

    // Métodos que retornam o pedido que obteve resposta mais rápido.( Sempre ou num intervalo determinado pelos parametros)
    public PedidodeSuporte pedidoMaisCurto(){
            PedidodeSuporte maisCurto = new PedidodeSuporte(this.sistema.get(0));
            double menosTempo = 1000;
            for(PedidodeSuporte pedido: this.sistema){
                double intervalo = ChronoUnit.DAYS.between(pedido.getInstanteResposta(),pedido.getInstantePedido());
                if(menosTempo >  intervalo){
                    menosTempo = intervalo;
                    maisCurto = pedido.clone();
                }
            }
        return maisCurto;
    }

    public PedidodeSuporte pedidoMaisCurto(LocalDate inicio, LocalDate fim){
        PedidodeSuporte maisCurto = new PedidodeSuporte(this.sistema.get(0));
        double menosTempo = 1000;
        for(PedidodeSuporte pedido: this.sistema){
            double intervalo = ChronoUnit.DAYS.between(pedido.getInstanteResposta(),pedido.getInstantePedido());
            if(menosTempo > intervalo && pedido.getInstanteResposta().isAfter(inicio) && pedido.getInstanteResposta().isBefore(fim)){
                menosTempo = intervalo;
                maisCurto = pedido.clone();
            }
        }
        return maisCurto;
    }

}

    


