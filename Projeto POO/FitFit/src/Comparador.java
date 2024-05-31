import java.util.Comparator;
import java.util.ArrayList;

public class Comparador {
    
    private ArrayList<Comparator> listaComparadores;

    // Construtores:
    // Construtor por omissão
    public Comparador(){
        this.listaComparadores = new ArrayList<>();
    }

    // Construtor parametrizado
    public Comparador(ArrayList<Comparator> listaComparadores){
        this.listaComparadores = new ArrayList<>(listaComparadores);
    }

    // Construtor de Cópia
    public Comparador(Comparador comparador){
        this.listaComparadores = comparador.getListaComparadores();
    }

    // Getters e Setters
    public ArrayList<Comparator> getListaComparadores(){
        return new ArrayList<>(this.listaComparadores);
    }

    public void setListaComparadores(ArrayList<Comparator> listaComparadores){
        this.listaComparadores = new ArrayList<>(listaComparadores);
    }

    // Métodos Uteis:
    public Comparador clone(){
        return new Comparador(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Comparador c = (Comparador) o;
        return this.listaComparadores.equals(c.getListaComparadores());
    }

    public String toString(){
        return "Comparador{" +
                "listaComparadores: " + listaComparadores +
                "}";
    }
    


}