/**
 * Problema: Operaciones con una pila
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Pila propia hecha con nodos enlazados (LIFO).
 */

/**
 * Pila enlazada: el último dato que entra es el primero que sale.
 * Solo se guarda la referencia al tope, así apilar y desapilar son O(1).
 */
public class Pila {
    private Nodo tope;    // nodo de hasta arriba (null si la pila está vacía)
    private int tamanio;  // cuántos elementos hay

    /**
     * Indica si la pila no tiene elementos.
     * @return true si está vacía
     */
    public boolean estaVacia() {
        return tope == null;
    }

    /**
     * Devuelve cuántos elementos hay en la pila.
     * @return el tamaño de la pila
     */
    public int tamanio() {
        return tamanio;
    }

    /**
     * Pone un dato hasta arriba de la pila.
     * @param dato dato a apilar
     */
    public void apilar(int dato) {
        // El nuevo nodo apunta al tope actual y se convierte en el nuevo tope
        tope = new Nodo(dato, tope);
        tamanio++;
    }

    /**
     * Quita el dato de hasta arriba y lo devuelve.
     * Antes de llamarlo hay que revisar que la pila no esté vacía.
     * @return el dato que estaba en el tope
     */
    public int desapilar() {
        int dato = tope.getDato();
        tope = tope.getAbajo(); // el tope baja al nodo de abajo
        tamanio--;
        return dato;
    }

    /**
     * Devuelve el dato de hasta arriba sin quitarlo.
     * Antes de llamarlo hay que revisar que la pila no esté vacía.
     * @return el dato del tope
     */
    public int verTope() {
        return tope.getDato();
    }
}