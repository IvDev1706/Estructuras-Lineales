/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuraslineales;
import ListaSensilla.*;
import ListasDobles.*;
import ListasDobles.ListaDobleG;
/**
 *
 * @author ivancadena
 */
public class PruebaListas {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ListaDobleG lista = new ListaDobleG();
//        lista.add("Pepewicho");
//        lista.add(12);
//        lista.add(true);
//        lista.add('T');
//        System.out.println(lista);
        ListaDoble();
    }
    
    public static void EnlazarNodos(){
        //objetos e instancias
        Nodo n1, n2, n3, n4, nuevoN1;
        n1 = new Nodo("Pepewicho");
        n2 = new Nodo("Ivan");
        n3 = new Nodo("Suma");
        n4 = new Nodo("Emmanuel Finanzas");
        nuevoN1 = n1.copia();
        
        //enlace de nodo
        n1.der = n2;
        n2.der = n3;
        n3.der = n4;
        n4.der = nuevoN1;
        
        //impresion
        System.out.println(n1.der.der.der.der);
    }
    
    public static void ListaSimple(){
        Lista lista = new Lista();
        lista.add("Pepewicho");
        lista.add("Suma");
        lista.add("Ruco");
        lista.add("Baruc");
        lista.add("Cadena");
        lista.add("Furrizo");
        System.out.println(lista);
        System.out.println("tamaño: "+lista.size());
        lista.add(lista.remove());
        lista.addFirst("Baljeet");
        System.out.println(lista);
        System.out.println("tamaño: "+lista.size());
        Nodo eliminado = lista.removeLast();
        System.out.println(lista);
        System.out.println("tamaño: "+lista.size());
        System.out.println("se elimino a: "+eliminado);
        lista.addFirst(eliminado);
        System.out.println(lista);
        System.out.println("tamaño: "+lista.size());
    }
    
    public static void ListaDoble(){
        ListaDobleG lista = new ListaDobleG();
        System.out.println("Lista doble:");
        lista.add(15);
        lista.add(34);
        lista.add(-4);
        lista.add(8);
        System.out.println(lista);
        lista.addFirst(19);
        System.out.println("se añadio: 19");
        System.out.println(lista);
        System.out.println("Se elimino a: "+lista.removeLast());
        System.out.println(lista);
        lista.addX(38,5);
        System.out.println("Se inserto: "+38+" en la posicion: "+5);
        System.out.println(lista);
        lista.addAll(lista);
        System.out.println(lista);
    }
}
