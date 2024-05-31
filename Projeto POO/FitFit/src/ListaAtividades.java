import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListaAtividades implements Serializable {
    
    private ArrayList<Atividades> lAtividades;
    
    //Construtores:
    //Construtor por omissão
    public ListaAtividades(){
        this.lAtividades = new ArrayList<>();
    }

    //Construtor parametrizado
    public ListaAtividades(ArrayList<Atividades> lAtividades){
        this.lAtividades = new ArrayList<>(lAtividades);
    }

    //Construtor de cópia
    public ListaAtividades(ListaAtividades lAtividades){
        this.lAtividades = lAtividades.getListaAtividades();
    }

    //Getters e Setters:
    public ArrayList<Atividades> getListaAtividades(){
        return new ArrayList<>(this.lAtividades);
    }   

    public void setUtilizadores(ArrayList<Atividades> lAtividades){
        this.lAtividades = new ArrayList<>(lAtividades);
    }

    //Métodos Uteis:
    public ListaAtividades clone(){
        return new ListaAtividades(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        ListaAtividades u = (ListaAtividades) o;
        return this.lAtividades.equals(u.getListaAtividades());
    }

    public String toString(){
        return  "Atividades: " + lAtividades + "\n";
    }

    // Método que adiciona uma atividade à lista de atividades.
    public void add(Atividades atividade){
        this.lAtividades.add(atividade);
    }

    // Método para listar as atividades numeradas
    public String listaAtividades(){
        int i = 1;
        StringBuilder sb = new StringBuilder();
        for(Atividades atividade: this.lAtividades){
            
            sb.append(i + ": " + atividade.getNomeAtividade().toString() + "\n");
            i++;
        }
        if(i == 1) sb.append("Não existem atividades registadas.\n");
        return sb.toString();
    }

    public void remove(int index){
        this.lAtividades.remove(index);
    }

    public int size(){
        return this.lAtividades.size();
    }

    public Atividades get(int index){
        return this.lAtividades.get(index);
    }

    public Atividades getThisAtividade(int index){
        int i = 0;
        for(Atividades atividade: this.lAtividades){
            if(i == index) return atividade;
            i++;
        }
        return null;
    }

    public void clear(){
        this.lAtividades.clear();
    }

    public boolean isEmpty() {
        return lAtividades.isEmpty();
    }

    public double calculoCaloriasLa (Utilizador utilizador){
        double caloriasLista = 0;

        for(Atividades atividade : this.lAtividades){
            caloriasLista += atividade.calculoDeCalorias(utilizador);
        }
        return caloriasLista;
    }

    public int calculoNumeroAt(){
        int numeroAtividade = 0;
        for(Atividades atividade : this.lAtividades){
            numeroAtividade++;
        }
        return numeroAtividade;
    }

    public int[] numeroTipoAtividade(){
        int[] numeroTipo = new int[4];
        for(Atividades atividade : this.lAtividades){
            if(atividade.getTipo().equals(TipoAtividade.ALTIMETRIA)){
                numeroTipo[0]++;
            } else if(atividade.getTipo().equals(TipoAtividade.DISTANCIA)){
                numeroTipo[1]++;
            } else if(atividade.getTipo().equals(TipoAtividade.REPETICOES)){
                numeroTipo[2]++;
            } else {
                numeroTipo[3]++;
            } 
        }
        
        return numeroTipo;
    }

    public int quilometrosPercorridos(){
        int quilometrosTotais = 0;
        for(Atividades atividade : this.lAtividades){
            if(atividade.getTipo().equals(TipoAtividade.DISTANCIA)){
                quilometrosTotais += ((Distancia) atividade).getDistancia();

            } else if(atividade.getTipo().equals(TipoAtividade.ALTIMETRIA)){
                quilometrosTotais += ((Altimetria) atividade).getDistancia();

            }
        }
        return quilometrosTotais;
    }

    public int metrosAltimetria(){
        int metrosTotais = 0;
        for(Atividades atividade : this.lAtividades){
            if(atividade.getTipo().equals(TipoAtividade.ALTIMETRIA)){
                metrosTotais += ((Altimetria) atividade).getAlturaMedia();
            }
        }
        return metrosTotais;
    }

    // contains
    public boolean contains(Atividades atividade){
        return this.lAtividades.contains(atividade);
    }
}