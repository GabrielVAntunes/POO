import java.time.LocalDateTime;
import java.util.Scanner;

//Não está completamente certo, faltaria calcular dias dos meses, anos bissextos etc... dá para ter uma noção

public class Tp1_Ex7{

    public static void main(String[] args){ 
        int birthYear, birthMonth, birthDay;
        int year, month, day, hour;
        int sumYears, sumMonths, sumDays;
        Scanner input = new Scanner(System.in);

        LocalDateTime now = LocalDateTime.now();

        System.out.println("Este programa irá calcular o tempo de vida de uma pessoa em horas");
        System.out.print("introduza o dia em que nasceu: ");
        birthDay = input.nextInt();
        System.out.print("introduza o mes em que nasceu: ");
        birthMonth = input.nextInt();
        System.out.print("introduza o ano em que nasceu: ");
        birthYear = input.nextInt();

        input.close();

        year = now.getYear();
        month = now.getMonthValue();
        day = now.getDayOfMonth();
        hour = now.getHour();

        sumYears = year - birthYear;
        sumYears *= 8766;

        sumMonths = month - birthMonth;
        sumMonths *= 730;

        sumDays = day - birthDay;
        sumDays *= 24;

        System.out.println("O tempo de vida da pessoa em horas é: " + (sumYears + sumMonths + sumDays + hour));
    }
}