/**
 * Problema: Conjunto
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Decide si una cadena solo tiene a, b, c, d y paréntesis balanceados, usando una pila propia.
 */

import java.util.Scanner;

/**
 * Revisa la cadena carácter por carácter: los '(' se apilan y cada ')' desapila uno.
 */
public class Main {

    /**
     * Revisa si la cadena pertenece al conjunto.
     * @param cadena cadena a revisar
     * @return true si solo tiene caracteres válidos y sus paréntesis están balanceados
     */
    private static boolean pertenece(String cadena) {
        Pila abiertos = new Pila();
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c == '(') {
                abiertos.apilar(c);
            } else if (c == ')') {
                // Un ')' sin '(' pendiente significa que no está balanceada
                if (abiertos.estaVacia()) {
                    return false;
                }
                abiertos.desapilar();
            } else if (c != 'a' && c != 'b' && c != 'c' && c != 'd') {
                return false; // carácter que no pertenece al conjunto
            }
        }
        // Si quedaron '(' sin cerrar, tampoco está balanceada
        return abiertos.estaVacia();
    }

    /**
     * Punto de entrada del programa.
     * @param args no se usan
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.hasNextLine() ? sc.nextLine().trim() : "";
        System.out.println(pertenece(cadena) ? 1 : 0);
    }
}
