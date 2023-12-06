/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuraslineales;
import Colas.ColaDinamica;
/**
 *
 * @author ivancadena
 */
public class PruebaColas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ColaDinamica cola = new ColaDinamica();
        cola.Insert("Pepewichozzz");
        cola.Insert("Rucozzzzz");
        cola.Insert("SamuSimp");
        cola.Insert("Cadenazzz");
        System.out.println(cola);
        System.out.println("Esta vacia? "+cola.isEmpty());
        System.out.println("Frente: "+cola.front());
        System.out.println("Se descolo a: "+cola.Delete());
        System.out.println(cola);
    }
    
}
