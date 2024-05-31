import java.io.Serializable;
import java.util.ArrayList;

public class Utilizadores implements Serializable {
    
    private ArrayList<Utilizador> utilizadores;
    
    // Construtores:
    // Construtor por omissão
    public Utilizadores(){
        this.utilizadores = new ArrayList<>();
    }

    // Construtor parametrizado
    public Utilizadores(ArrayList<Utilizador> utilizadores){
        this.utilizadores = new ArrayList<>(utilizadores);
    }

    // Construtor de cópia
    public Utilizadores(Utilizadores utilizadores){
        this.utilizadores = utilizadores.getUtilizadores();
    }

    // Getters e Setters:
    public ArrayList<Utilizador> getUtilizadores(){
        return new ArrayList<>(this.utilizadores);
    }   

    public void setUtilizadores(ArrayList<Utilizador> utilizadores){
        this.utilizadores = new ArrayList<>(utilizadores);
    }

    // Métodos Uteis:
    public Utilizadores clone(){
        return new Utilizadores(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Utilizadores u = (Utilizadores) o;
        return this.utilizadores.equals(u.getUtilizadores());
    }

    public String toString(){
        return "Utilizadores{" +
                "utilizadores=" + utilizadores +
                "}";
    }
    
    // Método que verifica se um utilizador está registado pelo seu código.
    public boolean codigoRegistado(String codigo){
        for(Utilizador utilizador: this.utilizadores){
            if(utilizador.getCodigoUtilizador().equals(codigo)){
                return true;
            }
        }
        return false;
    }
    
    // Método que adiciona um utilizador à lista de utilizadores.
    public void add(Utilizador utilizador){
        this.utilizadores.add(utilizador);
    }

    // Método que verifica se um utilizador está registado pelo seu email.
    public boolean emailRegistado(String email){
        for(Utilizador utilizador: this.utilizadores){
            if(utilizador.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    // Método que devolve o código de um utilizador a partir do seu email.
    public String emailToUser(String email){
        for (Utilizador utilizador: this.utilizadores){
            if(utilizador.getEmail().equals(email)){
                return utilizador.getCodigoUtilizador();
            }
        }
        return "";
    }

    // Método que remove um utilizador da lista de utilizadores.
    public void remove(int index){
        this.utilizadores.remove(index);
    }

    // Método que devolve o utilizador a partir do seu código.
    public Utilizador getThisUtilizador(String userCode){
        Utilizador userNone = new Utilizador();
        for(Utilizador utilizador: this.utilizadores){
            if(utilizador.getCodigoUtilizador().equals(userCode)){
                return utilizador;
            }
        }
        return userNone;
    }

    // Método que devolve o indíce de um utilizador a partir do seu código.
    public int getUserIndex(String userCode){
        int i = 0;
        for(Utilizador utilizador: this.utilizadores){
            if(utilizador.getCodigoUtilizador().equals(userCode)){
                break;
            }
            i++;
        }
        return i;
    }

    public String listaUsers(){
        int i = 1;
        StringBuilder sb = new StringBuilder();
        for(Utilizador utilizador: this.utilizadores){
            sb.append(i + ": " + utilizador.getCodigoUtilizador().toString() + "\n");
            i++;
        }
        return sb.toString();
    }

    // contains
    public boolean contains(Utilizador user){
        for(Utilizador utilizador: this.utilizadores){
            if(utilizador.getCodigoUtilizador().equals(user.getCodigoUtilizador())){
                return true;
            }
        }
        return false;
    }
}