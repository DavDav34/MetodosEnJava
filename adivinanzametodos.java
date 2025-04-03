import java.util.Random;
import java.util.Scanner;


public class JuegoAdivinanzaMetodos {

    // metodo para generar un numero aleatorio entre 1 y 100
    public static int generarNumeroAleatorio() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(100) + 1;
    }

    // mtodo estatico para obtener el número maximo de intentos
    public static int getIntentosMaximos() {
        return 10;
    }

    public static void jugarJuego() {
        int numeroBuscado = generarNumeroAleatorio();
        int intentosMaximos = getIntentosMaximos();
        int intentosRealizados = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("HOLAaaa VAMOS A JUGAR USANDO METODOS ESTATICOS");
        System.out.println("Adivina un numero entre 1 y 100");
        System.out.println("Tienes " + intentosMaximos + " intentos");

        while (intentosRealizados < intentosMaximos) {
            System.out.print("\nIntento " + (intentosRealizados + 1) + ": ");
            int numeroIngresado = scanner.nextInt();

            if (numeroIngresado < 1 || numeroIngresado > 100) {
                System.out.println("¡Numero invalido! Debe estar entre 1 y 100");
                continue;
            }

            intentosRealizados++;

            if (numeroIngresado == numeroBuscado) {
                System.out.println("\n¡Felicidades! Adivinaste el numero en " + intentosRealizados + " intentos");
                return;
            }

            // Logica de pistas
            if (intentosRealizados == intentosMaximos) {
                System.out.println("\n¡se acabaron los intentos perdiste :( !");
                System.out.println("El numero era: " + numeroBuscado);
                return;
            }

            if (numeroIngresado < numeroBuscado) {
                System.out.println("El numero es mayor");
            } else {
                System.out.println("El numero es menor");
            }

            System.out.println("Intentos restantes: " + (intentosMaximos - intentosRealizados));
        }
    }

    public static void main(String[] args) {
        JuegoAdivinanzaMetodos.jugarJuego();
    }
    
}