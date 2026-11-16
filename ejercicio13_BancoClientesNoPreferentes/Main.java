/**
 * Problema: Un banco con clientes no preferentes
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Simula las dos filas del banco con una cola y una pila propias.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Fila 1 (buen estatus) funciona como cola; fila 2 (morosos) funciona como pila.
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
        int eventos = Integer.parseInt(siguientePalabra());
        Cola fila1 = new Cola();
        Pila fila2 = new Pila();
        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < eventos; i++) {
            String evento = siguientePalabra();
            int fila = Integer.parseInt(siguientePalabra());
            if (evento.equals("E")) {
                String nombre = siguientePalabra();
                if (fila == 1) {
                    fila1.formar(nombre);
                } else {
                    fila2.apilar(nombre);
                }
            } else { // "A": se atiende al siguiente de esa fila
                if (fila == 1) {
                    salida.append(fila1.atender()).append("\n");
                } else {
                    salida.append(fila2.desapilar()).append("\n");
                }
            }
        }
        System.out.print(salida);
    }
}
