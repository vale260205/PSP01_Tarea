package es.dam.ejercicio13;

import java.io.File;
import java.io.IOException;

/**
 * Ejercicio 13: Redirección de salida y errores
 * Este programa ejecuta un comando de Windows y redirige la salida
 * estándar y los errores a diferentes archivos.
 */
public class Ejercicio13 {
    /**
     * Ejecuta el comando y redirige su salida y sus errores a archivos
     * @param args argumentos del programa
     * @throws IOException si ocurre un error al ejecutar el proceso.
     */
    static void main(String[] args) throws IOException {
        ProcessBuilder proceso = new ProcessBuilder("CMD", "/c", "verr");

        proceso.redirectOutput(new File("salida.txt"));
        proceso.redirectError(new File("error.txt"));

        proceso.start();


    }
}
