import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.Serializable;

public class PlanosTreino implements Serializable{
    
    private HashMap<String,PlanoSemanal> planosTreino;

    // Contrutores:
    // Construtor por omissão
    public PlanosTreino(){
        this.planosTreino = new HashMap<String,PlanoSemanal>();
    }

    // Construtor Parametrizado
    public PlanosTreino(HashMap<String,PlanoSemanal> planosTreino){
        this.planosTreino = new HashMap<String,PlanoSemanal>();
        for(String key : planosTreino.keySet()){
            this.planosTreino.put(key, planosTreino.get(key).clone());
        }
    }

    // Construtor de cópia
    public PlanosTreino(PlanosTreino pt){
        this.planosTreino = pt.getPlanosTreino();
    }

    // Getters e Setters
    public HashMap<String,PlanoSemanal> getPlanosTreino(){
        HashMap<String,PlanoSemanal> novo = new HashMap<String,PlanoSemanal>();
        for(String key : this.planosTreino.keySet()){
            novo.put(key, this.planosTreino.get(key).clone());
        }
        return novo;
    }

    public void setPlanoTreino(HashMap<String,PlanoSemanal> planoTreino){
        this.planosTreino = new HashMap<String,PlanoSemanal>();
        for(String key : planoTreino.keySet()){
            this.planosTreino.put(key, planoTreino.get(key).clone());
        }
    }

    // Métodos Uteis
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String key : this.planosTreino.keySet()){
            sb.append("Utilizador: " + key + " \nPlano de Treino: " + this.planosTreino.get(key).toString());
        }
        return sb.toString();
    }

    public PlanosTreino clone(){
        return new PlanosTreino(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        PlanosTreino pT = (PlanosTreino) o;
        return this.planosTreino.equals(pT.getPlanosTreino());
    }

    // Método que adiciona um plano de treino ao HashMap de planos de treino.
    public void put(String codigoUtilizador, PlanoSemanal planoSemanal){
        this.planosTreino.put(codigoUtilizador, planoSemanal);
    }

    // Método que remove um plano de treino do HashMap de planos de treino.
    public void remove(String codigoUtilizador){
        this.planosTreino.remove(codigoUtilizador);
    }

    // Método que lista todos os planos de treino existentes de forma numerada
    public String listaPlanosTreino(){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for(String key : this.planosTreino.keySet()){
            sb.append(i + ":\n");
            sb.append( "Utilizador: " + key + " \nPlano de Treino: " + this.planosTreino.get(key).toString());
            i++;
        }
        return sb.toString();
    }

    // Método que devolve o UserCode de uma das entradas do HashMap dado o seu indice
    public String getThis(int index){
        int i = 0;
        for(String key : this.planosTreino.keySet()){
            if(i == index){
                return this.planosTreino.get(key).toString();
            }
            i++;
        }
        return null;
    }

    public PlanoSemanal get(String userCode){
        return this.planosTreino.get(userCode);
    }

    // Método que verifica se um utilizador já tem um plano de treino registado
    public boolean contains(String userCode){
        for(String code : this.planosTreino.keySet()){
            if(userCode.equals(code)){
                return true;
            }
        }
        return false;
    }

    public double caloriasPlanoTreino (Utilizador utilizador){
        String userCode = utilizador.getCodigoUtilizador();
        for(String code : this.planosTreino.keySet()){
            if(userCode.equals(code)){
                return this.planosTreino.get(code).caloriasPlanoSemanal(utilizador);
            }
        }
        return 0;
    }

    public int atividadesPlanoTreino(Utilizador utilizador){
        String userCode = utilizador.getCodigoUtilizador();
        for(String code : this.planosTreino.keySet()){
            if(userCode.equals(code)){
                return this.planosTreino.get(code).numeroAtividadePlanoSemanal();
            }
        }
        return 0;
    }

    // Método que devolve uma lista com o número dos tipos de atividades presentes nos planos de treinor
    public List<Integer> tipoAtividadesPlanoTreino() {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            resultado.add(0);
        }
        
        for (String code : this.planosTreino.keySet()) {
                int[] valoresAtividade = this.planosTreino.get(code).numeroTipoAtividade();
                List<Integer> temp = new ArrayList<>();
                for (int valor : valoresAtividade) {
                    temp.add(valor);
                }
                
                for (int i = 0; i < temp.size(); i++) {
                    resultado.set(i, resultado.get(i) + temp.get(i));
                }
            }
    return resultado;
    }

    public int quilometrosPlanoTreino (Utilizador utilizador){
        String userCode = utilizador.getCodigoUtilizador();
        
        for(String code : this.planosTreino.keySet()){
            if ((userCode.equals(code))) {
                return this.planosTreino.get(code).quilometrosPercorridosPlanoSemanal();
            }
        }
        return 0;
    }

    public int metrosAltimetriaPlanoTreino (Utilizador utilizador){
        String userCode = utilizador.getCodigoUtilizador();
        
        for(String code : this.planosTreino.keySet()){
            if ((userCode.equals(code))) {
                return this.planosTreino.get(code).metrosAltimetriaPlanoSemanal();
            }
        }
        return 0;
    }

}