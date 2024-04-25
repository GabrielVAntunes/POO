import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.TreeSet;


public class CasaInteligente {

    private ArrayList<Lampada> lampadas;

    
    
    //Contrutores
    //Construtor por omissão
    public CasaInteligente(){
        this.lampadas = new ArrayList<Lampada>();
    }

    //Construtor Parametrizado
    public CasaInteligente(ArrayList<Lampada> lampadas){
        this.lampadas = lampadas;
    }

    //Construtor Cópia
    public CasaInteligente(CasaInteligente cI){
        this.lampadas = cI.getLampadas();
    }

    //Getters e Setters;
    public ArrayList<Lampada> getLampadas(){
        return this.lampadas;
    }

    public void setLampadas(ArrayList<Lampada> lampadas){
        this.lampadas = lampadas;
    }

    public String toString(){
        return "lampadas: " + this.lampadas;
    }

    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        CasaInteligente cI = (CasaInteligente) o;
        return(this.lampadas == cI.lampadas);
    }

    // Método que adiciona uma lampada à lista
    public void addLampada(Lampada l){
        this.lampadas.add(l);
    }

    // Dada a sua posição, este Método vai colocar a lampada em modo ON
    public void ligaLampadaNormal(int index){   
        this.lampadas.get(index).lampON();
    }

    // Dada a sua posição, este Método vai colocar a lampada em modo ECO
    public void ligaLampadaEco(int index){
        this.lampadas.get(index).lampECO();
    }

    //Método que vai contar quantas lampadas da casa estão em modo economico
    public int qtEmEco(){
        int soma = 0;
        for(Lampada lampada : this.lampadas){
            if(lampada.getEstado() == Lampada.Estado.ECO) soma++;
        }
        return soma;
    }

    // Método para remover alguma lampada da casa dada a sua posição
    public void removeLampada(int index){
        for(int i = 0; i < this.lampadas.size(); i++){
            if(i == index) this.lampadas.remove(index);
        }
    }

    //Método que coloca todas as lampadas em modo ON
    public void ligaTodasMax(){
        for(Lampada lampada : this.lampadas){
            lampada.lampON();
        }
    }

    //Método que coloca todas as lampadas em modo ECO
    public void ligaTodasEco(){
        for(Lampada lampada : this.lampadas){
            lampada.lampECO();
        }
    }

    // Método que calcula o consumo total da casa
    public double consumoTotal(){
        double total = 0;
        for (Lampada lampada : this.lampadas){
            total += lampada.totalConsumo();
        }
        return total;
    }

    // Método que devolve a lampada com maior gasto
    public Lampada maisGastadora(){
        double maisG = 0;
        Lampada l = new Lampada();
        for(Lampada lampada : this.lampadas){
            maisG = Math.max(lampada.totalConsumo(), maisG);
            if(maisG == lampada.totalConsumo()) l = lampada;
        }
        return l;
    }

    //Método que vai devolver um "Set" com as lampadas em modo ECO
    // Um Set (HashSet) é basicamente uma lista que não permite repetição de elementos. (Existem também TreeSet e LinkedHashSet) 
    // (O HashSet não mantém necessáriamente a ordem de adição dos elementos)
    public Set<Lampada> lampadasEmModoEco(){
        Set<Lampada> lampadasECO = new HashSet<>();
        for(Lampada lampada: this.lampadas){
            if(lampada.getEstado() == Lampada.Estado.ECO) lampadasECO.add(lampada);
        }
        return lampadasECO;
    }

    // Método que vai iniciar novamente a contagem das lampadas 
    // (faria mais sentido se eu tivesse usado instancias predefinidas em java como "LocaDate" para contar os milisegundos em tempo real)
    public void reset(){
        for(Lampada lampada: this.lampadas){
            lampada.setMilisecs(0);
        }
    }

    // Método que vai retornar as 3 lampadas mais economicas da casa
    // Fiz este Método assumindo que por bom senso uma mesma lampada em modo ECO consome menos que a lampada em modo ON
    // Um TreeSet é um Set que mantém a ordem natural dos elementos(normalmente crescente) ou uma ordem definida pelo utilizador
    // (Neste caso ordenei pelo consumo em modo ECO)
    public Set<Lampada> podiumEconomia(){
        Set<Lampada> lampadasOrd = new TreeSet<>(new LampadaComparatorECO());
        Set<Lampada> lampadasPodium = new HashSet<>();
        for(Lampada lampada: this.lampadas){
            lampadasOrd.add(lampada);
        }
        int i = 0;
        for(Lampada lampada: lampadasOrd){
            lampadasPodium.add(lampada);
            i++;
            if(i>2) break;
        }
        return lampadasPodium;
    }

    // Classe auxiliar que permite comparar as lampadas no método acima
    private class LampadaComparatorECO implements Comparator<Lampada> {

        public int compare(Lampada lampada1, Lampada lampada2) {
            
            return (Integer.compare(lampada1.getConsumoEco(), lampada2.getConsumoEco()));
        }
    }
}
