package es.dam.ejercicio4;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Ejercicio 4: Trabajo con directorios
 * Permite mostrar el contenido de una ruta y
 * crear una carpeta nueva dentro de ella
 */
public class Ejercicio4 {
    /**
     * Metodo principal del programa
     * Pide una ruta, muestra el contenido
     * y crea una carpeta nueva
     * @param args argumentos recibidos desde la linea de comandos
     * @throws Exception excepción que si ocurre algún error al trabajar con archivos
     */
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);

        String ruta = entrada.nextLine();

        Path dir = Path.of(ruta);

        Files.list(dir).forEach(System.out::println);

        System.out.println("Introduce el nombre de la nueva carpeta: ");
        String nombreCarpeta = entrada.nextLine();

        Path nuevaCarpeta = dir.resolve(nombreCarpeta);

        Files.createDirectories(nuevaCarpeta);

        System.out.println("Carpeta creada correctamente");

    }
}
