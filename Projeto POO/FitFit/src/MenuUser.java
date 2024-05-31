import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;

public class MenuUser extends Menu{

    // Construtores:
    // Construtor Parametrizado:
    public MenuUser(Utilizadores utilizadores, ListaAtividades lAtividades, PlanosTreino planosTreino){
        super(utilizadores, lAtividades, planosTreino);
    }
    
    //protected Scanner input = new Scanner(System.in);
    Verificacoes verificacoes = new Verificacoes();

    // Extensão do método abstrato logIn() caso o utilizador queira abrir a app em modo utilizador
    @Override
    public String logIn(){
            Scanner input = new Scanner(System.in);

            String userAtual = "";
            System.out.println("-------------------------------------------------------------------");
            System.out.println("------------------ Se já tiver conta prima [1] --------------------");
            System.out.println("------------------ Se não tiver conta prima [2] -------------------");
            System.out.println("-------------------------------------------------------------------");

            int opcaoConta = input.nextInt();
            input.nextLine();

            if(opcaoConta == 2) {
                userAtual = signUp();
            } else if(opcaoConta == 1){
                userAtual = signIn();
            }

        setUserCode(userAtual);
        return userAtual;
    }

    // Método auxiliar caso o utilizador ainda não esteja registado na app
    private String signUp(){
        Scanner input = new Scanner(System.in);

        System.out.println("Registe-se no FitFit");
        System.out.println("");
        System.out.print("Introduza o seu UserName: ");
        String userName = input.nextLine();

        while(userName.length() < 4 || getUtilizadores().codigoRegistado(userName)){
            if(userName.length() < 4) {
                System.out.println("Tamanho Mínimo do UserName são 4 caracteres");
            } else {
                System.out.println("Esse UserName já está registado!");
            }
            System.out.println("");
            System.out.print("Introduza o seu UserName: ");
            userName = input.nextLine();
            System.out.println("");
        }

        System.out.println("UserName registado com sucesso");
        System.out.println("");
        System.out.print("Introduza o seu Nome: ");
        String nome = input.nextLine();
        System.out.println("");
        System.out.print("Introduza a sua morada: ");
        String morada = input.nextLine();
        System.out.println("");
        System.out.print("Introduza o seu email: ");
        String email = input.nextLine();
        while(!verificacoes.emailValido(email) || getUtilizadores().emailRegistado(email)){
            System.out.println("");
            System.out.print("O email que introduziu é inválido ou ja se encontra registado. Introduza novamente: ");
            email = input.nextLine();
        }
        
        System.out.println("");
        System.out.print("Introduza a sua FCM: ");
        int FCM = input.nextInt();
        System.out.println("");
        System.out.print("Introduza a sua altura (em cms): ");
        int altura = input.nextInt();
        System.out.println("");
        System.out.print("Introduza o seu peso: ");
        double peso = input.nextDouble();
        System.out.println("");

        System.out.println("Qual considera que seja o seu Nível Atlético");
        System.out.println("------------------------------------------");
        System.out.println("--------- Praticante Ocasional [1] -------");
        System.out.println("--------- Amador [2] ---------------------");
        System.out.println("--------- Profissional [3] ---------------");
        System.out.println("------------------------------------------");
        int opcaoNivel = input.nextInt();
        input.nextLine();
        Dificuldades nivel = Dificuldades.AMADOR;
        switch (opcaoNivel) {

            case 1: 
                nivel = Dificuldades.PRATICANTE_OCASIONAL;
                break;

            case 2: 
                nivel = Dificuldades.AMADOR;
                break;

            case 3: 
                nivel = Dificuldades.PROFISSIONAL;
                break;
        }
        
        System.out.println("");
        System.out.print("Introduza o seu sexo [M/F]: ");

        String sexo = input.nextLine();

        Utilizador newUser = new Utilizador(userName, nome, morada, email, FCM, peso, altura, nivel, sexo);
        getUtilizadores().add(newUser);
        System.out.println(getUtilizadores().toString());
        return userName;
    }

    // Método auxiliar para o caso de o utilizador já estar registado na app
    private String signIn(){

        Scanner input = new Scanner(System.in);

        boolean invalidInput = true;

        String userAtual = "";
        
        while (invalidInput) {
            System.out.print("Introduza o seu UserName ou o seu email: ");
            String log = input.nextLine();
            System.out.println("");
            if (getUtilizadores().codigoRegistado(log) || getUtilizadores().emailRegistado(log)) {
                if (getUtilizadores().codigoRegistado(log)) {
                    userAtual = log;
                    invalidInput = false;
                } else {
                    userAtual = getUtilizadores().emailToUser(log);
                    invalidInput = false;
                } 
            } else {
                System.out.println("Código ou email não encontrados");
                System.out.println("Tente outro");
                System.out.println("");
            }
        }
        
        System.out.print("Loading ");
        // Delay para simular loading
        try {
            Thread.sleep(500);
            System.out.print(". ");
            Thread.sleep(500);
            System.out.print(". ");
            Thread.sleep(500);
            System.out.println(". ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("Bem-vindo de volta " + userAtual + "!");
        System.out.println("");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // TODO: Talvez acrescentar palavra passe
        return userAtual;
    }
        
    // Metodo que apresenta o menu caso o utilizador atual seja um utilizador regular
    @Override        
    public void mainMenu(){
        Scanner input = new Scanner(System.in);

        boolean run = true;
        while(run) {
            System.out.println("--------------------------- FitFit --------------------------------");        
            System.out.println("-------------------------------------------------------------------");
            System.out.println("------------ Conta [1] --------------------------------------------");
            System.out.println("------------ Atividades [2] ---------------------------------------");
            System.out.println("------------ Plano de Treino [3] ----------------------------------");
            System.out.println("------------ Simulação [4] ----------------------------------------");
            System.out.println("------------ Ranking [5] ------------------------------------------");
            System.out.println("------------ Sair [6] ---------------------------------------------");
            System.out.println("-------------------------------------------------------------------");
        
            int opcaoMenu = input.nextInt();

            switch(opcaoMenu){
                case 1:
                    if(!mainMenu1()){
                        return;
                    }
                    break;
                case 2:
                    mainMenu2();
                    break;
                case 3:
                    mainMenu3();
                    break;
                case 4:
                    mainMenu4();
                    break;
                case 5:
                    mainMenu5();
                    break;
                case 6:
                    if(!mainMenu6()){
                        return;
                    }
                    break;
        }
    }
}

    // Metodo caso o utilizador escolha a opcao Conta
    protected boolean mainMenu1(){
        Scanner input = new Scanner(System.in);

        boolean run = true;
        while(run){

            System.out.println("--------------------------- FitFit --------------------------------");        
            System.out.println("-------------------------------------------------------------------");
            System.out.println("------------ Ver Conta [1] ----------------------------------------");
            System.out.println("------------ Mudar Nível [2] --------------------------------------");
            System.out.println("------------ Alterar peso/altura [3] ------------------------------");
            System.out.println("------------ Eliminar Conta [4] -----------------------------------");
            System.out.println("------------ Voltar [5] ------------------------------------------");
            System.out.println("-------------------------------------------------------------------");

            int opcaoMenu2 = input.nextInt();

            switch (opcaoMenu2) {
                case 1:
                    System.out.println(getUtilizadores().getThisUtilizador(getUserCode()).toString());
                    System.out.println("");
                    System.out.println("Prima Enter para continuar...");
                    // Um destes inputs lê o "espaço" que ficou no buffer e o outro lê o enter para prosseguir
                    input.nextLine();
                    input.nextLine();
                    break;

                case 2:
                    mudaNivel();
                    break;
                
                case 3:   
                    System.out.print("Introduza o seu Peso atual: ");
                    double peso2 = input.nextDouble();
                    System.out.print("Introduza a sua Altura atual: ");
                    int altura2 = input.nextInt();

                        getUtilizadores().getThisUtilizador(getUserCode()).setPeso(peso2);
                        getUtilizadores().getThisUtilizador(getUserCode()).setAltura(altura2);
                        System.out.println("Os seus Dados foram atualizados!");
                    break;
                
                case 4:
                    boolean run1 = true;
                    while(run1){
                        System.out.println("Tem a certeza que pertende eliminar a sua conta?");
                        System.out.print("Digite 'Sim' para continuar... ");
                        input.nextLine();
                        String case4 = input.nextLine().toLowerCase();
                        if(case4.equals("sim") || case4.equals("s")){

                            System.out.println("A sua conta foi eliminada com sucesso!!!");
                            getUtilizadores().remove(getUtilizadores().getUserIndex(getUserCode()));
                            System.out.println("Prima enter para sair da aplicação");
                            input.nextLine();
                            return false;

                        } else {
                            run1 = false;
                        }
                    }
                    break;
                    
                case 5:
                    run = false;
                    break;

                default:
                    break;
            }
        }
        return true;
    }

    // Metodo caso o utilizador escolha a opcao atividades
    protected void mainMenu2(){
        Scanner input = new Scanner(System.in);

        boolean run = true;
        while (run) {
            
            System.out.println("--------------------------- FitFit --------------------------------");        
            System.out.println("-------------------------------------------------------------------");
            System.out.println("------------ Ver Atividades [1] -----------------------------------");
            System.out.println("------------ Registar Atividade [2] -------------------------------");
            System.out.println("------------ Voltar [3] -------------------------------------------");
            System.out.println("-------------------------------------------------------------------");            

            int opcaoMenu2 = input.nextInt();
    
            if(opcaoMenu2 == 1){
                System.out.println(getListaAtividades().listaAtividades());
            }else if(opcaoMenu2 == 2){
                if(getPlanosTreino().contains(getUserCode())){
                    registarAtividade();
                } else {
                    System.out.println("Ainda não tem Plano de Treino registado");
                }
            }else{
                run = false;
            }       
    }
    }
    // Metodo caso o utilizador escolha a opcao plano de treino
    protected void mainMenu3(){
        Scanner input = new Scanner(System.in);

        boolean run = true;
        while (run) {
            
            System.out.println("--------------------------- FitFit --------------------------------");        
            System.out.println("-------------------------------------------------------------------");
            System.out.println("------------ Ver Plano Treino [1] ---------------------------------");
            System.out.println("------------ Criar Plano de Treino [2] ----------------------------");
            System.out.println("------------ Voltar [3] -------------------------------------------");
            System.out.println("-------------------------------------------------------------------");            


            int opcaoMenu3 = input.nextInt();

            if(opcaoMenu3 == 1){
                PlanoSemanal plano = getPlanosTreino().get(getUserCode());
                    if (plano == null) {
                        System.out.println("Ainda não tem Plano de Treino");
                        System.out.println("Não perca mais tempo e va fazer o seu!!!");
                        System.out.print("Prima enter para avançar...");
                        input.nextLine();
                        input.nextLine();

                    } else {
                        System.out.println(plano.toString());
                        System.out.print("Prima enter para avançar...");
                        input.nextLine();
                        input.nextLine();

                    }
            }else if(opcaoMenu3 == 2){
                criarPlano();
            }
            else{
                run = false;
            }
        }
        }

    // Metodo caso o utilizador escolha a opcao Simulaçao
    protected void mainMenu4(){
    }

    // Metodo caso o utilizador escolha a opcao salvar
    protected void mainMenu5(){
        Scanner input = new Scanner(System.in);
        
        boolean run = true;

        while (run) {
            
            System.out.println("--------------------------- FitFit --------------------------------");        
            System.out.println("-------------------------------------------------------------------");
            System.out.println("------------ Ranking calorias perdidas [1] ------------------------");
            System.out.println("------------ Ranking número de atividades [2] ---------------------");
            System.out.println("------------ Ranking tipo de atividade [3] ------------------------"); 
            System.out.println("------------ Ranking quilometros percorridos [4] ------------------");        
            System.out.println("------------ Ranking Altimetria [5] -------------------------------");        
            System.out.println("------------ Ranking Plano de treino [6] --------------------------");        
            System.out.println("------------ Voltar [7] -------------------------------------------");
            System.out.println("-------------------------------------------------------------------");
            
            int opcao = input.nextInt();
            
            switch (opcao) {
                case 1:
                int j = 0;
                for(Utilizador utilizador: ordenaPorCalorias()){
                    System.out.println( j + 1 + "º lugar: " + utilizador.getCodigoUtilizador() + " Com " + getPlanosTreino().caloriasPlanoTreino(utilizador) + " calorias gastas!");
                    j++;
                }

                    break;
                case 2:
                    
                    break;
                case 3:

                    ArrayList<String> tiposAtividades = new ArrayList<>();
                    tiposAtividades.add("Altimetria");
                    tiposAtividades.add("Distancia");
                    tiposAtividades.add("Repetições");
                    tiposAtividades.add("Repetições com Peso");

                    List<Integer> NTipoAtividades = this.getPlanosTreino().tipoAtividadesPlanoTreino();

                    for(int i = 0; i < 4; i++){
                        System.out.println(tiposAtividades.get(i) + ": " + NTipoAtividades.get(i));
                    }
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    run = false;
                    break;
        
                default:
                    break;
            }
        }
    }
    
    // Metodo caso o utilizador escolha a opcao sair
    protected boolean mainMenu6(){

        Scanner input = new Scanner(System.in);

            
            System.out.println("-------------------------------------------------------------------");
            System.out.println("------------ Trocar de Conta [1] ----------------------------------");
            System.out.println("------------ Fechar [2] -------------------------------------------");
            System.out.println("------------ Voltar [3] -------------------------------------------");
            System.out.println("-------------------------------------------------------------------");            

            int opcaoMenu6 = input.nextInt();

            switch (opcaoMenu6) {
                case 1:
                    break;
            
                case 2:
                    return false;
                case 3:
                    break;
            }
            return true;

        }

    // Metodo auxiliar caso o utilizador queira registar uma atividade praticada
    protected void registarAtividade(){
        Scanner input = new Scanner(System.in);
                
        System.out.print("Introduza a atividade que praticou: ");
        String nome = input.nextLine();

        LocalDate data = LocalDate.now();
        System.out.println("Atividade registada a: " + data.toString());
        System.out.println("");
        
        System.out.print("Introduza a duracao que levou para realizar esta atividade em minutos: ");
        Double duracao = input.nextDouble();
        
        System.out.println("Introduza o tipo de atividade que realizou");
        System.out.println("");
        System.out.println("Altimetria [1]");
        System.out.println("Distancia [2]");
        System.out.println("Repetições [3]");
        System.out.println("Repetições com Peso [4]");
        System.out.println("");
        int opcao = input.nextInt();
        input.nextLine();
        
        TipoAtividade tipo = TipoAtividade.ALTIMETRIA;
        Atividades newAtividade = new Altimetria();
        int repeticoes;
        double distancia;
        int alturaMax;
        int alturaMedia;
        switch(opcao) {
            case 1: 
                tipo = TipoAtividade.ALTIMETRIA;
                System.out.print("Introduza a distancia que percorreu: ");
                distancia = input.nextDouble();
                
                System.out.print("Introduza a altura maxima que alcançou: ");
                alturaMax = input.nextInt();

                System.out.print("Introduza a altura media que percorreu: ");
                alturaMedia = input.nextInt();

                newAtividade = new Altimetria(nome ,data, duracao, tipo, alturaMax, alturaMedia, distancia);

                break;

            case 2: 
                tipo = TipoAtividade.DISTANCIA;
                System.out.print("Introduza a distancia que percorreu: ");
                distancia = input.nextDouble();

                newAtividade = new Distancia(nome, data,duracao,tipo, distancia);

                break;

            case 3: 
                tipo = TipoAtividade.REPETICOES;
                System.out.print("Introduza quantas repetições efetuou: ");
                repeticoes = input.nextInt();
                
                newAtividade = new Repeticoes(nome, data,duracao,tipo, repeticoes);

                break;

            case 4:
                tipo = TipoAtividade.REPETICOES_PESO;
                System.out.print("Introduza quantas repetições efetuou: ");
                repeticoes = input.nextInt();

                System.out.println("Introduza qual foi o peso utilizado nas repetições que efetuou: ");
                double pesoHaltere = input.nextDouble();

                newAtividade = new RepeticoesPeso(nome, data,duracao,tipo, repeticoes, pesoHaltere);
    
            default:
                break;
        }

        PlanoSemanal extra = getPlanosTreino().get(getUserCode());
        extra.get("Extra").add(newAtividade);
        getPlanosTreino().put(getUserCode(), extra);

        System.out.println("A sua atividade foi gravada com sucesso!!!");
                
        System.out.println("Prima enter para continuar");
        input.nextLine();
        input.nextLine();
    }

    private void mudaNivel(){
        Scanner input = new Scanner(System.in);

        boolean run = true;
        while (run) {
        System.out.println("--------------------------- FitFit --------------------------------");        
        System.out.println("-------------------------------------------------------------------");
        System.out.println("------------------ Introduza o seu novo Nivel ---------------------");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("------------ Profissional [1] -------------------------------------");
        System.out.println("------------ Amador [2] -------------------------------------------");
        System.out.println("------------ Praticante Ocasional [3] -----------------------------");
        System.out.println("------------ Voltar [4] -------------------------------------------");            
        System.out.println("-------------------------------------------------------------------");           
        
        int opcaoCase1 = input.nextInt();
        switch (opcaoCase1) {
            case 1:
                getUtilizadores().getThisUtilizador(getUserCode()).setNivel(Dificuldades.PROFISSIONAL);    
                System.out.println("O seu nivel foi atualizado com sucesso!!!");
                System.out.println("Prima enter para continuar");
                input.nextLine();
                input.nextLine();
                run = false;
                break;
        
            case 2:
                getUtilizadores().getThisUtilizador(getUserCode()).setNivel(Dificuldades.AMADOR);    
                System.out.println("O seu nivel foi atualizado com sucesso!!!");
                System.out.println("Prima enter para continuar");
                input.nextLine();
                input.nextLine();
                run = false;
                break;

            case 3:
                getUtilizadores().getThisUtilizador(getUserCode()).setNivel(Dificuldades.PRATICANTE_OCASIONAL);    
                System.out.println("O seu nivel foi atualizado com sucesso!!!");
                System.out.print("Prima enter para continuar");
                input.nextLine();
                input.nextLine();
                run = false;
                break;

            case 4:
                run = false;
                break;
                
            default:
                break;
        }
    }
}
    private void criarPlano(){
        Scanner input = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("--------------------------- FitFit --------------------------------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("------------ Plano de Treino (Aut) [1] ----------------------------");
            System.out.println("------------ Plano de Treino (Man) [2] ----------------------------");
            System.out.println("------------ Voltar [3] -------------------------------------------");            
            System.out.println("-------------------------------------------------------------------");
            
            int opcao = input.nextInt();
            PlanoSemanal planoSemanal = new PlanoSemanal();

            switch (opcao) {
                case 1:
                    planoSemanal = criaPlanoAut();
                    getPlanosTreino().put(getUserCode(), planoSemanal);
                    break;
            
                case 2:
                    planoSemanal = criarPlanoMan();
                    getPlanosTreino().put(getUserCode(), planoSemanal);
                    break;
                
                case 3:
                    run = false;
                    break;
            }
        }
    }


    private PlanoSemanal criaPlanoAut(){
        ArrayList<Boolean> diasDaSemana = new ArrayList<>();
        diasDaSemana = chooseDays();

        Utilizador utilizador = getUtilizadores().getThisUtilizador(getUserCode());
        PlanoSemanal planoSemanal = new PlanoSemanal();

        for(int i = 0; i < 7; i++){
            if(diasDaSemana.get(i)){
                planoSemanal.choose4(i, getListaAtividades(), utilizador);
            }
        }
        ListaAtividades empty = new ListaAtividades();
        planoSemanal.put("Extra", empty);

        return planoSemanal;
    }

    private PlanoSemanal criarPlanoMan(){

        Scanner input = new Scanner(System.in);
        ArrayList<Boolean> diasDaSemana = new ArrayList<>();
        diasDaSemana = chooseDays();

        Utilizador utilizador = getUtilizadores().getThisUtilizador(getUserCode());
        PlanoSemanal planoSemanal = new PlanoSemanal();
        if (getListaAtividades().size() == 0){
            System.out.println("Não existem atividades Registadas");
            System.out.print("Prima enter para voltar atrás na aplicação");
            input.nextLine();
        } else {
            System.out.println("Introduza a data em que começou a a praticar este Plano de Treino");
            System.out.println("Formato: \"yyyy-mm-dd\" / \"now\"");
            String strDataAtividade = input.nextLine();

            LocalDate dataAtividade = LocalDate.now();

            if(!strDataAtividade.equals("now")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dataAtividade = LocalDate.parse(strDataAtividade, formatter);
            }

            for(int i = 0; i < 7; i++){
                if(diasDaSemana.get(i)){
                    planoSemanal.userChoose4(i, getListaAtividades(), utilizador, dataAtividade);
                } 
            }
        }
        ListaAtividades empty = new ListaAtividades();
        planoSemanal.put("Extra", empty);

        return planoSemanal;
    }


    private ArrayList<Boolean> chooseDays(){
        Scanner input = new Scanner(System.in);
        int opcaoDias = 10;
        ArrayList<Boolean> diasDaSemana = new ArrayList<>();

        boolean Dom = false; diasDaSemana.add(Dom);
        boolean Seg = false; diasDaSemana.add(Seg);
        boolean Ter = false; diasDaSemana.add(Ter);
        boolean Qua = false; diasDaSemana.add(Qua);
        boolean Qui = false; diasDaSemana.add(Qui);
        boolean Sex = false; diasDaSemana.add(Sex);
        boolean Sab = false; diasDaSemana.add(Sab);

        System.out.println("Esta App cria planos de treino Semanais");
        System.out.println("Em que dias é que pretende treinar?");
        System.out.println("(Para retirar um dia volte a seleciona-lo)");

        while(opcaoDias != -1) {
            System.out.println("");
            System.out.print("Domingo [1] - "); if (diasDaSemana.get(0)) System.out.println("[X]"); else System.out.println("[ ]");
            System.out.print("Segunda [2] - "); if (diasDaSemana.get(1)) System.out.println("[X]"); else System.out.println("[ ]");
            System.out.print("Terça [3] - "); if (diasDaSemana.get(2)) System.out.println("[X]"); else System.out.println("[ ]");
            System.out.print("Quarta [4] - "); if (diasDaSemana.get(3)) System.out.println("[X]"); else System.out.println("[ ]");
            System.out.print("Quinta [5] - "); if (diasDaSemana.get(4)) System.out.println("[X]"); else System.out.println("[ ]");
            System.out.print("Sexta [6] - "); if (diasDaSemana.get(5)) System.out.println("[X]"); else System.out.println("[ ]");
            System.out.print("Sábado [7] - "); if (diasDaSemana.get(6)) System.out.println("[X]"); else System.out.println("[ ]");
            System.out.print("Terminar [0]");
            System.out.println("");
            opcaoDias = input.nextInt() - 1;

            if (opcaoDias > -1 && opcaoDias < 7)
                if (diasDaSemana.get(opcaoDias)) {
                    diasDaSemana.set(opcaoDias, false);
                } else {
                    diasDaSemana.set(opcaoDias, true);
                }

        }
        
        return diasDaSemana;
    }  
}