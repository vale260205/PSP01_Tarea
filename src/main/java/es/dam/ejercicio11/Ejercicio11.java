package es.dam.ejercicio11;

import java.io.IOException;

/**
 * Ejercicio 11: ProcessHandle y Sistema Operativo
 * Este programa detecta el sistema operativo, abre la calculadora en Windows
 * o Firefox en Linux y muestra información del proceso mediante ProcessHandle
 */
public class Ejercicio11 {
    /**
     * Detecta el sistema operativo, inicial el proceso y muestra su información
     * @param args  argumentos del programa
     * @throws IOException si ocurre un error al inicial el proceso
     */
    static void main(String[] args) throws IOException {
        String sistema = System.getProperty("os.name");

        Process proceso;

        if (sistema.toLowerCase().contains("win")) {

            proceso = new ProcessBuilder("calc").start();

        } else {

            proceso = new ProcessBuilder("firefox").start();
        }

        ProcessHandle handle = proceso.toHandle();

        System.out.println("Nombre del comando: " + handle.info().command());
        System.out.println("Argumentos: " + handle.info().arguments());
        System.out.println("Tiempo de comienzo: " + handle.info().startInstant());
        System.out.println("Tiempo de CPU: " + handle.info().totalCpuDuration());
        System.out.println("Propietario: " + handle.info().user());
        System.out.println("Número de procesos hijos: " + handle.children().count());
    }
}
