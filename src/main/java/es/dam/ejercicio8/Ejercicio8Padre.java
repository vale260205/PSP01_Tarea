package es.dam.ejercicio8;

import java.io.*;
import java.util.Scanner;

/**
 * Ejercicio 8: calculadora remota
 * Este programa actúa como proceso padre, solicita operaciones
 * al usuario y se comunica con el proceso hijo para obtener
 * el resultado de cada operacion
 */
public class Ejercicio8Padre {
    /**
     * Metodo principal del proceso hijo
     * @param args argumentos recibidos
     */
    static void main(String[] args) {
        ProcessBuilder proceso = new ProcessBuilder("java", "-cp", "target/classes", "es.dam.ejercicio8.Ejercicio8Hijo");
        try {
            Process hijo = proceso.start();

            BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream()));

            BufferedReader lector = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            Scanner entrada = new Scanner(System.in);

            while (true) {
                System.out.println("Introduce una operación matematica: ");
                String operacion = entrada.nextLine();

                if (operacion.equals("FIN")) {
                    escritor.write(operacion);
                    escritor.newLine();
                    escritor.flush();
                    break;

                }

                escritor.write(operacion);
                escritor.newLine();
                escritor.flush();

                String resultado = lector.readLine();
                System.out.println("Resultado: " + resultado);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
