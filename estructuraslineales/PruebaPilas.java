/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuraslineales;
import Pilas.PilaDinamica;
/**
 *
 * @author ivancadena
 */
public class PruebaPilas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PilaDinamica pila = new PilaDinamica();
        System.out.println("la pila esta vacia? "+pila.isEmpty());
        pila.push(12);
        pila.push("Pepewichozzzz");
        pila.push(true);
        System.out.println(pila);
        pila.pop();
        System.out.println(pila);
        System.out.println("la pila esta vacia? "+pila.isEmpty());
        System.out.println("cima: "+pila.peak());
        System.out.println("penultimo elemento: "+pila.penultimo());
        System.out.println("penultimo elemento: "+pila.penultimo());
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.push(6);
        System.out.println("Lista: "+pila);
        pila = pila.invertir();
        System.out.println("Pila invertida: "+pila);
        System.out.println(pila.fondo());
        System.out.println(pila);
    }
    
}
