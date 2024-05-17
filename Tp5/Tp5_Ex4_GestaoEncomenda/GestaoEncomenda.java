import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.time.LocalDate;

public class GestaoEncomenda{

    private HashMap<Integer, Encomenda> gestaoEncomenda;
    // Cada Entrada na Map é <Código da Encomenda, Encomenda>

    // Construtores:
    // Construtor por Omissão:
    public GestaoEncomenda(){
        this.gestaoEncomenda = new HashMap<>();
    }

    // Construtor Parametrizado
    public GestaoEncomenda(HashMap<Integer, Encomenda> gestaoEncomenda){
        setGestaoEncomenda(gestaoEncomenda);
    }

    // Construtor Cópia
    public GestaoEncomenda(GestaoEncomenda gestaoEncomenda){
        this.gestaoEncomenda = gestaoEncomenda.getGestaoEncomenda();
    }

    // Getters e Setters
    public HashMap<Integer, Encomenda> getGestaoEncomenda(){
        return this.gestaoEncomenda;
    }

    public void setGestaoEncomenda(HashMap<Integer, Encomenda> gestaoEncomenda){
        this.gestaoEncomenda = new HashMap<>();
        for(Integer key: gestaoEncomenda.keySet()){
            this.gestaoEncomenda.put(key, gestaoEncomenda.get(key).clone());
        }
    }

    // Métodos Uteis:
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Integer key: this.gestaoEncomenda.keySet()){
            sb.append("Referencia da Encomenda: " + key + "\n");
            sb.append("\n");
            sb.append(this.gestaoEncomenda.get(key));
            sb.append("\n");
        }
        return sb.toString();
    }

    public GestaoEncomenda clone(){
        return new GestaoEncomenda(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        GestaoEncomenda gE = (GestaoEncomenda) o;
        return (this.getGestaoEncomenda().equals(gE.getGestaoEncomenda()));
    }

    public void put(Integer key, Encomenda encomenda){
        this.gestaoEncomenda.put(key, encomenda);
    }

    // Exercicios:
    // ex1) Método que determina todos os Códigos de Encomenda existentes
    public Set<Integer> todosCodigosEnc(){
        Set<Integer> everyCode = new LinkedHashSet<>();
        for(Integer key: this.gestaoEncomenda.keySet()){
            everyCode.add(key);
        }
        return everyCode;
    }

    // ex2) Método que adiciona uma encomenda à gestão
    public void addEncomenda(Encomenda encomenda){
        this.gestaoEncomenda.put(encomenda.getNumEnc(), encomenda);
    }

    // ex3) Método que dado um código de encomenda a devolve
    public Encomenda getEncomenda(Integer code){
        for(Integer key: this.gestaoEncomenda.keySet()){
            if (code == key) return this.gestaoEncomenda.get(key);
        }
        return null;
    }

    // ex4) Método que remove uma Encomenda dado o seu Código
    public void removeEncomenda(Integer code){
        for(Integer key: this.gestaoEncomenda.keySet()){
            if(code == key) this.gestaoEncomenda.remove(key);
        }
    }

    // ex5) Método que retorna o Código da Encomenda com mais produtos associados
    public Integer mostProducts(){
        int maxProdutos = 0;
        Integer maxCode = 0;
        for(Integer key: this.gestaoEncomenda.keySet()){
            if(this.gestaoEncomenda.get(key).numeroTotalProdutos() > maxProdutos){
                maxProdutos = this.gestaoEncomenda.get(key).numeroTotalProdutos();
                maxCode = key;
            }
        }
        return maxCode;
    }

    // ex6) Método que retorna todas as Encomendas que contenham um determinado produto
    public Set<Integer> containsProd(String refProd){
        Set<Integer> delsWithProd = new HashSet<>(); 
        for(Integer key: this.gestaoEncomenda.keySet()){
            if(this.gestaoEncomenda.get(key).existeProdutoEncomenda(refProd)){
                delsWithProd.add(key);
            }
        }
        return delsWithProd;
    }

    // ex7) Método que retorna todas as Encomendas feitas depois de uma data estipulada
    public Set<Integer> delsAfterDate(LocalDate data){
        Set<Integer> delsAfterDate = new HashSet<>();
        for(Integer key: this.gestaoEncomenda.keySet()){
            if(this.gestaoEncomenda.get(key).getData().isAfter(data)){
                delsAfterDate.add(key);
            }
        }
        return delsAfterDate;
    }

    // ex8) Método que determina a Encomenda mais cara
    public Encomenda getMostExpensive(){
        double bgstPrice = 0;
        Integer mstExp = 0;
        for(Integer key: this.gestaoEncomenda.keySet()){
            if(this.gestaoEncomenda.get(key).calculaValorTotal() > bgstPrice){
                bgstPrice = this.gestaoEncomenda.get(key).calculaValorTotal();
                mstExp = key;
            }
        }
        return this.gestaoEncomenda.get(mstExp);
    }

    // ex9) Método que retorna uma lista das Encomendas ordenadas pela quantidade de produtos
    // Não testei mas à partida estará certo
    public Collection<Encomenda> rankingDelsNumProds(){
        Set<Encomenda> ranking = new TreeSet<>((Enc1,Enc2) -> Enc1.numeroTotalProdutos() - Enc2.numeroTotalProdutos());
        for(Integer key: this.gestaoEncomenda.keySet()){
            ranking.add(this.gestaoEncomenda.get(key));
        }
        return ranking;
    }

    // ex10) Método que retorna uma lista das Encomendas ordenadas por ordem decrescente do valor total da encomenda
    public Collection<Encomenda> rankingMostExpOrders (){
        TreeSet<Encomenda> ranking = new TreeSet<>((Enc1,Enc2) -> Double.compare(Enc2.calculaValorTotal(), Enc1.calculaValorTotal()));
        for(Integer key: this.gestaoEncomenda.keySet()){
            ranking.add(this.gestaoEncomenda.get(key));
        }
        return ranking;
    }

    // ex11) Não fiz as classes anteriores a contar com este exercicio
}