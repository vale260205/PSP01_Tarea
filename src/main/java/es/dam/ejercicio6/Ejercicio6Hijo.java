package es.dam.ejercicio6;

import java.util.Random;
import java.util.Scanner;

/**
 * Ejercicio 6: Generador de números de Lotería
 *
 * Percibe una petición del proceso padre y genera
 * un número aleatorio de lotería entre 0 y 99999
 */
public class Ejercicio6Hijo {
    /**
     * Recibe peticiones del proceso padre y genera
     * un número aleatorio cuando recibe la petición GENERAR
     */
    static void main() {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        while(entrada.hasNextLine()) {
            String peticion = entrada.nextLine();
            if (peticion.equals("GENERAR")) {

                int numero = random.nextInt(100000);

                System.out.println(numero);
                System.out.flush();
            }
        }
    }
}
