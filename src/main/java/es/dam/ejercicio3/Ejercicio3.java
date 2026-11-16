package es.dam.ejercicio3;

import java.io.*;

/**
 * Ejercicio3: Ejecución de comandos
 * Permite lanzar comandos mediante un proceso
 * y mostrar por pantalla su resultado
 */

public class Ejercicio3 {
    /**
     * Ejecuta un comando del sistema y muestra su resultado
     * @param comando que se quiere ejecutar
     */
    public static void lanzarProceso(String comando) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c",comando);

        try {
        Process proceso = pb.start();

        InputStream entrada = proceso.getInputStream();
        InputStreamReader lector = new InputStreamReader(entrada);

        BufferedReader br = new BufferedReader(lector);

        String linea;

        while((linea = br.readLine())!= null) {
            System.out.println(linea);
        }

        } catch (IOException e) {
            System.out.println("Error al ejecutar el proceso. ");;
        }
    }

    /**
     * Metodo principal del programa
     * Ejecuta varios comandos del sistema
     * @param args argumentos recibidos desde la linea de comandos
     */
    public static void main(String[] args) {
            lanzarProceso("date /t");
            lanzarProceso("time /t ");
            lanzarProceso("ipconfig");

    }
}
