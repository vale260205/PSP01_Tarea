package es.dam.ejercicio9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ejercicio 9: Analizador de texto
 * Este proceso hijo recibe frases del proceso padre y analiza cada una
 * para calcular sus caracteres, palabras y vocales. Después devuelve el
 * resultado al padre. El programa termina cuando recibe "FIN"
 */
public class Ejercicio9Hijo {
    /**
     * Recibe las frases, realiza el análisis y devuelve el resultado
     * @param args argumentos del proyecto
     * @throws IOException si ocurre un error de entrada
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader entradaPadre = new InputStreamReader(System.in);

        BufferedReader lector = new BufferedReader(entradaPadre);

        String linea;

        while ((linea = lector.readLine()) != null) {

            if (linea.equals("FIN")) {
                break;
            }

            int numCaracteres = linea.length();

            String[] palabras = linea.trim().split("\\s+");

            int numPalabras = palabras.length;

            int numVocales = 0;

            String texto = linea.toLowerCase();

            for (int i = 0; i < texto.length(); i++) {
                char c = texto.charAt(i);

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    numVocales++;
                }
            }

            System.out.println("caracteres=" + numCaracteres + "; palabras=" + numPalabras + "; vocales=" + numVocales);
        }
    }
}
