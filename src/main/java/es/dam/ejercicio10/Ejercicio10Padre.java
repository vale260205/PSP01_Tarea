package es.dam.ejercicio10;

import java.io.*;
import java.util.Scanner;

/**
 * Ejercicio 10: Filtro de números
 * Este proceso padre solicita números al usuario y los envía al proceso
 * hijo para analizarlos. Muestra las respuestas recibidas y termina al
 * enviar "FIN".
 */
public class Ejercicio10Padre {
    /**
     * Inicia el proceso hijo y gestiona el envío y recepción de números
     * @param args argumentos del programa
     * @throws IOException si ocurre un error durante la comunicación
     */
    static void main(String[] args) throws IOException {

        ProcessBuilder proceso = new ProcessBuilder("java", "-cp", "target/classes", "es.dam.ejercicio10.Ejercicio10Hijo");

        Process hijo = proceso.start();

        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream()));

        BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.print("Introduce un número: ");
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
        entrada.close();
    }
}
