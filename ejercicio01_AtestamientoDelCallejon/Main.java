/**
 * Problema: Atestamiento del callejón
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Cuenta cuántos autos hay que sacar del callejón usando una pila propia.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * El callejón tiene una sola entrada: el último auto que entró es el primero que sale (pila).
 */
public class Main {
    private static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer partes = new StringTokenizer("");

    /**
     * Lee la siguiente palabra de la entrada.
     * @return la siguiente palabra, o null si ya no hay más
     * @throws IOException si falla la lectura
     */
    private static String siguientePalabra() throws IOException {
        while (!partes.hasMoreTokens()) {
            String linea = lector.readLine();
            if (linea == null) {
                return null;
            }
            partes = new StringTokenizer(linea);
        }
        return partes.nextToken();
    }

    /**
     * Punto de entrada del programa.
     * @param args no se usan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        int autos = Integer.parseInt(siguientePalabra());

        // Las placas se guardan como texto para no perder ceros a la izquierda (ej. 012)
        Pila callejon = new Pila();
        for (int i = 0; i < autos; i++) {
            callejon.apilar(siguientePalabra());
        }
        String solicitado = siguientePalabra();

        // Se sacan autos desde la entrada (el tope) hasta encontrar el solicitado
        int sacados = 0;
        boolean encontrado = false;
        while (!callejon.estaVacia() && !encontrado) {
            String placa = callejon.desapilar();
            sacados++; // también cuenta el auto solicitado
            if (placa.equals(solicitado)) {
                encontrado = true;
            }
        }

        if (encontrado) {
            System.out.println(sacados);
        } else {
            System.out.println("No existe el auto");
        }
    }
}
