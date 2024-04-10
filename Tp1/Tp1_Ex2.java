import java.util.Scanner;
public class Tp1_Ex2 {

    public static void main(String[] args) {
        int diasSt, horasSt, minutosSt, segundosSt;
        int diasNd, horasNd, minutosNd, segundosNd;

        Scanner input = new Scanner(System.in);

        System.out.println("Introduza a 1ª data: ");
        System.out.print("dias: ");
        diasSt = input.nextInt();
        System.out.print("horas: ");
        horasSt = input.nextInt();
        System.out.print("minutos: ");
        minutosSt = input.nextInt();
        System.out.print("segundos: ");
        segundosSt = input.nextInt();

        System.out.println("Introduza a 2ª data: ");
        System.out.print("dias: ");
        diasNd = input.nextInt();
        System.out.print("horas: ");
        horasNd = input.nextInt();
        System.out.print("minutos: ");
        minutosNd = input.nextInt();
        System.out.print("segundos: ");
        segundosNd = input.nextInt();

        input.close();

        String resp = somaDatas(diasSt, horasSt, minutosSt, segundosSt, diasNd, horasNd, minutosNd, segundosNd);

        System.out.println(resp);
    }

    public static String somaDatas(int diasSt, int horasSt, int minutosSt, int segundosSt, 
                                   int diasNd, int horasNd, int minutosNd, int segundosNd) {
        int somaDias = diasSt + diasNd, somaHoras = horasSt + horasNd;
        int somaMinutos = minutosSt + minutosNd, somaSegundos = segundosSt + segundosNd;
        int diasExtra, horasExtra, minutosExtra;

        minutosExtra = somaSegundos / 60;
        somaSegundos %= 60;
        somaMinutos += minutosExtra;
        
        horasExtra = somaMinutos / 60;
        somaMinutos %= 60;
        somaHoras += horasExtra;

        diasExtra = somaHoras / 24;
        somaHoras %= 24;
        somaDias += diasExtra;

        return (somaDias + " Dias, " + somaHoras + " Horas, " +  somaMinutos + " Minutos, " +  somaSegundos + " Segundos.");
    }
}
