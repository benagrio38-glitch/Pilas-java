/**
 * Problema: Paréntesis Balanceados
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Decide si cada secuencia de paréntesis está balanceada usando una pila propia.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Los paréntesis que abren se apilan; cada uno que cierra debe coincidir con el del tope.
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
     * Revisa si una secuencia está balanceada.
     * @param secuencia cadena con ( ) [ ] { }
     * @return true si está balanceada
     */
    private static boolean estaBalanceada(String secuencia) {
        Pila abiertos = new Pila();
        for (int i = 0; i < secuencia.length(); i++) {
            char c = secuencia.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                abiertos.apilar(c);
            } else {
                // Un cierre necesita un abierto pendiente del mismo tipo
                if (abiertos.estaVacia()) {
                    return false;
                }
                char abre = abiertos.desapilar();
                if ((c == ')' && abre != '(') || (c == ']' && abre != '[') || (c == '}' && abre != '{')) {
                    return false;
                }
            }
        }
        // Si quedaron abiertos sin cerrar, no está balanceada
        return abiertos.estaVacia();
    }

    /**
     * Punto de entrada del programa.
     * @param args no se usan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        int casos = Integer.parseInt(siguientePalabra());
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < casos; i++) {
            salida.append(estaBalanceada(siguientePalabra()) ? "SI" : "NO").append("\n");
        }
        System.out.print(salida);
    }
}
