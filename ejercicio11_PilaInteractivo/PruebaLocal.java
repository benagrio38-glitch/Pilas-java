/**
 * Problema: Pila Interactivo
 * Autor: Oscar Manuel Ayala Ortiz
 * Grupo: GTID244
 * Fecha: 16/11/2026
 * Descripción: Programa solo para probar PilaInteractivo en la computadora
 * (en omegaUp no se envía; allá el evaluador hace las llamadas).
 */

import java.util.Scanner;

/**
 * Lee órdenes "agrega n" y "saca" y muestra lo que devuelve saca().
 */
public class PruebaLocal {

    /**
     * Punto de entrada de la prueba.
     * @param args no se usan
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String orden = sc.next();
            if (orden.equals("agrega")) {
                PilaInteractivo.agrega(sc.nextInt());
            } else if (orden.equals("saca")) {
                System.out.println(PilaInteractivo.saca());
            }
        }
    }
}
