import java.util.Scanner;
import java.time.LocalDateTime;
import java.math.BigInteger;
public class Tp1_5II {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        Tp1_5II Ex = new Tp1_5II();
        int question;

        System.out.println("Qual das perguntas quer acessar? [1/2/3/4/5/6/7]");
        question = input.nextInt();

        switch (question) {
            case 1:
            double cel, far;
            System.out.print("Introduza a temperatura: ");
            cel = input.nextDouble();
            far = Ex.celsiusParaFarenheit(cel);

            System.out.println(cel + "º Celsius equivalem a " + far + "º Farenheit");
                break;
        
            case 2:
                int a, b, max;

                System.out.print("Introduza o 1º número: ");
                a = input.nextInt();
                System.out.print("Introduza o 2º número: ");
                b = input.nextInt();

                max = Ex.maximoNumeros(a, b);

                System.out.println("O maior dos 2 valores é " +  max);
            
                break;

            case 3:
                String name;
                double bal;

                System.out.println("Introduza o seu nome e o saldo");

                name = input.next();
                bal = input.nextDouble();

                System.out.println(Ex.criaDescricaoConta(name, bal));

                break;

            case 4:
                double euros, taxa, valorFinal;


                System.out.println("Introduza o valor e a taxa de conversão");

                euros = input.nextDouble();
                taxa = input.nextDouble();

                valorFinal = Ex.eurosParaLibras(euros, taxa);

                System.out.println("O valor em libras: " + valorFinal);

                break;

            case 5:
                int n1, n2;
                double media;

                System.out.println("Introduza 2 números");
                n1 = input.nextInt();
                n2 = input.nextInt();

                media = Ex.calculaMedia(n1, n2);

                System.out.println("A média dos 2 valores é igual a: " + media);

                break;
            
            case 6:
                int num, fac;

                System.out.println("Introduza um valor para calcular o seu fatorial");
                num = input.nextInt();

                fac = Ex.factorial(num);

                System.out.println(fac);

                break;

            case 7:
                long tempo;

                tempo = Ex.tempoGasto();

                System.out.println(tempo);
                break;
        }       



        input.close();
    }
        
    public int maximoNumeros(int a, int b){
        return(Math.max(a, b));
    }

    public double celsiusParaFarenheit(double cel){
        return(cel * 1.8 + 32);
    }

    public String criaDescricaoConta(String name, double bal){
        return "Nome: " + name + " Saldo: " + bal;
    }

    public double eurosParaLibras(double euros, double taxa){
        return(euros*taxa);
    }

    public int calculaMedia(int n1, int n2){
        System.out.print(Math.max(n1, n2) + " ");
        System.out.println(Math.min(n1, n2));
        return(n1 + n2) / 2;
    }

    public int factorial(int num){
        int fac = num;
        for(int i = num -1; i > 0; i--){
            fac *= i;
        }
        return fac;
    }

    public long tempoGasto(){
        
        LocalDateTime now = LocalDateTime.now();
        int milisecs, milisecsf;

        milisecs = now.getNano();
        System.out.println(milisecs);

        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= 5000; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial);

        milisecsf = now.getNano();
        System.out.println(milisecsf);

        long resp = milisecsf - milisecs;
        return resp;
    }
}
