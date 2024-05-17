import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class Parque {
    
    private HashMap<String, Lugar> parque;

    //Construtores
    //Construtor por omissão
    public Parque(){
        this.parque = new HashMap<>();
    }

    //Construtor parametrizado
    public Parque(HashMap<String, Lugar> hashMap){
        this.parque = new HashMap<>();
        for(Map.Entry<String, Lugar> entry : hashMap.entrySet()){
            this.parque.put(entry.getKey(), entry.getValue());
        }
    }

    //Construtor de cópia
    public Parque(Parque p){
        this.parque = p.getParque();
    }

    //Getters
    public HashMap<String, Lugar> getParque(){
        HashMap<String, Lugar> res = new HashMap<>();
        for(Map.Entry<String, Lugar> entry : this.parque.entrySet()){
            res.put(entry.getKey(), entry.getValue());
        }
        return res;
    }

    //Setters
    public void setParque(HashMap<String, Lugar> hashMap){
        this.parque = new HashMap<>();
        for(HashMap.Entry<String, Lugar> entry : hashMap.entrySet()){
            this.parque.put(entry.getKey(), entry.getValue());
        }
    }

    //Métodos uteis
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Parque: \n");
        for(Map.Entry<String, Lugar> entry: this.parque.entrySet()){
            sb.append(entry.getValue().toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        Parque p = (Parque) o;
        return this.parque.equals(p.getParque());
    }

    public Parque clone(){
        return new Parque(this);
    }

    //Método put para por uma entrada do dicionario nesta instancia
    public void add(Lugar lugar){
        this.parque.put(lugar.getMatricula(), lugar);
    }

    // Método que retorna todos os lugares ocupados
    public Set<String> lugaresOcupados(){
        Set<String> lugaresO = new HashSet<>(parque.keySet());
        return lugaresO;
    }

    public Lugar get(String plate){
        return this.parque.get(plate);
    }

    // Método que remove o lugar de uma dada matrícula
    public void remove(String plate){
        this.parque.remove(plate);
    }

    // Método que dada uma matrícula altera o tempo restante
    public void setTime4This(String plate, int newTime){
        for(String matricula: this.parque.keySet()){
            if(matricula.equals(plate)){
                this.parque.get(matricula).setMinutos(newTime);
            }
        }
    }

    // Método que devolve o total de minutos atribuídos
    public int sumAllMinutes(){
        int sumMinutes = 0;
        for(String matricula: this.parque.keySet()){
            sumMinutes += this.parque.get(matricula).getMinutos();
        }
        return sumMinutes;
    }

    public boolean existeLugar(String plate){
        for(String matricula: this.parque.keySet()){
            if(matricula.equals(plate)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> longerThan(int time){
        ArrayList<String> longerList = new ArrayList<>();
        for(String matricula: this.parque.keySet()){
            if(this.parque.get(matricula).getMinutos() > time && this.parque.get(matricula).getPermanente()){
                longerList.add(matricula);
            }
        }
        return longerList;
    }

    public ArrayList<Lugar> getCpyLots(){
        ArrayList<Lugar> lotsCpy = new ArrayList<>();
        for(String matricula: this.parque.keySet()){
            lotsCpy.add(this.parque.get(matricula).clone());
        }
        return lotsCpy;
    }

    public void parkingLotFile(String plate){
        System.out.println(this.parque.get(plate).toString());
    }
}
