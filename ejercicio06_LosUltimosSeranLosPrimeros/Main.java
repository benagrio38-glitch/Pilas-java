/**
 * Problema: Los Ultimos Seran Los Primeros
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Invierte el orden de llegada de los concursantes usando una pila propia.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Se apilan los nombres conforme cruzan la meta y luego se desapilan:
 * el último en llegar sale primero.
 */
public class Main {

    /**
     * Punto de entrada del programa.
     * @param args no se usan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Pila meta = new Pila();

        // Se leen nombres hasta encontrar "#" (o hasta que se acabe la entrada)
        String nombre = lector.readLine();
        while (nombre != null && !nombre.trim().equals("#")) {
            nombre = nombre.trim();
            if (!nombre.isEmpty()) {
                meta.apilar(nombre);
            }
            nombre = lector.readLine();
        }

        StringBuilder salida = new StringBuilder();
        while (!meta.estaVacia()) {
            salida.append(meta.desapilar()).append("\n");
        }
        System.out.print(salida);
    }
}
