import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Tp2_Ex2Tester {
    private LocalDate[] dates;

    // Construtor de classe, vai inicializar a variavel de instância que vai ser usada nesta classe
    public Tp2_Ex2Tester(int size){
        dates = new LocalDate[size];
    }

    // Método que irá adicionar as datas ao array
    public void addDate(int index, LocalDate date){
        if(index >= 0 && index < dates.length){
            dates[index] = date;
        }
    }

    // Método que calcula qual é a data do array mais próxima a uma data dada
    public LocalDate proximaData(LocalDate data){
        long menor = data.until(dates[0], ChronoUnit.DAYS);
        LocalDate dataResp = dates[0];
        for(LocalDate date : dates){
            if(data.until(date, ChronoUnit.DAYS) < menor){
                menor = data.until(date, ChronoUnit.DAYS);
                dataResp = date;
            }
        }
        return dataResp;
    }

    // Escreve todas as datas do array numa String
    public String dateString(){

        String stringDatas = "";

        stringDatas += "{";
        for(LocalDate date: dates){
            stringDatas += date + "; ";
        }
        stringDatas += "}";
        return stringDatas;
    }
}
