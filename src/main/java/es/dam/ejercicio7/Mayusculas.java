package es.dam.ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ejercicio 7: Conversión a mayúsculas
 * Recibe un texto del proceso padre y lo convierte
 * a mayúsculas antes de devolverlo
 */
public class Mayusculas {
    /**
     * Lee un texto recibido del proceso padre,
     * lo convierte a mayúsculas y lo muestra por pantalla
     */
    static void main() throws IOException {
        InputStreamReader entradaPadre = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(entradaPadre);
        String texto = br.readLine();
        String textoMayusculas = texto.toUpperCase();

        System.out.println(textoMayusculas);
    }
}
