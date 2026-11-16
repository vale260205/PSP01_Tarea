package es.dam.ejercicio2;

import java.io.IOException;

/**
 * Ejercicio 2: Secuenciación y espera
 * Inicia el Bloc de notas y, después de esperar,
 * inicia la calculadora.
 */
public class Ejercicio2 {

    public static void lanzaProcesos() {

        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        ProcessBuilder pb2 = new ProcessBuilder("calc.exe");

        try {
            Process p = pb.start();

            p.waitFor();

            Thread.sleep(10000);

            pb2.start();

        } catch (IOException e) {
            System.out.println("Error al ejecutar los procesos.");
        } catch (InterruptedException e) {
            System.out.println("El proceso ha sido interrumpido.");
        }
    }

    public static void main(String[] args) {
        lanzaProcesos();
    }
}