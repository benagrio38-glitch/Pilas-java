/**
 * Problema: Máximo Elemento en la Pila
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Nodo de la pila; guarda un valor y el máximo de la pila hasta ese nodo.
 */

/**
 * Nodo de una pila enlazada que, además del valor, recuerda cuál era el máximo
 * de la pila en el momento en que se apiló.
 */
public class Nodo {
    private long valor;
    private long maximo;
    private Nodo abajo;

    /**
     * Crea un nodo.
     * @param valor número que se apila
     * @param maximo máximo de la pila contando este nodo y todos los de abajo
     * @param abajo nodo que queda debajo de este (null si es el primero)
     */
    public Nodo(long valor, long maximo, Nodo abajo) {
        this.valor = valor;
        this.maximo = maximo;
        this.abajo = abajo;
    }

    /** @return el valor del nodo */
    public long getValor() { return valor; }

    /** @return el máximo de la pila desde este nodo hacia abajo */
    public long getMaximo() { return maximo; }

    /** @return el nodo que está debajo, o null si es el último */
    public Nodo getAbajo() { return abajo; }
}
