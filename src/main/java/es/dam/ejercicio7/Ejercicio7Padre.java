package es.dam.ejercicio7;

import java.io.*;
import java.util.Scanner;

/**
 * Ejercicio 7: Conversión de texto a mayúsculas
 * Se comunica con un proceso hijo para enviarle
 * un texto y recibirlo convertido a mayúsculas.
 */
public class Ejercicio7Padre {
    /**
     * Punto de entrada obligatorio del programa.
     * Solicita un texto al usuario, lo envía al proceso hijo
     * y muestra el texto recibido en mayúsculas
     * @param args argumentos recibidos
     */
    static void main(String[] args) throws IOException {
        String classpath = System.getProperty("java.class.path");
        ProcessBuilder proceso = new ProcessBuilder("java", "-cp", classpath, "es.dam.ejercicio7.Mayusculas");
        Process process = proceso.start();

        Scanner entrada = new Scanner(System.in);

        try (BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
             BufferedReader lector = new BufferedReader(new InputStreamReader(process.getInputStream()))){

            System.out.print("Introduce un texto: ");
            String texto = entrada.nextLine();

            escritor.write(texto);
            escritor.newLine();
            escritor.flush();

            String respuesta = lector.readLine();
            System.out.println("Texto en mayúsculas: " + respuesta);

        }
    }
}
