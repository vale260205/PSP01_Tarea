package es.dam.ejercicio5;

import java.io.IOException;

/**
 * Ejercicio 5: lanzador reutilizable
 * Permite ejecutar otras clases Java indicando
 * la ruta donde se encuentran y el nombre de la clase
 */
public class Ejercicio5 {
    /**
     * Se ejecuta una clase java como un proceso independiente
     * @param ruta es la ruta donde se encuentra la clase que se quiere ejecutar
     * @param comando es el nombre de la clase a ejecutar
     */
    public static void lanzador(String ruta, String comando) {

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, comando);

        try {
            Process proceso = pb.start();

            System.out.println("Proceso iniciado correctamente.");

            int codigo = proceso.waitFor();

            System.out.println("Proceso terminado con código: " + codigo);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar el proceso: " + e.getMessage());
        }
    }

    /**
     * Metodo principal
     * Se ejecutan dos ejercicios mediante el metodo lanzador
     * @param args son los argumentos recibidos
     */
    public static void main(String[] args) {

        lanzador("target\\classes", "es.dam.ejercicio1.Ejercicio1");
        lanzador("target\\classes", "es.dam.ejercicio2.Ejercicio2");
    }
}

