/**
 * Problema: Paréntesis Regulares
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Encuentra la subcadena regular más larga y cuántas hay de ese largo,
 * usando una pila propia de posiciones.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * En la pila se guardan posiciones. En el fondo siempre queda la posición justo antes
 * de donde empieza la parte regular actual; así, al cerrar un paréntesis,
 * la longitud de la subcadena regular que termina ahí es i - tope.
 */
public class Main {

    /**
     * Punto de entrada del programa.
     * @param args no se usan
     * @throws IOException si falla la lectura
     */
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String linea = lector.readLine();
        String cadena = (linea == null) ? "" : linea.trim();

        PilaArreglo posiciones = new PilaArreglo(cadena.length() + 1);
        posiciones.apilar(-1); // "base": la parte regular empezaría en la posición 0

        int masLarga = 0;
        int cantidad = 1; // si no hay ninguna, la respuesta es "0 1"

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '(') {
                posiciones.apilar(i);
            } else {
                posiciones.desapilar(); // se empareja con el '(' del tope (o se quita la base)
                if (posiciones.estaVacia()) {
                    // ')' sin pareja: la siguiente parte regular empieza después de i
                    posiciones.apilar(i);
                } else {
                    int largo = i - posiciones.verTope();
                    if (largo > masLarga) {
                        masLarga = largo;
                        cantidad = 1;
                    } else if (largo == masLarga) {
                        cantidad++;
                    }
                }
            }
        }

        System.out.println(masLarga + " " + cantidad);
    }
}
