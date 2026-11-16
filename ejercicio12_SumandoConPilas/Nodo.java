/**
 * Problema: Sumando con pilas
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Nodo de la pila; guarda un número entero.
 */

/**
 * Nodo de una pila enlazada: guarda un dato y la referencia al nodo que está debajo.
 */
public class Nodo {
    private long dato;
    private Nodo abajo;

    /**
     * Crea un nodo.
     * @param dato un número entero
     * @param abajo nodo que queda debajo de este (null si es el primero de la pila)
     */
    public Nodo(long dato, Nodo abajo) {
        this.dato = dato;
        this.abajo = abajo;
    }

    /** @return el dato guardado en el nodo */
    public long getDato() { return dato; }

    /** @return el nodo que está debajo, o null si es el último */
    public Nodo getAbajo() { return abajo; }
}