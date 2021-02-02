import java.util.Scanner;

public class Ejercicio1 {

    static Scanner scan = new Scanner(System.in);

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

    static double maximoArray(double[] numbers) {
        double max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            double number = numbers[i];
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    static void valorMaximo(double value) {
        System.out.println("El máximo es " + value);
    }

    public static void main(String[] args) {
        System.out.println("Introduzca un array de decimales");
        double[] array = arrayDoubles();
        double resultado = maximoArray(array);
        valorMaximo(resultado);
    }
}
