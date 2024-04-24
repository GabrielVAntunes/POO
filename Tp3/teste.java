public class teste{

    public static void main(String[] args){
        
        Circulo cDefault = new Circulo();
        Circulo cParam = new Circulo(2 , 2 , 5);
        Circulo cCopy = new Circulo(cParam);

        System.out.println("O Círculo Parametrizao e o Círculo Cópia são iguais:");
        System.out.println(cParam.equals(cCopy));

        System.out.println("Circulos criados:");
        System.out.println(cDefault.toString());
        System.out.println(cParam.toString());
        System.out.println(cCopy.toString());

        cDefault.setX(5);
        cParam.setY(1);
        cCopy.setRaio(2);

        System.out.println("Recolha de variaveis de Instancia depois de alteradas: ");
        System.out.println(cDefault.getX());
        System.out.println(cParam.getY());
        System.out.println(cCopy.getRaio());  
        
        System.out.println("O Círculo Parametrizao e o Círculo Cópia são iguais:");
        System.out.println(cParam.equals(cCopy));

        Circulo cClone = cCopy.clone();

        System.out.println("O Círculo Cópia e o Círculo Clone são iguais:");
        System.out.println(cCopy.equals(cClone));

        cCopy.alteraCentro(0, 0);

        System.out.println("A área do Círculo Cópia é: " + cCopy.calculaArea() + " m^2");
        System.out.println("O perímetro do Círculo Cópia é: " + cCopy.calculaPerimetro() + " m");

        System.out.println(cCopy.toString());
    }
}