/**
 * Problema: EasyStack
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Aplica las operaciones Push, Pop y Top sobre una pila propia.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Procesa las instrucciones 1 (Push), 2 (Pop) y 3 (Top).
 */
public class Main {
    private static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer partes = new StringTokenizer("");

    /**
     * Lee el siguiente número de la entrada (con BufferedReader porque puede haber 100,000 instrucciones).
     * @return el siguiente número
     * @throws IOException si falla la lectura
     */
    private static int siguienteNumero() throws IOException {
        while (!partes.hasMoreTokens()) {
            partes = new StringTokenizer(lector.readLine());
        }
        return Integer.parseInt(partes.nextToken());
    }

    /**
     * Punto de entrada del programa.
     * @param args no se usan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        int instrucciones = siguienteNumero();
        Pila pila = new Pila();
        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < instrucciones; i++) {
            int tipo = siguienteNumero();
            if (tipo == 1) {
                pila.apilar(siguienteNumero());          // Push
            } else if (tipo == 2) {
                if (!pila.estaVacia()) {                  // Pop: si está vacía no se hace nada
                    pila.desapilar();
                }
            } else {
                if (pila.estaVacia()) {                   // Top
                    salida.append("Empty!\n");
                } else {
                    salida.append(pila.verTope()).append("\n");
                }
            }
        }
        System.out.print(salida);
    }
}
