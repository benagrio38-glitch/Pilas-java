/**
 * Problema: Un banco con clientes no preferentes
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Cola propia para la fila 1 (el primero en llegar es el primero en ser atendido).
 */

/**
 * Cola enlazada de nombres (FIFO). Guarda frente y fin para que formar y atender sean O(1).
 */
public class Cola {
    private Nodo frente; // el siguiente en ser atendido
    private Nodo fin;    // el último que llegó

    /**
     * Forma a un cliente al final de la fila.
     * @param nombre nombre del cliente
     */
    public void formar(String nombre) {
        Nodo nuevo = new Nodo(nombre);
        if (frente == null) {
            frente = nuevo;            // fila vacía: es el primero y el último
        } else {
            fin.setSiguiente(nuevo);   // el último actual apunta al nuevo
        }
        fin = nuevo;
    }

    /**
     * Atiende al cliente del frente y devuelve su nombre.
     * @return el nombre del cliente atendido
     */
    public String atender() {
        String nombre = frente.getNombre();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null; // la fila quedó vacía
        }
        return nombre;
    }
}
