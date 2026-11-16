/**
 * Problema: Máximo Elemento en la Pila
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Responde el máximo de la pila en cada consulta usando una pila propia.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Procesa las preguntas 1 x (agregar), 2 (borrar) y 3 (imprimir el máximo).
 */
public class Main {
    private static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer partes = new StringTokenizer("");

    /**
     * Lee el siguiente número de la entrada.
     * @return el siguiente número
     * @throws IOException si falla la lectura
     */
    private static long siguienteNumero() throws IOException {
        while (!partes.hasMoreTokens()) {
            partes = new StringTokenizer(lector.readLine());
        }
        return Long.parseLong(partes.nextToken());
    }

    /**
     * Punto de entrada del programa.
     * @param args no se usan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        int preguntas = (int) siguienteNumero();
        Pila pila = new Pila();
        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < preguntas; i++) {
            int tipo = (int) siguienteNumero();
            if (tipo == 1) {
                pila.apilar(siguienteNumero());
            } else if (tipo == 2) {
                pila.desapilar();
            } else {
                salida.append(pila.maximo()).append("\n");
            }
        }
        System.out.print(salida);
    }
}
