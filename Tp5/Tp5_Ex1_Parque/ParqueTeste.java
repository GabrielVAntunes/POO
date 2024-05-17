import java.util.Map;

public class ParqueTeste {
    public static void main(String[] args){

        // Criar instâncias de Lugar
        Lugar lugar1 = new Lugar("AB-1234", "João", 60, false);
        Lugar lugar2 = new Lugar("CD-5678", "Maria", 120, true);
        Lugar lugar3 = new Lugar("EF-9101", "Carlos", 30, true);

        // Criar um HashMap para representar o parque
        Parque parque = new Parque();

        // Adicionar os lugares ao parque
        parque.add(lugar1);
        parque.add(lugar2);
        parque.add(lugar3);

        // Testar os métodos com o parque criado
        System.out.println("Parque:");
        for (Map.Entry<String, Lugar> entry : parque.getParque().entrySet()) {
            System.out.println("Matrícula: " + entry.getKey());
            System.out.println(entry.getValue());
        }

        //parque.remove("CD-5678");

        System.out.println("");
        System.out.println(parque.toString());
        System.out.println("");
        System.out.println(parque.lugaresOcupados());
        System.out.println(parque.longerThan(25));
        System.out.println("Aqui");
        parque.parkingLotFile("CD-5678");
    }
}
