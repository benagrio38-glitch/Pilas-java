/**
 * Problema: Los Ultimos Seran Los Primeros
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Nodo de la pila; guarda el nombre de un concursante.
 */

/**
 * Nodo de una pila enlazada: guarda un dato y la referencia al nodo que está debajo.
 */
public class Nodo {
    private String dato;
    private Nodo abajo;

    /**
     * Crea un nodo.
     * @param dato el nombre de un concursante
     * @param abajo nodo que queda debajo de este (null si es el primero de la pila)
     */
    public Nodo(String dato, Nodo abajo) {
        this.dato = dato;
        this.abajo = abajo;
    }

    /** @return el dato guardado en el nodo */
    public String getDato() { return dato; }

    /** @return el nodo que está debajo, o null si es el último */
    public Nodo getAbajo() { return abajo; }
}