package es.dam.ejercicio1;

import java.io.IOException;

/**
 * Ejercicio1: Lanzamiento de un editor
 * La aplicación inicia el Bloc de notas y espera
 * hasta que el proceso termine
 */

public class Ejercicio1 {
    /**
     * Metodo principal del programa
     * @param args argumentos desde la linea de comandos
     */
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("notepad.exe");

        try {
            Process proceso;
            proceso = pb.start();

            System.out.println("padre esperando: ");
            int codigo = proceso.waitFor();
            System.out.println("hijo terminado con codigo: " + codigo);
        } catch (IOException | InterruptedException e) {
            System.err.println(
                    "No se pudo iniciar el proceso: " + e.getMessage());
        }
    }
}


