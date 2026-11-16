/**
 * Problema: Un banco con clientes no preferentes
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Pila propia para la fila 2 (el último en llegar es el primero en ser atendido).
 */

/**
 * Pila enlazada de nombres (LIFO).
 */
public class Pila {
    private Nodo tope; // cliente de hasta arriba

    /**
     * Pone un cliente hasta arriba de la pila.
     * @param nombre nombre del cliente
     */
    public void apilar(String nombre) {
        Nodo nuevo = new Nodo(nombre);
        nuevo.setSiguiente(tope); // el nuevo apunta al que estaba arriba
        tope = nuevo;             // y se convierte en el nuevo tope
    }

    /**
     * Quita al cliente de hasta arriba y devuelve su nombre.
     * @return el nombre del cliente atendido
     */
    public String desapilar() {
        String nombre = tope.getNombre();
        tope = tope.getSiguiente(); // el tope baja al siguiente
        return nombre;
    }
}
