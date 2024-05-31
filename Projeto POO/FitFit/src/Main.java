import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class Main implements Serializable{
    
    public static void main(String[] args){

        //  Carregar dados
        //  TODO: A decidir se é opcional ou obrigatório e neste ponto

        Scanner input = new Scanner(System.in);
        Menu menu = new MenuAdmin();

        Utilizadores utilizadores = new Utilizadores();
        ListaAtividades lAtividades = new ListaAtividades();
        PlanosTreino planosTreino = new PlanosTreino();

        try {
            menu = (Menu) new ObjectInputStream(new FileInputStream("save.dat")).readObject();
            utilizadores = menu.getUtilizadores();
            lAtividades = menu.getListaAtividades();
            planosTreino = menu.getPlanosTreino();
            System.out.println("Dados carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Não foi encontrado nenhum ficheiro de dados.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // //Adicionar uma entrada ao plano de treino para testar
        // // criar uma atividade gennérica do tipo Distancia:
        // Atividades atividade = new Distancia();
        // lAtividades.add(atividade);
        // // criar um plano de treino genérico:
        // PlanoSemanal planoSemanal = new PlanoSemanal();
        // planoSemanal.add(lAtividades);

        // // criar um utilizador genérico:
        // Utilizador utilizador = new Utilizador("Gabi" , "Gabriel Antunes", "Rua 29 de junho", "gabyenzoop24@gmail.com", 50, 80, 175, Dificuldades.PROFISSIONAL, "M");

        // planosTreino.put(utilizador.getCodigoUtilizador(), planoSemanal);


        System.out.println("-------------------------------------------------------------------");
        System.out.println("----------Para aceder a aplicação em modo user prima [1]-----------");
        System.out.println("----------Para aceder a aplicação em modo admin prima [2]----------");
        System.out.println("-------------------------------------------------------------------");

        int option = input.nextInt();
        if (option == 2) {
            menu = new MenuAdmin(utilizadores, lAtividades, planosTreino);
        } else {
            menu = new MenuUser(utilizadores, lAtividades, planosTreino);
        }

        menu.initUtilizadores();
        menu.initAtividades();

        // Variável userAtual vai guardar o codigo do utilizador que está neste momento a utilizar a app.
        String userAtual = menu.logIn();
        if(userAtual.equals("")) {
            input.close();
            return;
        }
        
        menu.mainMenu();
        // TODO: Continuar a desenvolver os menus iniciais

        try {
            menu.gravarDados("save.dat");
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        input.close();
    }          
}   