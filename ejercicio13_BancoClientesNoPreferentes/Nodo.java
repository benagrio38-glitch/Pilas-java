/**
 * Problema: Un banco con clientes no preferentes
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Nodo que guarda el nombre de un cliente; lo usan la pila y la cola.
 */

/**
 * Nodo enlazado con un nombre y la referencia al siguiente nodo.
 * En la pila "siguiente" es el nodo de abajo; en la cola es el que va detrás.
 */
public class Nodo {
    private String nombre;
    private Nodo siguiente;

    /**
     * Crea un nodo sin enlazar.
     * @param nombre nombre del cliente
     */
    public Nodo(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
    }

    /** @return el nombre del cliente */
    public String getNombre() { return nombre; }

    /** @return el nodo siguiente, o null si no hay */
    public Nodo getSiguiente() { return siguiente; }

    /** @param siguiente nodo que quedará enlazado después de este */
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
}
