/**
 * Problema: ()[]{}<>
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Calcula el mínimo de reemplazos para que la cadena "tenga sentido", usando una pila propia.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Cada carácter de cierre se empareja con el último de apertura pendiente (el tope de la pila).
 * Si no son del mismo tipo, basta con un reemplazo para que coincidan.
 */
public class Main {

    /**
     * Indica si un carácter es de apertura.
     * @param c carácter a revisar
     * @return true si es '(', '[', '{' o '<'
     */
    private static boolean esApertura(char c) {
        return c == '(' || c == '[' || c == '{' || c == '<';
    }

    /**
     * Indica si un carácter de apertura y uno de cierre son del mismo tipo.
     * @param abre carácter de apertura
     * @param cierra carácter de cierre
     * @return true si forman pareja
     */
    private static boolean sonPareja(char abre, char cierra) {
        return (abre == '(' && cierra == ')') || (abre == '[' && cierra == ']')
                || (abre == '{' && cierra == '}') || (abre == '<' && cierra == '>');
    }

    /**
     * Punto de entrada del programa.
     * @param args no se usan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        // Se lee toda la entrada y se ignoran saltos de línea o espacios
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder cadena = new StringBuilder();
        String linea;
        while ((linea = lector.readLine()) != null) {
            cadena.append(linea.trim());
        }

        Pila aperturas = new Pila();
        int reemplazos = 0;
        boolean imposible = false;

        for (int i = 0; i < cadena.length() && !imposible; i++) {
            char c = cadena.charAt(i);
            if (esApertura(c)) {
                aperturas.apilar(c);
            } else if (aperturas.estaVacia()) {
                imposible = true; // un cierre sin apertura pendiente no se puede arreglar
            } else {
                char abre = aperturas.desapilar();
                if (!sonPareja(abre, c)) {
                    reemplazos++; // cambiar uno de los dos basta para que coincidan
                }
            }
        }
        // Si sobran aperturas sin cerrar, tampoco se puede arreglar
        if (!aperturas.estaVacia()) {
            imposible = true;
        }

        System.out.println(imposible ? "imposible" : String.valueOf(reemplazos));
    }
}
