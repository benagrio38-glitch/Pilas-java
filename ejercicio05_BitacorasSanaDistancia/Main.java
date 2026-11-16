/**
 * Problema: Las bitácoras de la sana distancia
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Simula los papelitos en el escritorio con una pila propia para saber
 * en qué orden se llamó a los teléfonos.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Cada minuto se pone un papelito encima de los demás (apilar). Cuando la telefonista
 * está libre, toma el de hasta arriba (desapilar) y la llamada dura lo que diga su bitácora.
 */
public class Main {
    private static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer partes = new StringTokenizer("");

    /**
     * Lee el siguiente número de la entrada.
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
        int n = siguienteNumero();
        int[] duraciones = new int[n]; // duración de la 1a, 2a, 3a... llamada que se hizo
        for (int i = 0; i < n; i++) {
            duraciones[i] = siguienteNumero();
        }

        Pila escritorio = new Pila();
        StringBuilder salida = new StringBuilder();
        int libreEnMinuto = 1; // minuto en el que la telefonista vuelve a estar libre
        int llamadasHechas = 0;

        for (int minuto = 1; minuto <= n; minuto++) {
            // 1) El asistente pone el papelito de este minuto encima de los demás
            escritorio.apilar(siguienteNumero());

            // 2) Si la telefonista ya está libre, toma el papelito de hasta arriba
            if (minuto >= libreEnMinuto) {
                salida.append(escritorio.desapilar()).append("\n");
                libreEnMinuto = minuto + duraciones[llamadasHechas];
                llamadasHechas++;
            }
        }

        // Ya no llegan papelitos: se llaman los que quedan, de arriba hacia abajo
        while (!escritorio.estaVacia()) {
            salida.append(escritorio.desapilar()).append("\n");
        }
        System.out.print(salida);
    }
}
