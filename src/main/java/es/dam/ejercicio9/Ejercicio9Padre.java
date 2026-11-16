package es.dam.ejercicio9;

import java.io.*;
import java.util.Scanner;

/**
 * Ejercicio 9: Analizador de texto
 * Este proceso padre pide frases al usuario y se las envía al proceso hijo
 * para que las analice. Después muestra los resultados recibidos y termina
 * cuando el usuario introduce "FIN".
 */
public class Ejercicio9Padre {
    /**
     * Inicia el proceso hijo y gestiona el envío y recepción de información
     * @param args argumentos del programa
     * @throws IOException si ocurre un error durante la comunicación
     */
    static void main(String[] args) throws IOException {
        ProcessBuilder proceso = new ProcessBuilder("java", "-cp", "target/classes", "es.dam.ejercicio9.Ejercicio9Hijo");

        Process hijo = proceso.start();

        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream()));

        BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("Introduce una frase: ");

            String linea = entrada.nextLine();

            if (linea.equals("FIN")) {
                escritor.write(linea);
                escritor.newLine();
                escritor.flush();
                break;
            }

            escritor.write(linea);
            escritor.newLine();
            escritor.flush();

            String respuesta = lector.readLine();
            System.out.println(respuesta);
        }
    }
}
