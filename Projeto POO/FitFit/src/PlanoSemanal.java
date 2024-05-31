import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.time.LocalDate;

public class PlanoSemanal implements Serializable{
    
    private LinkedHashMap<String,ListaAtividades> planoSemanal;

    // Contrutores:
    // Construtor por omissão
    public PlanoSemanal(){
        this.planoSemanal = new LinkedHashMap<String,ListaAtividades>();
    }

    // Construtor Parametrizado
    public PlanoSemanal(HashMap<String,ListaAtividades> planoSemanal){
        this.planoSemanal = new LinkedHashMap<String,ListaAtividades>();
        for(String key : planoSemanal.keySet()){
            this.planoSemanal.put(key, planoSemanal.get(key).clone());
        }
    }

    // Construtor de cópia
    public PlanoSemanal(PlanoSemanal pS){
        this.planoSemanal = pS.getPlanoSemanal();
    }

    // Getters e Setters
    public LinkedHashMap<String,ListaAtividades> getPlanoSemanal(){
        LinkedHashMap<String,ListaAtividades> novo = new LinkedHashMap<String,ListaAtividades>();
        for(String key : this.planoSemanal.keySet()){
            novo.put(key, this.planoSemanal.get(key).clone());
        }
        return novo;
    }

    public void setPlanoSemanal(HashMap<String,ListaAtividades> planoSemanal){
        this.planoSemanal = new LinkedHashMap<String,ListaAtividades>();
        for(String key : planoSemanal.keySet()){
            this.planoSemanal.put(key, planoSemanal.get(key).clone());
        }
    }

    // Métodos Uteis
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String key : this.planoSemanal.keySet()){
            sb.append( key + " \n: " + this.planoSemanal.get(key).toString());
        }
        return sb.toString();
    }

    public PlanoSemanal clone(){
        return new PlanoSemanal(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        PlanoSemanal pS = (PlanoSemanal) o;
        return this.planoSemanal.equals(pS.getPlanoSemanal());
    }

    // Método que adiciona uma lista de atividades a um dos dias da semana.
    public void put(String dia, ListaAtividades lAtividades){
        this.planoSemanal.put(dia, lAtividades.clone());
    }

    public void choose4(int index, ListaAtividades lAtividades, Utilizador utilizador){
        Scanner input = new Scanner(System.in);
        ListaAtividades atividadesDoDia = new ListaAtividades();
        Random random = new Random();
        Atividades atividade;
        if (!lAtividades.isEmpty()) {
            for(int i = 0; i < 4; i++){
                atividade = lAtividades.get(random.nextInt(lAtividades.size()));
                Atividades atividadeCopia = atividade.clone();
                atividadeCopia.geraVariante(utilizador);
                atividadesDoDia.add(atividadeCopia);
            }
        } else {
            System.out.println("Não existem atividades Registadas");
            System.out.print("Prima enter para voltar atrás na aplicação");            
            input.nextLine();
        }
        String weekDay = index2WeekDay(index);
        this.planoSemanal.put(weekDay, atividadesDoDia);
    }

    // Método para o caso de utilizador escolher construir um plano de forma Manual
    //neste caso ele pode escolher as atividades que constam no seu plano de treino
    public void userChoose4(int index, ListaAtividades lAtividades, Utilizador utilizador, LocalDate dataAtividade){
        Scanner input = new Scanner(System.in);
        ListaAtividades atividadesDoDia = new ListaAtividades();
        Atividades atividade;

        System.out.println("Escolha as quatro atividades para o seu plano de treino");
        boolean run = true;

        while (run) {

            for(int i = 0; i < 4; i++){
                System.out.println(lAtividades.listaAtividades());
                int addThis = input.nextInt() - 1;

                atividade = lAtividades.getThisAtividade(addThis);
                Atividades atividadeCopia = atividade.clone();

                atividadeCopia.geraVariante(utilizador);
                atividadeCopia.setData(dataAtividade);

                atividadesDoDia.add(atividadeCopia);
                if(i<3){
                    System.out.println("Atividade adicionada com sucesso ao plano de treino!!!"+ "\n"+
                    "Continue a adicionar");
                }
            }

            String weekDay = index2WeekDay(index);
            this.planoSemanal.put(weekDay, atividadesDoDia);

            System.out.println("O seu plano de treino ficou neste fromato:");
            System.err.println(atividadesDoDia);
            System.out.println("");
            System.out.println("Está de acordo com o plano que escolheu? [Sim/Não]");
            input.nextLine();
            String opcao = input.nextLine().toLowerCase();
            if(opcao.equals("sim") || opcao.equals("s")){
                run = false;
                System.out.println("");
                System.out.print("Prima enter para avançar...");
                input.nextLine();
            } else {
                atividadesDoDia.clear();
                System.out.println("");
                System.out.println("Volte a definir o plano de treino para " + weekDay);
                System.out.print("Prima enter para avançar...");
                input.nextLine();
            } 

        }
    }

    private String index2WeekDay(int index){
        switch(index){
            case 0:
                return"Domingo";
                
            case 1:
                return"Segunda";

            case 2:
                return"Terça";
    
            case 3:
                return"Quarta";

            case 4:
                return"Quinta";
    
            case 5:
                return"Sexta";

            case 6:
                return "Sábado";
        }
        return null;
    }

    public Set<String> keySet(){
        return this.planoSemanal.keySet();
    }

    public ListaAtividades get(String weekDay){
        return this.planoSemanal.get(weekDay);
    }

    public double caloriasPlanoSemanal(Utilizador utilizador){
        double caloriasTotais = 0;
        for(String key : this.planoSemanal.keySet()){
            caloriasTotais += this.planoSemanal.get(key).calculoCaloriasLa(utilizador);
        }
        return caloriasTotais;
    }

    public int numeroAtividadePlanoSemanal(){
        int numeroAtividadesTotais = 0;
        for(String key : this.planoSemanal.keySet()){
            numeroAtividadesTotais += this.planoSemanal.get(key).calculoNumeroAt();
        }
        return numeroAtividadesTotais;
    }

    public int[] numeroTipoAtividade() {
        int[] numeroTipoAtividadeSemanal = new int[4];
        
        for (String key : this.planoSemanal.keySet()) {
            int[] valoresAtividade = this.planoSemanal.get(key).numeroTipoAtividade();
            
            // Somar os valores das mesmas posições
            for (int i = 0; i < valoresAtividade.length; i++) {
                numeroTipoAtividadeSemanal[i] += valoresAtividade[i];
            }
        }
        return numeroTipoAtividadeSemanal;
    }

    public int quilometrosPercorridosPlanoSemanal(){
        int quilometrosPlanoSemanal = 0;

        for(String key : this.planoSemanal.keySet()){
            quilometrosPlanoSemanal += this.planoSemanal.get(key).quilometrosPercorridos();
        }
        return quilometrosPlanoSemanal;
    }

    public int metrosAltimetriaPlanoSemanal(){
        int metrosTotalPS = 0;

        for(String key : this.planoSemanal.keySet()){
            metrosTotalPS += this.planoSemanal.get(key).metrosAltimetria();
        }
        return metrosTotalPS;
    }

    
}