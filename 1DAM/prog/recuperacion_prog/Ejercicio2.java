import java.util.Scanner;

public class Ejercicio2 {

    static Scanner scan = new Scanner(System.in);

    static double cuentaNegativos(double[] numbers) {
        int negativo = 0;
        for (int i = 0; i < numbers.length; i++) {
            double number = numbers[i];
            if (number < 0) {
                negativo = negativo + 1;
            }
        }
        return negativo;
    }

    static double calcularMedia(double[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            double number = numbers[i];
            sum = sum + number;
        }
        return sum / numbers.length;
    }

    static int numeroEntero() {
        System.out.println("Introduce un número entero");
        int n = scan.nextInt();
        while (n <= 0) {
            System.out.println("Introduce un número mayor que 0");
            n = scan.nextInt();
        }
        return n;
    }

    static double[] arrayDoubles() {
        System.out.println("¿Cuántos números va a introducir?");
        int n = numeroEntero();
        double[] numbers = new double[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextDouble();
        }
        return numbers;
    }

    public static void main(String[] args) {
        System.out.println("¿Qué operación desea realizar? (Negativo/Media/Salir");
        String respuesta = scan.next();
        while (true) {
            if (respuesta.equals("Negativo")) {
                double[] array = arrayDoubles();
                double neg = cuentaNegativos(array);
                System.out.println("Ha introducido " + neg + "números negativos");
            } else if (respuesta.equals("Media")) {
                System.out.println("¿Cuántos números va a introducir?");
                double[] array = arrayDoubles();
                double media = calcularMedia(array);
                System.out.println("La media es " + media);
            } else if (respuesta.equals("Salir")) {
                System.out.println("Ya no quiere realizar más operaciones");
                break;
            }
        }
    }
}