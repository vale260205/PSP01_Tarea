package es.dam.ejercicio15;

import java.io.IOException;

/**
 * Explicación Ejercicio 15: Espera y Valor de salida
 * Al ejecutar el programa, el proceso padre crea un proceso hijo y espera
 * a que este termine mediante waitFor(). Por eso, los números aleatorios
 * no se generan hasta que el proceso hijo ha finalizado

 * Despues de terminar el proceso hijo, se muestra su valor de salida. En
 * este caso 0, lo que significa que el proceso terminó correctamente y sin
 * errores. Por ultimo el proceso padre continúa su ejecución y genera los
 * cinco números aleatorios
 */
public class Ejercicio15 {
    static void main(String[] args) throws IOException, InterruptedException {
       ProcessBuilder proceso = new ProcessBuilder("java", "-cp", "target/classes", "es.dam.ejercicio14.Ejercicio14");

       Process hijo = proceso.start();

       int valorSalida = hijo.waitFor();

        System.out.println("El proceso hijo ha terminado. ");
        System.out.println("Valor de salida del proceso hijo: " + valorSalida);

        for (int i = 0; i < 5 ; i++) {
            int numero = (int) (Math.random() * 100);
            System.out.println("Numero aleatorio: " + numero);
        }
    }
}
