public class Tp1_OlaAlguem {
    
    public static String geraSaudacao(String nome) {
        return ("Olá " + nome + "!");
    }

    public static void main(String[] args) {
        String saudacao = geraSaudacao("Moi-Moi");
        System.out.println(saudacao);
    }
}