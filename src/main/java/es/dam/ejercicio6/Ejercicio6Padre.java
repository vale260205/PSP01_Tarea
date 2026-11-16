package es.dam.ejercicio6;

import java.io.*;
import java.util.Scanner;

/**
 *  Ejercicio 6: Generador de números de Lotería
 *
 * Se comunica con el proceso hijo para solicitar
 * la generación de un número de lotería
 */
public class Ejercicio6Padre {
    /**
     * Metodo principal del programa
     * Es el que inicia el proceso hijo, este solicita un número de lotería
     * y muestra el número recibido. Repite la petición hasta que el
     * usuario responde NO
     * @param args argumentos desde la linea de comandos
     */
    public static void main(String[] args) {

        ProcessBuilder proceso = new ProcessBuilder("java", "-cp", "target/classes", "es.dam.ejercicio6.Ejercicio6Hijo");

        try {
            Process process = proceso.start();
            BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

            BufferedReader lector = new BufferedReader(new InputStreamReader(process.getInputStream()));

            Scanner teclado = new Scanner(System.in);
            String respuesta;

            do {
                escritor.write("GENERAR");
                escritor.newLine();
                escritor.flush();

                String numero = lector.readLine();

                System.out.println("Número de lotería: " + numero);

                System.out.println("¿Quieres otro número? (SI/NO)");
                respuesta = teclado.nextLine();

            } while (!respuesta.equalsIgnoreCase("NO"));

            escritor.close();
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
