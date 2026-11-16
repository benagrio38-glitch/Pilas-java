/**
 * Problema: Operaciones con una pila
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Aplica las operaciones mete(a) y saca(a) sobre una pila propia.
 */

import java.util.Scanner;

/**
 * Para cada número a: si la pila tiene menos de a elementos se mete a,
 * si no, se sacan a elementos del tope.
 */
public class Main {

    /**
     * Punto de entrada del programa.
     * @param args no se usan
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pila pila = new Pila();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (pila.tamanio() < a) {
                pila.apilar(a);                  // mete(a)
            } else {
                for (int j = 0; j < a; j++) {    // saca(a): quita a elementos del tope
                    pila.desapilar();
                }
            }
        }

        // Cantidad que queda y el orden en que saldrían (del tope hacia abajo)
        System.out.println(pila.tamanio());
        StringBuilder linea = new StringBuilder();
        while (!pila.estaVacia()) {
            linea.append(pila.desapilar());
            if (!pila.estaVacia()) {
                linea.append(" ");
            }
        }
        System.out.println(linea);
    }
}
