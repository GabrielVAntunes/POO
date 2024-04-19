import java.time.LocalDate;

public class Tp2_Ex2 {
    
    public static void main(String[] args){
        // Os métodos desta instância serão desenvolvidos no ficheiro: "Tp2_Ex2Tester"
        Tp2_Ex2Tester dateArray = new Tp2_Ex2Tester(5);
        // Instância pré-definida em java que contém métodos referentes ao cálculo e representação de datas
        LocalDate data = LocalDate.of(2003, 3, 24);

        // Chamamos o método da alínea a) e o array de datas é construído
        dateArray.addDate(0, LocalDate.of(2003, 11, 27));
        dateArray.addDate(1, LocalDate.of(2017, 9,21 ));
        dateArray.addDate(2, LocalDate.of(2003, 5,25));
        dateArray.addDate(3, LocalDate.of(2003, 11,18 ));
        dateArray.addDate(4, LocalDate.of(2003, 6,15 ));

        // Chamamos o método da alínea b)
        LocalDate dataMaisProxima = dateArray.proximaData(data);
        System.out.println("A data mais próxima é: " + dataMaisProxima);

        // Chamamos o método da alínea c)
        String stringDatas = dateArray.dateString();
        System.out.println(stringDatas);
    }
}
