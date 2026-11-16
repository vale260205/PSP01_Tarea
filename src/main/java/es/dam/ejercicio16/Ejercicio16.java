package es.dam.ejercicio16;

import java.io.IOException;

/**
 * Ejercicio 16: Finalización programada de un proceso.
 * Abre una aplicación, espera unos segundos, finaliza el
 * proceso indicado y muestra un mensaje.
 */
public class Ejercicio16 {

    /**
     * Metodo principal del programa.
     *
     * @param args nombre de la aplicación que se quiere finalizar
     * @throws IOException si ocurre un error al iniciar el proceso
     * @throws InterruptedException si el proceso es interrumpido durante la espera
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length == 0) {
            System.out.println("Debes indicar una aplicación.");
            return;
        }

        String aplicacion = args[0];

        ProcessBuilder proceso = new ProcessBuilder("notepad.exe");
        Process hijo = proceso.start();

        Thread.sleep(10000);

        new ProcessBuilder("taskkill", "/F", "/IM", aplicacion).start();

        Thread.sleep(5000);

        System.out.println("Buenas noches amigo!");
    }
}
