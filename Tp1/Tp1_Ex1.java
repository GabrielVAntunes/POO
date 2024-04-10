import java.util.Scanner;
public class Tp1_Ex1 {
    
    public static void main(String[] args) {

        int dia, mes, ano;
        Scanner input = new Scanner(System.in);

        System.out.println("Introduza uma data: ");
        dia = input.nextInt();
        mes = input.nextInt();
        ano = input.nextInt();

        input.close();

        int diaDaSemana = calcularDiaDaSemana(dia, mes, ano);
        System.out.println("O dia da semana é: " + diaDaSemana);
    }

    public static int calcularDiaDaSemana(int dia, int mes, int ano){
        //passo a)
        int totalDias = (ano - 1900) * 365; // i)
        totalDias += (ano-1900)/4; // ii)
        if (eBissexto(ano) && mes<=2) totalDias -= 1; // iii)
        totalDias += diasPassados(dia, mes, ano);// iv)

        //passo b)
        int diaDaSemana = totalDias % 7;

        //passo c)
        return diaDaSemana;
    }

    public static Boolean eBissexto(int ano){
        return(ano % 4 == 0);
    }
        
    public static int diasPassados(int dia, int mes, int ano) {
        int somaDias = 0;
        int[] diasPorMes = {31,28,31,30,31,30,31,31,30,31,30,31};

        for(int i = 0; i + 1 < mes; i++){
            somaDias += diasPorMes[i];
        }

        somaDias += dia;

        if(eBissexto(ano) && mes > 2) {
            somaDias += 1;
        }

        return somaDias;
    }
}
