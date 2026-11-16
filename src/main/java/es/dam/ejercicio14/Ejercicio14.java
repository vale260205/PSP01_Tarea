package es.dam.ejercicio14;

/**
 * Ejercicio 14: Pausa de la ejecución
 * El funcionamiento del programa es que muestra un mensaje diez
 * veces, esperando un segundo entre cada impresión.
 */
public class Ejercicio14 {
    /**
     * Muestra el mensaje diez veces con una pausa de un segundo.
     * @param args argumentos del programa
     * @throws InterruptedException si se interrumpe la pausa del proceso
     */
    static void main(String[] args) throws InterruptedException{

        for (int i = 0; i < 10; i++) {

            System.out.println("¿Qué pasa?");

            Thread.sleep(1000);

        }
    }
}
