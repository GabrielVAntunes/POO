import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
    
    private Map<Integer,Set<Integer>> adj;

    // Construtores:
    // Construtor por Omissão
    public Grafo(){
        this.adj = new HashMap<>();
    }

    // Construtor Parametrizado
    public Grafo(Map<Integer, Set<Integer>> adj){
        setAdj(adj);
    }

    // Construtor Cópia
    public Grafo(Grafo graph){
        this.adj = graph.getAdj();
    }

    // Getters e Setters
    public Map<Integer,Set<Integer>> getAdj(){
        Map<Integer,Set<Integer>> rtrnMap = new HashMap<>();
        for(Integer key: this.adj.keySet()){
            Set<Integer> rtrnSet = new HashSet<>();
            for(Integer node: this.adj.get(key)){
                rtrnSet.add(node);
            }
            rtrnMap.put(key, rtrnSet);
        }
        return rtrnMap;
    }

    public void setAdj(Map<Integer, Set<Integer>> adj){
        Map<Integer, Set<Integer>> setMap = new HashMap<>();
        for(Integer key: adj.keySet()){
            Set<Integer> setSet = new HashSet<>();
            for(Integer node: adj.get(key)){
                setSet.add(node);
            }
            setMap.put(key, setSet);
        }
    }

    // Métodos Uteis:
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Integer key: this.adj.keySet()){
            sb.append("Nó: " +  key + "\n");
            sb.append("Adjacentes: " + adj.get(key).toString() + "\n");
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Grafo g = (Grafo) o;
        return (this.getAdj().equals(g.getAdj()));
    }

    public Grafo clone(){
        return new Grafo(this);
    }

    // Exercicios
    // ex1) Método que acrescenta um arco (interpretei que grafo = aresta) ao grafo
    public void addArco(Integer vOrigin, Integer vDest){
        if(!isAdj(vOrigin,vDest)){
            this.adj.get(vOrigin).add(vDest);
        }
    }

    // Método auxiliar para se 2 vértices já são adjacentes
    public boolean isAdj(Integer vOrigin, Integer vDest){
        for(Integer node: this.adj.get(vOrigin)){
            if(node == vDest){
                return true;
            }
        }
        return false;
    }

    // ex2) Método que verifica se um vértice não tem nenhum adjacente
    public boolean isSink (Integer node){
        if(this.adj.get(node).size() == 0) return true;
        return false;
    }

    // ex3) Método que verifica se um vértice não é adjacente de nenhum outro
    public boolean isSource(Integer node){
        for(Integer key: this.adj.keySet()){
            if(isAdj(key, node)) return false;
        }
        return true;
    }

    // ex4) Método que calcula o tamanho de um grafo
    public int size(){
        int count = 0;
        for(Integer key: this.adj.keySet()){
            count ++;
            for(Integer node: this.adj.get(key)){
                count++;
            }
        }
        return count;
    }

    // ex5) Método que verifica se existe um caminho entre 2 vértices do grafo
    // Incomepleto seria preciso implementar um algoritmo de travessia (bfs ou dfs)
    // não soube fazer
}
