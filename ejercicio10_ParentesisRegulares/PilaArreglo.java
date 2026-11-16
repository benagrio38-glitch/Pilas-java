/**
 * Problema: Paréntesis Regulares
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Pila propia de enteros hecha con un arreglo.
 */

/**
 * Pila de enteros implementada con un arreglo de tamaño fijo.
 * Se usa arreglo y no nodos porque la cadena puede tener 1,000,000 de caracteres:
 * un millón de objetos Nodo podría pasarse del límite de 32 MB de memoria,
 * mientras que un arreglo de int ocupa solo 4 bytes por elemento.
 */
public class PilaArreglo {
    private int[] datos;  // aquí se guardan los elementos
    private int tope;     // cantidad de elementos; el de hasta arriba está en datos[tope - 1]

    /**
     * Crea una pila vacía.
     * @param capacidad número máximo de elementos que puede guardar
     */
    public PilaArreglo(int capacidad) {
        datos = new int[capacidad];
        tope = 0;
    }

    /**
     * Indica si la pila no tiene elementos.
     * @return true si está vacía
     */
    public boolean estaVacia() {
        return tope == 0;
    }

    /**
     * Pone un número hasta arriba de la pila.
     * @param valor número a apilar
     */
    public void apilar(int valor) {
        datos[tope] = valor;
        tope++;
    }

    /**
     * Quita el número de hasta arriba y lo devuelve.
     * @return el número que estaba en el tope
     */
    public int desapilar() {
        tope--;
        return datos[tope];
    }

    /**
     * Devuelve el número de hasta arriba sin quitarlo.
     * @return el número del tope
     */
    public int verTope() {
        return datos[tope - 1];
    }
}
