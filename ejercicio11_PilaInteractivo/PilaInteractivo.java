/**
 * Problema: Pila Interactivo
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Implementa las funciones agrega y saca usando una pila propia.
 */

/**
 * Problema interactivo: omegaUp llama directamente a agrega(n) y saca().
 * No se lee entrada ni se imprime nada; solo se guarda y se devuelve.
 */
public class PilaInteractivo {
    private static Pila pila = new Pila(); // la misma pila para todas las llamadas

    /**
     * Agrega un número hasta arriba de la pila.
     * @param n número a agregar
     */
    public static void agrega(int n) {
        pila.apilar(n);
    }

    /**
     * Saca el número de hasta arriba de la pila.
     * @return el número que estaba en el tope, o -1 si la pila está vacía
     */
    public static int saca() {
        if (pila.estaVacia()) {
            return -1;
        }
        return pila.desapilar();
    }
}
