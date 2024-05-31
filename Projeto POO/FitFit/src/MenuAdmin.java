import java.util.Scanner;
import java.time.LocalDate;

public class MenuAdmin extends Menu {

    // Construtores:
    // Construtor por Omissão
    public MenuAdmin(){
        super();
    }

    // Construtor com Parametrizado
    public MenuAdmin(Utilizadores utilizadores, ListaAtividades lAtividades, PlanosTreino planosTreino){
        super(utilizadores, lAtividades, planosTreino);
    }

    // Construtor Cópia
    public MenuAdmin(Menu menu){
        super(menu);
    }

    // extensão do método abstrato logIn() caso o utilizador queira abrir a app em modo admin (tendo mais acessos)
    @Override   
    public String logIn() {
        Scanner input = new Scanner(System.in);

        System.out.println("");

        String passAdmin = "";
        int i = 4;

        while(i > 0){
            if(i != 4){
                System.out.println("Tem apenas mais " + i + " tentativas!");
            }   
            System.out.print("Introduza a Password: ");
            passAdmin = input.nextLine();

            i--;

            if(!passAdmin.equals("Admin")){
                System.out.println("");
                System.out.println("!!! Acesso negado !!!");
                System.out.println("");
            } else {
                System.out.println("");
                System.out.println("Acesso concedido!");
                System.out.println("");
                setUserCode("Admin");
                return "Admin";
            }
        
        }
        return "";
    }

    // Método que que apresenta o menu caso o utlizador atual seja o administrador
    @Override
    public void mainMenu(){
        Scanner input = new Scanner(System.in);

        boolean run = true;
        
        while(run){
            System.out.println("----------------------------- FitFit ------------------------------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("--------- Utilizadores [1] ----------------------------------------");
            System.out.println("--------- Atividades [2] ------------------------------------------");
            System.out.println("--------- Planos de Treino [3] ------------------------------------");
            System.out.println("--------- Simulação [4] -------------------------------------------");
            System.out.println("--------- Ranking [5] ---------------------------------------------");
            System.out.println("--------- Sair [6] ------------------------------------------------");
            System.out.println("-------------------------------------------------------------------");

            int opcaoMenu = input.nextInt();
            input.nextLine();

            switch(opcaoMenu){
                case 1:
                    mainMenu1();
                    break;

                case 2:
                    mainMenu2();
                    break;

                case 3: 
                    mainMenu3();
                    break;

                case 6:
                    run = false;
                    break;
            }
        }
    }

    // Método caso o Utilizador selecione a opção Utilizadores
    protected boolean mainMenu1(){
        Scanner input = new Scanner(System.in);

        boolean run = true;
        while(run){
            System.out.println("----------------------------- FitFit ------------------------------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("--------- Ver lista de Utilizadores [1] ---------------------------");
            System.out.println("--------- Banir Utilizador [2]-------------------------------------");
            System.out.println("--------- Voltar [3] ----------------------------------------------");
            System.out.println("-------------------------------------------------------------------");

            int opcaoMenu1 = input.nextInt();

            if(opcaoMenu1 == 1){
                // TODO: criar método para mostrar apenas os usernames
                System.out.println(getUtilizadores().listaUsers());
            } else if (opcaoMenu1 == 2) {
                System.out.println(getUtilizadores().listaUsers());
                //System.out.println("");
                System.out.print("Introduza a posição do utilizador que deseja remover: ");
                int removeThis = input.nextInt() - 1;
                getUtilizadores().remove(removeThis);
                System.out.println("");
                System.out.println("Utilizador Banido com Sucesso!");
                System.out.println("");
                System.out.println("Nova lista de Utilizadores: ");
                System.out.println(getUtilizadores().listaUsers());
                System.out.println("");
            } else {
                run = false;
                System.out.println("");
            }
        }
        return true;
    }

    // Método caso o Utilizador selecione a opção Atividades
    protected void mainMenu2(){
        Scanner input = new Scanner(System.in);

        boolean run = true;

        while(run){
            System.out.println("----------------------------- FitFit ------------------------------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("--------- Ver lista de Atividades [1] -----------------------------");
            System.out.println("--------- Adicionar Atividade [2] ---------------------------------");
            System.out.println("--------- Remover Atividade [3] -----------------------------------");
            System.out.println("--------- Voltar [4] ----------------------------------------------");
            System.out.println("-------------------------------------------------------------------");

            int opcaoMenu2 = input.nextInt();
            input.nextLine();
            System.out.println("");

            switch(opcaoMenu2){
                case 1:
                    System.out.println(getListaAtividades().toString());
                    System.out.println("");
                    break;

                case 2:
                    registarAtividade();
                    break;

                case 3:
                    System.out.println(getListaAtividades().listaAtividades());
                    System.out.print("Introduza a posição da atividade que deseja remover: ");
                    int removeThis = input.nextInt() - 1;
                    getListaAtividades().remove(removeThis);
                    System.out.println("");
                    System.out.println("Atividade Banido com Sucesso!");
                    System.out.println("");
                    System.out.println("Nova lista de Atividades: ");
                    System.out.println(getListaAtividades().listaAtividades());
                    System.out.println("");
                    break;

                case 4:
                    run = false;
                    break;
            }
        }
    }

    protected void mainMenu3(){
        Scanner input = new Scanner(System.in);

        int opcaoMenu3 = 0;
        boolean run = true;

        while(run){

            System.out.println("----------------------------- FitFit ------------------------------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("--------- Ver lista de Planos de treino [1] -----------------------");
            System.out.println("--------- Remover Plano de Treino [2]------------------------------");
            System.out.println("--------- Voltar [3] ----------------------------------------------");
            System.out.println("-------------------------------------------------------------------");

            opcaoMenu3 = input.nextInt();

            switch(opcaoMenu3){
                case 1:
                    System.out.println(getPlanosTreino().toString());
                    break;

                case 2:
                    System.out.println(getPlanosTreino().listaPlanosTreino());
                    System.out.print("Introduza a posição do plano de treino que deseja remover: ");
                    int removeThis = input.nextInt() - 1;
                    getPlanosTreino().remove(getPlanosTreino().getThis(removeThis));
                    System.out.println("");
                    System.out.println("Plano de Treino Removido com Sucesso!");
                    System.out.println("");
                    System.out.println("Nova lista de Planos de Treino: ");
                    System.out.println(getPlanosTreino().listaPlanosTreino());
                    System.out.println("");
                    break;

                case 3:
                    run = false;
                    break;
            }
        }
    }

    protected void mainMenu4(){
        Scanner input = new Scanner(System.in);
    }

    protected void mainMenu5(){}
    protected boolean mainMenu6(){return true;}   
    
    // Método que regista uma atividade caso o utilizador seja o administrador
    protected void registarAtividade(){
        Scanner input = new Scanner(System.in);

        System.out.print("Introduza o nome da atividade: ");
        String nomeAtividade = input.nextLine();
        System.out.println("");

        LocalDate data = LocalDate.now();
        System.out.println(data.toString());
        System.out.println("");

        System.out.println("(Referencia: Corrida: / Alongamentos: )");
        System.out.println("Introduza a duração base para esta atividade:");
        double duracao = input.nextDouble();
        input.nextLine();
        System.out.println("");

        System.out.println("----------------------------- FitFit ------------------------------");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--------------- Como caracteriza esta atividade? ------------------");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("---------------- Atividade de Distância [1] -----------------------");
        System.out.println("---------------- Atividade de Altimetria [2] ----------------------");
        System.out.println("---------------- Atividade de Repetição [3] -----------------------");
        System.out.println("---------------- Atividade de Repetição/Peso [4] ------------------");
        System.out.println("-------------------------------------------------------------------");

        int opcaoTipo = input.nextInt();
        input.nextLine();

        TipoAtividade tipo = TipoAtividade.ALTIMETRIA;
        
        Atividades newAtividade = new Distancia();

        double distancia;
        int repeticoes;

        switch(opcaoTipo) {
            case 1:
                tipo = TipoAtividade.DISTANCIA;

                System.out.println("(Referencia: Corrida: / Trail Corrida: )");
                System.out.println("Introduza a distância base em Km's: ");
                distancia = input.nextDouble();
                input.nextLine();
                System.out.println("");

                newAtividade = new Distancia(nomeAtividade, data, duracao, tipo, distancia);
                break;
            case 2:
                tipo = TipoAtividade.ALTIMETRIA;

                System.out.println("(Referencia: Trail Corrida / Trail Bicicleta: )");
                System.out.println("Introduza a altura Máxima base em Metros: ");
                int alturaMax = input.nextInt();
                input.nextLine();
                System.out.println("");

                System.out.println("(Referencia: Trail Corrida / Trail Bicicleta: )");
                System.out.println("Introduza a altura Média base em Metros: ");
                int alturaMedia = input.nextInt();
                input.nextLine();
                System.out.println("");

                System.out.println("(Referencia: Corrida: / Trail: )");
                System.out.println("Introduza a distância base em Km's: ");
                distancia = input.nextDouble();
                input.nextLine();
                System.out.println("");

                newAtividade = new Altimetria(nomeAtividade, data, duracao, tipo, alturaMax, alturaMedia, distancia);
                break;
            case 3:
                tipo = TipoAtividade.REPETICOES;

                System.out.println("(Referencia: Trail Corrida / Trail Bicicleta: )");
                System.out.println("Introduza o número de repetições base em Metros: ");
                repeticoes = input.nextInt();
                input.nextLine();
                System.out.println("");

                newAtividade = new Repeticoes(nomeAtividade, data, duracao, tipo, repeticoes);
                break;
            case 4: 
                tipo = TipoAtividade.REPETICOES_PESO;

                System.out.println("(Referencia: Trail Corrida / Trail Bicicleta: )");
                System.out.println("Introduza o número de repetições base em Metros: ");
                repeticoes = input.nextInt();
                input.nextLine();
                System.out.println("");

                System.out.println("(Referencia: Trail Corrida / Trail Bicicleta: )");
                System.out.println("Introduza o número de repetições base em Metros: ");
                int pesoHaltere = input.nextInt();
                input.nextLine();
                System.out.println("");

                newAtividade = new RepeticoesPeso(nomeAtividade, data, duracao, tipo, repeticoes, pesoHaltere);
                break;
        }

        getListaAtividades().add(newAtividade);
        System.out.println("Nova atividade Registada com sucesso!");
        System.out.println("");
        System.out.println("Prima Enter para Continuar...");
        input.nextLine();
    }
}