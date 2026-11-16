/**
 * Problema: Máximo Elemento en la Pila
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Pila propia que sabe su máximo en O(1).
 */

/**
 * Pila enlazada en la que cada nodo guarda el máximo "hasta ahí".
 * Así el máximo de toda la pila siempre está en el tope y no hay que recorrerla.
 */
public class Pila {
    private Nodo tope;

    /**
     * Indica si la pila no tiene elementos.
     * @return true si está vacía
     */
    public boolean estaVacia() {
        return tope == null;
    }

    /**
     * Apila un valor y calcula el nuevo máximo.
     * @param valor número a apilar
     */
    public void apilar(long valor) {
        long maximo = valor;
        if (tope != null && tope.getMaximo() > valor) {
            maximo = tope.getMaximo(); // el máximo de abajo sigue siendo mayor
        }
        tope = new Nodo(valor, maximo, tope); // el nuevo nodo apunta al tope anterior
    }

    /**
     * Quita el elemento de hasta arriba. Al hacerlo, el máximo vuelve a ser
     * el que estaba guardado en el nodo de abajo.
     */
    public void desapilar() {
        tope = tope.getAbajo();
    }

    /**
     * Devuelve el máximo de toda la pila.
     * @return el máximo (está guardado en el tope)
     */
    public long maximo() {
        return tope.getMaximo();
    }
}
