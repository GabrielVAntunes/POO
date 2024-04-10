import java.util.Scanner;
public class Tp1_Ex5 {
    
    public static void main(String[] args){
        double base = 1, altura;
        double area, perimetro;
        Scanner input = new Scanner(System.in);


        while (base != 0) {
            System.out.println("Este programa irá calcular a área e o perímetro de um triangulo");
            System.out.println("Introduza a base de um triangulo retangulo. ('0' para terminar execução)");
            base = input.nextFloat();
            if(base != 0) {
                System.out.println("Introduza agora a altura desse mesmo trinagulo.");
                altura = input.nextFloat();

                area = calculaArea(base, altura);
                perimetro = calculaPerimetro(base, altura);

                System.out.println("A área do triangulo é: " + area);
                System.out.println("O perímetro do triangulo é: " + perimetro);
                

            } else {
                System.out.println("Programa terminado!");
            }
        }

        input.close();
        
    }

    public static double calculaArea(double base, double altura){
        return (base*altura)/2;
    }

    public static double calculaPerimetro(double base, double altura){
        double hipotenusa;

        hipotenusa = pitagoras(base, altura);

        return (base + altura + hipotenusa);
    }

    private static double pitagoras(double base, double altura){
        return(Math.sqrt(Math.pow(base,2) + Math.pow(altura,2)));
    }
}
