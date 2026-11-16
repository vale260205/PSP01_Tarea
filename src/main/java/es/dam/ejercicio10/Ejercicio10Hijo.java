package es.dam.ejercicio10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ejercicio 10: Filtro de números
 *
 * Este proceso hijo recibe números del padre y comprueba si son pares
 * o impares y si son positivos, negativos o cero. Devuelve el resultado
 * al padre hasta recibir "FIN".
 */
public class Ejercicio10Hijo {
    /**
     * Recibe los números, realiza las comprobaciones y devuelve el resultado
     * @param args argumentos del programa
     * @throws IOException si se presenta un error de entrada en el programa.
     */
    static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        String linea;

        while((linea = lector.readLine()) != null) {
            if (linea.equals("FIN")) {
                break;
            }
            int numero = Integer.parseInt(linea);

            String pares;

            if (numero % 2 == 0) {
                pares = "par";
            } else {
                pares = "impar";
            }

            String signo;

            if (numero > 0) {
                signo = "positivo";
            } else if (numero < 0 ) {
                signo = "negativo";
            } else {
                signo = "cero";
            }

            System.out.println("numero=" + numero + ";" + pares + ";" + signo);
            System.out.flush();
        }
    }
}
