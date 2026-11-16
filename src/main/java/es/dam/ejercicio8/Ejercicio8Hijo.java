package es.dam.ejercicio8;

import java.util.Scanner;
    /**
     * Ejercicio 8: Calculadora Remota
     * Este programa actúa como proceso hijo y recibe operaciones
     * matemáticas mediante la entrada estandar
     * Calcula el resultado y lo devuelve por la salida estandar
     */
public class Ejercicio8Hijo {
    /**
     * Metodo principal del proceso hijo
     * @param args argumentos recibidos
     */
    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while(entrada.hasNextLine()) {
            String operacion = entrada.nextLine();
            if (operacion.equals("FIN")) {
                break;
            }
            String[] partes = operacion.split(" ");

            double numero1 = Double.parseDouble(partes[0]);
            double numero2 = Double.parseDouble(partes[2]);

            String operador = partes[1];

            double resultado;

            switch (operador) {
                case "+" -> resultado = numero1 + numero2;
                case "-" -> resultado = numero1 - numero2;
                case "*" -> resultado = numero1 * numero2;
                case "/" -> resultado = numero1 / numero2;
                default -> resultado = 0;
            }
            System.out.println(resultado);
            System.out.flush();
        }
    }
}
