package es.dam.ejercicio12;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * Ejercicio 12: ProcessBuilder y variables de entorno
 * Este programa solicita una aplicación, la ejecuta con ProcessBuilder
 * y muestra sus variables de entorno como pares clave = valor.
 */
public class Ejercicio12 {
    /**
     * Solicita una aplicación, la inicia y muestra sus variables de entorno
     * @param args argumentos del programa
     * @throws IOException si no se puede iniciar la aplicación
     */
    static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce una aplicación: ");
        String aplicacion = entrada.nextLine();

        ProcessBuilder proceso = new ProcessBuilder(aplicacion);

        proceso.start();

        Map<String, String> entorno = proceso.environment();

        for (Map.Entry<String, String> variable : entorno.entrySet()) {
            System.out.println(variable.getKey() + " = " + variable.getValue());
        }
    }
}
