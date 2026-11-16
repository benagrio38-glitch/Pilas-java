/**
 * Problema: Sumando con pilas
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Ejecuta AGREGA, CONSUME e IMPRIME sobre una pila propia.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * CONSUME saca los dos de hasta arriba y apila su suma. Se usa long porque
 * al sumar muchas veces el resultado podría no caber en un int.
 */
public class Main {
    private static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer partes = new StringTokenizer("");

    /**
     * Lee la siguiente palabra de la entrada.
     * @return la siguiente palabra
     * @throws IOException si falla la lectura
     */
    private static String siguientePalabra() throws IOException {
        while (!partes.hasMoreTokens()) {
            partes = new StringTokenizer(lector.readLine());
        }
        return partes.nextToken();
    }

    /**
     * Punto de entrada del programa.
     * @param args no se usan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        int operaciones = Integer.parseInt(siguientePalabra());
        Pila p = new Pila();
        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < operaciones; i++) {
            String operacion = siguientePalabra();
            if (operacion.equals("AGREGA")) {
                p.apilar(Long.parseLong(siguientePalabra()));
            } else if (operacion.equals("CONSUME")) {
                long ultimo = p.desapilar();
                long penultimo = p.desapilar();
                p.apilar(penultimo + ultimo);
            } else { // IMPRIME
                salida.append(p.verTope()).append("\n");
            }
        }
        System.out.print(salida);
    }
}
