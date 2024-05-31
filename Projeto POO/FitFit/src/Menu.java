import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public abstract class Menu implements Serializable{

    private String userCode;
    
    private Utilizadores utilizadores;
    private ListaAtividades lAtividades;
    private PlanosTreino planosTreino;

    //private static final long serialVersionUID = 1L;

    //Construtores: 
    //Construtor Parametrizado:
    public Menu(Utilizadores utilizadores, ListaAtividades lAtividades, PlanosTreino planosTreino){
        this.utilizadores = utilizadores;
        this.lAtividades = lAtividades;
        this.planosTreino = planosTreino;
    }

    // Construtor por Omissão:
    public Menu(){
        this.utilizadores = new Utilizadores();
        this.lAtividades = new ListaAtividades();
        this.planosTreino = new PlanosTreino();
    }

    // Construtor Cópia
    public Menu(Menu m){
        this.utilizadores = m.getUtilizadores();
        this.lAtividades = m.getListaAtividades();
        this.planosTreino = m.getPlanosTreino();
    }

    // Getters e Setters:
    public Utilizadores getUtilizadores(){
        return this.utilizadores;
    }

    public void setUtilizadores(Utilizadores utilizadores){
        this.utilizadores = utilizadores;
    }

    public ListaAtividades getListaAtividades(){
        return this.lAtividades;
    }

    public void setListaAtividades(ListaAtividades lAtividades){
        this.lAtividades = lAtividades;
    }

    public PlanosTreino getPlanosTreino(){
        return this.planosTreino;
    }

    public void setPlanosTreino(PlanosTreino planosTreino){
        this.planosTreino = planosTreino;
    }

    public String getUserCode(){
        return this.userCode;
    }

    public void setUserCode(String userCode){
        this.userCode = userCode;
    }

    public Menu carregarDados(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Menu menu = (Menu) ois.readObject();
        ois.close();
        return menu;
    }

    public void gravarDados(String fileName) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    //TODO: Talvez por isto tudo dentro de um método só

    // Métodos responsaveis por retornar os utilizadores ordenados pelos diversos rankings possiveis:
    // Ranking por calorias
    public List<Utilizador> ordenaPorCalorias(){
        return this.utilizadores.getUtilizadores().stream().sorted((u1,u2) -> (int) (this.planosTreino.caloriasPlanoTreino(u2) - this.planosTreino.caloriasPlanoTreino(u1))).collect(Collectors.toList());
    }

    // Ranking por número de atividades
    public List<Utilizador> ordenaPorNAtividades(){
        return this.utilizadores.getUtilizadores().stream().sorted((u1,u2) -> (this.planosTreino.atividadesPlanoTreino(u2) - this.planosTreino.atividadesPlanoTreino(u1))).collect(Collectors.toList());
    }
    
    // Método para Inicializar alguns utilizadores genéricos diferentes
    public void initUtilizadores(){
        Utilizador utilizador1 = new Utilizador("Gabi" , "Gabriel Antunes", "Rua 29 de junho", "gayenzoop24@.com", 50, 80, 175, Dificuldades.PROFISSIONAL, "M");
        Utilizador utilizador2 = new Utilizador("Rita" , "Rita Pereira", "Rua 29 de junho", "ritapereira@.com", 50, 80, 175, Dificuldades.AMADOR, "F");
        Utilizador utilizador3 = new Utilizador("Joao" , "Joao Pereira", "Rua 29 de junho", "joaopereira@.com", 50, 80, 175, Dificuldades.PRATICANTE_OCASIONAL, "M");
        Utilizador utilizador4 = new Utilizador("Guigui" , "Guilherme Pinho", "SubPortela", "guilhermepP@.com", 50, 80, 175, Dificuldades.PROFISSIONAL, "M");
        Utilizador utilizador5 = new Utilizador("Marta" , "Marta Pereira", "Rua 29 de junho", "martapereira@.com", 50, 80, 175, Dificuldades.PROFISSIONAL, "F");

        for(Utilizador utilizador : new Utilizador[]{utilizador1, utilizador2, utilizador3, utilizador4, utilizador5}){
            if(!containsUtilizador(utilizador)){
                this.utilizadores.add(utilizador);
            }
        }
    }

    // Método que inicialia a lista de atividades com algumas atividades genéricas
    public void initAtividades(){

        Atividades atividade1 = new Distancia("Corrida", LocalDate.now(), 10, TipoAtividade.DISTANCIA, 5);
        Atividades atividade2 = new Altimetria("Trail Corrida", LocalDate.now(), (double) 10, TipoAtividade.ALTIMETRIA, 5, 10, 10);
        Atividades atividade3 = new Altimetria("Ciclismo", LocalDate.now(), (double) 15, TipoAtividade.ALTIMETRIA, 5, 10, 10);
        Atividades atividade4 = new RepeticoesPeso("Natação", LocalDate.now(), (double) 10, TipoAtividade.REPETICOES_PESO, 10, 20);
        Atividades atividade5 = new Repeticoes("Flexões", LocalDate.now(), (double) (10), TipoAtividade.REPETICOES, 20);
        Atividades atividade6 = new Distancia("Natação", LocalDate.now(), 5, TipoAtividade.REPETICOES, 20);

        for(Atividades atividade : new Atividades[]{atividade1, atividade2, atividade3, atividade4, atividade5, atividade6}){
            if(containsAtividade(atividade)){
                this.lAtividades.add(atividade);
            }
        }
    }
    

    // Método login vai retornar o utilizador que está a controlar a app no momento consoante o log
    public abstract String logIn();

    // Método que vai para o menu principal da app
    public abstract void mainMenu();

    // Os proximos metodos sao auxiliares para apresentar as ramificações no menu principal
    protected abstract boolean mainMenu1();
    protected abstract void mainMenu2();
    protected abstract void mainMenu3();
    protected abstract void mainMenu4();
    protected abstract void mainMenu5();
    protected abstract boolean mainMenu6();

    // Método auxiliar para registar uma atividade
    protected abstract void registarAtividade();

    // Método que verifica se contém
    private boolean containsUtilizador(Utilizador utilizador){
        return this.utilizadores.contains(utilizador);
    }

    // Método que verifica se contém
    private boolean containsAtividade(Atividades atividade){
        return this.lAtividades.contains(atividade);
    }
}